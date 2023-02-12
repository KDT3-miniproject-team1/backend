package com.miniproject.backend.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "EMAIL_UNIQUE", columnNames = {"email"})})
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String birth; //생년월일+뒷자리 1개

    private int asset; //사용자 자산

    private int income; //소득

    private String job; //직업

    private String region; //지역

    @Column(name = "why_join")
    private String whyJoin; //가입목적

}
