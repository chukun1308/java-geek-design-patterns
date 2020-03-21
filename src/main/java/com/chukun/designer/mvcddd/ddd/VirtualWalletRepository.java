package com.chukun.designer.mvcddd.ddd;

import java.math.BigDecimal;

public interface VirtualWalletRepository {

    VirtualWalletEntity getWalletEntity(Long walletId);

    BigDecimal getBalance(Long walletId);

    void updateBalance(Long walletId, BigDecimal balance);
}
