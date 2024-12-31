package com.aalvarezg.ms_plazoleta.domain.usecase;

import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import com.aalvarezg.ms_plazoleta.domain.spi.IRestaurantePersistencePort;
import com.aalvarezg.ms_plazoleta.domain.spi.IUsuarioPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestauranteUseCaseTest {

    @Mock
    private IRestaurantePersistencePort restaurantePersistencePort;

    @Mock
    private IUsuarioPersistencePort usuarioPersistencePort;

    @InjectMocks
    private RestauranteUseCase restauranteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearRestaurante_Correcto() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "Restaurante Prueba", "123456789",
                10L, "+123456789", "http://logo.com/logo.png", "90134453");
        when(usuarioPersistencePort.isPropietario(10L)).thenReturn(true);
        when(restaurantePersistencePort.crearRestaurante(restaurante)).thenReturn(restaurante);

        // Act
        Restaurante result = restauranteUseCase.crearRestaurante(restaurante);

        // Assert
        assertEquals(restaurante, result);
        verify(restaurantePersistencePort, times(1)).crearRestaurante(restaurante);
    }

    @Test
    void crearRestaurante_NombreInvalido() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "12121212", "123456789",
                7L, "+123456789", "http://logo.com/logo.png", "90134453");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> restauranteUseCase.crearRestaurante(restaurante));
        assertEquals("El nombre del restaurante no es válido. No puede contener solo números.", exception.getMessage());
    }

    @Test
    void crearRestaurante_NitInvalido() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "Restaurante Prueba", "123456789",
                7L, "+123456789", "http://logo.com/logo.png", "ASDAA");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> restauranteUseCase.crearRestaurante(restaurante));
        assertEquals("El NIT no es válido. Debe ser numérico.", exception.getMessage());
    }

    @Test
    void crearRestaurante_TelefonoInvalido() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "Restaurante Prueba", "123456789",
                7L, "+1234--89", "http://logo.com/logo.png", "90134453");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> restauranteUseCase.crearRestaurante(restaurante));
        assertEquals("El teléfono no es válido. Debe ser numérico y puede contener un máximo de 13 caracteres con el símbolo '+'.", exception.getMessage());
    }

    @Test
    void crearRestaurante_PropietarioInvalido() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "Restaurante Prueba", "123456789",
                2L, "+123456789", "http://logo.com/logo.png", "90134453");

        when(usuarioPersistencePort.isPropietario(10L)).thenReturn(false);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> restauranteUseCase.crearRestaurante(restaurante));
        assertEquals("El ID del usuario propietario no corresponde a un usuario con el rol adecuado.", exception.getMessage());
    }

}