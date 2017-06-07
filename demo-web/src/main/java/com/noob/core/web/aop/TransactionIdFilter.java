package com.noob.core.web.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.noob.core.common.util.CommonUtil;

public class TransactionIdFilter implements Filter {

	protected transient final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		String transactionId = CommonUtil.upadteMDC();
		logger.debug("==================生成的TransactionId: {} ================= ", transactionId);
		return invoker.invoke(invocation);
	}

}
