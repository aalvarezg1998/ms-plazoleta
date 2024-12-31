package com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.adapter;

import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import com.aalvarezg.ms_plazoleta.domain.spi.IRestaurantePersistencePort;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.entity.RestaurantesEntity;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.mapper.RestauranteEntityMapper;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RestauranteJpaAdapter implements IRestaurantePersistencePort {
    private final IRestauranteRepository restauranteRepository;

    @Override
    public Restaurante crearRestaurante(Restaurante restaurante) {
        RestaurantesEntity restaurantesEntity = restauranteRepository.save(RestauranteEntityMapper.toEntity(restaurante));
        return RestauranteEntityMapper.toRestaurante(restaurantesEntity);
    }
}
