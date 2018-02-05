package ar.com.demonetty.resources;

import ar.com.demonetty.bussineslogic.BusinessLogic;
import ar.com.demonetty.dtos.Planeta;
import ar.com.demonetty.services.AccesoAServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo/v1")
public class RestResources {

    @Autowired
    private BusinessLogic businessLogic;

    @GetMapping(path = "/message",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getEstring() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

    @GetMapping(path = "/mensaje",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<Planeta> getMensaje(){
       return new ResponseEntity<Planeta>(this.businessLogic.getPlaneta(),HttpStatus.OK);
    }
}
