package com.aalvarezg.ms_plazoleta.infrastructure.configuration;

import com.aalvarezg.ms_plazoleta.domain.api.IRestauranteServicePort;
import com.aalvarezg.ms_plazoleta.domain.spi.IRestaurantePersistencePort;
import com.aalvarezg.ms_plazoleta.domain.spi.IUsuarioPersistencePort;
import com.aalvarezg.ms_plazoleta.domain.usecase.RestauranteUseCase;
import com.aalvarezg.ms_plazoleta.infrastructure.feign.adapter.UsuarioFeingAdapter;
import com.aalvarezg.ms_plazoleta.infrastructure.feign.client.IUsuarioFeingClient;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.adapter.RestauranteJpaAdapter;
import com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRestauranteRepository restauranteRepository;
    private final IUsuarioFeingClient usuarioFeingClient;

    @Bean
    public IRestaurantePersistencePort restaurantePersistencePort() {
        return new RestauranteJpaAdapter(restauranteRepository); // Pasamos el repositorio correctamente
    }

    @Bean
    public IUsuarioPersistencePort usuarioPersistencePort() {
        return new UsuarioFeingAdapter(usuarioFeingClient); // Pasamos el cliente Feign correctamente
    }

    @Bean
    public IRestauranteServicePort restauranteServicePort() {
        return new RestauranteUseCase(restaurantePersistencePort(), usuarioPersistencePort());
    }
}
