package org.pbreakers.engine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pbreakers.engine.core.DatabaseOperation;
import org.pbreakers.engine.persistance.Database;

public class Main extends Application {
    public static void main(String[] args) {
        Database db = new Database("main");

        boolean resutl = DatabaseOperation.createDatabasee(db);
        System.out.println(resutl);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("view/home.fxml"));

        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.setTitle("SGBRR");
        stage.show();
    }
}
