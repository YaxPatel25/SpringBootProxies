package com.example.SpringBootProxies;

import java.lang.reflect.Proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SpringBootProxies.classes.Man;
import com.example.SpringBootProxies.classes.Person;
import com.example.SpringBootProxies.classes.PersonInvocationHandler;

@SpringBootApplication
public class SpringBootProxiesApplication {

	public static void main(String[] args) {
		Man yash = new Man("Yash", 25, "Delhi", "India");
		ClassLoader yashClassLoader = yash.getClass().getClassLoader();
		Class[] interfaces = yash.getClass().getInterfaces();
		Person proxyYash = (Person) Proxy.newProxyInstance(yashClassLoader, interfaces, new PersonInvocationHandler(yash));
		proxyYash.introduce(yash.getName());
	}

}
