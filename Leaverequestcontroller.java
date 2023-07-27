package com.example.employeemanagementsystem1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LeaveRequestController implements Initializable {

	@FXML

	private Button b1;

	@FXML

	private Button b2;

	@FXML

	private TextField t1;

	@FXML

	private TextField t2;

	@FXML

	private TextField t3;

	@Override

	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	void handlebuttonactionsubmit(ActionEvent event) {
		String query = "INSERT INTO leaverequest VALUES ('" + t1.getText() + "'," +
			t2.getText() + ",'" + t3.getText() + "')";
		System.out.println(query);
		executeQuery(query);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("CONFIRMATION");
		// alert.setHeaderText("Leave ");
		alert.setContentText("Leave Request Successfully Submitted !");

		alert.showAndWait().ifPresent(rs -> {
			if (rs == ButtonType.OK) {
				System.out.println("Pressed OK.");
			}
		});

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

	public Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/daproject ", "root", "");
			return conn;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			return null;
		}
	}
	@FXML
	void handlebuttonactioncancel(ActionEvent event) {
		System.exit(0);
	}
}
