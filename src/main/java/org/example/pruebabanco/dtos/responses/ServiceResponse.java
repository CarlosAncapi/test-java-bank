package org.example.pruebabanco.dtos.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceResponse<T> {
    @JsonProperty("mensaje")
    private String message;

    @JsonProperty("data")
    private T data;
}
