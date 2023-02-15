package com.miniproject.backend.bank.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Bank {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id")
    private Long id;

    @Column(name = "bank_name")
    private String bankNm;

    @Column(name = "icon_path")
    private String imgPath;
}
