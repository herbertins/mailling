package br.com.mailling.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CondoModel {

    VERTICAL("V"),
    HORIZONTAL("H");

    private final String code;

    public static CondoModel fromCode(String value) {
        for (CondoModel obj : CondoModel.values()) {
            if (obj.getCode().equals(value)) {
                return obj;
            }
        }
        throw new IllegalArgumentException("Uknown code" + value);
    }

}
