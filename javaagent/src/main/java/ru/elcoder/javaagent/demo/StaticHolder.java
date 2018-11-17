package ru.elcoder.javaagent.demo;

import org.springframework.context.ApplicationContext;

/**
 * Created by xuthus on 16.11.2018 23:24.
 */
public class StaticHolder {
	public static volatile String staticValue = "Hello, StaticHolder!";
	public static ApplicationContext context;

	public static void init(String user) {
		System.out.println("StaticHolder.init()");
		staticValue = String.format("Hello, %s!", user);
	}

	public static <T> T getBean(Class<T> klass) {
		return (T) context.getBean(klass);
	}
}
