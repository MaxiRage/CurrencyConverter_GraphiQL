package com.iteratia.currency_converter.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "transactions")
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

    @Column(name = "result", nullable = false)
    private BigDecimal result;

    @Column(name = "volume", nullable = false)
    private BigDecimal volume;

    @ManyToOne
    @JoinColumn(name = "initial_currency", nullable = false)
    private Currency initialCurrency;

    @ManyToOne
    @JoinColumn(name = "final_currency", nullable = false)
    private Currency finalCurrency;

}
