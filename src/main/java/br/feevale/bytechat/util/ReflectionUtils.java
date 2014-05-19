package br.feevale.bytechat.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;

public final class ReflectionUtils {
	
	public static Method findMethod(Class<?> clazz, String methodName) {
		return findMethod(clazz, methodName, (Class<?>) null);
	}
	
	public static Method findMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void invokeEachItemInBackGround(Executor executor, final List<?> items, final Method method, final Object... parameters) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				invokeEachItem(items, method, parameters);
			}
		});
	}
	
	public static void invokeEachItem(List<?> items, Method method, Object... parameters) {
		if (items == null || items.size() == 0) {
			return;
		}
		
		try {
			for (Object item : items) {
				method.invoke(item, parameters);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
