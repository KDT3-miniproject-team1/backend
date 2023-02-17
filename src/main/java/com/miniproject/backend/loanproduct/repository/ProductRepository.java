package com.miniproject.backend.loanproduct.repository;

import com.miniproject.backend.loanproduct.domain.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<LoanProduct, Long> {

    Optional<LoanProduct> findById(String productId);

}
