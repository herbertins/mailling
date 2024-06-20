package br.com.messaging.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    @JsonProperty("logradouro")
    private String street;
    @JsonProperty("numero")
    private String number;
    @JsonProperty("complemento")
    private String neighborhood;
    @JsonProperty("localidade")
    private String city;
    @JsonProperty("uf")
    private String state;
    @JsonProperty("cep")
    private String zipCode;

}
