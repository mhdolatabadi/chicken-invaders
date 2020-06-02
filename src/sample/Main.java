package sample;

import com.sun.deploy.panel.ExceptionListDialog;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

import static java.lang.String.valueOf;


public class Main extends Application {
    private final Color Black = new Color(0, 1, 1, 1);
    Color color = new Color(1, 1, 1, 1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int[] score = {0};
        final int[] counter = {0};
        final int[] number = {0};
        Media media = new Media(getClass().getResource("/Untitled3.mp3").toURI().toString());
        Media shoot = new Media(getClass().getResource("/shoot.mp3").toURI().toString());
        Media ground = new Media(getClass().getResource("/spaceinvaders1.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaPlayer shootPlayer = new MediaPlayer(shoot);
        MediaPlayer groundPlayer = new MediaPlayer(ground);



        Image scoreImage = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\score.png"));
        Image background = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\background.jpg"));

        Button backButton = new Button();
        backButton.setText("Back");
        backButton.setStyle("-fx-font-family: Broadway; -fx-background-image: url(background.jpg); -fx-font-size: 38px");
        backButton.setLayoutX(1710);
        backButton.setLayoutY(5);
        backButton.setMinSize(100, 25);
        backButton.setTextFill(color);

        Button startNewGameButton = new Button();
        startNewGameButton.setText("Start New Game");
        startNewGameButton.setStyle("-fx-font-family: Broadway; -fx-background-image: url(background.jpg); -fx-font-size: 38px");
        startNewGameButton.setLayoutX(1000);
        startNewGameButton.setLayoutY(700);
        startNewGameButton.setTextFill(color);
        
        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setStyle("-fx-font-family: Broadway; -fx-background-image: url(background.jpg); -fx-font-size: 38px");
        exitButton.setLayoutX(800);
        exitButton.setLayoutY(800);
        exitButton.setTextFill(color);

        Button resumeButton = new Button();
        resumeButton.setText("Resume");
        resumeButton.setStyle("-fx-font-family: Broadway; -fx-background-image: url(background.jpg); -fx-font-size: 38px");
        resumeButton.setLayoutX(800);
        resumeButton.setLayoutY(300);
        resumeButton.setTextFill(color);

        Button highscoreButton = new Button();
        highscoreButton.setText("High Scores");
        highscoreButton.setStyle("-fx-font-family: Broadway; -fx-background-image: url(background.jpg); -fx-font-size: 38px");
        highscoreButton.setLayoutX(800);
        highscoreButton.setLayoutY(100);
        highscoreButton.setTextFill(color);

        Label scoreNumber = new Label();
        scoreNumber.setText(valueOf(score[0]));
        scoreNumber.setLayoutX(170);
        scoreNumber.setLayoutY(20);
        scoreNumber.setTextFill(color);
        scoreNumber.setStyle("-fx-font-size: 38px;" +
                "-fx-font-family: Broadway");


        Label scoreText = new Label();
        scoreText.setText("Score");
        scoreText.setLayoutX(25);
        scoreText.setLayoutY(20);
        scoreText.setTextFill(color);
        scoreText.setStyle("-fx-font-size: 38px;" +
                "-fx-font-family: Broadway");

        Label messageText = new Label();
        messageText.setText("Press ctrl to use your gift");
        messageText.setLayoutX(750);
        messageText.setLayoutY(20);
        messageText.setTextFill(color);
        messageText.setStyle("-fx-font-size: 38px;" +
                "-fx-font-family: Broadway");

        ImageView bgGame = new ImageView(background);
        bgGame.setX(0);
        bgGame.setY(0);
        bgGame.setFitHeight(3000);
        bgGame.setFitWidth(2000);
        bgGame.setPreserveRatio(true);

        ImageView bgStart = new ImageView(background);
        bgStart.setX(0);
        bgStart.setY(0);
        bgStart.setFitHeight(3000);
        bgStart.setFitWidth(2000);
        bgStart.setPreserveRatio(true);

        Image image = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\spaceShip.png"));
        ImageView SpaceShip = new ImageView(image);
        SpaceShip.setX(920);
        SpaceShip.setY(860);
        SpaceShip.setFitHeight(100);
        SpaceShip.setFitWidth(100);
        SpaceShip.setPreserveRatio(true);

        ImageView scoreImageView = new ImageView(scoreImage);
        scoreImageView.setX(10);
        scoreImageView.setY(10);
        scoreImageView.setFitWidth(80);
        scoreImageView.setFitHeight(80);
        scoreImageView.setPreserveRatio(true);


        Image B1 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\B1.png"));
        Image B2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\B2.png"));
        Image B3 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\B3.png"));
        Image Y1 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Y1.png"));
        Image Y2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Y2.png"));
        Image Y3 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Y3.png"));
        Image G1 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\G1.png"));
        Image G2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\G2.png"));
        Image G3 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\G3.png"));
        Image R1 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\R1.png"));
        Image R2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\R2.png"));
        Image R3 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\R3.png"));
        Image P1 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\P1.png"));
        Image P2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\P2.png"));
        Image P3 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\P3.png"));

        ImageView Invader0 = new ImageView(B1);
        ImageView Invader1 = new ImageView(B1);
        ImageView Invader2 = new ImageView(B1);
        ImageView Invader3 = new ImageView(B1);
        ImageView Invader4 = new ImageView(R1);
        ImageView Invader5 = new ImageView(R1);
        ImageView Invader6 = new ImageView(R1);
        ImageView Invader7 = new ImageView(R1);
        ImageView Invader8 = new ImageView(Y1);
        ImageView Invader9 = new ImageView(Y1);
        ImageView Invader10 = new ImageView(Y1);
        ImageView Invader11 = new ImageView(Y1);
        ImageView Invader12 = new ImageView(G1);
        ImageView Invader13 = new ImageView(G1);
        ImageView Invader14 = new ImageView(G1);
        ImageView Invader15 = new ImageView(G1);
        ImageView Invader16 = new ImageView(P1);
        ImageView Invader17 = new ImageView(P1);
        ImageView Invader18 = new ImageView(P1);
        ImageView Invader19 = new ImageView(P1);
        ImageView Invader20 = new ImageView(B1);
        ImageView Invader21 = new ImageView(B1);
        ImageView Invader22 = new ImageView(B1);
        ImageView Invader23 = new ImageView(B1);
        ImageView Invader24 = new ImageView(R1);
        ImageView Invader25 = new ImageView(R1);
        ImageView Invader26 = new ImageView(R1);
        ImageView Invader27 = new ImageView(R1);
        ImageView Invader28 = new ImageView(Y1);
        ImageView Invader29 = new ImageView(Y1);
        ImageView Invader30 = new ImageView(Y1);
        ImageView Invader31 = new ImageView(Y1);
        ImageView Invader32 = new ImageView(G1);
        ImageView Invader33 = new ImageView(G1);
        ImageView Invader34 = new ImageView(G1);
        ImageView Invader35 = new ImageView(G1);
        ImageView Invader36 = new ImageView(P1);
        ImageView Invader37 = new ImageView(P1);
        ImageView Invader38 = new ImageView(P1);
        ImageView Invader39 = new ImageView(P1);
        ImageView Invader40 = new ImageView(B1);
        ImageView Invader41 = new ImageView(B1);
        ImageView Invader42 = new ImageView(B1);
        ImageView Invader43 = new ImageView(B1);
        ImageView Invader44 = new ImageView(R1);
        ImageView Invader45 = new ImageView(R1);
        ImageView Invader46 = new ImageView(R1);
        ImageView Invader47 = new ImageView(R1);
        ImageView Invader48 = new ImageView(Y1);
        ImageView Invader49 = new ImageView(Y1);
        ImageView Invader50 = new ImageView(Y1);
        ImageView Invader51 = new ImageView(Y1);
        ImageView Invader52 = new ImageView(G1);
        ImageView Invader53 = new ImageView(G1);
        ImageView Invader54 = new ImageView(G1);
        ImageView Invader55 = new ImageView(G1);
        ImageView Invader56 = new ImageView(P1);
        ImageView Invader57 = new ImageView(P1);
        ImageView Invader58 = new ImageView(P1);
        ImageView Invader59 = new ImageView(P1);

        Invader0.setX(40);
        Invader0.setY(100);
        Invader0.setFitHeight(80);
        Invader0.setFitWidth(80);
        Invader0.setPreserveRatio(true);

        Invader1.setX(120);
        Invader1.setY(100);
        Invader1.setFitHeight(80);
        Invader1.setFitWidth(80);
        Invader1.setPreserveRatio(true);

        Invader2.setX(200);
        Invader2.setY(100);
        Invader2.setFitHeight(80);
        Invader2.setFitWidth(80);
        Invader2.setPreserveRatio(true);

        Invader3.setX(280);
        Invader3.setY(100);
        Invader3.setFitHeight(80);
        Invader3.setFitWidth(80);
        Invader3.setPreserveRatio(true);

        Invader4.setX(400);
        Invader4.setY(100);
        Invader4.setFitHeight(80);
        Invader4.setFitWidth(80);
        Invader4.setPreserveRatio(true);

        Invader5.setX(480);
        Invader5.setY(100);
        Invader5.setFitHeight(80);
        Invader5.setFitWidth(80);
        Invader5.setPreserveRatio(true);

        Invader6.setX(560);
        Invader6.setY(100);
        Invader6.setFitHeight(80);
        Invader6.setFitWidth(80);
        Invader6.setPreserveRatio(true);

        Invader7.setX(640);
        Invader7.setY(100);
        Invader7.setFitHeight(80);
        Invader7.setFitWidth(80);
        Invader7.setPreserveRatio(true);

        Invader8.setX(760);
        Invader8.setY(100);
        Invader8.setFitHeight(80);
        Invader8.setFitWidth(80);
        Invader8.setPreserveRatio(true);

        Invader9.setX(840);
        Invader9.setY(100);
        Invader9.setFitHeight(80);
        Invader9.setFitWidth(80);
        Invader9.setPreserveRatio(true);

        Invader10.setX(920);
        Invader10.setY(100);
        Invader10.setFitHeight(80);
        Invader10.setFitWidth(80);
        Invader10.setPreserveRatio(true);

        Invader11.setX(1000);
        Invader11.setY(100);
        Invader11.setFitHeight(80);
        Invader11.setFitWidth(80);
        Invader11.setPreserveRatio(true);

        Invader12.setX(1120);
        Invader12.setY(100);
        Invader12.setFitHeight(80);
        Invader12.setFitWidth(80);
        Invader12.setPreserveRatio(true);

        Invader13.setX(1200);
        Invader13.setY(100);
        Invader13.setFitHeight(80);
        Invader13.setFitWidth(80);
        Invader13.setPreserveRatio(true);

        Invader14.setX(1280);
        Invader14.setY(100);
        Invader14.setFitHeight(80);
        Invader14.setFitWidth(80);
        Invader14.setPreserveRatio(true);

        Invader15.setX(1360);
        Invader15.setY(100);
        Invader15.setFitHeight(80);
        Invader15.setFitWidth(80);
        Invader15.setPreserveRatio(true);

        Invader16.setX(1480);
        Invader16.setY(100);
        Invader16.setFitHeight(80);
        Invader16.setFitWidth(80);
        Invader16.setPreserveRatio(true);

        Invader17.setX(1560);
        Invader17.setY(100);
        Invader17.setFitHeight(80);
        Invader17.setFitWidth(80);
        Invader17.setPreserveRatio(true);

        Invader18.setX(1640);
        Invader18.setY(100);
        Invader18.setFitHeight(80);
        Invader18.setFitWidth(80);
        Invader18.setPreserveRatio(true);

        Invader19.setX(1720);
        Invader19.setY(100);
        Invader19.setFitHeight(80);
        Invader19.setFitWidth(80);
        Invader19.setPreserveRatio(true);

        Invader20.setX(40);
        Invader20.setY(180);
        Invader20.setFitHeight(80);
        Invader20.setFitWidth(80);
        Invader20.setPreserveRatio(true);

        Invader21.setX(120);
        Invader21.setY(180);
        Invader21.setFitHeight(80);
        Invader21.setFitWidth(80);
        Invader21.setPreserveRatio(true);

        Invader22.setX(200);
        Invader22.setY(180);
        Invader22.setFitHeight(80);
        Invader22.setFitWidth(80);
        Invader22.setPreserveRatio(true);

        Invader23.setX(280);
        Invader23.setY(180);
        Invader23.setFitHeight(80);
        Invader23.setFitWidth(80);
        Invader23.setPreserveRatio(true);

        Invader24.setX(400);
        Invader24.setY(180);
        Invader24.setFitHeight(80);
        Invader24.setFitWidth(80);
        Invader24.setPreserveRatio(true);

        Invader25.setX(480);
        Invader25.setY(180);
        Invader25.setFitHeight(80);
        Invader25.setFitWidth(80);
        Invader25.setPreserveRatio(true);

        Invader26.setX(560);
        Invader26.setY(180);
        Invader26.setFitHeight(80);
        Invader26.setFitWidth(80);
        Invader26.setPreserveRatio(true);

        Invader27.setX(640);
        Invader27.setY(180);
        Invader27.setFitHeight(80);
        Invader27.setFitWidth(80);
        Invader27.setPreserveRatio(true);

        Invader28.setX(760);
        Invader28.setY(180);
        Invader28.setFitHeight(80);
        Invader28.setFitWidth(80);
        Invader28.setPreserveRatio(true);

        Invader29.setX(840);
        Invader29.setY(180);
        Invader29.setFitHeight(80);
        Invader29.setFitWidth(80);
        Invader29.setPreserveRatio(true);

        Invader30.setX(920);
        Invader30.setY(180);
        Invader30.setFitHeight(80);
        Invader30.setFitWidth(80);
        Invader30.setPreserveRatio(true);

        Invader31.setX(1000);
        Invader31.setY(180);
        Invader31.setFitHeight(80);
        Invader31.setFitWidth(80);
        Invader31.setPreserveRatio(true);

        Invader32.setX(1120);
        Invader32.setY(180);
        Invader32.setFitHeight(80);
        Invader32.setFitWidth(80);
        Invader32.setPreserveRatio(true);

        Invader33.setX(1200);
        Invader33.setY(180);
        Invader33.setFitHeight(80);
        Invader33.setFitWidth(80);
        Invader33.setPreserveRatio(true);

        Invader34.setX(1280);
        Invader34.setY(180);
        Invader34.setFitHeight(80);
        Invader34.setFitWidth(80);
        Invader34.setPreserveRatio(true);

        Invader35.setX(1360);
        Invader35.setY(180);
        Invader35.setFitHeight(80);
        Invader35.setFitWidth(80);
        Invader35.setPreserveRatio(true);

        Invader36.setX(1480);
        Invader36.setY(180);
        Invader36.setFitHeight(80);
        Invader36.setFitWidth(80);
        Invader36.setPreserveRatio(true);

        Invader37.setX(1560);
        Invader37.setY(180);
        Invader37.setFitHeight(80);
        Invader37.setFitWidth(80);
        Invader37.setPreserveRatio(true);

        Invader38.setX(1640);
        Invader38.setY(180);
        Invader38.setFitHeight(80);
        Invader38.setFitWidth(80);
        Invader38.setPreserveRatio(true);

        Invader39.setX(1720);
        Invader39.setY(180);
        Invader39.setFitHeight(80);
        Invader39.setFitWidth(80);
        Invader39.setPreserveRatio(true);

        Invader40.setX(40);
        Invader40.setY(260);
        Invader40.setFitHeight(80);
        Invader40.setFitWidth(80);
        Invader40.setPreserveRatio(true);

        Invader41.setX(120);
        Invader41.setY(260);
        Invader41.setFitHeight(80);
        Invader41.setFitWidth(80);
        Invader41.setPreserveRatio(true);

        Invader42.setX(200);
        Invader42.setY(260);
        Invader42.setFitHeight(80);
        Invader42.setFitWidth(80);
        Invader42.setPreserveRatio(true);

        Invader43.setX(280);
        Invader43.setY(260);
        Invader43.setFitHeight(80);
        Invader43.setFitWidth(80);
        Invader43.setPreserveRatio(true);

        Invader44.setX(400);
        Invader44.setY(260);
        Invader44.setFitHeight(80);
        Invader44.setFitWidth(80);
        Invader44.setPreserveRatio(true);

        Invader45.setX(480);
        Invader45.setY(260);
        Invader45.setFitHeight(80);
        Invader45.setFitWidth(80);
        Invader45.setPreserveRatio(true);

        Invader46.setX(560);
        Invader46.setY(260);
        Invader46.setFitHeight(80);
        Invader46.setFitWidth(80);
        Invader46.setPreserveRatio(true);

        Invader47.setX(640);
        Invader47.setY(260);
        Invader47.setFitHeight(80);
        Invader47.setFitWidth(80);
        Invader47.setPreserveRatio(true);

        Invader48.setX(760);
        Invader48.setY(260);
        Invader48.setFitHeight(80);
        Invader48.setFitWidth(80);
        Invader48.setPreserveRatio(true);

        Invader49.setX(840);
        Invader49.setY(260);
        Invader49.setFitHeight(80);
        Invader49.setFitWidth(80);
        Invader49.setPreserveRatio(true);

        Invader50.setX(920);
        Invader50.setY(260);
        Invader50.setFitHeight(80);
        Invader50.setFitWidth(80);
        Invader50.setPreserveRatio(true);

        Invader51.setX(1000);
        Invader51.setY(260);
        Invader51.setFitHeight(80);
        Invader51.setFitWidth(80);
        Invader51.setPreserveRatio(true);

        Invader52.setX(1120);
        Invader52.setY(260);
        Invader52.setFitHeight(80);
        Invader52.setFitWidth(80);
        Invader52.setPreserveRatio(true);

        Invader53.setX(1200);
        Invader53.setY(260);
        Invader53.setFitHeight(80);
        Invader53.setFitWidth(80);
        Invader53.setPreserveRatio(true);

        Invader54.setX(1280);
        Invader54.setY(260);
        Invader54.setFitHeight(80);
        Invader54.setFitWidth(80);
        Invader54.setPreserveRatio(true);

        Invader55.setX(1360);
        Invader55.setY(260);
        Invader55.setFitHeight(80);
        Invader55.setFitWidth(80);
        Invader55.setPreserveRatio(true);

        Invader56.setX(1480);
        Invader56.setY(260);
        Invader56.setFitHeight(80);
        Invader56.setFitWidth(80);
        Invader56.setPreserveRatio(true);

        Invader57.setX(1560);
        Invader57.setY(260);
        Invader57.setFitHeight(80);
        Invader57.setFitWidth(80);
        Invader57.setPreserveRatio(true);

        Invader58.setX(1640);
        Invader58.setY(260);
        Invader58.setFitHeight(80);
        Invader58.setFitWidth(80);
        Invader58.setPreserveRatio(true);

        Invader59.setX(1720);
        Invader59.setY(260);
        Invader59.setFitHeight(80);
        Invader59.setFitWidth(80);
        Invader59.setPreserveRatio(true);

        Image bullet = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Bullet.png"));
        ImageView Bullet = new ImageView(bullet);
        Bullet.setX(SpaceShip.getX() + 30);
        Bullet.setY(SpaceShip.getY() + 50);
        Bullet.setFitHeight(50);
        Bullet.setFitWidth(50);
        Bullet.setPreserveRatio(true);
        Bullet.setVisible(false);

        ImageView Bullet1 = new ImageView(bullet);
        Bullet.setX(SpaceShip.getX() + 30);
        Bullet.setY(SpaceShip.getY() + 50);
        Bullet.setFitHeight(50);
        Bullet.setFitWidth(50);
        Bullet.setPreserveRatio(true);
        Bullet.setVisible(false);
        final int[] state = {0};
        AnimationTimer graphic0 = new AnimationTimer() {
            @Override
            public void handle(long now) {

                counter[0]++;
                if (counter[0] % 50 == 0) {
                    Invader0.setImage(B2);
                    Invader1.setImage(B2);
                    Invader2.setImage(B2);
                    Invader3.setImage(B2);
                    Invader4.setImage(R2);
                    Invader5.setImage(R2);
                    Invader6.setImage(R2);
                    Invader7.setImage(R2);
                    Invader8.setImage(Y2);
                    Invader9.setImage(Y2);
                    Invader10.setImage(Y2);
                    Invader11.setImage(Y2);
                    Invader12.setImage(G2);
                    Invader13.setImage(G2);
                    Invader14.setImage(G2);
                    Invader15.setImage(G2);
                    Invader16.setImage(P2);
                    Invader17.setImage(P2);
                    Invader18.setImage(P2);
                    Invader19.setImage(P2);
                    Invader20.setImage(B2);
                    Invader21.setImage(B2);
                    Invader22.setImage(B2);
                    Invader23.setImage(B2);
                    Invader24.setImage(R2);
                    Invader25.setImage(R2);
                    Invader26.setImage(R2);
                    Invader27.setImage(R2);
                    Invader28.setImage(Y2);
                    Invader29.setImage(Y2);
                    Invader30.setImage(Y2);
                    Invader31.setImage(Y2);
                    Invader32.setImage(G2);
                    Invader33.setImage(G2);
                    Invader34.setImage(G2);
                    Invader35.setImage(G2);
                    Invader36.setImage(P2);
                    Invader37.setImage(P2);
                    Invader38.setImage(P2);
                    Invader39.setImage(P2);
                    Invader40.setImage(B2);
                    Invader41.setImage(B2);
                    Invader42.setImage(B2);
                    Invader43.setImage(B2);
                    Invader44.setImage(R2);
                    Invader45.setImage(R2);
                    Invader46.setImage(R2);
                    Invader47.setImage(R2);
                    Invader48.setImage(Y2);
                    Invader49.setImage(Y2);
                    Invader50.setImage(Y2);
                    Invader51.setImage(Y2);
                    Invader52.setImage(G2);
                    Invader53.setImage(G2);
                    Invader54.setImage(G2);
                    Invader55.setImage(G2);
                    Invader56.setImage(P2);
                    Invader57.setImage(P2);
                    Invader58.setImage(P2);
                    Invader59.setImage(P2);

                }
                if (counter[0] % 50 == 25) {
                    Invader0.setImage(B1);
                    Invader1.setImage(B1);
                    Invader2.setImage(B1);
                    Invader3.setImage(B1);
                    Invader4.setImage(R1);
                    Invader5.setImage(R1);
                    Invader6.setImage(R1);
                    Invader7.setImage(R1);
                    Invader8.setImage(Y1);
                    Invader9.setImage(Y1);
                    Invader10.setImage(Y1);
                    Invader11.setImage(Y1);
                    Invader12.setImage(G1);
                    Invader13.setImage(G1);
                    Invader14.setImage(G1);
                    Invader15.setImage(G1);
                    Invader16.setImage(P1);
                    Invader17.setImage(P1);
                    Invader18.setImage(P1);
                    Invader19.setImage(P1);
                    Invader20.setImage(B1);
                    Invader21.setImage(B1);
                    Invader22.setImage(B1);
                    Invader23.setImage(B1);
                    Invader24.setImage(R1);
                    Invader25.setImage(R1);
                    Invader26.setImage(R1);
                    Invader27.setImage(R1);
                    Invader28.setImage(Y1);
                    Invader29.setImage(Y1);
                    Invader30.setImage(Y1);
                    Invader31.setImage(Y1);
                    Invader32.setImage(G1);
                    Invader33.setImage(G1);
                    Invader34.setImage(G1);
                    Invader35.setImage(G1);
                    Invader36.setImage(P1);
                    Invader37.setImage(P1);
                    Invader38.setImage(P1);
                    Invader39.setImage(P1);
                    Invader40.setImage(B1);
                    Invader41.setImage(B1);
                    Invader42.setImage(B1);
                    Invader43.setImage(B1);
                    Invader44.setImage(R1);
                    Invader45.setImage(R1);
                    Invader46.setImage(R1);
                    Invader47.setImage(R1);
                    Invader48.setImage(Y1);
                    Invader49.setImage(Y1);
                    Invader50.setImage(Y1);
                    Invader51.setImage(Y1);
                    Invader52.setImage(G1);
                    Invader53.setImage(G1);
                    Invader54.setImage(G1);
                    Invader55.setImage(G1);
                    Invader56.setImage(P1);
                    Invader57.setImage(P1);
                    Invader58.setImage(P1);
                    Invader59.setImage(P1);
                }

                if (counter[0] % 400 == 0) {
                    Invader0.setX(Invader0.getX() - 50);
                    Invader1.setX(Invader1.getX() - 50);
                    Invader2.setX(Invader2.getX() - 50);
                    Invader3.setX(Invader3.getX() - 50);
                    Invader4.setX(Invader4.getX() - 50);
                    Invader5.setX(Invader5.getX() - 50);
                    Invader6.setX(Invader6.getX() - 50);
                    Invader7.setX(Invader7.getX() - 50);
                    Invader8.setX(Invader8.getX() - 50);
                    Invader9.setX(Invader9.getX() - 50);
                    Invader10.setX(Invader10.getX() - 50);
                    Invader11.setX(Invader11.getX() - 50);
                    Invader12.setX(Invader12.getX() - 50);
                    Invader13.setX(Invader13.getX() - 50);
                    Invader14.setX(Invader14.getX() - 50);
                    Invader15.setX(Invader15.getX() - 50);
                    Invader16.setX(Invader16.getX() - 50);
                    Invader17.setX(Invader17.getX() - 50);
                    Invader18.setX(Invader18.getX() - 50);
                    Invader19.setX(Invader19.getX() - 50);
                    Invader20.setX(Invader20.getX() - 50);
                    Invader21.setX(Invader21.getX() - 50);
                    Invader22.setX(Invader22.getX() - 50);
                    Invader23.setX(Invader23.getX() - 50);
                    Invader24.setX(Invader24.getX() - 50);
                    Invader25.setX(Invader25.getX() - 50);
                    Invader26.setX(Invader26.getX() - 50);
                    Invader27.setX(Invader27.getX() - 50);
                    Invader28.setX(Invader28.getX() - 50);
                    Invader29.setX(Invader29.getX() - 50);
                    Invader30.setX(Invader30.getX() - 50);
                    Invader31.setX(Invader31.getX() - 50);
                    Invader32.setX(Invader32.getX() - 50);
                    Invader33.setX(Invader33.getX() - 50);
                    Invader34.setX(Invader34.getX() - 50);
                    Invader35.setX(Invader35.getX() - 50);
                    Invader36.setX(Invader36.getX() - 50);
                    Invader37.setX(Invader37.getX() - 50);
                    Invader38.setX(Invader38.getX() - 50);
                    Invader39.setX(Invader39.getX() - 50);
                    Invader40.setX(Invader40.getX() - 50);
                    Invader41.setX(Invader41.getX() - 50);
                    Invader42.setX(Invader42.getX() - 50);
                    Invader43.setX(Invader43.getX() - 50);
                    Invader44.setX(Invader44.getX() - 50);
                    Invader45.setX(Invader45.getX() - 50);
                    Invader46.setX(Invader46.getX() - 50);
                    Invader47.setX(Invader47.getX() - 50);
                    Invader48.setX(Invader48.getX() - 50);
                    Invader49.setX(Invader49.getX() - 50);
                    Invader50.setX(Invader50.getX() - 50);
                    Invader51.setX(Invader51.getX() - 50);
                    Invader52.setX(Invader52.getX() - 50);
                    Invader53.setX(Invader53.getX() - 50);
                    Invader54.setX(Invader54.getX() - 50);
                    Invader55.setX(Invader55.getX() - 50);
                    Invader56.setX(Invader56.getX() - 50);
                    Invader57.setX(Invader57.getX() - 50);
                    Invader58.setX(Invader58.getX() - 50);
                    Invader59.setX(Invader59.getX() - 50);

                }
                if (counter[0] % 400 == 200) {
                    Invader0.setX(Invader0.getX() + 50);
                    Invader1.setX(Invader1.getX() + 50);
                    Invader2.setX(Invader2.getX() + 50);
                    Invader3.setX(Invader3.getX() + 50);
                    Invader4.setX(Invader4.getX() + 50);
                    Invader5.setX(Invader5.getX() + 50);
                    Invader6.setX(Invader6.getX() + 50);
                    Invader7.setX(Invader7.getX() + 50);
                    Invader8.setX(Invader8.getX() + 50);
                    Invader9.setX(Invader9.getX() + 50);
                    Invader10.setX(Invader10.getX() + 50);
                    Invader11.setX(Invader11.getX() + 50);
                    Invader12.setX(Invader12.getX() + 50);
                    Invader13.setX(Invader13.getX() + 50);
                    Invader14.setX(Invader14.getX() + 50);
                    Invader15.setX(Invader15.getX() + 50);
                    Invader16.setX(Invader16.getX() + 50);
                    Invader17.setX(Invader17.getX() + 50);
                    Invader18.setX(Invader18.getX() + 50);
                    Invader19.setX(Invader19.getX() + 50);
                    Invader20.setX(Invader20.getX() + 50);
                    Invader21.setX(Invader21.getX() + 50);
                    Invader22.setX(Invader22.getX() + 50);
                    Invader23.setX(Invader23.getX() + 50);
                    Invader24.setX(Invader24.getX() + 50);
                    Invader25.setX(Invader25.getX() + 50);
                    Invader26.setX(Invader26.getX() + 50);
                    Invader27.setX(Invader27.getX() + 50);
                    Invader28.setX(Invader28.getX() + 50);
                    Invader29.setX(Invader29.getX() + 50);
                    Invader30.setX(Invader30.getX() + 50);
                    Invader31.setX(Invader31.getX() + 50);
                    Invader32.setX(Invader32.getX() + 50);
                    Invader33.setX(Invader33.getX() + 50);
                    Invader34.setX(Invader34.getX() + 50);
                    Invader35.setX(Invader35.getX() + 50);
                    Invader36.setX(Invader36.getX() + 50);
                    Invader37.setX(Invader37.getX() + 50);
                    Invader38.setX(Invader38.getX() + 50);
                    Invader39.setX(Invader39.getX() + 50);
                    Invader40.setX(Invader40.getX() + 50);
                    Invader41.setX(Invader41.getX() + 50);
                    Invader42.setX(Invader42.getX() + 50);
                    Invader43.setX(Invader43.getX() + 50);
                    Invader44.setX(Invader44.getX() + 50);
                    Invader45.setX(Invader45.getX() + 50);
                    Invader46.setX(Invader46.getX() + 50);
                    Invader47.setX(Invader47.getX() + 50);
                    Invader48.setX(Invader48.getX() + 50);
                    Invader49.setX(Invader49.getX() + 50);
                    Invader50.setX(Invader50.getX() + 50);
                    Invader51.setX(Invader51.getX() + 50);
                    Invader52.setX(Invader52.getX() + 50);
                    Invader53.setX(Invader53.getX() + 50);
                    Invader54.setX(Invader54.getX() + 50);
                    Invader55.setX(Invader55.getX() + 50);
                    Invader56.setX(Invader56.getX() + 50);
                    Invader57.setX(Invader57.getX() + 50);
                    Invader58.setX(Invader58.getX() + 50);
                    Invader59.setX(Invader59.getX() + 50);

                }

                if (counter[0] % 1000 == 800) {
                    Invader0.setY(Invader0.getY() + 50);
                    Invader1.setY(Invader1.getY() + 50);
                    Invader2.setY(Invader2.getY() + 50);
                    Invader3.setY(Invader3.getY() + 50);
                    Invader4.setY(Invader4.getY() + 50);
                    Invader5.setY(Invader5.getY() + 50);
                    Invader6.setY(Invader6.getY() + 50);
                    Invader7.setY(Invader7.getY() + 50);
                    Invader8.setY(Invader8.getY() + 50);
                    Invader9.setY(Invader9.getY() + 50);
                    Invader10.setY(Invader10.getY() + 50);
                    Invader11.setY(Invader11.getY() + 50);
                    Invader12.setY(Invader12.getY() + 50);
                    Invader13.setY(Invader13.getY() + 50);
                    Invader14.setY(Invader14.getY() + 50);
                    Invader15.setY(Invader15.getY() + 50);
                    Invader16.setY(Invader16.getY() + 50);
                    Invader17.setY(Invader17.getY() + 50);
                    Invader18.setY(Invader18.getY() + 50);
                    Invader19.setY(Invader19.getY() + 50);
                    Invader20.setY(Invader20.getY() + 50);
                    Invader21.setY(Invader21.getY() + 50);
                    Invader22.setY(Invader22.getY() + 50);
                    Invader23.setY(Invader23.getY() + 50);
                    Invader24.setY(Invader24.getY() + 50);
                    Invader25.setY(Invader25.getY() + 50);
                    Invader26.setY(Invader26.getY() + 50);
                    Invader27.setY(Invader27.getY() + 50);
                    Invader28.setY(Invader28.getY() + 50);
                    Invader29.setY(Invader29.getY() + 50);
                    Invader30.setY(Invader30.getY() + 50);
                    Invader31.setY(Invader31.getY() + 50);
                    Invader32.setY(Invader32.getY() + 50);
                    Invader33.setY(Invader33.getY() + 50);
                    Invader34.setY(Invader34.getY() + 50);
                    Invader35.setY(Invader35.getY() + 50);
                    Invader36.setY(Invader36.getY() + 50);
                    Invader37.setY(Invader37.getY() + 50);
                    Invader38.setY(Invader38.getY() + 50);
                    Invader39.setY(Invader39.getY() + 50);
                    Invader40.setY(Invader40.getY() + 50);
                    Invader41.setY(Invader41.getY() + 50);
                    Invader42.setY(Invader42.getY() + 50);
                    Invader43.setY(Invader43.getY() + 50);
                    Invader44.setY(Invader44.getY() + 50);
                    Invader45.setY(Invader45.getY() + 50);
                    Invader46.setY(Invader46.getY() + 50);
                    Invader47.setY(Invader47.getY() + 50);
                    Invader48.setY(Invader48.getY() + 50);
                    Invader49.setY(Invader49.getY() + 50);
                    Invader50.setY(Invader50.getY() + 50);
                    Invader51.setY(Invader51.getY() + 50);
                    Invader52.setY(Invader52.getY() + 50);
                    Invader53.setY(Invader53.getY() + 50);
                    Invader54.setY(Invader54.getY() + 50);
                    Invader55.setY(Invader55.getY() + 50);
                    Invader56.setY(Invader56.getY() + 50);
                    Invader57.setY(Invader57.getY() + 50);
                    Invader58.setY(Invader58.getY() + 50);
                    Invader59.setY(Invader59.getY() + 50);

                }
                if(counter[0] %10000 == 0){
                    Invader0.setX(40);
                    Invader0.setY(100);
                    Invader0.setFitHeight(80);
                    Invader0.setFitWidth(80);
                    Invader0.setPreserveRatio(true);
                    Invader0.setVisible(true);

                    Invader1.setX(120);
                    Invader1.setY(100);
                    Invader1.setFitHeight(80);
                    Invader1.setFitWidth(80);
                    Invader1.setPreserveRatio(true);
                    Invader1.setVisible(true);

                    Invader2.setX(200);
                    Invader2.setY(100);
                    Invader2.setFitHeight(80);
                    Invader2.setFitWidth(80);
                    Invader2.setPreserveRatio(true);
                    Invader2.setVisible(true);

                    Invader3.setX(280);
                    Invader3.setY(100);
                    Invader3.setFitHeight(80);
                    Invader3.setFitWidth(80);
                    Invader3.setPreserveRatio(true);
                    Invader3.setVisible(true);

                    Invader4.setX(400);
                    Invader4.setY(100);
                    Invader4.setFitHeight(80);
                    Invader4.setFitWidth(80);
                    Invader4.setPreserveRatio(true);
                    Invader4.setVisible(true);

                    Invader5.setX(480);
                    Invader5.setY(100);
                    Invader5.setFitHeight(80);
                    Invader5.setFitWidth(80);
                    Invader5.setPreserveRatio(true);
                    Invader5.setVisible(true);

                    Invader6.setX(560);
                    Invader6.setY(100);
                    Invader6.setFitHeight(80);
                    Invader6.setFitWidth(80);
                    Invader6.setPreserveRatio(true);
                    Invader6.setVisible(true);

                    Invader7.setX(640);
                    Invader7.setY(100);
                    Invader7.setFitHeight(80);
                    Invader7.setFitWidth(80);
                    Invader7.setPreserveRatio(true);
                    Invader7.setVisible(true);

                    Invader8.setX(760);
                    Invader8.setY(100);
                    Invader8.setFitHeight(80);
                    Invader8.setFitWidth(80);
                    Invader8.setPreserveRatio(true);
                    Invader8.setVisible(true);

                    Invader9.setX(840);
                    Invader9.setY(100);
                    Invader9.setFitHeight(80);
                    Invader9.setFitWidth(80);
                    Invader9.setPreserveRatio(true);
                    Invader9.setVisible(true);

                    Invader10.setX(920);
                    Invader10.setY(100);
                    Invader10.setFitHeight(80);
                    Invader10.setFitWidth(80);
                    Invader10.setPreserveRatio(true);
                    Invader10.setVisible(true);

                    Invader11.setX(1000);
                    Invader11.setY(100);
                    Invader11.setFitHeight(80);
                    Invader11.setFitWidth(80);
                    Invader11.setPreserveRatio(true);
                    Invader11.setVisible(true);

                    Invader12.setX(1120);
                    Invader12.setY(100);
                    Invader12.setFitHeight(80);
                    Invader12.setFitWidth(80);
                    Invader12.setPreserveRatio(true);
                    Invader12.setVisible(true);

                    Invader13.setX(1200);
                    Invader13.setY(100);
                    Invader13.setFitHeight(80);
                    Invader13.setFitWidth(80);
                    Invader13.setPreserveRatio(true);
                    Invader13.setVisible(true);

                    Invader14.setX(1280);
                    Invader14.setY(100);
                    Invader14.setFitHeight(80);
                    Invader14.setFitWidth(80);
                    Invader14.setPreserveRatio(true);
                    Invader14.setVisible(true);

                    Invader15.setX(1360);
                    Invader15.setY(100);
                    Invader15.setFitHeight(80);
                    Invader15.setFitWidth(80);
                    Invader15.setPreserveRatio(true);
                    Invader15.setVisible(true);

                    Invader16.setX(1480);
                    Invader16.setY(100);
                    Invader16.setFitHeight(80);
                    Invader16.setFitWidth(80);
                    Invader16.setPreserveRatio(true);
                    Invader16.setVisible(true);

                    Invader17.setX(1560);
                    Invader17.setY(100);
                    Invader17.setFitHeight(80);
                    Invader17.setFitWidth(80);
                    Invader17.setPreserveRatio(true);
                    Invader17.setVisible(true);

                    Invader18.setX(1640);
                    Invader18.setY(100);
                    Invader18.setFitHeight(80);
                    Invader18.setFitWidth(80);
                    Invader18.setPreserveRatio(true);
                    Invader18.setVisible(true);

                    Invader19.setX(1720);
                    Invader19.setY(100);
                    Invader19.setFitHeight(80);
                    Invader19.setFitWidth(80);
                    Invader19.setPreserveRatio(true);
                    Invader19.setVisible(true);
                }
            }
        };
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Bullet.setY(Bullet.getY() - 20);
                if (Bullet.getY() < -49) {
                    Bullet.setVisible(false);
                }
                if (Bullet.getY() <= Invader0.getY() + 25 && Bullet.getY() >= Invader0.getY() && Bullet.getX() <= Invader0.getX() + 54 && Bullet.getX() >= Invader0.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader0.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader0.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader0.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }


                }
                if (Bullet.getY() <= Invader1.getY() + 25 && Bullet.getY() >= Invader1.getY() && Bullet.getX() <= Invader1.getX() + 54 && Bullet.getX() >= Invader1.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader1.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader1.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader1.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader2.getY() + 25 && Bullet.getY() >= Invader2.getY() && Bullet.getX() <= Invader2.getX() + 54 && Bullet.getX() >= Invader2.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader2.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader2.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader2.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader3.getY() + 25 && Bullet.getY() >= Invader3.getY() && Bullet.getX() <= Invader3.getX() + 54 && Bullet.getX() >= Invader3.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader3.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader3.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader3.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader4.getY() + 25 && Bullet.getY() >= Invader4.getY() && Bullet.getX() <= Invader4.getX() + 54 && Bullet.getX() >= Invader4.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader4.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader4.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader4.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader5.getY() + 25 && Bullet.getY() >= Invader5.getY() && Bullet.getX() <= Invader5.getX() + 54 && Bullet.getX() >= Invader5.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader5.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader5.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader5.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader6.getY() + 25 && Bullet.getY() >= Invader6.getY() && Bullet.getX() <= Invader6.getX() + 54 && Bullet.getX() >= Invader6.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader6.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader6.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader6.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader7.getY() + 25 && Bullet.getY() >= Invader7.getY() && Bullet.getX() <= Invader7.getX() + 54 && Bullet.getX() >= Invader7.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader7.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader7.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader7.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader8.getY() + 25 && Bullet.getY() >= Invader8.getY() && Bullet.getX() <= Invader8.getX() + 54 && Bullet.getX() >= Invader8.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader8.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader8.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader8.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader9.getY() + 25 && Bullet.getY() >= Invader9.getY() && Bullet.getX() <= Invader9.getX() + 54 && Bullet.getX() >= Invader9.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader9.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader9.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader9.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader10.getY() + 25 && Bullet.getY() >= Invader10.getY() && Bullet.getX() <= Invader10.getX() + 54 && Bullet.getX() >= Invader10.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader10.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader10.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader10.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader11.getY() + 25 && Bullet.getY() >= Invader11.getY() && Bullet.getX() <= Invader11.getX() + 54 && Bullet.getX() >= Invader11.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader11.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader11.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader11.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader12.getY() + 25 && Bullet.getY() >= Invader12.getY() && Bullet.getX() <= Invader12.getX() + 54 && Bullet.getX() >= Invader12.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader12.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader12.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader12.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader13.getY() + 25 && Bullet.getY() >= Invader13.getY() && Bullet.getX() <= Invader13.getX() + 54 && Bullet.getX() >= Invader13.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader13.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader13.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader13.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader14.getY() + 25 && Bullet.getY() >= Invader14.getY() && Bullet.getX() <= Invader14.getX() + 54 && Bullet.getX() >= Invader14.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader14.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader14.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader14.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader15.getY() + 25 && Bullet.getY() >= Invader15.getY() && Bullet.getX() <= Invader15.getX() + 54 && Bullet.getX() >= Invader15.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader15.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader15.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader15.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader16.getY() + 25 && Bullet.getY() >= Invader16.getY() && Bullet.getX() <= Invader16.getX() + 54 && Bullet.getX() >= Invader16.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader16.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader16.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader16.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader17.getY() + 25 && Bullet.getY() >= Invader17.getY() && Bullet.getX() <= Invader17.getX() + 54 && Bullet.getX() >= Invader17.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader17.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader17.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader17.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader18.getY() + 25 && Bullet.getY() >= Invader18.getY() && Bullet.getX() <= Invader18.getX() + 54 && Bullet.getX() >= Invader18.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader18.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader18.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader18.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader19.getY() + 25 && Bullet.getY() >= Invader19.getY() && Bullet.getX() <= Invader19.getX() + 54 && Bullet.getX() >= Invader19.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader19.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader19.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader19.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader20.getY() + 25 && Bullet.getY() >= Invader20.getY() && Bullet.getX() <= Invader20.getX() + 54 && Bullet.getX() >= Invader20.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader20.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader20.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader20.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }


                }
                if (Bullet.getY() <= Invader21.getY() + 25 && Bullet.getY() >= Invader21.getY() && Bullet.getX() <= Invader21.getX() + 54 && Bullet.getX() >= Invader21.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader21.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader21.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader21.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader22.getY() + 25 && Bullet.getY() >= Invader22.getY() && Bullet.getX() <= Invader22.getX() + 54 && Bullet.getX() >= Invader22.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader22.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader22.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader22.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader23.getY() + 25 && Bullet.getY() >= Invader23.getY() && Bullet.getX() <= Invader23.getX() + 54 && Bullet.getX() >= Invader23.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader23.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader23.setImage(B3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader23.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader24.getY() + 25 && Bullet.getY() >= Invader24.getY() && Bullet.getX() <= Invader24.getX() + 54 && Bullet.getX() >= Invader24.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader24.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader24.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader24.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader25.getY() + 25 && Bullet.getY() >= Invader25.getY() && Bullet.getX() <= Invader25.getX() + 54 && Bullet.getX() >= Invader25.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader25.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader25.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader25.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader26.getY() + 25 && Bullet.getY() >= Invader26.getY() && Bullet.getX() <= Invader26.getX() + 54 && Bullet.getX() >= Invader26.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader26.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader26.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader26.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader27.getY() + 25 && Bullet.getY() >= Invader27.getY() && Bullet.getX() <= Invader27.getX() + 54 && Bullet.getX() >= Invader27.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader27.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader27.setImage(R3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader27.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader28.getY() + 25 && Bullet.getY() >= Invader28.getY() && Bullet.getX() <= Invader28.getX() + 54 && Bullet.getX() >= Invader28.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader28.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader28.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader28.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader29.getY() + 25 && Bullet.getY() >= Invader29.getY() && Bullet.getX() <= Invader29.getX() + 54 && Bullet.getX() >= Invader29.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader29.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader29.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader29.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader30.getY() + 25 && Bullet.getY() >= Invader30.getY() && Bullet.getX() <= Invader30.getX() + 54 && Bullet.getX() >= Invader30.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader30.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader30.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader30.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader31.getY() + 25 && Bullet.getY() >= Invader31.getY() && Bullet.getX() <= Invader31.getX() + 54 && Bullet.getX() >= Invader31.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader31.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader31.setImage(Y3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader31.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader32.getY() + 25 && Bullet.getY() >= Invader32.getY() && Bullet.getX() <= Invader32.getX() + 54 && Bullet.getX() >= Invader32.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader32.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader32.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader32.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader33.getY() + 25 && Bullet.getY() >= Invader33.getY() && Bullet.getX() <= Invader33.getX() + 54 && Bullet.getX() >= Invader33.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader33.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader33.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader33.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader34.getY() + 25 && Bullet.getY() >= Invader34.getY() && Bullet.getX() <= Invader34.getX() + 54 && Bullet.getX() >= Invader34.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader34.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader34.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader34.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader35.getY() + 25 && Bullet.getY() >= Invader35.getY() && Bullet.getX() <= Invader35.getX() + 54 && Bullet.getX() >= Invader35.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader35.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader35.setImage(G3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader35.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }
                }
                if (Bullet.getY() <= Invader36.getY() + 25 && Bullet.getY() >= Invader36.getY() && Bullet.getX() <= Invader36.getX() + 54 && Bullet.getX() >= Invader36.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader36.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader36.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader36.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader37.getY() + 25 && Bullet.getY() >= Invader37.getY() && Bullet.getX() <= Invader37.getX() + 54 && Bullet.getX() >= Invader37.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader37.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader37.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader37.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader38.getY() + 25 && Bullet.getY() >= Invader38.getY() && Bullet.getX() <= Invader38.getX() + 54 && Bullet.getX() >= Invader38.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader38.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader38.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader38.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
                if (Bullet.getY() <= Invader39.getY() + 25 && Bullet.getY() >= Invader39.getY() && Bullet.getX() <= Invader39.getX() + 54 && Bullet.getX() >= Invader39.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader39.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        Invader39.setImage(P3);
                        graphic0.stop();
                        state[0]++;
                    }
                    if (state[0] == 2) {
                        Invader39.setVisible(false);
                        graphic0.start();
                        state[0] = 0;
                    }

                }
            }
        };


        EventHandler<KeyEvent> keyListener = event -> {
            if (event.getCode() == KeyCode.RIGHT && SpaceShip.getX() < 1880) {
                SpaceShip.setX(SpaceShip.getX() + 20);
            }
            if (event.getCode() == KeyCode.LEFT && SpaceShip.getX() > 0) {
                SpaceShip.setX(SpaceShip.getX() - 20);
            }
            if (event.getCode() == KeyCode.UP && SpaceShip.getY() > 0) {
                SpaceShip.setY(SpaceShip.getY() - 20);
            }
            if (event.getCode() == KeyCode.DOWN && SpaceShip.getY() < 960) {
                SpaceShip.setY(SpaceShip.getY() + 20);
            }
            if (event.getCode() == KeyCode.A) {
                Bullet.setVisible(true);
                if(Bullet.getY() < 0) {

                    Bullet.setX(SpaceShip.getX() + 25);
                    Bullet.setY(SpaceShip.getY() + 50);

                }
                shootPlayer.play();
                animationTimer.start();
                shootPlayer.stop();
                shootPlayer.play();
                shootPlayer.stop();

            }
            if (event.getCode() == KeyCode.S) {
                System.out.println(score[0]);
            }
            event.consume();
        };



        Group game = new Group(bgGame, Invader0, Invader1, Invader2, Invader3, Invader4, Invader5, Invader6, Invader7,
                Invader8, Invader9, Invader10, Invader11, SpaceShip, Invader12, Invader13,
                Invader14, Invader15, Invader16, Invader17, Invader18, Invader19, Invader20, Invader21,
                Invader22, Invader23, Invader24, Invader25, Invader26, Invader27, Invader28, Invader29,
                Invader30, Invader31, Invader32, Invader33, Invader34, Invader35, Invader36, Invader37,
                Invader38, Invader39, Invader40, Invader41, Invader42, Invader43, Invader44, Invader45, Invader46, Invader47,
                Invader48, Invader49,Invader50, Invader51, Invader52, Invader53, Invader54, Invader55, Invader56, Invader57,
                Invader58, Invader59, scoreNumber, scoreText, messageText, backButton, Bullet);


        Group menu = new Group(bgStart, startNewGameButton, exitButton, resumeButton, highscoreButton);


        groundPlayer.setAutoPlay(true);

        Scene gameScene = new Scene(game, 1880, 960);
        gameScene.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());
        gameScene.setOnKeyPressed(keyListener);

        Scene menuScene = new Scene(menu, 1880, 960);


        primaryStage.setTitle("SpaceInvaders");
        primaryStage.getIcons().add(new Image("/B1.png"));
        primaryStage.setScene(menuScene);
        primaryStage.show();

        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.NO, ButtonType.YES);
        exitAlert.setHeaderText("We will lose you...");
        exitAlert.setContentText("Are you sure?");
        exitAlert.setTitle("exit");
        exitAlert.setResult(exitAlert.getResult());
        DialogPane dialogPane = exitAlert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");


        startNewGameButton.setOnMouseClicked(event -> {
            primaryStage.setScene(gameScene);
            graphic0.start();
        });
        exitButton.setOnMouseClicked(event -> {
            exitAlert.showAndWait();
            if(exitAlert.getResult() == ButtonType.YES){
                primaryStage.close();
            }
        });
        backButton.setOnMouseClicked(event -> {
            graphic0.stop();
            primaryStage.setScene(menuScene);
        });


    }


    public static void main(String[] args) {
        launch(args);
    }

}