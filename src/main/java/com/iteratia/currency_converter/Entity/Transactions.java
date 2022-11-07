package com.iteratia.currency_converter.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "transactions")
@Entity
public class Transactions {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_value", nullable = false)
    private BigDecimal initialValue;

    @Column(name = "final_value", nullable = false)
    private BigDecimal finalValue;

    @Column(name = "rate", nullable = false)
    private BigDecimal rate;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "initial_currency", nullable = false)
    private Currency initialCurrency;

    @ManyToOne
    @JoinColumn(name = "final_currency", nullable = false)
    private Currency finalCurrency;

}
