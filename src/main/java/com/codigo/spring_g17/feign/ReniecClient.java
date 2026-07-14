package com.codigo.spring_g17.feign;

import com.codigo.spring_g17.dto.ouput.ReniecResponseApi;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec-service", url = "https://api.decolecta.com/v1/reniec/dni")
public interface ReniecClient {

    @GetMapping
    ReniecResponseApi getInfoPersona(
            @RequestParam String numero,
            @RequestHeader("Authorization") String token);
}
