package edu.icet.controller;

import edu.icet.util.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    public TextField txtCostName;
    public TextField txtContNumber;
    public TextField txtEmail;
    public TextField txtDate;
    public TextField txtEmpName;
    public ComboBox cmbEmpId;
    public TextField txtItemName;
    public ComboBox txtItemCode;
    public TextField txtDes;
    public TextField txtQty;
    public TextField txtQonHand;
    public TextField txtSellPrice;
    public TextField txtProfit;
    public TextField txtType;
    public TextField txtSize;
    public TextField txtOrderId;
    public ComboBox cmbPayMethod;
    public TextField txtDiscount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCmbEmployeeId();
        cmbEmpId.setOnAction(actionEvent -> {
            setEmployeeName();
        });

    }

    private void setEmployeeName(){
        String empId = cmbEmpId.getValue().toString();

        try {
            ResultSet resultSet = CrudUtil.execute("SELECT name FROM employee where id = '"+empId+"'");
            while(resultSet.next()){
                String empName = resultSet.getString(1);
                txtEmpName.setText(empName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadCmbEmployeeId(){
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT id FROM employee");
            ObservableList<String> employeeId = FXCollections.observableArrayList();

            while(resultSet.next()){
                employeeId.add(resultSet.getString(1));
            }
            cmbEmpId.setItems(employeeId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnRemoveOrder(ActionEvent actionEvent) {
    }

    public void btnClear(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnAddToCart(ActionEvent actionEvent) {
    }

    public void btnPlaceOrder(ActionEvent actionEvent) {
    }



}
