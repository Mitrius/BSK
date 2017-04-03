package com.bsk.dao.interfaces;

import com.bsk.entities.ShopTransaction;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface ShopTransactionDao {
    ShopTransaction findByID(Integer id);

    void save(ShopTransaction shopTransaction);

    List<ShopTransaction> findAllTransactions();
}
