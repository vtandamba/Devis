module fr.sorefa {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.sorefa to javafx.fxml;
    opens fr.sorefa.controllers to javafx.fxml;

    exports fr.sorefa;
    exports fr.sorefa.model;
    exports fr.sorefa.controllers;

    requires java.sql;
    requires json.simple;
    requires itextpdf;
    // requires javax.ScriptEngine;
    // requires javax.servlet.api;
    requires spring.web;
    requires transitive javafx.graphics;
    requires transitive javax.servlet.api;
}
