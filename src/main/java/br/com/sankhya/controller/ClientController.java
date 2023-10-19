package br.com.sankhya.controller;

import br.com.sankhya.entity.Client;
import br.com.sankhya.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/Clientes")
    public ResponseEntity registerClient(@RequestParam Client client){
        ResponseEntity response = registerClient(client);
        return response;
    }

    @GetMapping("/Clientes")
    public ResponseEntity getClients(){
        ResponseEntity response = getClients();
        return response;
    }

}
