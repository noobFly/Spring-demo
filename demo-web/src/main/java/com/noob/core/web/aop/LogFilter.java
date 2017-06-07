package com.noob.core.web.aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.noob.core.common.util.CommonUtil;

public class LogFilter implements Filter {

	protected transient final Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {

		String transactionId = CommonUtil.upadteMDC();
		logger.debug("==================生成的TransactionId: {} ================= ", transactionId);
	}

	@Override
	public void destroy() {

	}
}
