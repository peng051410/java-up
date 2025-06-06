/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.profile;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
public class DefaultTransferService implements TransferService {

    private final AccountRepository accountRepository;
    private final FeePolicy feePolicy;

    public DefaultTransferService(AccountRepository accountRepository, FeePolicy feePolicy) {
        this.accountRepository = accountRepository;
        this.feePolicy = feePolicy;
    }
}
