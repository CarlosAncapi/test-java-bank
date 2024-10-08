package org.example.pruebabanco.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Getter
@AllArgsConstructor
public class ClientReq {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phones")
    private List<PhonesReq> phones;

}
