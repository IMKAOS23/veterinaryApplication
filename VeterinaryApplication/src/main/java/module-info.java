module com.mycompany.veterinaryApplication {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.veterinaryApplication to javafx.fxml;
    exports com.mycompany.veterinaryApplication;
}
