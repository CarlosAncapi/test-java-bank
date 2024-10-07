package org.example.pruebabanco.services.impl;

import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.dtos.request.PhonesReq;
import org.example.pruebabanco.entities.ClientEntity;
import org.example.pruebabanco.entities.PhoneEntity;
import org.example.pruebabanco.repositories.ClientsRepository;
import org.example.pruebabanco.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientRepository;

    @Override
    public ClientEntity saveClient(ClientReq client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(client.getName());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setPassword(client.getPassword());

        if (!client.getPhones().isEmpty()) {
            List<PhoneEntity> phonesEntity = new ArrayList<>();
            for (PhonesReq phone : client.getPhones()) {
                PhoneEntity phoneEntity = new PhoneEntity();
                phoneEntity.setNumber(phone.getNumber());
                phoneEntity.setCitycode(phone.getCityCode());
                phoneEntity.setContrycode(phone.getContryCode());
                phonesEntity.add(phoneEntity);
            }
            clientEntity.setPhones(phonesEntity);
        }
        return clientRepository.save(clientEntity);
    }
}
