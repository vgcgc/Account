package com.zerobase.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResponse {
    private String clientId;
    private String accountNumber;
    private LocalDateTime createAt;

}
