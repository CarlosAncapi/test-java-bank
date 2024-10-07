package org.example.pruebabanco.dtos.mapper;

import org.example.pruebabanco.dtos.request.ClientReq;
import org.example.pruebabanco.dtos.request.PhonesReq;
import org.example.pruebabanco.entities.ClientEntity;
import org.example.pruebabanco.entities.PhoneEntity;

import java.util.ArrayList;
import java.util.List;

public class MappUserDTO {

    public static ClientEntity mappUserReq(ClientReq clientReq) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientReq.getName());
        clientEntity.setEmail(clientReq.getEmail());
        clientEntity.setPassword(clientReq.getPassword());

        List<PhoneEntity> phonesEntity = new ArrayList<>();
        for (PhonesReq phone : clientReq.getPhones()) {
            PhoneEntity phoneEntity = new PhoneEntity();
            phoneEntity.setNumber(phone.getNumber());
            phoneEntity.setCitycode(phone.getCityCode());
            phoneEntity.setContrycode(phone.getContryCode());
            phonesEntity.add(phoneEntity);
        }
        clientEntity.setPhones(phonesEntity);

        return clientEntity;
    }

}
