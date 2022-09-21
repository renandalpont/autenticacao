package apitoken.autenticacao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPrimaria {

    @RequestMapping("/")
    public String index() {
        return  "Funcionando";
    }

}