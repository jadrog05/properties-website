package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoDB implements AccountDao{
    @Autowired
    JdbcTemplate jdbc;
    @Override
    public Account addAccount(Account account) {
        return null;
    }

    @Override
    public void deleteAccountByID(int id) {

    }

    @Override
    public void updateAccount(Account account) {

    }
}
