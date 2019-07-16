package com.revature.hello;

public class ParentBean {
	
	private HelloSpring dependency;
	
	public ParentBean() {}

	public ParentBean(HelloSpring dependency) {
		super();
		this.dependency = dependency;
	}

	public HelloSpring getDependency() {
		return dependency;
	}

	public void setDependency(HelloSpring dependency) {
		this.dependency = dependency;
	}

	@Override
	public String toString() {
		return "ParentBean [dependency=" + dependency + "]";
	}
	
	

}
