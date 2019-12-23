package com.xmustang.dao;


/**
 * description:转账案例的DAO层接口
 */
public interface IAccountDao {
    void outMoney(String out, Double money);

    void inMoney(String in, Double money);
}
