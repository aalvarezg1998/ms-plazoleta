package com.aalvarezg.ms_plazoleta.application.mapper;

import com.aalvarezg.ms_plazoleta.application.dto.RestauranteRequestDTO;
import com.aalvarezg.ms_plazoleta.application.dto.RestauranteResponseDTO;
import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;

public class RestautanteMapper {
    private RestautanteMapper(){
        throw new IllegalStateException("Mapper para restaurante");
    }

    public static Restaurante toRestaurante(RestauranteRequestDTO restauranteRequestDTO){
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteRequestDTO.getNombre());
        restaurante.setDireccion(restauranteRequestDTO.getDireccion());
        restaurante.setNit(restauranteRequestDTO.getNit());
        restaurante.setTelefono(restauranteRequestDTO.getTelefono());
        restaurante.setUrlLogo(restauranteRequestDTO.getUrlLogo());
        restaurante.setIdPropietario(restauranteRequestDTO.getIdPropietario());
        return restaurante;
    }

    public static RestauranteResponseDTO toRestauranteResponse(Restaurante restaurante){
        RestauranteResponseDTO restauranteResponseDTO = new RestauranteResponseDTO();
        restauranteResponseDTO.setNit(restaurante.getNit());
        restauranteResponseDTO.setNombre(restaurante.getNombre());
        restauranteResponseDTO.setDireccion(restaurante.getDireccion());
        restauranteResponseDTO.setTelefono(restaurante.getTelefono());
        restauranteResponseDTO.setUrlLogo(restaurante.getUrlLogo());
        return restauranteResponseDTO;
    }

}
