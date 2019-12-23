package com.xmustang;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xmustang.service.IAccountService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Slf4j
public class TransactionTest {

	/**
	 * 一定要注入代理类:因为代理类进行增强的操作
	 */
	@Resource(name = "accountService")
	private IAccountService accountService;

	@Test
	public void testTransfer() {
		try {
			accountService.transfer("horse", "xmustang", 200d);
		} catch (Exception e) {
			log.error("转账事务失败，{}", "horse->xmustang:200d", e);
		}
	}
}