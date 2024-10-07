package org.example.pruebabanco.services.impl;

import org.example.pruebabanco.dtos.mapper.MappUserDTO;
import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.dtos.responses.ServiceResponse;
import org.example.pruebabanco.entities.ClientEntity;
import org.example.pruebabanco.repositories.ClientsRepository;
import org.example.pruebabanco.services.ClientsService;
import org.example.pruebabanco.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientRepository;

    @Override
    public ServiceResponse saveClient(ClientReq client) {
        ServiceResponse response = new ServiceResponse();
        ClientEntity clientEntity = new ClientEntity();
        String mensaje = "";
        if(client != null){
            Optional<ClientEntity> existingClient = clientRepository.findByEmail(client.getEmail());
            if (!existingClient.isPresent()) {
                if(!client.getPhones().isEmpty()){
                    if(VerificationUtil.verifyFormatEmail(client.getEmail())){
                        if(VerificationUtil.verifyPasswordSecurity(client.getPassword())){
                            ClientEntity clientMapped = MappUserDTO.mappUserReq(client);
                            mensaje = "Usuario grabado correctamente en la Base de datos";
                            clientEntity = clientRepository.save(clientMapped);
                        }else{
                            mensaje = "la clave debe contener al menos : 1 Mayúscula, 2 letras minúsculas, y 2 números";
                        }
                    }else {
                        mensaje = "El correo debe contener el siguiente formato:  aaaaaaa@dominio.cl";
                    }
                }else{
                    mensaje = "El cliente debería tener al menos un teléfono";
                }
            }else{
                mensaje = "El correo ya existe en la base de datos";
            }
        }else {
            mensaje = "No se entregaron datos del cliente en la solicitud de grabación";
        }
        response.setMessage(mensaje);
        response.setData(clientEntity);
        return response;
    }

    @Override
    public ServiceResponse getAllUsers() {
        ServiceResponse response = new ServiceResponse();
        List<ClientEntity> clients = clientRepository.findAll();
        if(!clients.isEmpty()){
            response.setMessage("Se encontraron los siguientes clientes en la base de datos");
            response.setData(clients);
        }else {
            response.setMessage("No se encontr´ningún cliente en la base de datos ");
            response.setData(null);
        }
        return response;
    }

}

