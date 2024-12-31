package com.aalvarezg.ms_plazoleta.infrastructure.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-usuarios", url = "${ms.usuarios.url}")
public interface IUsuarioFeingClient {
    @GetMapping("/propietarios/")
    ResponseEntity<Boolean> isPropietario(@RequestParam("id") Long id);
}
