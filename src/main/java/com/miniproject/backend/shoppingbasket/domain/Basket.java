package com.miniproject.backend.shoppingbasket.domain;

import com.miniproject.backend.loanproduct.domain.LoanProduct;
import com.miniproject.backend.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shopping_basket")
public class Basket {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shopping_basket_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id ")
    private LoanProduct loanProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
