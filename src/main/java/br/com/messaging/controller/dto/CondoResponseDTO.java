package br.com.messaging.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CondoResponseDTO {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("email")
    private String email;

    @JsonProperty("latitude")
    private BigDecimal latitude;

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("quantidade_unidade")
    private Integer unitQuantity;

    @JsonProperty("tipo")
    private CondoType type;

    @JsonProperty("modelo")
    private CondoModel model;

    @JsonProperty("endereco")
    private AddressDTO address;

    @Getter
    @AllArgsConstructor
    public static class CondoType {
        @JsonProperty("codigo")
        private String code;
        @JsonProperty("descricao")
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class CondoModel {
        @JsonProperty("codigo")
        private String code;
        @JsonProperty("descricao")
        private String description;
    }

}
