package br.com.mailling.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CondoType {

    RESIDENCIAL("R"),
    COMMERCIAL("C");

    private final String code;

    public static CondoType fromCode(String value) {
        for (CondoType obj : CondoType.values()) {
            if (obj.getCode().equals(value)) {
                return obj;
            }
        }
        throw new IllegalArgumentException("Uknown code" + value);
    }

}
