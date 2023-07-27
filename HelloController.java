package com.example.employeemanagementsystem1;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
	ObservableList employees = FXCollections.observableArrayList();

	@FXML

	private Button db3;

	@FXML

	private TableColumn<employees, String> dt5;

	@FXML

	private TableColumn<employees, String> fnt2;

	@FXML

	private Button ib1;

	@FXML

	private TableColumn<employees, Integer> idt1;

	@FXML

	private TableColumn<employees, String> lnt3;

	@FXML

	private TableColumn<employees, Integer> st4;

	@FXML

	private TextField t1;

	@FXML

	private TextField t2;

	@FXML

	private TextField t3;

	@FXML

	private TextField t4;

	@FXML

	private TextField t5;

	@FXML

	private TextField t6;

	@FXML

	private TableView<employees> tableemployees;

	@FXML

	private Button ub2;

	@FXML
	void handleButtonaction(ActionEvent event) {
		if (event.getSource() == ib1) {
			insertRecord();
		} else if (event.getSource() == ub2) {
			updateRecord();
		} else if (event.getSource() == db3) {

			deleteRecord();
		}

	}
	@FXML

	private void handleMouseAction(MouseEvent event) {
		employees employee =
			tableemployees.getSelectionModel().getSelectedItem();
		t1.setText("" + employee.getId());
		t2.setText(employee.getFirstName());
		t3.setText(employee.getLastName());
		t4.setText("" + employee.getSalary());
		t5.setText("" + employee.getDepartment());

	}

	private void deleteRecord() {
		String query = "DELETE FROM EMPLOYEES WHERE ID='" +
			t1.getText() + "';";
		executeQuery(query);
		showdetails();

	}

	private void updateRecord() {
		String query =
			"UPDATE employees" +
			" SET FirstName='" + t2.getText() +
			"',LastName='" + t3.getText() +
			"',Salary='" + t4.getText() + "',Department='" + t5.getText() +
			"' WHERE Id='" + t1.getText() + "';";
		executeQuery(query);
		showdetails();

	}

	private void insertRecord() {

		String query = "INSERT INTO EMPLOYEES VALUES('" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + t4.getTe xt() + "','" + t5.getText() + "');";
		executeQuery(query);
		showdetails();

	}

	private void executeQuery(String query) {
		Connection conn = getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override

	public void initialize(URL url, ResourceBundle resourceBundle) {
		showdetails();
	}

	public Connection getConnection() {
		Connection conn;
		try {
			conn =
				DriverManager.getConnection("jdbc:mysql://localhost:3308/daproject ", "root", "");
			return conn;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			return null;
		}
	}

	public ObservableList<employees> getemployeesList() {
		ObservableList<employees> employeeList =
			FXCollections.observableArrayList();
		Connection conn = getConnection();
		String query = "SELECT * FROM employees";
		java.sql.Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			employees employees;

			while (rs.next()) {
				employees = new employees(rs.getString("Id"), rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("Salary"), rs.getString("Department"));
				employeeList.add(employees);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return employeeList;
	}

	private void showdetails() {
		ObservableList<employees> list = getemployeesList();
		idt1.setCellValueFactory(new PropertyValueFactory < employees,
			Integer > ("Id"));
		fnt2.setCellValueFactory(new PropertyValueFactory<employees, String> ("FirstName"));
		lnt3.setCellValueFactory(new PropertyValueFactory<employees, String> ("LastName"));
		st4.setCellValueFactory(new PropertyValueFactory<employees, Integer> ("Salary"));
		dt5.setCellValueFactory(new PropertyValueFactory<employees, String> ("Department"));
		tableemployees.setItems(list);
	}
}
