package com.miniproject.backend.loanproduct.dto;

import com.miniproject.backend.loanproduct.domain.LoanRate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(name = "대출금리 출력데이터")
public class LoanRateResponseDTO {

    @Schema(name = "대출금리")
    private float avgRate;

    public LoanRateResponseDTO(LoanRate loanRate){
        this.avgRate = loanRate.getAvgRate();
    }



}
