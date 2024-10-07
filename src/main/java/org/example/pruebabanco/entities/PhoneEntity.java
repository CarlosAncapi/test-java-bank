package org.example.pruebabanco.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "phones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, length = 15)
    private String number;

    @Column(name = "city_code", nullable = false, length = 5)
    private String citycode;

    @Column(name = "country_code", nullable = false, length = 5)
    private String contrycode;

    @ManyToMany(mappedBy = "phones")
    private List<ClientEntity> clients;
}
