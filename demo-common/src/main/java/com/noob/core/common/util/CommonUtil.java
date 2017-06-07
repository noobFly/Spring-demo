package com.noob.core.common.util;

import java.util.UUID;

import org.slf4j.MDC;

import com.noob.core.common.enums.CommonConstants;

public class CommonUtil {

	public static String upadteMDC() {
		MDC.remove(CommonConstants.TRANSACTION_ID);
		String transId = CommonUtil.genarateTransactionId();
		MDC.put(CommonConstants.TRANSACTION_ID, transId);
		return transId;
	}

	public static String genarateTransactionId() {
		return new StringBuffer(UUID.randomUUID().toString().replace("-", "")).toString();
	}

}
