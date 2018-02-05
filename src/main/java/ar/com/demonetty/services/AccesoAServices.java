package ar.com.demonetty.services;

import ar.com.demonetty.dtos.Mensaje;
import ar.com.demonetty.dtos.Planeta;
import org.springframework.http.ResponseEntity;

public interface AccesoAServices {

    public String mensaje();

    ResponseEntity<String> readMensaje();
}
