package br.feevale.bytechat.util;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {

	public static void sleep(long time, TimeUnit timeUnit) {
		sleep(timeUnit.toMillis(time));
	}
	
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
