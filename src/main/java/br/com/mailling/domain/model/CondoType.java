package br.com.mailling.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CondoType {

    RESIDENCIAL("R", "Residencial"),
    COMMERCIAL("C", "Comercial");

    private final String code;

    private final String description;

    public static CondoType fromCode(String value) {
        for (CondoType obj : CondoType.values()) {
            if (obj.getCode().equals(value)) {
                return obj;
            }
        }
        throw new IllegalArgumentException("Uknown code" + value);
    }

}
