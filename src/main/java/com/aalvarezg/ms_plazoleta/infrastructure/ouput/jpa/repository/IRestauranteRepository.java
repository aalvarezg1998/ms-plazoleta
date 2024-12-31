package com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.repository;

import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.entity.RestaurantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestauranteRepository extends JpaRepository<RestaurantesEntity, Long> {
}
