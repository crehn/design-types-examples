package net.designtypes.examples.powerful.lib;

import javax.interceptor.*;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Logged
@Interceptor
public class LoggedInterceptor {
	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		Logger logger = getLogger(context);
		
		logBegin(logger, context);
		try {
			Object result = context.proceed();
			logResult(logger, context, result);
			return result;
		} catch (Exception e) {
			logException(logger, context, e);
			throw e;
		}
	}
	
	private Logger getLogger(InvocationContext context) {
		return LoggerFactory.getLogger(context.getTarget().getClass());
	}

	private void logBegin(Logger log, InvocationContext context) {
		log.debug("entering method {}", methodInvocation(context));
	}

	private String methodInvocation(InvocationContext context) {
		return String.format("%s.%s(%s)", className(context), methodName(context), parameters(context));
	}

	private String className(InvocationContext context) {
		return context.getTarget().getClass().getSimpleName();
	}
	
	private String methodName(InvocationContext context) {
		return context.getMethod().getName();
	}

	private String parameters(InvocationContext context) {
		return StringUtils.join(context.getParameters(), ", ");
	}

	private void logResult(Logger log, InvocationContext context, Object result) {
		log.trace("leaving method {} returning result {}", methodInvocation(context), result);
	}
	
	private void logException(Logger log, InvocationContext context, Exception e) {
		log.trace("leaving method {} throwing exception {}", methodInvocation(context), e);
	}
}
