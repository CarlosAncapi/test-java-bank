package org.example.pruebabanco.services;

import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.dtos.responses.ServiceResponse;

public interface ClientsService {

    ServiceResponse saveClient(ClientReq client);

}
