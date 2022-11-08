package com.iteratia.currency_converter.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "currency")
@Entity
public class Currency {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_code", nullable = false)
    private Long numCode;

    @Id
    @Column(name = "char_code")
    private String charCode;

    @Column(name = "nominal", nullable = false)
    private Long nominal;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}
