package com.example.employeemanagementsystem1;


public class employees {

	private String Id;

	private String FirstName;

	private String LastName;

	private int Salary;

	private String Department;

	public employees(String Id, String FirstName, String LastName, int Salary, String Department) {
		this.Id = Id;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Salary = Salary;
		this.Department = Department;

	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {

		Department = department;
	}
}
