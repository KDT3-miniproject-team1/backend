package com.miniproject.backend.loanproduct.dto;

import com.miniproject.backend.loanproduct.domain.LoanProduct;
import com.miniproject.backend.loanproduct.domain.LoanRate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Schema(name = "상품 데이터")
public class LoanProductResponseDTO {

    @Schema(name = "상품id")
    private String productId;

    @Schema(name = "은행아이콘")
    private String bankImgPath;

    @Schema(name = "은행이름")
    private String bankName;
    @Schema(name = "상품이름")
    private String productName;
    @Schema(name = "대출한도")
    private String loanLimit;

    @Schema(name = "대출금리 리스트")
    private List<LoanRate> loanRateList;

    public LoanProductResponseDTO(LoanProduct loanProduct){
        this.productId = loanProduct.getId();
        this.bankImgPath = loanProduct.getBank().getImgPath();
        this.bankName = loanProduct.getBank().getBankNm();
        this.productName = loanProduct.getProductNm();
        this.loanRateList = loanProduct.getLoanRates();
        this.loanLimit = loanProduct.getLoanLimit();

    }


}
