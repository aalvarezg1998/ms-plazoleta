package com.aalvarezg.ms_plazoleta.application.handler;

import com.aalvarezg.ms_plazoleta.application.dto.RestauranteRequestDTO;
import com.aalvarezg.ms_plazoleta.application.dto.RestauranteResponseDTO;
import com.aalvarezg.ms_plazoleta.application.mapper.RestautanteMapper;
import com.aalvarezg.ms_plazoleta.domain.api.IRestauranteServicePort;
import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestauranteHandlerTest {

    @Mock
    private IRestauranteServicePort restauranteServicePort;

    @InjectMocks
    private RestauranteHandler restauranteHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearRestaurante_Correcto() {
        // Arrange
        RestauranteRequestDTO requestDTO = new RestauranteRequestDTO();
        requestDTO.setNombre("Restaurante Prueba");
        requestDTO.setNit("123456789");
        requestDTO.setDireccion("Dirección Prueba");
        requestDTO.setTelefono("+123456789");
        requestDTO.setUrlLogo("http://logo.com/logo.png");
        requestDTO.setIdPropietario(10L);

        Restaurante restaurante = RestautanteMapper.toRestaurante(requestDTO);

        Restaurante restauranteCreado = new Restaurante(1L, "Restaurante Prueba", "Dirección Prueba",
                7L, "+123456789", "http://logo.com/logo.png", "123456789");

        when(restauranteServicePort.crearRestaurante(any(Restaurante.class))).thenReturn(restauranteCreado);

        RestauranteResponseDTO expectedResponse = RestautanteMapper.toRestauranteResponse(restauranteCreado);

        // Act
        RestauranteResponseDTO actualResponse = restauranteHandler.crearRestaurante(requestDTO);

        // Assert
        assertEquals(expectedResponse.getNombre(), actualResponse.getNombre());
        assertEquals(expectedResponse.getNit(), actualResponse.getNit());
        assertEquals(expectedResponse.getDireccion(), actualResponse.getDireccion());
        assertEquals(expectedResponse.getTelefono(), actualResponse.getTelefono());
        assertEquals(expectedResponse.getUrlLogo(), actualResponse.getUrlLogo());

        verify(restauranteServicePort, times(1)).crearRestaurante(any(Restaurante.class));
    }

}