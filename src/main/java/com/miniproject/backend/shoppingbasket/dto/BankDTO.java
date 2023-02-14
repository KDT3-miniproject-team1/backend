package com.miniproject.backend.shoppingbasket.dto;

import com.miniproject.backend.bank.Bank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Schema(name = "은행 데이터")
public class BankDTO {

    @Schema(name = "은행이름")
    private String bankName;

    @Schema(name = "은행아이콘")
    private String image;

    public BankDTO(Bank bank){
        this.bankName = bank.getBankNm();
        this.image = bank.getImgPath();
    }

}
