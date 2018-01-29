package me.tylergrissom.yamlstats;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public class YamlStats extends Application {

    private static YSApp app;

    public YSApp getApp() {
        return app;
    }

    public static void main(String[] args) {
        app = new YSApp();

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Yaml Stats");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Yaml Stats");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label pathFieldLabel = new Label("Path:");
        grid.add(pathFieldLabel, 0, 1);

        final TextField pathField = new TextField();
        grid.add(pathField, 1, 1);

        final Text results = new Text("Results: ");

        pathField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    results.setText("Results: " + app.count(pathField.getText()));
                }
            }
        });

        grid.add(results, 0, 3);

        Scene scene = new Scene(grid, 500, 475);

        scene.getStylesheets().add("app.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
