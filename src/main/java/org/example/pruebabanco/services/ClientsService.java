package org.example.pruebabanco.services;

import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.entities.ClientEntity;
import org.springframework.stereotype.Service;

public interface ClientsService {

    ClientEntity saveClient(ClientReq client);

}
