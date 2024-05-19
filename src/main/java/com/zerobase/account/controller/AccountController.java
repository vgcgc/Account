package com.zerobase.account.controller;

import com.zerobase.account.domain.*;
import com.zerobase.account.service.AccountService;
import com.zerobase.account.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }

    @PostMapping("/create-account")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest createAccount) {
        return accountService.createAccount(createAccount);
    }

    @PostMapping("/delete-account")
    public DeleteAccountResponse deleteAccount(@RequestBody DeleteAccountRequest deleteAccount) {
        return accountService.deleteAccount(deleteAccount);

    }

    @GetMapping("/select-account")
    public List<SelectAccountResponse> getAccount(@RequestParam("clientId") String clientId) {
        return accountService.selectAccount(clientId);
    }

}
