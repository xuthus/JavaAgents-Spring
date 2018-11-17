package ru.elcoder.javaagent.demo;

import java.lang.reflect.Constructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackages = {"ru.elcoder.javaagent"})
public class DemoAgent {

	public static void premain(final String agentArgument) {
		System.out.println("DemoAgent.premain");
		System.out.println("agentArgument = [" + agentArgument + "]");
		System.out.println(StaticHolder.staticValue);
		StaticHolder.staticValue = "Hello, DemoAgent!";
		System.out.println(StaticHolder.staticValue);
		StaticHolder.init("premain");
		System.out.println(StaticHolder.staticValue);

		showInfo();
		testClassPath();

		StaticHolder.context = new AnnotationConfigApplicationContext("ru.elcoder.javaagent");
		final DemoAgent app = StaticHolder.getBean(DemoAgent.class);
		app.runApp();
	}

	private static void showInfo() {
		final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(String.format("Thread.currentThread().contextClassLoader: %s", contextClassLoader.getClass().getName()));
		System.out.println(String.format("Thread.currentThread().contextClassLoader.parent: %s", contextClassLoader.getParent().getClass().getName()));
		System.out.println(String.format("Thread.currentThread().name: %s", Thread.currentThread().getName()));
		System.out.println(String.format("DemoAgent.class.classLoader: %s", DemoAgent.class.getClassLoader().getClass().getName()));
		System.out.println(String.format("DemoAgent.class.classLoader: %s", DemoAgent.class.getClassLoader().getParent().getClass().getName()));
	}

	private static void testClassPath() {
		try {
			final Class<?> klass = Class.forName("ru.elcoder.javaagent.demo.Student");
			final Constructor<?> constructor = klass.getConstructor(String.class, int.class);
			final Object student = constructor.newInstance("Ani", 21);
			System.out.println(student.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void runApp() {
		StaticHolder.getBean(IStep.class).runMe("DemoAgent");
	}

}
