package io.grupo14.tucomunidad14.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;
import io.grupo14.tucomunidad14.model.Vecino;
import io.grupo14.tucomunidad14.model.VecinoDTO;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;
import io.grupo14.tucomunidad14.repository.VecinoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class VecinoController {

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private ComunidadRepository comunidadRepository;

    public static final Logger log = LoggerFactory.getLogger(ReservasController.class);

    @PostMapping("/vecinos")
    public ResponseEntity<?> createVecino(@RequestBody VecinoDTO vecinoDTO) {
        try {
            Vecino vecino = new Vecino();
            vecino.setNombre(vecinoDTO.getNombre());
            vecino.setApellidos(vecinoDTO.getApellidos());
            vecino.setEmail(vecinoDTO.getEmail());
            vecino.setNombredeusuario(vecinoDTO.getNombredeusuario());
            vecino.setContraseña(vecinoDTO.getContraseña());
            vecino.setGestor(vecinoDTO.getGestor());

            // Si idComunidad es null, no asociar una comunidad al vecino
            if (vecinoDTO.getIdComunidad() != null & !vecinoDTO.getGestor()) {
                Comunidad comunidad = comunidadRepository.findById(vecinoDTO.getIdComunidad()).orElseThrow(
                        () -> new RuntimeException("Comunidad no encontrada con id: " + vecinoDTO.getIdComunidad()));
                vecino.setComunidad(comunidad);
            } else {
                Long a = (long) 1;
                Comunidad comunidad = comunidadRepository.findById(a).orElseThrow(
                        () -> new RuntimeException("Comunidad no encontrada con id: " + vecinoDTO.getIdComunidad()));
                ;
                vecino.setComunidad(comunidad);// Comunidad provisonal
            }

            vecinoRepository.save(vecino);

            return ResponseEntity.ok(vecino.getIdvecino());
        } catch (Exception e) {
            log.error("Error al crear el vecino", e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al crear el vecino: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * @PostMapping("/api/login")
     * public ResponseEntity<String> iniciarSesion(@RequestBody Vecino vecino) {
     * // Obtener el vecino de la base de datos por nombre de usuario
     * Vecino vecinoExistente =
     * vecinoRepository.findByNombredeusuario(vecino.getNombredeusuario());
     * 
     * // Verificar si el vecino existe y si la contraseña coincide
     * if (vecinoExistente != null &&
     * vecinoExistente.getContraseña().equals(vecino.getContraseña())) {
     * // Si las credenciales son correctas, retornar un mensaje de éxito y código
     * 200
     * return ResponseEntity.ok().body("Inicio de sesión exitoso");
     * } else {
     * // Si las credenciales son incorrectas, retornar un mensaje de error y código
     * 401 (No autorizado)
     * return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales
     * incorrectas");
     * }
     * }
     */
    /**
     * @param idVecino
     * @return
     */

    @GetMapping("/vecino/comunidad")
    public ComunidadDTO obtenerComunidadDeVecino(@RequestParam Long idVecino) {
        Comunidad comunidad = comunidadRepository.findByVecinosContainsId(idVecino);

        ComunidadDTO comunidadDTO = new ComunidadDTO();
        comunidadDTO.setIdcomunidad(comunidad.getIdcomunidad());
        comunidadDTO.setNombre(comunidad.getNombre());
        comunidadDTO.setCodpostal(comunidad.getCodpostal());

        return comunidadDTO;
    }

    @GetMapping("/vecino")
    public ResponseEntity<?> obtenerVecinoPorUsuarioYContraseña(@RequestParam String usuario,
            @RequestParam String contraseña) {
        Optional<Vecino> vecinoOpt = vecinoRepository.findByUsernameAndPassword(usuario, contraseña);
        if (vecinoOpt.isPresent()) {
            Vecino vecino = vecinoOpt.get();
            VecinoDTO vecinoDTO = new VecinoDTO();
            vecinoDTO.setIdvecino(vecino.getIdvecino());
            vecinoDTO.setNombre(vecino.getNombre());
            vecinoDTO.setApellidos(vecino.getApellidos());
            vecinoDTO.setEmail(vecino.getEmail());
            vecinoDTO.setNombredeusuario(vecino.getNombredeusuario());
            vecinoDTO.setContraseña(vecino.getContraseña()); // Considera no retornar la contraseña por seguridad
            vecinoDTO.setGestor(vecino.getGestor());
            vecinoDTO.setIdComunidad(vecino.getComunidad().getIdcomunidad());

            return ResponseEntity.ok(vecinoDTO); // Devuelve el objeto vecinoDTO como JSON con estado 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El vecino no está registrado");
        }
    }

    @PostMapping("/cambioContrasena")
    public ResponseEntity<?> cambiarContrasena(@RequestBody CambioContrasenaRequest cambioContrasenaRequest) {
        String newPasswordEncoded = cambioContrasenaRequest.getContraseña();
        int updatedCount = vecinoRepository.updateContraseñaByNombredeusuario(newPasswordEncoded,
                cambioContrasenaRequest.getNombredeusuario());

        if (updatedCount > 0) {
            return ResponseEntity.ok().body("Contraseña actualizada correctamente.");
        } else {
            return ResponseEntity.badRequest().body("Error: El nombre de usuario no existe.");
        }
    }

    @GetMapping("/esgestor")
    public ResponseEntity<?> esgestor(@RequestParam Long idvecino) {
        Optional<Vecino> vecino = vecinoRepository.findById(idvecino);
        if (vecino.isPresent()) {
            boolean esGestor = vecino.get().getGestor(); // getGestor() devuelve un booleano
            return ResponseEntity.ok(esGestor); // Devuelve directamente el valor booleano
        } else {
            // Retorna un mensaje de error si el vecino no existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No consta ese vecino");
        }
    }

    @GetMapping("/vecinoporid")
    public ResponseEntity<?> vecinoporid(@RequestParam Long idvecino) {
        Optional<Vecino> vecinoOpt = vecinoRepository.findById(idvecino);
        if (vecinoOpt.isPresent()) {
            Vecino vecino = vecinoOpt.get();
            VecinoDTO vecinoDTO = new VecinoDTO();
            vecinoDTO.setIdvecino(vecino.getIdvecino());
            vecinoDTO.setNombre(vecino.getNombre());
            vecinoDTO.setApellidos(vecino.getApellidos());
            vecinoDTO.setEmail(vecino.getEmail());
            vecinoDTO.setNombredeusuario(vecino.getNombredeusuario());
            vecinoDTO.setContraseña(vecino.getContraseña()); // Considera no retornar la contraseña por seguridad
            vecinoDTO.setGestor(vecino.getGestor());
            vecinoDTO.setIdComunidad(vecino.getComunidad().getIdcomunidad());

            return ResponseEntity.ok(vecinoDTO);

        } else {
            // Retorna un mensaje de error si el vecino no existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No consta ese vecino");
        }
    }

    @PutMapping("/cambiarcom")
    public ResponseEntity<?> putMethodName(@RequestParam Long idvecino, @RequestParam Long idcomunidad) {
        Optional<Vecino> vecinoOpt = vecinoRepository.findById(idvecino);

        if (vecinoOpt.isPresent()) {
            Vecino vecino = vecinoOpt.get();
            Optional<Comunidad> comunidad = comunidadRepository.findById(idcomunidad);
            vecino.setComunidad(comunidad.get());
            vecinoRepository.save(vecino);
            VecinoDTO vecinoDTO = new VecinoDTO();
            vecinoDTO.setIdvecino(vecino.getIdvecino());
            vecinoDTO.setNombre(vecino.getNombre());
            vecinoDTO.setApellidos(vecino.getApellidos());
            vecinoDTO.setEmail(vecino.getEmail());
            vecinoDTO.setNombredeusuario(vecino.getNombredeusuario());
            vecinoDTO.setContraseña(vecino.getContraseña()); // Considera no retornar la contraseña por seguridad
            vecinoDTO.setGestor(vecino.getGestor());
            vecinoDTO.setIdComunidad(vecino.getComunidad().getIdcomunidad());

            return ResponseEntity.ok(vecinoDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No consta ese vecino");
        }

    }

    @GetMapping("/listadevecinosporgestor")
    public ResponseEntity<?> listadevecinosporgestor(@RequestParam Long idvecino) {

        Vecino vecino = vecinoRepository.findById(idvecino).orElse(null);

        if (vecino != null && vecino.getGestor()) {
            Comunidad comunidad = comunidadRepository.findById(vecino.getComunidad().getIdcomunidad()).orElse(null);

            if (comunidad != null) {
                List<VecinoDTO> vecinosDTO = comunidad.getVecinos().stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(vecinosDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La comunidad no fue encontrada");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No consta ese vecino");
        }

    }

    private VecinoDTO convertToDto(Vecino vecino) {
        VecinoDTO vecinoDTO = new VecinoDTO();
        // Aquí mapea los atributos del Vecino a los del VecinoDTO
        vecinoDTO.setNombre(vecino.getNombre());
        vecinoDTO.setIdvecino(vecino.getIdvecino());
        vecinoDTO.setNombre(vecino.getNombre());
        vecinoDTO.setApellidos(vecino.getApellidos());
        vecinoDTO.setEmail(vecino.getEmail());
        vecinoDTO.setNombredeusuario(vecino.getNombredeusuario());
        vecinoDTO.setContraseña(vecino.getContraseña()); // Considera no retornar la contraseña por seguridad
        vecinoDTO.setGestor(vecino.getGestor());
        vecinoDTO.setIdComunidad(vecino.getComunidad().getIdcomunidad());

        return vecinoDTO;
    }

    @GetMapping("/idcomunidadporvecino")
    public ResponseEntity<?> idcomunidadporvecino(@RequestParam Long idvecino) {
        Vecino vecino = vecinoRepository.findById(idvecino).get();
        if (vecino != null) {
            Long idcomunidad = vecino.getComunidad().getIdcomunidad();
            return ResponseEntity.ok(idcomunidad);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No consta ese vecino");
        }

    }

    @PostMapping("/otorgarpermisos")
    public ResponseEntity<?> otorgarpermisos(@RequestParam Long idgestor, @RequestParam Long idvecino) {
        Vecino gestor = vecinoRepository.findById(idgestor).get();
        Vecino vecino = vecinoRepository.findById(idvecino).get();

        if (gestor != null & vecino != null & gestor.getGestor()) {
            vecino.setGestor(true);
            vecinoRepository.save(vecino);
            return ResponseEntity.ok("Permisos otorgados");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha habido algun problema");
        }

    }

    @PostMapping("/eliminarvecino")
    public ResponseEntity<?> eliminarvecino(@RequestParam Long idgestor, @RequestParam Long idvecino) {
        Vecino gestor = vecinoRepository.findById(idgestor).get();
        Vecino vecino = vecinoRepository.findById(idvecino).get();
        if (gestor != null & vecino != null & gestor.getGestor()) {
            vecinoRepository.delete(vecino);
            return ResponseEntity.ok("Vecino eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha habido algun problema");
        }

    }

}
