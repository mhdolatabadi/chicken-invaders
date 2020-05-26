package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;


public class Main extends Application {
    private final Color Black = new Color(0, 1, 1, 1);

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
        Image background = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\background.png"));
        ImageView bgView = new ImageView(background);
        bgView.setX(0);
        bgView.setY(0);
        bgView.setFitHeight(3000);
        bgView.setFitWidth(2000);
        bgView.setPreserveRatio(true);
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


        Image bullet = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Bullet.png"));
        ImageView Bullet = new ImageView(bullet);
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
                }
            }
        };
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Bullet.setY(Bullet.getY() - 20);
                if (Bullet.getY() <= Invader0.getY() + 25 && Bullet.getY() >= Invader0.getY() && Bullet.getX() <= Invader0.getX() + 54 && Bullet.getX() >= Invader0.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (Invader0.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
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
            }
        };


        EventHandler<KeyEvent> keyListener = event -> {
            if (event.getCode() == KeyCode.RIGHT && SpaceShip.getX() < 1200) {
                SpaceShip.setX(SpaceShip.getX() + 20);
            }
            if (event.getCode() == KeyCode.LEFT && SpaceShip.getX() > 100) {
                SpaceShip.setX(SpaceShip.getX() - 20);
            }
            if (event.getCode() == KeyCode.SPACE) {
                Bullet.setVisible(true);
                Bullet.setX(SpaceShip.getX() + 25);
                Bullet.setY(SpaceShip.getY() + 50);
                shootPlayer.play();
                animationTimer.start();
                shootPlayer.stop();
                shootPlayer.play();
                shootPlayer.stop();

            }
            if (event.getCode() == KeyCode.M) {
                groundPlayer.play();

            }
            if (event.getCode() == KeyCode.P) {
                mediaPlayer.pause();
            }
            if (event.getCode() == KeyCode.S) {
                System.out.println(score[0]);
            }
            event.consume();
        };


        //Creating a Group object
        Group group = new Group(bgView, Invader0, Invader1, Invader2, Invader3, Invader4, Invader5, Invader6, Invader7,
                Invader8, Invader9, Invader10, Invader11, Bullet, SpaceShip, Invader12, Invader13,
                Invader14, Invader15, Invader16, Invader17, Invader18, Invader19, scoreImageView);

        Scene scene = new Scene(group, 1880, 960);
        scene.setOnKeyPressed(keyListener);
        scene.setFill(Black);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();
        graphic0.start();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
