package com.GagulaEyeClinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Appinitializer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LoadingScreen.fxml"))));
    stage.show();
    }
}