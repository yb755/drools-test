package com.vbgps.drools_test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();
		// 默认自动加载 META-INF/kmodule.xml
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		// kmodule.xml 中定义的 ksession name
		KieSession kieSession = kieContainer.newKieSession("simpleRuleKSession");

		Person p1 = new Person();
		p1.setAge(10);
		Car car1 = new Car();
		car1.setPerson(p1);
		kieSession.insert(car1);	
		
		Person p2 = new Person();
		p2.setAge(50);
		Car car2 = new Car();
		car2.setPerson(p2);
		kieSession.insert(car2);
		
		Person p3 = new Person();
		p3.setAge(70);
		Car car3 = new Car();
		car3.setPerson(p3);
		kieSession.insert(car3);
		
		Person p4 = new Person();
		p4.setAge(85);
		Car car4 = new Car();
		car4.setPerson(p4);
		kieSession.insert(car4);
		
		
		System.out.println(kieSession.fireAllRules());
		System.out.println(car1.getDiscount());
		System.out.println(car2.getDiscount());
		System.out.println(car3.getDiscount());
		System.out.println(car4.getDiscount());

		kieSession.dispose();
	}
}
