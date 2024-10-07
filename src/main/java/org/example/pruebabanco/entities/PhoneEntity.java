package org.example.pruebabanco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "phones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonIgnore // Evito la serialización recursiva
    private List<ClientEntity> clients;
}
