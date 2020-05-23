package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("Untitled.png");
        Image image = new Image(fileInputStream);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
