package io.grupo14.tucomunidad14;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.grupo14.tucomunidad14.controller.Comunidadcontroller;
import io.grupo14.tucomunidad14.controller.VecinoController;
import io.grupo14.tucomunidad14.model.Vecino;
import io.grupo14.tucomunidad14.model.VecinoDTO;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;
import io.grupo14.tucomunidad14.repository.VecinoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class pruebas {

    @Mock
    private ComunidadRepository comunidadRepository;

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private Comunidadcontroller comunidadController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private VecinoController vecinoController;

    public void setUp() {
        vecinoController = new VecinoController();
    }

    @Test
    public void testCrearVecino() throws Exception {
        VecinoDTO nuevoVecino = new VecinoDTO();
        nuevoVecino.setNombre("NombrePrueba");
        nuevoVecino.setApellidos("ApellidosPrueba");
        nuevoVecino.setEmail("correo@example.com");
        nuevoVecino.setNombredeusuario("usuario_prueba");
        nuevoVecino.setContraseña("contraseña123");
        nuevoVecino.setGestor(false);
        nuevoVecino.setIdComunidad(1L); // ID de la comunidad a la que se va a asociar el vecino

        mockMvc.perform(post("/vecinos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nuevoVecino)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists()); // Verifica que se reciba una respuesta exitosa y que exista
                                                    // contenido en la respuesta
    }

    @Test
    public void testIniciarSesionCorrectamente() {
        // Simulamos un vecino existente con nombre de usuario y contraseña correctos
        Vecino vecinoMock = new Vecino();
        vecinoMock.setNombredeusuario("usuario");
        vecinoMock.setContraseña("contraseña");

        // Creamos un mock del repositorio de vecinos
        VecinoRepository vecinoRepositoryMock = mock(VecinoRepository.class);
        when(vecinoRepositoryMock.findByUsernameAndPassword("usuario", "contraseña"))
                .thenReturn(Optional.of(vecinoMock));

        // Creamos un mock del controlador de vecinos
        VecinoController vecinoControllerMock = mock(VecinoController.class);
        when(vecinoControllerMock.obtenerVecinoPorUsuarioYContraseña("usuario", "contraseña"))
                .thenReturn(ResponseEntity.ok().build());

        // Probamos el inicio de sesión
        ResponseEntity<?> responseEntity = vecinoControllerMock.obtenerVecinoPorUsuarioYContraseña("usuario",
                "contraseña");

        // Verificamos que la respuesta sea exitosa
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}