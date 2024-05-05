module org.example.doancoso1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires de.jensd.fx.glyphs.emojione;
    requires fontawesomefx;

    opens org.example.doancoso1 to javafx.fxml;
    exports org.example.doancoso1;
}