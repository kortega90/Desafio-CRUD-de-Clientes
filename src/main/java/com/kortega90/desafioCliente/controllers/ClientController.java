package com.kortega90.desafioCliente.controllers;

import com.kortega90.desafioCliente.dto.ClientDTO;
import com.kortega90.desafioCliente.entities.Client;
import com.kortega90.desafioCliente.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping (value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

@GetMapping (value = "/{id}")
    public ClientDTO findById( @PathVariable Long id){
        return service.findById(id);
    }
}
