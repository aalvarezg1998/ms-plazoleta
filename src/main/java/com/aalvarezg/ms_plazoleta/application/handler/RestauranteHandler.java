package com.aalvarezg.ms_plazoleta.application.handler;

import com.aalvarezg.ms_plazoleta.application.dto.RestauranteRequestDTO;
import com.aalvarezg.ms_plazoleta.application.dto.RestauranteResponseDTO;
import com.aalvarezg.ms_plazoleta.application.mapper.RestautanteMapper;
import com.aalvarezg.ms_plazoleta.domain.api.IRestauranteServicePort;
import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RestauranteHandler implements IRestauranteHandler{
    private final IRestauranteServicePort restauranteServicePort;
    @Override
    public RestauranteResponseDTO crearRestaurante(RestauranteRequestDTO restauranteRequest) {
        log.info("Se inicia a crear el restaurante con el nombre {}", restauranteRequest.getNombre());
        Restaurante restaurante = RestautanteMapper.toRestaurante(restauranteRequest);
        return RestautanteMapper.toRestauranteResponse(restauranteServicePort.crearRestaurante(restaurante));
    }
}
