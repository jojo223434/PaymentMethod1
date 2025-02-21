package com.example.paymentmethod1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Betalingssystem");

        // UI-komponenter
        Label amountLabel = new Label("Beløb (kr.):");
        TextField amountField = new TextField();
        Label methodLabel = new Label("Vælg betalingsmetode:");
        ComboBox<PaymentType> methodComboBox = new ComboBox<>();
        methodComboBox.getItems().addAll(PaymentType.values());
        Button payButton = new Button("Betal");

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(amountLabel, amountField, methodLabel, methodComboBox, payButton);

        // Håndter betalingsknappen
        payButton.setOnAction(event -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                PaymentType selectedType = methodComboBox.getValue();
                if (selectedType == null) {
                    System.out.println("Vælg en betalingsmetode.");
                    return;
                }

                PaymentFactory factory = new PaymentFactory();
                PaymentMethod paymentMethod = factory.createPaymentMethod(selectedType);
                paymentMethod.processPayment(amount);


                String receipt = paymentMethod.generateReceipt(amount);
                String fileName = "Kvittering_" + selectedType + "_" + System.currentTimeMillis() + ".txt";
                ReceiptSaver.saveReceiptToFile(receipt, fileName);

            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt beløb. Indtast et tal.");
            }
        });

        // Vis scenen
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}