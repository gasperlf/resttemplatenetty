package ar.com.demonetty.bussineslogic;

import ar.com.demonetty.dtos.Planeta;
import ar.com.demonetty.services.AccesoAServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@Configurable
public class BussinesLogicImpl implements BusinessLogic {

    @Autowired
    private AccesoAServices accesoAServices;
    ObjectMapper objectMapper = null;

    @PostConstruct
    public void setUp(){
        objectMapper = new ObjectMapper();
    }

    public Planeta getPlaneta(){
        long start =  System.currentTimeMillis();
        Planeta planeta =null;

        ResponseEntity<String> response = accesoAServices.readMensaje();
        if(response !=  null){
            planeta = (Planeta) converter(response.getBody(),Planeta.class);
        }
        System.out.println("Time logic: " + (System.currentTimeMillis()-start));
        return  planeta;
    }

    public Object converter(String json,Class cClass){
        Object o = null;
        try {
             o = objectMapper.readValue(json,cClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}
