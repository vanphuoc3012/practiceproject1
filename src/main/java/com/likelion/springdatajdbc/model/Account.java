package com.likelion.springdatajdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    private Long id;

    private String name;

    private BigDecimal amount;
}
