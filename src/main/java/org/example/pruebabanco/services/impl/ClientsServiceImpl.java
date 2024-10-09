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
                mensaje = errorMessage(optionalClient, client);
            }
        } else {
            mensaje = "No se entregaron datos del cliente en la solicitud de grabación";
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

    private String errorMessage(Optional<ClientEntity> optionalClient, ClientReq client) {
        String mensaje = "";
        if (optionalClient.isPresent()) {
            mensaje = "El cliente ya existe en la base de datos";
        } else if (client.getPhones().isEmpty()) {
            mensaje = "El cliente no tiene información de algún teléfono";
        } else if (!VerificationUtil.verifyFormatEmail(client.getEmail())) {
            mensaje = "El correo no cumple con el siguiente formato : aaaaa@dominio.cl";
        } else if (!VerificationUtil.verifyPasswordSecurity(client.getPassword())) {
            mensaje = "La contraseña entregada debe tener el siguiente formato: Al menos Una Mayúscula, 2 letras minúsculas, y dos números";
        }
        return mensaje;
    }


}

