package com.zerobase.account.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {

    @Test
    void accountDto() {
        // given
        // when
        // then

        AccountDto accountDto = new AccountDto();
        accountDto.setClientId("testClient");
        System.out.println(accountDto.getClientId());
    }

}