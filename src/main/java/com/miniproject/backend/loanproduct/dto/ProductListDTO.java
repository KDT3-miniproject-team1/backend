package com.miniproject.backend.loanproduct.dto;

import com.miniproject.backend.loanproduct.domain.LoanProduct;
import com.miniproject.backend.loanproduct.domain.LoanRate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@Getter
@ToString
@Schema(name = "제품 리스트 출력 데이터 ")
public class ProductListDTO {

    @Schema(description = "상품아이디", defaultValue = "1")
    private Long id;
    @Schema(description = "상품 이름", defaultValue = "test대출")
    private String productName;
    @Schema(description = "은행 이름", defaultValue = "test은행")
    private String bankName;
    @Schema(description = "상품 이름", defaultValue = "은행 img")
    private String bankImg;
    private List<LongRateShortDTO> longRateShortDTO;
//    private List<LoanRate> loanRates;

    public ProductListDTO(LoanProduct loanProduct) {
        this.id = loanProduct.getBank().getId();
        this.productName = loanProduct.getProductNm();
        this.bankName = loanProduct.getBank().getBankNm();
        this.bankImg = loanProduct.getBank().getImgPath();
        this.longRateShortDTO = toRateDTO(loanProduct.getLoanRates());
//        this.loanRates = loanProduct.getLoanRates();
    }

    public List<LongRateShortDTO> toRateDTO(List<LoanRate> loanRates) {
        return loanRates.stream().map(LongRateShortDTO::new)
                .collect(Collectors.toList());
    }
}
