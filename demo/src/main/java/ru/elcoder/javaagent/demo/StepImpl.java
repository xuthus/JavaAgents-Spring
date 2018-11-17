package ru.elcoder.javaagent.demo;

import org.springframework.stereotype.Component;

@Component
public class StepImpl implements IStep {

	private String lastName = "unassigned";

	@Override
	public void runMe(String name) {
		System.out.println(String.format("hello from StepImpl, %s!", lastName));
		this.lastName = name;
	}
}
