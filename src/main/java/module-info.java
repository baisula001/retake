module org.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.logging;

    opens org.example.demo2 to javafx.fxml;
    exports org.example.demo2;



    exports org.example.demo2.util;
    opens org.example.demo2.util to javafx.fxml;
    exports org.example.demo2.org.example.demo2;
    opens org.example.demo2.org.example.demo2 to javafx.fxml;

}