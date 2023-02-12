package com.miniproject.backend.like.domain;

import com.miniproject.backend.loanproduct.domain.LoanProduct;
import com.miniproject.backend.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "likes_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id ")
    private LoanProduct loanProduct;
}
