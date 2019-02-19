package com.reonsoft.spring.common.util;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ObjectUtils.class);
	
	/**
	 * Object type 변수가 비어있는지 체크
	 * 
	 * @ param obj 
	 * @ return Boolean : true / false
	 */
	public static Boolean isEmpty(Object obj) {
		
		logger.info("isEmpty [" + obj + "]");
		
		if(obj instanceof String)
			return obj == null || "".equals(obj.toString().trim());
		else if (obj instanceof List)
			return obj == null || ((List<?>) obj).isEmpty();
		else if (obj instanceof Map)
			return obj == null || ((Map<?, ?>) obj).isEmpty();
		else if (obj instanceof Object[])
			return obj == null || Array.getLength(obj) == 0;
		else
			return obj == null;
	}
	
	/**
	 * Object type 변수가 비어있지 않은지 체크
	 * 
	 * @ param obj
	 * @ return Boolean : true / false
	 */
	public static Boolean isNotEmpty(Object obj) {
		
		logger.info("isNotEmpty [" + !isEmpty(obj) + "]");
		
		return !isEmpty(obj);
	}
	
}
