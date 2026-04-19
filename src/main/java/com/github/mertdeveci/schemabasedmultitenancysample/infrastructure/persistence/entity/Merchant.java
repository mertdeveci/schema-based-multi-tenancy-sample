package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.entity;

import com.github.mertdeveci.entity.AbstractIdStatusEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "merchant")
@Getter
@Setter
public class Merchant extends AbstractIdStatusEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

}
