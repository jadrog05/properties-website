package com.sg.propertyWebsite.daos;


import com.sg.propertyWebsite.entities.Account;

public interface AccountDao {
    Account addAccount(Account account);
    void deleteAccountByID(int id);
    void updateAccount(Account account);
}
