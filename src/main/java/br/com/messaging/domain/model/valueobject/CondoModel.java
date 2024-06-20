package br.com.messaging.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CondoModel {

    VERTICAL("V", "Vertical"),
    HORIZONTAL("H", "Horizontal");

    private final String code;

    private final String description;

    public static CondoModel fromCode(String value) {
        for (CondoModel obj : CondoModel.values()) {
            if (obj.getCode().equals(value)) {
                return obj;
            }
        }
        throw new IllegalArgumentException("Uknown code" + value);
    }

}
