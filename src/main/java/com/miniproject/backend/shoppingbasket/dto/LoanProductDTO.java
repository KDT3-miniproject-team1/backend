package com.miniproject.backend.shoppingbasket.dto;

import com.miniproject.backend.loanproduct.domain.LoanProduct;
import com.miniproject.backend.loanproduct.domain.LoanRate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Schema(name = "상품 데이터")
public class LoanProductDTO {

    @Schema(name = "상품id")
    private String productId;
    @Schema(name = "상품이름")
    private String productName;
    @Schema(name = "대출한도")
    private String loanLimit;
    @Schema(name = "대출금리 리스트")
    private List<LoanRateDTO> loanRateList;

    public LoanProductDTO(LoanProduct loanProduct){
        this.productId = loanProduct.getId();
        this.productName = loanProduct.getProductNm();
        this.loanLimit = loanProduct.getLoanLimit();
        this.loanRateList = loanProduct.getLoanRates().stream().map(entity->new LoanRateDTO(entity)).collect(Collectors.toList());
    }


}
