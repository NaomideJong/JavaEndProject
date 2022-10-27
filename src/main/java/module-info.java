module com.example.naomidejong562748endassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.naomidejong562748endassignment to javafx.fxml;
    exports com.example.naomidejong562748endassignment;
    exports com.example.naomidejong562748endassignment.controllers;
    opens com.example.naomidejong562748endassignment.controllers to javafx.fxml;
}