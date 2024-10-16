module org.example.bmicalcualtor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.bmicalcualtor to javafx.fxml;
    exports org.example.bmicalcualtor;
}