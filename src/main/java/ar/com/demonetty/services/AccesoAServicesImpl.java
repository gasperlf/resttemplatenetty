package ar.com.demonetty.services;

import ar.com.demonetty.dtos.Planeta;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Configurable
public class AccesoAServicesImpl implements AccesoAServices {

    @Autowired
    private RestTemplate restTemplate;

    public static final String BASE_URL = "http://swapi.co/api";
    public static final String APPLICATION_NAME = "SWAPI-JAVA";

    @Override
    public String mensaje() {
        return "Hola lewis!!!";
    }

    public ResponseEntity<String> readMensaje(){
        long start =  System.currentTimeMillis();
        ResponseEntity<String> response = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent",  APPLICATION_NAME);
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(httpHeaders);
        try {
             response = restTemplate.exchange("https://swapi.co/api/planets/1/", HttpMethod.GET,  entity,String.class);
        }catch (RestClientException e){
            e.printStackTrace();
        }
        System.out.println("Time acces: " + (System.currentTimeMillis()-start));
        return response;
    }
}
