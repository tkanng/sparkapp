package com.tkanng;

import java.util.ServiceLoader;
import java.sql.DriverManager;

public class ServiceLoaderExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//need to define related class full name in /META-INF/services/....
		ServiceLoader<IService> serviceLoader = ServiceLoader
				.load(IService.class);
		for (IService service : serviceLoader) {
			System.out.println(service.getScheme()+"="+service.sayHello());
		}
	}

}
