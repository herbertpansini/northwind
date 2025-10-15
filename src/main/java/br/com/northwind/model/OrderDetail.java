package br.com.northwind.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "\"Order Details\"", schema = "dbo")
@Getter
@Setter
@EqualsAndHashCode(of = "pk")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    @EmbeddedId
    OrderDetailId pk = new OrderDetailId();

    @JsonIgnoreProperties(value = "orderDetails")
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "OrderID", nullable = false)
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "ProductID", nullable = false)
    Product product;

    @Column(name = "UnitPrice", nullable = false, precision = 19, scale = 4)
    BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    Integer quantity = 1;

    @Column(name = "Discount", nullable = false, precision = 24, scale = 4)
    BigDecimal discount = BigDecimal.ZERO;
}