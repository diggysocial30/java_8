package com.divs.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.divs.lambdas.Employee.UpperConcat;

public class Main {

	public static void main(String[] args) {

		new Thread(() -> {
			System.out.println("Yayy");
			System.out.println("Yippes");
		}).start();

		Employee emp1 = new Employee("aa", 12);
		Employee emp2 = new Employee("bb", 22);
		Employee emp3 = new Employee("cc", 32);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);

		Collections.sort(employees, (e1, e2) -> {
			System.out.println("Let us see");
			return e1.getName().compareTo(e2.getName());
		});

		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}

		UpperConcat uc=(s1,s2) -> s1+s2;
		
		String silly=doStringStuff((s1,s2) -> s1+s2, "s", "j");
		
		System.out.println(silly);
		
		CheckSomething cs=new CheckSomething();
		CheckSomething2 cs2=new CheckSomething2();
		
		System.out.println("*** cs.doSomething() *******"+cs.doSomething());
		
		System.out.println("*********doSomething2*********"+cs.doSomething2());
		
		System.out.println("*********CheckSomething2 cs2*********"+cs2.doSomething());
	}
	
	 public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
	        return uc.upperAndConcat(s1, s2);
	    }
}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@FunctionalInterface
	interface UpperConcat {
	    public String upperAndConcat(String s1, String s2);
	}
}

class CheckSomething{
	
	
	public String doSomething(){
		System.out.println(this.getClass().getCanonicalName());
		
		return Main.doStringStuff(new UpperConcat() {
			
			@Override
			public String upperAndConcat(String s1, String s2) {
				System.out.println(this.getClass().getCanonicalName());
				return s1+s2;
			}
		}, "aaa", "bbbb");
	}
	
	public String doSomething2() {
		return Main.doStringStuff((s1, s2) -> {
			System.out.println(this.getClass().getCanonicalName());
			return s1 + s2;
		}, "89", "789");

	}
	
}
	
	class CheckSomething2{
		
		public String doSomething(){
			int i=0;
			final int j=0;
			{
				UpperConcat uc=new UpperConcat() {
					
					@Override
					public String upperAndConcat(String s1, String s2) {
						return s1+s2;
					}
				};
				i++;
			//	j++;
			}
			System.out.println(i);
			return "CheckSomething2 doSomething";
		}
	}
