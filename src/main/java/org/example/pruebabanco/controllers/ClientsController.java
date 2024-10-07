package org.example.pruebabanco.controllers;

import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.entities.ClientEntity;
import org.example.pruebabanco.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes/")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/crear-usuario")
    public ClientEntity createClient(@RequestBody ClientReq client) {
        return clientsService.saveClient(client);

    }
}
