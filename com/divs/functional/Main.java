package com.divs.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {

		Employee emp0 = new Employee("a", 2);
		Employee emp1 = new Employee("aa", 12);
		Employee emp2 = new Employee("bb", 22);
		Employee emp3 = new Employee("cc", 32);
		Employee emp4 = new Employee("dd", 42);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp0);
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);

		System.out.println("Age less than 30");
		employees.forEach((e) -> {
			if (e.getAge() > 30) {
				System.out.println(e.getName());
			}
		});

		System.out.println("Age greater than 30");
		employees.forEach((employee) -> {
			if (employee.getAge() < 30) {
				System.out.println(employee.getName());
			}
		});

		printEmployeeByAge(employees, "Age before 30",  (e) -> e.getAge() <30 );
		printEmployeeByAge(employees, "Age after 30",  (e) -> e.getAge() >30 );
		
		printEmployeeByAge(employees, "Age before 25", new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getAge()<25;
			}
		});
		
		int b=20;
		IntPredicate intPredicateLess= age -> age <100;
		IntPredicate intPredicateGreater= age -> age>10;
		System.out.println("checking int predicte less for b"+intPredicateLess.test(b/10));
		System.out.println("checking int predicte and greater for 80"+intPredicateLess.and(intPredicateGreater).test(80));
		
		Random random= new Random();
		
		for(int i=0;i<5;i++){
			System.out.println( random.nextInt());
			
		}
		
		Supplier<Integer> randomInt= () ->  random.nextInt(10000) ;
		
		for(int i=0;i<5;i++){
			System.out.println( randomInt);
			
		}
		
		
	}

	private static void printEmployeeByAge(List<Employee> emps, String ageText, Predicate<Employee> ageCondition) {

		System.out.println("Age text"+ageText);
		for(Employee em:emps){
			if(ageCondition.test(em))
				System.out.println(em.getName());
		}
	}

}
