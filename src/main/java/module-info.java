module com.example.paymentmethod1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.paymentmethod1 to javafx.fxml;
    exports com.example.paymentmethod1;
}