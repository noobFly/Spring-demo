package com.noob.test;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.baidu.disconf.core.common.utils.GsonUtils;

import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath*:/bootstrap/context/spring.xml",
		"classpath*:/bootstrap/mvc/spring-mvc.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = false, transactionManager = "localTxManager")
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class BaseTest extends TestCase {

	@Autowired
	protected ApplicationContext ctx;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "bootstrap/context/spring.xml", "bootstrap/mvc/spring-mvc.xml" });//先把服务加载进来
		System.out.println(GsonUtils.toJson(context.getBeanDefinitionNames()));
		System.out.println(context.getBeansWithAnnotation(Service.class));
	}
}
