package com.zerobase.account.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class AccountDto {
    private String clientId;
    private String accountNumber;
    private Integer accountBalance;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

}
