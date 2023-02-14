package com.miniproject.backend.shoppingbasket.dto;

import com.miniproject.backend.bank.Bank;
import com.miniproject.backend.category.Category;
import com.miniproject.backend.shoppingbasket.domain.Basket;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@Schema(name = "장바구니 리스트 데이터")
public class BasketResponseDTO { //은행 이미지, 은행 이름, 대출 상품 이름, 금리 + 한도

    @Schema(name = "장바구니id")
    private Long basketId;

    @Schema(name = "은행 출력정보")
    private BankDTO bankDTO;

    @Schema(name = "상품 출력정보")
    private LoanProductDTO loanProductDTO;




    public BasketResponseDTO(Basket basket){
        this.basketId = basket.getId();
        this.bankDTO = new BankDTO(basket.getLoanProduct().getBank());
        this.loanProductDTO = new LoanProductDTO(basket.getLoanProduct());

    }







}
