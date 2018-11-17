package ru.elcoder.javaagent.demo;

public class DemoClient {

	public static void main(String[] args) {
		System.out.println("DemoClient.main");
		System.out.println(String.format("DemoClient: %s", StaticHolder.staticValue));
		StaticHolder.init("DemoClient");
		System.out.println(String.format("DemoClient: %s", StaticHolder.staticValue));

		StaticHolder.getBean(IStep.class).runMe("DemoClient");
	}
}
