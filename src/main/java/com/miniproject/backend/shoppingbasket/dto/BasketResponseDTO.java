package com.miniproject.backend.shoppingbasket.dto;

import com.miniproject.backend.loanproduct.dto.LoanProductResponseDTO;
import com.miniproject.backend.shoppingbasket.domain.Basket;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(name = "장바구니 리스트 데이터")
public class BasketResponseDTO { //은행 이미지, 은행 이름, 대출 상품 이름, 금리 + 한도

    @Schema(name = "장바구니id")
    private Long basketId;


    @Schema(name = "상품 출력정보")
    private LoanProductResponseDTO loanProductDTO;




    public BasketResponseDTO(Basket basket){
        this.basketId = basket.getId();
        this.loanProductDTO = new LoanProductResponseDTO(basket.getLoanProduct());
    }







}
