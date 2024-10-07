package org.example.pruebabanco.services;

import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.dtos.responses.ServiceResponse;
import org.example.pruebabanco.entities.ClientEntity;

import java.util.List;

public interface ClientsService {

    ServiceResponse saveClient(ClientReq client);

    ServiceResponse getAllUsers ();

}
