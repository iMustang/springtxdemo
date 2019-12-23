package com.xmustang.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * description:转账案例的DAO层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money-? where name = ?";
        this.getJdbcTemplate().update(sql, money, out);
    }

    public void inMoney(String in, Double money) {
        String sql = "update account set money = money+? where name = ?";
        this.getJdbcTemplate().update(sql, money, in);
    }
}