package br.com.mailling.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request {

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
    private String type;

    @JsonProperty("modelo")
    private String model;

}
