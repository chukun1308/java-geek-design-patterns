package com.chukun.designer.mvcddd.ddd;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.*;

/**
 * 相比原来的贫血的mvc开发模式，这里主要将模型方法加以实现，service直接调用模型的相关方法即可
 */
public class VirtualWalletService {

    // 通过构造函数或者IOC框架注入
   private VirtualWalletRepository virtualWalletRepository;


    /**
     * 获取钱包的相关信息
     * @param walletId
     * @return
     */
   public VirtualWallet getVirtualWallet(Long walletId){
       VirtualWalletEntity walletEntity = virtualWalletRepository.getWalletEntity(walletId);
       VirtualWallet virtualWallet = convert(walletEntity);
       return virtualWallet;
   }

    /**
     * 获取账户余额
     * @param walletId
     * @return
     */
   public BigDecimal getBalance(Long walletId){
      return virtualWalletRepository.getBalance(walletId);
   }

    /**
     * 出账操作
     * @param walletId
     * @param amount
     */
   public void debit(Long walletId, BigDecimal amount){
       VirtualWalletEntity walletEntity = virtualWalletRepository.getWalletEntity(walletId);
       VirtualWallet virtualWallet = convert(walletEntity);
       //调用模型的debit方法
       virtualWallet.debit(amount);
       //更新数据库相关的信息
       virtualWalletRepository.updateBalance(walletId,virtualWallet.balance());
   }

    /**
     * 充值操作
     * @param walletId
     * @param amount
     */
   public void credit(Long walletId, BigDecimal amount){
       VirtualWalletEntity walletEntity = virtualWalletRepository.getWalletEntity(walletId);
       VirtualWallet virtualWallet = convert(walletEntity);
       //调用模型的credit方法
       virtualWallet.credit(amount);
       //更新数据库相关的信息
       virtualWalletRepository.updateBalance(walletId,virtualWallet.balance());
   }


    /**
     * 暂不实现
     * @param walletEntity
     * @return
     */
    private VirtualWallet convert(VirtualWalletEntity walletEntity) {
        return new VirtualWallet(walletEntity.getId());
    }

}
