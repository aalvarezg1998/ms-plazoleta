package com.aalvarezg.ms_plazoleta.domain.spi;

import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;

public interface IRestaurantePersistencePort {
    Restaurante crearRestaurante(Restaurante restaurante);
}
