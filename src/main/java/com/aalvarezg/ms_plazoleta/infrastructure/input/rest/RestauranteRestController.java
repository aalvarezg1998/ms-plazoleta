package com.aalvarezg.ms_plazoleta.infrastructure.input.rest;

import com.aalvarezg.ms_plazoleta.application.dto.RestauranteRequestDTO;
import com.aalvarezg.ms_plazoleta.application.dto.RestauranteResponseDTO;
import com.aalvarezg.ms_plazoleta.application.handler.IRestauranteHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes/")
@RequiredArgsConstructor
public class RestauranteRestController {
    private final IRestauranteHandler restauranteHandler;

    @Operation(
            summary = "Crear un restaurante",
            description = "Este endpoint permite crear un nuevo restaurante proporcionando la información requerida."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Restaurante creado exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestauranteResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitud inválida (error de validación)",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    @PostMapping
    public ResponseEntity<RestauranteResponseDTO> crearRestaurante(
            @RequestBody RestauranteRequestDTO restauranteRequestDTO) {
        RestauranteResponseDTO restauranteResponseDTO = restauranteHandler.crearRestaurante(restauranteRequestDTO);
        return ResponseEntity.ok(restauranteResponseDTO);
    }
}
