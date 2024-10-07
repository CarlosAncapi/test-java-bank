package org.example.pruebabanco.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhonesReq {

    @JsonProperty("number")
    private String number;

    @JsonProperty("citycode")
    private String cityCode;

    @JsonProperty("contrycode")
    private String contryCode;
}
