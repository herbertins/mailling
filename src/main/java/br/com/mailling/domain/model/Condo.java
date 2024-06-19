package br.com.mailling.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "condominiums")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Condo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "email")
    private String email;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "unit_quantity")
    private Integer unitQuantity;

    @Column(name = "type", columnDefinition = "varchar(20)")
    private CondoType type;

    @Column(name = "model", columnDefinition = "varchar(20)")
    private CondoModel model;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}
