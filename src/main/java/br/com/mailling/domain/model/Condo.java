package br.com.mailling.domain.model;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Condo {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private Long id;

    private String name;

    private String description;

    private String email;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Integer unitQuantity;

    private CondoType type;

    private CondoModel model;

    private Address address;

    public Condo(Long id, String name, String description, String email, BigDecimal latitude, BigDecimal longitude, Integer unitQuantity, CondoType type, CondoModel model, Address address) {

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.unitQuantity = unitQuantity;
        this.type = type;
        this.model = model;
        this.address = address;
    }

    private boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public CondoType getType() {
        return type;
    }

    public void setType(CondoType type) {
        this.type = type;
    }

    public CondoModel getModel() {
        return model;
    }

    public void setModel(CondoModel model) {
        this.model = model;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
