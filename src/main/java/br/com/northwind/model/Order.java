package br.com.northwind.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Orders\"", schema = "dbo")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", nullable = false)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    Employee employee;

    @Column(name = "OrderDate")
    LocalDateTime orderDate;

    @Column(name = "RequiredDate")
    LocalDateTime requiredDate;

    @Column(name = "ShippedDate")
    LocalDateTime shippedDate;

    @Column(name = "ShipVia")
    Integer shipVia;

    @Column(name = "Freight", precision = 19, scale = 4)
    BigDecimal freight = BigDecimal.ZERO;

    @Column(name = "ShipName")
    String shipName;

    @Column(name = "ShipAddress")
    String shipAddress;

    @Column(name = "ShipCity")
    String shipCity;

    @Column(name = "ShipRegion")
    String shipRegion;

    @Column(name = "ShipPostalCode")
    String shipPostalCode;

    @Column(name = "ShipCountry")
    String shipCountry;

    @JsonIgnoreProperties(value = {"order"}, allowSetters = true)
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Set<OrderDetail> orderDetails = new HashSet<>();
}