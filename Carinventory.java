package com.carinventory.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.carinventory.dao.*;
import com.carinventory.model.Car;

public class Carinventory {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Cardao dao = (Cardao) context.getBean("cardao");
		System.out.println("enter make");
		Scanner scanner = new Scanner(System.in);
		String carMake = scanner.nextLine();
		Car car = new Car();
		car.setMake(carMake);
		dao.saveCar(car);
	    List<Car> list=dao.getFetchCarDetails(); 
	    list.forEach(e->System.out.println(e));

	}
}
