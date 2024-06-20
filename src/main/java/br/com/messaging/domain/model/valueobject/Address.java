package br.com.messaging.domain.model.valueobject;

public class Address {

    private Long id;
    private String street;
    private String numero;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;

    public Address(Long id, String street, String neighborhood, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumero() {
        return numero;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }


}
