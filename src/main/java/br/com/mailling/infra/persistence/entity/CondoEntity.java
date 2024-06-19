package br.com.mailling.infra.persistence.entity;

import br.com.mailling.domain.model.Address;
import br.com.mailling.domain.model.CondoModel;
import br.com.mailling.domain.model.CondoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_condo")
public class CondoEntity {

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

    @Column(name = "type", columnDefinition = "varchar(1)")
    private String type;

    @Column(name = "model", columnDefinition = "varchar(1)")
    private String model;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;


}
