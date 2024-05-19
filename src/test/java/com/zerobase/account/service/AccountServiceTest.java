package com.zerobase.account.service;

import com.zerobase.account.domain.CreateAccountRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void testCreateAccount() {
        //accountService.createAccount();
        //Account account = accountService.getAccount(1L);

        //assertEquals("4000", account.getAccountNumber());
        //assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }

    @Test
    void testGetAccount2() {
        //accountService.createAccount();
        //Account account = accountService.getAccount(2L);

        //assertEquals("4000", account.getAccountNumber());
        //assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }

}