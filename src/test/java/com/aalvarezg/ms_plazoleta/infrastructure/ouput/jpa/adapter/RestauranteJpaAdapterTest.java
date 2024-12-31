package com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.adapter;

import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.entity.RestaurantesEntity;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.repository.IRestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RestauranteJpaAdapterTest {

    @Mock
    private IRestauranteRepository restauranteRepository;

    @InjectMocks
    private RestauranteJpaAdapter restauranteJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearRestaurante_Correcto() {
        // Arrange
        Restaurante restaurante = new Restaurante(1L, "Restaurante Prueba", "Dirección Prueba",
                7L, "+123456789", "http://logo.com/logo.png", "123456789");

        RestaurantesEntity entityToSave = new RestaurantesEntity();
        entityToSave.setId(1L);
        entityToSave.setNombre("Restaurante Prueba");
        entityToSave.setNit("123456789");
        entityToSave.setDireccion("Dirección Prueba");
        entityToSave.setTelefono("+123456789");
        entityToSave.setUrlLogo("http://logo.com/logo.png");
        entityToSave.setIdPropietario(10L);

        RestaurantesEntity savedEntity = new RestaurantesEntity();
        savedEntity.setId(1L);
        savedEntity.setNombre("Restaurante Prueba");
        savedEntity.setNit("123456789");
        savedEntity.setDireccion("Dirección Prueba");
        savedEntity.setTelefono("+123456789");
        savedEntity.setUrlLogo("http://logo.com/logo.png");
        savedEntity.setIdPropietario(10L);

        when(restauranteRepository.save(any(RestaurantesEntity.class))).thenReturn(savedEntity);

        // Act
        Restaurante result = restauranteJpaAdapter.crearRestaurante(restaurante);

        // Assert
        assertEquals(restaurante.getId(), result.getId());
        assertEquals(restaurante.getNombre(), result.getNombre());
        assertEquals(restaurante.getNit(), result.getNit());
        assertEquals(restaurante.getDireccion(), result.getDireccion());
    }

}