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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.sound.midi.*;
import javax.sound.midi.spi.SoundbankReader;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Main extends Application {

    private final Color Black = new Color(0, 0, 0, 1);


    @Override
    public void start(Stage primaryStage) throws Exception {
        final int[] score = {0};
        Media media = new Media(getClass().getResource("/Untitled3.mp3").toURI().toString());
        Media shoot = new Media(getClass().getResource("/shoot.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaPlayer shootPlayer = new MediaPlayer(shoot);

        Image image = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Untitled.jpg"));
        ImageView SpaceShip = new ImageView(image);
        SpaceShip.setX(650);
        SpaceShip.setY(700);
        SpaceShip.setFitHeight(100);
        SpaceShip.setFitWidth(100);
        SpaceShip.setPreserveRatio(true);


        Image image2 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Invader1.jpg"));
        Image image3 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Invader2.jpg"));
        Image image4 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Invader3.jpg"));
        Image image5 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Invader4.jpg"));
        Image image6 = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Invader5.jpg"));
        ImageView Invader0 = new ImageView(image2);
        ImageView Invader1 = new ImageView(image2);
        ImageView Invader2 = new ImageView(image2);
        ImageView Invader3 = new ImageView(image2);
        ImageView Invader4 = new ImageView(image3);
        ImageView Invader5 = new ImageView(image3);
        ImageView Invader6 = new ImageView(image3);
        ImageView Invader7 = new ImageView(image3);
        ImageView Invader8 = new ImageView(image4);
        ImageView Invader9 = new ImageView(image4);
        ImageView Invader10 = new ImageView(image4);
        ImageView Invader11 = new ImageView(image4);
        ImageView Invader12 = new ImageView(image5);
        ImageView Invader13 = new ImageView(image5);
        ImageView Invader14 = new ImageView(image5);
        ImageView Invader15 = new ImageView(image5);
        ImageView Invader16 = new ImageView(image6);
        ImageView Invader17 = new ImageView(image6);
        ImageView Invader18 = new ImageView(image6);
        ImageView Invader19 = new ImageView(image6);
        ImageView Invader20 = new ImageView(image2);
        ImageView Invader21 = new ImageView(image2);
        ImageView Invader22 = new ImageView(image2);
        ImageView Invader23 = new ImageView(image2);
        ImageView Invader24 = new ImageView(image3);
        ImageView Invader25 = new ImageView(image3);
        ImageView Invader26 = new ImageView(image3);
        ImageView Invader27 = new ImageView(image3);
        ImageView Invader28 = new ImageView(image4);
        ImageView Invader29 = new ImageView(image4);
        ImageView Invader30 = new ImageView(image4);
        ImageView Invader31 = new ImageView(image4);
        ImageView Invader32 = new ImageView(image5);
        ImageView Invader33 = new ImageView(image5);
        ImageView Invader34 = new ImageView(image5);
        ImageView Invader35 = new ImageView(image5);
        ImageView Invader36 = new ImageView(image6);
        ImageView Invader37 = new ImageView(image6);
        ImageView Invader38 = new ImageView(image6);
        ImageView Invader39 = new ImageView(image6);
        ImageView Invader40 = new ImageView(image2);
        ImageView Invader41 = new ImageView(image2);
        ImageView Invader42 = new ImageView(image2);
        ImageView Invader43 = new ImageView(image2);
        ImageView Invader44 = new ImageView(image2);
        ImageView Invader45 = new ImageView(image2);
        ImageView Invader46 = new ImageView(image2);
        ImageView Invader47 = new ImageView(image2);
        ImageView Invader48 = new ImageView(image2);
        ImageView Invader49 = new ImageView(image2);
        ImageView Invader50 = new ImageView(image2);
        ImageView Invader51 = new ImageView(image2);
        ImageView Invader52 = new ImageView(image2);
        ImageView Invader53 = new ImageView(image2);
        ImageView Invader54 = new ImageView(image2);
        ImageView Invader55 = new ImageView(image2);
        ImageView Invader56 = new ImageView(image2);
        ImageView Invader57 = new ImageView(image2);
        ImageView Invader58 = new ImageView(image2);
        ImageView Invader59 = new ImageView(image2);
        ImageView Invader60 = new ImageView(image2);
        ImageView Invader61 = new ImageView(image2);
        ImageView Invader62 = new ImageView(image2);
        ImageView Invader63 = new ImageView(image2);
        ImageView Invader64 = new ImageView(image2);
        ImageView Invader65 = new ImageView(image2);
        ImageView Invader66 = new ImageView(image2);
        ImageView Invader67 = new ImageView(image2);
        ImageView Invader68 = new ImageView(image2);
        ImageView Invader69 = new ImageView(image2);
        ImageView Invader70 = new ImageView(image2);
        ImageView Invader71 = new ImageView(image2);
        ImageView Invader72 = new ImageView(image2);
        ImageView Invader73 = new ImageView(image2);
        ImageView Invader74 = new ImageView(image2);
        ImageView Invader75 = new ImageView(image2);
        ImageView Invader76 = new ImageView(image2);
        ImageView Invader77 = new ImageView(image2);
        ImageView Invader78 = new ImageView(image2);
        ImageView Invader79 = new ImageView(image2);
        ImageView Invader80 = new ImageView(image2);
        ImageView Invader81 = new ImageView(image2);
        ImageView Invader82 = new ImageView(image2);
        ImageView Invader83 = new ImageView(image2);
        ImageView Invader84 = new ImageView(image2);
        ImageView Invader85 = new ImageView(image2);
        ImageView Invader86 = new ImageView(image2);
        ImageView Invader87 = new ImageView(image2);
        ImageView Invader88 = new ImageView(image2);
        ImageView Invader89 = new ImageView(image2);
        ImageView Invader90 = new ImageView(image2);
        ImageView Invader91 = new ImageView(image2);
        ImageView Invader92 = new ImageView(image2);
        ImageView Invader93 = new ImageView(image2);
        ImageView Invader94 = new ImageView(image2);
        ImageView Invader95 = new ImageView(image2);
        ImageView Invader96 = new ImageView(image2);
        ImageView Invader97 = new ImageView(image2);
        ImageView Invader98 = new ImageView(image2);
        ImageView Invader99 = new ImageView(image2);
        ImageView Invader100 = new ImageView(image2);
        ImageView Invader101 = new ImageView(image2);
        ImageView Invader102 = new ImageView(image2);
        ImageView Invader103 = new ImageView(image2);
        ImageView Invader104 = new ImageView(image2);
        ImageView Invader105 = new ImageView(image2);
        ImageView Invader106 = new ImageView(image2);
        ImageView Invader107 = new ImageView(image2);
        ImageView Invader108 = new ImageView(image2);
        ImageView Invader109 = new ImageView(image2);
        ImageView Invader110 = new ImageView(image2);
        ImageView Invader111 = new ImageView(image2);
        ImageView Invader112 = new ImageView(image2);
        ImageView Invader113 = new ImageView(image2);
        ImageView Invader114 = new ImageView(image2);
        ImageView Invader115 = new ImageView(image2);
        ImageView Invader116 = new ImageView(image2);
        ImageView Invader117 = new ImageView(image2);
        ImageView Invader118 = new ImageView(image2);
        ImageView Invader119 = new ImageView(image2);


        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader10.setX(700);
        Invader10.setY(100);
        Invader10.setFitHeight(50);
        Invader10.setFitWidth(50);
        Invader10.setPreserveRatio(true);

        Invader11.setX(750);
        Invader11.setY(100);
        Invader11.setFitHeight(50);
        Invader11.setFitWidth(50);
        Invader11.setPreserveRatio(true);

        Invader12.setX(825);
        Invader12.setY(100);
        Invader12.setFitHeight(50);
        Invader12.setFitWidth(50);
        Invader12.setPreserveRatio(true);

        Invader13.setX(875);
        Invader13.setY(100);
        Invader13.setFitHeight(50);
        Invader13.setFitWidth(50);
        Invader13.setPreserveRatio(true);

        Invader14.setX(925);
        Invader14.setY(100);
        Invader14.setFitHeight(50);
        Invader14.setFitWidth(50);
        Invader14.setPreserveRatio(true);

        Invader15.setX(975);
        Invader15.setY(100);
        Invader15.setFitHeight(50);
        Invader15.setFitWidth(50);
        Invader15.setPreserveRatio(true);

        Invader16.setX(1050);
        Invader16.setY(100);
        Invader16.setFitHeight(50);
        Invader16.setFitWidth(50);
        Invader16.setPreserveRatio(true);

        Invader17.setX(1100);
        Invader17.setY(100);
        Invader17.setFitHeight(50);
        Invader17.setFitWidth(50);
        Invader17.setPreserveRatio(true);

        Invader18.setX(1150);
        Invader18.setY(100);
        Invader18.setFitHeight(50);
        Invader18.setFitWidth(50);
        Invader18.setPreserveRatio(true);

        Invader19.setX(1200);
        Invader19.setY(100);
        Invader19.setFitHeight(50);
        Invader19.setFitWidth(50);
        Invader19.setPreserveRatio(true);

        Invader20.setX(150);
        Invader20.setY(150);
        Invader20.setFitHeight(50);
        Invader20.setFitWidth(50);
        Invader20.setPreserveRatio(true);

        Invader21.setX(200);
        Invader21.setY(150);
        Invader21.setFitHeight(50);
        Invader21.setFitWidth(50);
        Invader21.setPreserveRatio(true);

        Invader22.setX(250);
        Invader22.setY(150);
        Invader22.setFitHeight(50);
        Invader22.setFitWidth(50);
        Invader22.setPreserveRatio(true);

        Invader23.setX(300);
        Invader23.setY(150);
        Invader23.setFitHeight(50);
        Invader23.setFitWidth(50);
        Invader23.setPreserveRatio(true);

        Invader24.setX(375);
        Invader24.setY(150);
        Invader24.setFitHeight(50);
        Invader24.setFitWidth(50);
        Invader24.setPreserveRatio(true);

        Invader25.setX(425);
        Invader25.setY(150);
        Invader25.setFitHeight(50);
        Invader25.setFitWidth(50);
        Invader25.setPreserveRatio(true);

        Invader26.setX(475);
        Invader26.setY(150);
        Invader26.setFitHeight(50);
        Invader26.setFitWidth(50);
        Invader26.setPreserveRatio(true);

        Invader27.setX(525);
        Invader27.setY(150);
        Invader27.setFitHeight(50);
        Invader27.setFitWidth(50);
        Invader27.setPreserveRatio(true);

        Invader28.setX(600);
        Invader28.setY(150);
        Invader28.setFitHeight(50);
        Invader28.setFitWidth(50);
        Invader28.setPreserveRatio(true);

        Invader29.setX(650);
        Invader29.setY(150);
        Invader29.setFitHeight(50);
        Invader29.setFitWidth(50);
        Invader29.setPreserveRatio(true);

        Invader30.setX(700);
        Invader30.setY(150);
        Invader30.setFitHeight(50);
        Invader30.setFitWidth(50);
        Invader30.setPreserveRatio(true);

        Invader31.setX(750);
        Invader31.setY(150);
        Invader31.setFitHeight(50);
        Invader31.setFitWidth(50);
        Invader31.setPreserveRatio(true);

        Invader32.setX(825);
        Invader32.setY(150);
        Invader32.setFitHeight(50);
        Invader32.setFitWidth(50);
        Invader32.setPreserveRatio(true);

        Invader33.setX(875);
        Invader33.setY(150);
        Invader33.setFitHeight(50);
        Invader33.setFitWidth(50);
        Invader33.setPreserveRatio(true);

        Invader34.setX(925);
        Invader34.setY(150);
        Invader34.setFitHeight(50);
        Invader34.setFitWidth(50);
        Invader34.setPreserveRatio(true);

        Invader35.setX(975);
        Invader35.setY(150);
        Invader35.setFitHeight(50);
        Invader35.setFitWidth(50);
        Invader35.setPreserveRatio(true);

        Invader36.setX(1050);
        Invader36.setY(150);
        Invader36.setFitHeight(50);
        Invader36.setFitWidth(50);
        Invader36.setPreserveRatio(true);

        Invader37.setX(1100);
        Invader37.setY(150);
        Invader37.setFitHeight(50);
        Invader37.setFitWidth(50);
        Invader37.setPreserveRatio(true);

        Invader38.setX(1150);
        Invader38.setY(150);
        Invader38.setFitHeight(50);
        Invader38.setFitWidth(50);
        Invader38.setPreserveRatio(true);

        Invader39.setX(1200);
        Invader39.setY(150);
        Invader39.setFitHeight(50);
        Invader39.setFitWidth(50);
        Invader39.setPreserveRatio(true);

        Invader40.setX(150);
        Invader40.setY(100);
        Invader40.setFitHeight(50);
        Invader40.setFitWidth(50);
        Invader40.setPreserveRatio(true);

        Invader41.setX(200);
        Invader41.setY(100);
        Invader41.setFitHeight(50);
        Invader41.setFitWidth(50);
        Invader41.setPreserveRatio(true);

        Invader42.setX(250);
        Invader42.setY(100);
        Invader42.setFitHeight(50);
        Invader42.setFitWidth(50);
        Invader42.setPreserveRatio(true);

        Invader43.setX(300);
        Invader43.setY(100);
        Invader43.setFitHeight(50);
        Invader43.setFitWidth(50);
        Invader43.setPreserveRatio(true);

        Invader44.setX(375);
        Invader44.setY(100);
        Invader44.setFitHeight(50);
        Invader44.setFitWidth(50);
        Invader44.setPreserveRatio(true);

        Invader45.setX(425);
        Invader45.setY(100);
        Invader45.setFitHeight(50);
        Invader45.setFitWidth(50);
        Invader45.setPreserveRatio(true);

        Invader46.setX(475);
        Invader46.setY(100);
        Invader46.setFitHeight(50);
        Invader46.setFitWidth(50);
        Invader46.setPreserveRatio(true);

        Invader47.setX(525);
        Invader47.setY(100);
        Invader47.setFitHeight(50);
        Invader47.setFitWidth(50);
        Invader47.setPreserveRatio(true);

        Invader48.setX(600);
        Invader48.setY(100);
        Invader48.setFitHeight(50);
        Invader48.setFitWidth(50);
        Invader48.setPreserveRatio(true);

        Invader49.setX(650);
        Invader49.setY(100);
        Invader49.setFitHeight(50);
        Invader49.setFitWidth(50);
        Invader49.setPreserveRatio(true);

        Invader50.setX(150);
        Invader50.setY(100);
        Invader50.setFitHeight(50);
        Invader50.setFitWidth(50);
        Invader50.setPreserveRatio(true);

        Invader51.setX(200);
        Invader51.setY(100);
        Invader51.setFitHeight(50);
        Invader51.setFitWidth(50);
        Invader51.setPreserveRatio(true);

        Invader52.setX(250);
        Invader52.setY(100);
        Invader52.setFitHeight(50);
        Invader52.setFitWidth(50);
        Invader52.setPreserveRatio(true);

        Invader53.setX(300);
        Invader53.setY(100);
        Invader53.setFitHeight(50);
        Invader53.setFitWidth(50);
        Invader53.setPreserveRatio(true);

        Invader54.setX(375);
        Invader54.setY(100);
        Invader54.setFitHeight(50);
        Invader54.setFitWidth(50);
        Invader54.setPreserveRatio(true);

        Invader55.setX(425);
        Invader55.setY(100);
        Invader55.setFitHeight(50);
        Invader55.setFitWidth(50);
        Invader55.setPreserveRatio(true);

        Invader56.setX(475);
        Invader56.setY(100);
        Invader56.setFitHeight(50);
        Invader56.setFitWidth(50);
        Invader56.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Invader0.setX(150);
        Invader0.setY(100);
        Invader0.setFitHeight(50);
        Invader0.setFitWidth(50);
        Invader0.setPreserveRatio(true);

        Invader1.setX(200);
        Invader1.setY(100);
        Invader1.setFitHeight(50);
        Invader1.setFitWidth(50);
        Invader1.setPreserveRatio(true);

        Invader2.setX(250);
        Invader2.setY(100);
        Invader2.setFitHeight(50);
        Invader2.setFitWidth(50);
        Invader2.setPreserveRatio(true);

        Invader3.setX(300);
        Invader3.setY(100);
        Invader3.setFitHeight(50);
        Invader3.setFitWidth(50);
        Invader3.setPreserveRatio(true);

        Invader4.setX(375);
        Invader4.setY(100);
        Invader4.setFitHeight(50);
        Invader4.setFitWidth(50);
        Invader4.setPreserveRatio(true);

        Invader5.setX(425);
        Invader5.setY(100);
        Invader5.setFitHeight(50);
        Invader5.setFitWidth(50);
        Invader5.setPreserveRatio(true);

        Invader6.setX(475);
        Invader6.setY(100);
        Invader6.setFitHeight(50);
        Invader6.setFitWidth(50);
        Invader6.setPreserveRatio(true);

        Invader7.setX(525);
        Invader7.setY(100);
        Invader7.setFitHeight(50);
        Invader7.setFitWidth(50);
        Invader7.setPreserveRatio(true);

        Invader8.setX(600);
        Invader8.setY(100);
        Invader8.setFitHeight(50);
        Invader8.setFitWidth(50);
        Invader8.setPreserveRatio(true);

        Invader9.setX(650);
        Invader9.setY(100);
        Invader9.setFitHeight(50);
        Invader9.setFitWidth(50);
        Invader9.setPreserveRatio(true);

        Image bullet = new Image(new FileInputStream("e:\\Users\\asus\\Documents\\As A Student\\Term 2\\Advance Programming\\Space Invaders\\Resources\\Untitled4.jpg"));
        ImageView Bullet = new ImageView(bullet);
        Bullet.setX(SpaceShip.getX() + 40);
        Bullet.setY(SpaceShip.getY() + 50);
        Bullet.setFitHeight(10);
        Bullet.setFitWidth(10);
        Bullet.setPreserveRatio(true);
        Bullet.setVisible(false);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Bullet.setY(Bullet.getY() - 20);
                if (Bullet.getY() <= Invader0.getY() + 25 && Bullet.getX() <= Invader0.getX() + 75 && Bullet.getX() >= Invader0.getX() && Bullet.visibleProperty().getValue())  {
                    if (Invader0.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader0.setVisible(false);

                }
                if (Bullet.getY() <= Invader1.getY() + 25 && Bullet.getX() <= Invader1.getX() + 75 && Bullet.getX() >= Invader1.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader1.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader1.setVisible(false);

                }
                if (Bullet.getY() <= Invader2.getY() + 25 && Bullet.getX() <= Invader2.getX() + 75 && Bullet.getX() >= Invader2.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader2.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader2.setVisible(false);

                }
                if (Bullet.getY() <= Invader3.getY() + 25 && Bullet.getX() <= Invader3.getX() + 75 && Bullet.getX() >= Invader3.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader3.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader3.setVisible(false);

                }
                if (Bullet.getY() <= Invader4.getY() + 25 && Bullet.getX() <= Invader4.getX() + 75 && Bullet.getX() >= Invader4.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader4.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader4.setVisible(false);

                }
                if (Bullet.getY() <= Invader5.getY() + 25 && Bullet.getX() <= Invader5.getX() + 75 && Bullet.getX() >= Invader5.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader5.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader5.setVisible(false);

                }
                if (Bullet.getY() <= Invader6.getY() + 25 && Bullet.getX() <= Invader6.getX() + 75 && Bullet.getX() >= Invader6.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader6.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader6.setVisible(false);

                }
                if (Bullet.getY() <= Invader7.getY() + 25 && Bullet.getX() <= Invader7.getX() + 75 && Bullet.getX() >= Invader7.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader7.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader7.setVisible(false);

                }
                if (Bullet.getY() <= Invader8.getY() + 25 && Bullet.getX() <= Invader8.getX() + 75 && Bullet.getX() >= Invader8.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader8.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader8.setVisible(false);
                    score[0] += 100;

                }
                if (Bullet.getY() <= Invader9.getY() + 25 && Bullet.getX() <= Invader9.getX() + 75 && Bullet.getX() >= Invader9.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader9.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }

                    Invader9.setVisible(false);
                }
                if (Bullet.getY() <= Invader10.getY() + 25 && Bullet.getX() <= Invader10.getX() + 75 && Bullet.getX() >= Invader10.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader10.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader10.setVisible(false);

                }
                if (Bullet.getY() <= Invader11.getY() + 25 && Bullet.getX() <= Invader11.getX() + 75 && Bullet.getX() >= Invader11.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader11.visibleProperty().getValue()) {
                        score[0] += 100;
                        Bullet.setVisible(false);
                    }
                    Invader11.setVisible(false);
                }
                if (Bullet.getY() <= Invader12.getY() + 25 && Bullet.getX() <= Invader12.getX() + 75 && Bullet.getX() >= Invader12.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader12.visibleProperty().getValue()) {
                        score[0] += 100;
                        Bullet.setVisible(false);
                    }
                    Invader12.setVisible(false);
                }
                if (Bullet.getY() <= Invader13.getY() + 25 && Bullet.getX() <= Invader13.getX() + 75 && Bullet.getX() >= Invader13.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader13.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }

                    Invader13.setVisible(false);
                }
                if (Bullet.getY() <= Invader14.getY() + 25 && Bullet.getX() <= Invader14.getX() + 75 && Bullet.getX() >= Invader14.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader14.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }

                    Invader14.setVisible(false);
                }
                if (Bullet.getY() <= Invader15.getY() + 25 && Bullet.getX() <= Invader15.getX() + 75 && Bullet.getX() >= Invader15.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader15.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }

                    Invader15.setVisible(false);
                }
                if (Bullet.getY() <= Invader16.getY() + 25 && Bullet.getX() <= Invader16.getX() + 75 && Bullet.getX() >= Invader16.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader16.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader16.setVisible(false);

                }
                if (Bullet.getY() <= Invader17.getY() + 25 && Bullet.getX() <= Invader17.getX() + 75 && Bullet.getX() >= Invader17.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader17.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader17.setVisible(false);

                }
                if (Bullet.getY() <= Invader18.getY() + 25 && Bullet.getX() <= Invader18.getX() + 75 && Bullet.getX() >= Invader18.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader18.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader18.setVisible(false);

                }
                if (Bullet.getY() <= Invader19.getY() + 25 && Bullet.getX() <= Invader19.getX() + 75 && Bullet.getX() >= Invader19.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader19.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader19.setVisible(false);

                }
                if (Bullet.getY() <= Invader20.getY() + 25 && Bullet.getX() <= Invader20.getX() + 75 && Bullet.getX() >= Invader20.getX() && Bullet.visibleProperty().getValue())  {
                    if (Invader20.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader20.setVisible(false);

                }
                if (Bullet.getY() <= Invader21.getY() + 25 && Bullet.getX() <= Invader21.getX() + 75 && Bullet.getX() >= Invader21.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader21.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader21.setVisible(false);

                }
                if (Bullet.getY() <= Invader22.getY() + 25 && Bullet.getX() <= Invader22.getX() + 75 && Bullet.getX() >= Invader22.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader22.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader22.setVisible(false);

                }
                if (Bullet.getY() <= Invader23.getY() + 25 && Bullet.getX() <= Invader23.getX() + 75 && Bullet.getX() >= Invader23.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader23.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader23.setVisible(false);

                }
                if (Bullet.getY() <= Invader24.getY() + 25 && Bullet.getX() <= Invader24.getX() + 75 && Bullet.getX() >= Invader24.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader24.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader24.setVisible(false);

                }
                if (Bullet.getY() <= Invader25.getY() + 25 && Bullet.getX() <= Invader25.getX() + 75 && Bullet.getX() >= Invader25.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader25.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader25.setVisible(false);

                }
                if (Bullet.getY() <= Invader26.getY() + 25 && Bullet.getX() <= Invader26.getX() + 75 && Bullet.getX() >= Invader26.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader26.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader26.setVisible(false);

                }
                if (Bullet.getY() <= Invader27.getY() + 25 && Bullet.getX() <= Invader27.getX() + 75 && Bullet.getX() >= Invader27.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader27.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader27.setVisible(false);

                }
                if (Bullet.getY() <= Invader28.getY() + 25 && Bullet.getX() <= Invader28.getX() + 75 && Bullet.getX() >= Invader28.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader28.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader28.setVisible(false);
                    score[0] += 100;

                }
                if (Bullet.getY() <= Invader29.getY() + 25 && Bullet.getX() <= Invader29.getX() + 75 && Bullet.getX() >= Invader29.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader29.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }

                    Invader29.setVisible(false);
                }
                if (Bullet.getY() <= Invader30.getY() + 25 && Bullet.getX() <= Invader30.getX() + 75 && Bullet.getX() >= Invader30.getX() && Bullet.visibleProperty().getValue())  {
                    if (Invader30.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader30.setVisible(false);

                }
                if (Bullet.getY() <= Invader31.getY() + 25 && Bullet.getX() <= Invader31.getX() + 75 && Bullet.getX() >= Invader31.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader31.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader31.setVisible(false);

                }
                if (Bullet.getY() <= Invader32.getY() + 25 && Bullet.getX() <= Invader32.getX() + 75 && Bullet.getX() >= Invader32.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader32.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader32.setVisible(false);

                }
                if (Bullet.getY() <= Invader33.getY() + 25 && Bullet.getX() <= Invader33.getX() + 75 && Bullet.getX() >= Invader33.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader33.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader33.setVisible(false);

                }
                if (Bullet.getY() <= Invader34.getY() + 25 && Bullet.getX() <= Invader34.getX() + 75 && Bullet.getX() >= Invader34.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader34.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader34.setVisible(false);

                }
                if (Bullet.getY() <= Invader35.getY() + 25 && Bullet.getX() <= Invader35.getX() + 75 && Bullet.getX() >= Invader35.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader35.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader35.setVisible(false);

                }
                if (Bullet.getY() <= Invader36.getY() + 25 && Bullet.getX() <= Invader36.getX() + 75 && Bullet.getX() >= Invader36.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader36.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader36.setVisible(false);

                }
                if (Bullet.getY() <= Invader37.getY() + 25 && Bullet.getX() <= Invader37.getX() + 75 && Bullet.getX() >= Invader37.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader37.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader37.setVisible(false);

                }
                if (Bullet.getY() <= Invader38.getY() + 25 && Bullet.getX() <= Invader38.getX() + 75 && Bullet.getX() >= Invader38.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader38.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader38.setVisible(false);
                    score[0] += 100;

                }
                if (Bullet.getY() <= Invader39.getY() + 25 && Bullet.getX() <= Invader39.getX() + 75 && Bullet.getX() >= Invader39.getX() && Bullet.visibleProperty().getValue()) {
                    if (Invader39.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                    }
                    Invader39.setVisible(false);
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
                Bullet.setX(SpaceShip.getX() + 40);
                Bullet.setY(SpaceShip.getY() + 50);
                shootPlayer.play();
                animationTimer.start();
                shootPlayer.stop();
                shootPlayer.play();
                shootPlayer.stop();

            }
            if (event.getCode() == KeyCode.M) {
                mediaPlayer.play();
            }
            if (event.getCode() == KeyCode.P) {
                mediaPlayer.pause();
            }
            if (event.getCode() == KeyCode.S) {
                System.out.println(score[0]);
            }
            if(event.getCode() == KeyCode.Q){
                shootPlayer.play();
            }
            event.consume();
        };


        //Creating a Group object
        Group group = new Group(Invader0, Invader1, Invader2, Invader3, Invader4, Invader5, Invader6, Invader7,
                Invader8, Invader9, Invader10, Invader11, Bullet, SpaceShip, Invader12, Invader13,
                Invader14, Invader15, Invader16, Invader17, Invader18, Invader19, Invader20, Invader21,
                Invader22, Invader23, Invader24, Invader25, Invader26, Invader27, Invader28, Invader29,
                Invader30, Invader31, Invader32, Invader33, Invader34, Invader35, Invader36, Invader37,
                Invader38, Invader39);
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
