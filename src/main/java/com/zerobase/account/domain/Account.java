package com.zerobase.account.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    @Column(length = 50, nullable = false)
    private String clientId;
    private Integer accountBalance;
    private LocalDateTime createdAt;

}
