package org.example.pruebabanco.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor // crea un constructor con todas las clases que sean final
@Slf4j
public class ClientsServiceImpl implements ClientsService {

    private final ClientsRepository clientRepository;

    @Override
    public ServiceResponse<ClientEntity> saveClient(ClientReq client) {
        ServiceResponse<ClientEntity> response = new ServiceResponse<>();
        ClientEntity clientEntity = new ClientEntity();
        String mensaje = "";
        if (client != null) {
            Optional<ClientEntity> optionalClient = clientRepository.findByEmail(client.getEmail());
            if (optionalClient.isEmpty()
                    || !client.getPhones().isEmpty()
                    || VerificationUtil.verifyFormatEmail(client.getEmail())
                    || VerificationUtil.verifyPasswordSecurity(client.getPassword())) {
                ClientEntity clientMapped = MappUserDTO.mappUserReq(client);
                mensaje = "Usuario grabado correctamente en la Base de datos";
                clientEntity = clientRepository.save(clientMapped);
            } else {
                // TODO: realizar metodo para personalizar mensaje de error
                mensaje = "No se entregaron datos del cliente en la solicitud de grabación";
            }
        }
        response.setMessage(mensaje);
        response.setData(clientEntity);
        return response;
    }

    @Override
    public ServiceResponse<List<ClientEntity>> getAllUsers() {
        ServiceResponse<List<ClientEntity>> response = new ServiceResponse<>();
        List<ClientEntity> clients = clientRepository.findAll();
        if (!clients.isEmpty()) {
            response.setMessage("Se encontraron los siguientes clientes en la base de datos");
            response.setData(clients);
        } else {
            response.setMessage("No se encontraron clientes en la base de datos ");
            response.setData(null);
        }
        return response;
    }




}

