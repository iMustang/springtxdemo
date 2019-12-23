package com.xmustang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xmustang.dao.IAccountDao;

/**
 * 基于XML配置声明的方式（基于注解）
 *
 * @Transactional中的的属性： <p/>
 * propagation   :事务的传播行为
 * isolation     :事务的隔离级别
 * readOnly      :只读
 * rollbackFor   :发生哪些异常回滚
 * noRollbackFor :发生哪些异常不回滚
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements IAccountService {

	// 注入转账的DAO
	private IAccountDao accountDao;

	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		int i = 1 / 0;
		accountDao.inMoney(in, money);
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
}
