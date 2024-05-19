package com.zerobase.account.service;

import com.zerobase.account.domain.*;
import com.zerobase.account.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    // 계좌 가져오기
    @Transactional
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
    
    // 계좌 생성
    @Transactional
    public CreateAccountResponse createAccount(CreateAccountRequest request) {

        String accountNumber = null;

        while(true) {
            accountNumber = String.format("%010d", (long)((Math.random()*9999999)+1));
            if(accountRepository.findByAccountNumber(accountNumber) == null) break;
        }

         Account account = Account.builder()
                 .accountNumber(accountNumber)
                 .clientId(request.getClientId())
                 .accountBalance(request.getAccountBalance())
                 .createdAt(LocalDateTime.now())
                 .build();
         accountRepository.save(account);

         CreateAccountResponse createAccountResponse = new CreateAccountResponse();
         createAccountResponse.setAccountNumber(accountNumber);
         createAccountResponse.setClientId(account.getClientId());
         createAccountResponse.setCreateAt(account.getCreatedAt());

         return createAccountResponse;
    }

    // 계좌 해지
    @Transactional
    public DeleteAccountResponse deleteAccount(DeleteAccountRequest deleteAccountRequest) {
        Account account = accountRepository.findByAccountNumber(deleteAccountRequest.getAccountNumber());
        accountRepository.delete(account);
        DeleteAccountResponse deleteAccountResponse = new DeleteAccountResponse();
        deleteAccountResponse.setAccountNumber(account.getAccountNumber());
        deleteAccountResponse.setClientId(account.getClientId());
        deleteAccountResponse.setDeleteAt(LocalDateTime.now());
        return deleteAccountResponse;
    }

    // 계좌 확인
    @Transactional
    public List<SelectAccountResponse> selectAccount(String clientId) {

        List<SelectAccountResponse> selectAccountResponses = new ArrayList<>();
        List<Account> accounts = accountRepository.findByClientId(clientId);

        for (Account account : accounts) {
            SelectAccountResponse selectAccountResponse = new SelectAccountResponse();
            selectAccountResponse.setAccountNumber(account.getAccountNumber());
            selectAccountResponse.setAccountBalance(account.getAccountBalance());
            selectAccountResponses.add(selectAccountResponse);
        }

        return selectAccountResponses;

    }

}
