package com.aalvarezg.ms_plazoleta.domain.usecase;

import com.aalvarezg.ms_plazoleta.domain.api.IRestauranteServicePort;
import com.aalvarezg.ms_plazoleta.domain.model.Restaurante;
import com.aalvarezg.ms_plazoleta.domain.spi.IRestaurantePersistencePort;
import com.aalvarezg.ms_plazoleta.domain.spi.IUsuarioPersistencePort;

public class RestauranteUseCase implements IRestauranteServicePort {
    public static final String REGEX_SOLO_NUMERO = "\\d+";
    public static final String REGEX_TELEFONO_VALIDO = "\\+?\\d{1,13}";
    public static final String REGEX_NOMBRE_VALIDO = ".*[a-zA-Z]+.*";
    private final IRestaurantePersistencePort restaurantePersistencePort;
    private final IUsuarioPersistencePort usuarioPersistencePort;

    public RestauranteUseCase(IRestaurantePersistencePort restaurantePersistencePort, IUsuarioPersistencePort usuarioPersistencePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
        this.usuarioPersistencePort = usuarioPersistencePort;
    }

    @Override
    public Restaurante crearRestaurante(Restaurante restaurante) {
        validarRestaurante(restaurante);
        return restaurantePersistencePort.crearRestaurante(restaurante);
    }

    private void validarRestaurante(Restaurante restaurante) {
        validarCamposObligatorios(restaurante);
        validarFormatoDatos(restaurante);
        validarUsuarioPropietario(restaurante.getIdPropietario());
    }

    private void validarCamposObligatorios(Restaurante restaurante) {
        validarCampoNoVacio(restaurante.getNombre(), "El nombre del restaurante es obligatorio.");
        validarCampoNoVacio(restaurante.getNit(), "El NIT del restaurante es obligatorio.");
        validarCampoNoVacio(restaurante.getDireccion(), "La dirección del restaurante es obligatoria.");
        validarCampoNoVacio(restaurante.getTelefono(), "El teléfono del restaurante es obligatorio.");
        validarCampoNoVacio(restaurante.getUrlLogo(), "La URL del logo es obligatoria.");

        if (restaurante.getIdPropietario() == null) {
            throw new IllegalArgumentException("El ID del usuario propietario es obligatorio.");
        }
    }

    private void validarCampoNoVacio(String campo, String mensajeError) {
        if (campo == null || campo.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    private void validarFormatoDatos(Restaurante restaurante) {
        if (!esNombreValido(restaurante.getNombre())) {
            throw new IllegalArgumentException("El nombre del restaurante no es válido. No puede contener solo números.");
        }
        if (!esDocumentoValido(restaurante.getNit())) {
            throw new IllegalArgumentException("El NIT no es válido. Debe ser numérico.");
        }
        if (!esTelefonoValido(restaurante.getTelefono())) {
            throw new IllegalArgumentException("El teléfono no es válido. Debe ser numérico y puede contener un máximo de 13 caracteres con el símbolo '+'.");
        }
    }

    private void validarUsuarioPropietario(Long idUsuarioPropietario) {
        if (!esUsuarioPropietarioValido(idUsuarioPropietario)) {
            throw new IllegalArgumentException("El ID del usuario propietario no corresponde a un usuario con el rol adecuado.");
        }
    }

    private boolean esDocumentoValido(String documento) {
        return documento.matches(REGEX_SOLO_NUMERO);
    }

    private boolean esTelefonoValido(String telefono) {
        return telefono.matches(REGEX_TELEFONO_VALIDO);
    }

    private boolean esNombreValido(String nombre) {
        return nombre.matches(REGEX_NOMBRE_VALIDO) && !nombre.matches(REGEX_SOLO_NUMERO);
    }

    private boolean esUsuarioPropietarioValido(Long idUsuarioPropietario) {
        return usuarioPersistencePort.isPropietario(idUsuarioPropietario);
    }

}
