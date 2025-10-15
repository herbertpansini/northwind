package br.com.northwind.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(of = {"orderId", "productId"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "OrderID")
    Long orderId;

    @Column(name = "ProductID")
    Long productId;
}