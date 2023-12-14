package com.example.gaztnik2_0.ui;

import com.example.gaztnik2_0.database.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productTypeField;

    @FXML
    private TextField productQuantityField;

    @FXML
    private void initialize() {
        // Создание таблицы при запуске контроллера
        DatabaseManager.createProductTable();
    }

    @FXML
    private void handleAddProduct() {
        // Пример запроса добавления товара
        String insertProductSQL = "INSERT INTO products (name, type, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(insertProductSQL)) {

            // Установка значений параметров запроса из полей ввода
            preparedStatement.setString(1, productNameField.getText());
            preparedStatement.setString(2, productTypeField.getText());
            preparedStatement.setInt(3, Integer.parseInt(productQuantityField.getText()));

            // Выполнение запроса
            preparedStatement.executeUpdate();

            // Очистка полей ввода
            productNameField.clear();
            productTypeField.clear();
            productQuantityField.clear();

            // Вывод успешного сообщения
            showAlert(Alert.AlertType.INFORMATION, "Product Added", "Product has been successfully added.");

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while adding the product.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}