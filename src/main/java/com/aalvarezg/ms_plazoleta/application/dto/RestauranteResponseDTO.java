package com.aalvarezg.ms_plazoleta.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteResponseDTO {
    private String nombre;
    private String direccion;
    private String telefono;
    private String urlLogo;
    private String nit;
}
