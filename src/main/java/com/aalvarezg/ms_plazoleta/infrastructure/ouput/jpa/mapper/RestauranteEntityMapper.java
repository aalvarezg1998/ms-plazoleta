package com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.mapper;

import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.entity.RestaurantesEntity;

public class RestauranteEntityMapper {
    private RestauranteEntityMapper(){
        throw new IllegalStateException("Mapper para restaurante entity");
    }

    public static Restaurante toRestaurante(RestaurantesEntity restaurantesEntity){
        Restaurante restaurante = new Restaurante();
        restaurante.setDireccion(restaurantesEntity.getDireccion());
        restaurante.setNombre(restaurantesEntity.getNombre());
        restaurante.setNit(restaurantesEntity.getNit());
        restaurante.setTelefono(restaurantesEntity.getTelefono());
        restaurante.setUrlLogo(restaurantesEntity.getUrlLogo());
        restaurante.setIdPropietario(restaurantesEntity.getIdPropietario());
        restaurante.setId(restaurantesEntity.getId());
        return restaurante;
    }

    public static RestaurantesEntity toEntity(Restaurante restaurante){
        RestaurantesEntity restaurantesEntity = new RestaurantesEntity();
        restaurantesEntity.setId(restaurante.getId());
        restaurantesEntity.setDireccion(restaurante.getDireccion());
        restaurantesEntity.setNombre(restaurante.getNombre());
        restaurantesEntity.setNit(restaurante.getNit());
        restaurantesEntity.setTelefono(restaurante.getTelefono());
        restaurantesEntity.setUrlLogo(restaurante.getUrlLogo());
        restaurantesEntity.setIdPropietario(restaurante.getIdPropietario());
        return restaurantesEntity;
    }
}
