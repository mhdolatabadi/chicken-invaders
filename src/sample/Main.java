package sample;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    private Color Black = new Color(0,0,0,1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Image image = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Untitled.jpg"));
        ImageView imageView = new ImageView(image);
        //Setting the position of the image
        imageView.setX(650);
        imageView.setY(700);

        //setting the fit height and width of the image view
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);


        Image image2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Untitled2.png"));
        ImageView imageView2 = new ImageView(image2);
        //Setting the position of the image
        imageView2.setX(250);
        imageView2.setY(200);

        //setting the fit height and width of the image view
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);

        //Setting the preserve ratio of the image view
        imageView2.setPreserveRatio(true);

        EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT && imageView.getX() < 1200) {
                    imageView.setX(imageView.getX() + 100);
                } else if (event.getCode() == KeyCode.LEFT && imageView.getX() > 100){
                    imageView.setX(imageView.getX() - 100 );

                } else if (event.getCode() == KeyCode.SPACE) {
                    //your code for shooting the missile
                }
                event.consume();
            }
        };

        //Creating a Group object
        Group group = new Group(imageView, imageView2);
        Scene scene = new Scene(group, 1400, 800);
        scene.setOnKeyPressed(keyListener);
        scene.setFill(Black);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
