package model.entities;

public class Employee implements Comparable<Employee> {
	private String name;
	private Double salary;

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee other) {
		/* 
		 * Para ordenar por salario de forma decrescente
		 * return -salary.compareTo(other.getSalary());
		 * 
		 * Para ordenar por salario de forma crescente
		 * return salary.compareTo(other.getSalary());
		 * 
		 * Para ordenar por nome de forma decrescente
		 * return -name.compareTo(other.getName());
		*/
		// Para ordenar por nome de forma crescente
		return name.compareTo(other.getName());
	}
}