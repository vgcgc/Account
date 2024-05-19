package com.zerobase.account.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountRequest {
    private String clientId;
    private Integer accountBalance;

}
