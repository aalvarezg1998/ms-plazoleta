package com.aalvarezg.ms_plazoleta.application.handler;

import com.aalvarezg.ms_plazoleta.application.dto.RestauranteRequestDTO;
import com.aalvarezg.ms_plazoleta.application.dto.RestauranteResponseDTO;

public interface IRestauranteHandler {
    RestauranteResponseDTO crearRestaurante(RestauranteRequestDTO restauranteRequest);
}
