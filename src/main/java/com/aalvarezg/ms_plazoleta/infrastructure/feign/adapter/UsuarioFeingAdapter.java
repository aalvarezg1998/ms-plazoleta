package com.aalvarezg.ms_plazoleta.infrastructure.feign.adapter;

import com.aalvarezg.ms_plazoleta.domain.spi.IUsuarioPersistencePort;
import com.aalvarezg.ms_plazoleta.infrastructure.exception.NoIsPropietarioException;
import com.aalvarezg.ms_plazoleta.infrastructure.feign.client.IUsuarioFeingClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class UsuarioFeingAdapter implements IUsuarioPersistencePort {
    private final IUsuarioFeingClient usuarioFeingClient;

    @Override
    public boolean isPropietario(Long idPropietario) {
        try {
            return usuarioFeingClient.isPropietario(idPropietario).getBody();
        }catch (Exception exception){
            log.info(exception.getMessage());
            throw new NoIsPropietarioException();
        }
    }
}
