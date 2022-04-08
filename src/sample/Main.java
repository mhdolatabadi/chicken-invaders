package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static java.lang.String.valueOf;


public class Main extends Application {
    Color color = new Color(1, 1, 1, 1);

    @Override
    public void start(Stage primaryStage)  {
        final int[] score = {0};
        final int[] counter = {0};

        Label gameOver = new Label("Game Over");
        gameOver.setLayoutX(400);
        gameOver.setLayoutY(500);
        gameOver.setTextFill(color);
        gameOver.setStyle("-fx-font-size: 200px;" +
                "-fx-font-family: Broadway");
        gameOver.setVisible(false);


        Random random = new Random();
        Media shoot = new Media("/shoot.mp3");
        Media ground = new Media("/spaceinvaders1.mp3");

        MediaPlayer shootPlayer = new MediaPlayer(shoot);
//        MediaPlayer groundPlayer = new MediaPlayer(ground);

        TableView tableView = new TableView();


        Image background = new Image("background.jpg");
        Image sad = new Image("sad.png");
        Image EggB = new Image("EggB.png");
        Image EggR = new Image("EggR.png");
        Image EggY = new Image("EggY.png");
        Image EggG = new Image("EggG.png");
        Image EggP = new Image("EggP.png");


        ImageView EB = new ImageView(EggB);
        EB.setFitWidth(40);
        EB.setFitHeight(40);
        EB.setX(100);
        EB.setY(1000);
        EB.setVisible(false);

        ImageView ER = new ImageView(EggR);
        ER.setFitWidth(40);
        ER.setFitHeight(40);
        ER.setX(200);
        ER.setY(1000);
        ER.setVisible(false);

        ImageView EY = new ImageView(EggY);
        EY.setFitWidth(40);
        EY.setFitHeight(40);
        EY.setX(300);
        EY.setY(1000);
        EY.setVisible(false);

        ImageView EG = new ImageView(EggG);
        EG.setFitWidth(40);
        EG.setFitHeight(40);
        EG.setX(400);
        EG.setY(1000);
        EG.setVisible(false);

        ImageView EP = new ImageView(EggP);
        EP.setFitWidth(40);
        EP.setFitHeight(40);
        EP.setX(500);
        EP.setY(1000);
        EP.setVisible(false);


        ImageView sadView0 = new ImageView(sad);
        sadView0.setFitHeight(100);
        sadView0.setFitWidth(140);
        sadView0.setX(300);
        sadView0.setY(700);
        ImageView sadView1 = new ImageView(sad);
        sadView1.setFitHeight(100);
        sadView1.setFitWidth(140);
        sadView1.setX(600);
        sadView1.setY(700);
        ImageView sadView2 = new ImageView(sad);
        sadView2.setFitHeight(100);
        sadView2.setFitWidth(140);
        sadView2.setX(900);
        sadView2.setY(700);
        ImageView sadView3 = new ImageView(sad);
        sadView3.setFitHeight(100);
        sadView3.setFitWidth(140);
        sadView3.setX(1200);
        sadView3.setY(700);
        ImageView sadView4 = new ImageView(sad);
        sadView4.setFitHeight(100);
        sadView4.setFitWidth(140);
        sadView4.setX(1500);
        sadView4.setY(700);


        Button backButton = new Button();
        backButton.setText("Back");
        backButton.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 38px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        backButton.setLayoutX(1710);
        backButton.setLayoutY(5);
        backButton.setMinSize(100, 25);
        backButton.setTextFill(color);

        Button startNewGameButton = new Button();
        startNewGameButton.setText("Start New Game");
        startNewGameButton.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 38px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        startNewGameButton.setLayoutX(735);
        startNewGameButton.setLayoutY(400);
        startNewGameButton.setTextFill(color);

        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 38px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        exitButton.setLayoutX(860);
        exitButton.setLayoutY(600);
        exitButton.setTextFill(color);

        Button resumeButton = new Button();
        resumeButton.setText("Resume");
        resumeButton.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 38px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        resumeButton.setLayoutX(820);
        resumeButton.setLayoutY(300);
        resumeButton.setTextFill(color);

        Button highScoreButton = new Button();
        highScoreButton.setText("High Scores");
        highScoreButton.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 38px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        highScoreButton.setLayoutX(790);
        highScoreButton.setLayoutY(500);
        highScoreButton.setTextFill(color);

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

        Image image = new Image("spaceShip.png");
        ImageView SpaceShip = new ImageView(image);
        SpaceShip.setX(920);
        SpaceShip.setY(860);
        SpaceShip.setFitHeight(100);
        SpaceShip.setFitWidth(100);
        SpaceShip.setPreserveRatio(true);


        Label title = new Label();
        title.setText("CHICKEN INVADERS");
        title.setLayoutX(475);
        title.setLayoutY(100);
        title.setTextFill(color);
        title.setStyle("-fx-font-size: 100px;" +
                "-fx-font-family: Broadway; -fx-border-color: white;" +
                "-fx-border-radius: 20px");


        Image[] blueChicken = new Image[4];
        for (int i = 0; i < 4; i++)
            blueChicken[i] = new Image("blue" + i + ".png");

        Image[] yellowChicken = new Image[4];
        for (int i = 0; i < 4; i++)
            yellowChicken[i] = new Image("yellow" + i + ".png");

        Image[] greenChicken = new Image[4];
        for (int i = 0; i < 4; i++)
            greenChicken[i] = new Image("green" + i + ".png");

        Image[] redChicken = new Image[4];
        for (int i = 0; i < 4; i++)
            redChicken[i] = new Image("red" + i + ".png");

        Image[] purpleChicken = new Image[4];
        for (int i = 0; i < 4; i++)
            purpleChicken[i] = new Image("purple" + i + ".png");


        ImageView[] invader = new ImageView[60];
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++)
                invader[i + 20 * j] = new ImageView(blueChicken[0]);
            for (int i = 4; i < 8; i++)
                invader[i + 20 * j] = new ImageView(redChicken[0]);
            for (int i = 8; i < 12; i++)
                invader[i + 20 * j] = new ImageView(yellowChicken[0]);
            for (int i = 12; i < 16; i++)
                invader[i + 20 * j] = new ImageView(greenChicken[0]);
            for (int i = 16; i < 20; i++)
                invader[i + 20 * j] = new ImageView(purpleChicken[0]);
        }


        final int[] bigbig = {1};

        Image big1 = new Image("white0.png");
        Image big2 = new Image("white1.png");
        ImageView biginvader = new ImageView(big1);
        biginvader.setX(150);
        biginvader.setY(300);
        biginvader.setFitHeight(400);
        biginvader.setFitWidth(400);
        biginvader.setPreserveRatio(true);

        AnimationTimer bigGraphic = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bigbig[0]++;
                if (bigbig[0] % 50 == 0) {
                    biginvader.setImage(big2);
                }
                if (bigbig[0] % 50 == 25)
                    biginvader.setImage(big1);
            }
        };


        for (ImageView i : invader) {
            i.setFitHeight(80);
            i.setFitWidth(80);
            i.setPreserveRatio(true);
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 20; i += 80) {
                invader[i + (j * 20)].setX(40 + 80 * i);
            }
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 20; i += 80) {
                invader[i + (j * 20)].setY(100 + 80 * j);
            }
        }


        Image bullet = new Image("Bullet.png");
        ImageView Bullet = new ImageView(bullet);
        Bullet.setX(SpaceShip.getX() + 30);
        Bullet.setY(SpaceShip.getY() + 50);
        Bullet.setFitHeight(50);
        Bullet.setFitWidth(50);
        Bullet.setPreserveRatio(true);
        Bullet.setVisible(false);


        final int[] state = new int[60];

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Bullet.setY(Bullet.getY() - 20);
                if (Bullet.getY() < -49) {
                    Bullet.setVisible(false);
                }
                if (Bullet.getY() <= invader[0].getY() + 25 && Bullet.getY() >= invader[0].getY() && Bullet.getX() <= invader[0].getX() + 54 && Bullet.getX() >= invader[0].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[0].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[0].setImage(blueChicken[2]);
                        state[0]++;
                    }
                    if (state[0] == 2 && invader[0].getImage() == blueChicken[2]) {
                        invader[0].setImage(blueChicken[3]);
                        state[0] = 0;
                    }


                }
                if (Bullet.getY() <= invader[1].getY() + 25 && Bullet.getY() >= invader[1].getY() && Bullet.getX() <= invader[1].getX() + 54 && Bullet.getX() >= invader[1].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[1].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[1].setImage(blueChicken[2]);
                        state[1]++;
                    }
                    if (state[1] == 2 && invader[1].getImage() == blueChicken[2]) {
                        invader[1].setImage(blueChicken[3]);
                        state[1] = 0;
                    }

                }
                if (Bullet.getY() <= invader[2].getY() + 25 && Bullet.getY() >= invader[2].getY() && Bullet.getX() <= invader[2].getX() + 54 && Bullet.getX() >= invader[2].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[2].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[2].setImage(blueChicken[2]);
                        state[2]++;
                    }
                    if (state[2] == 2 && invader[2].getImage() == blueChicken[2]) {
                        invader[2].setImage(blueChicken[3]);
                        state[2] = 0;
                    }

                }
                if (Bullet.getY() <= invader[3].getY() + 25 && Bullet.getY() >= invader[3].getY() && Bullet.getX() <= invader[3].getX() + 54 && Bullet.getX() >= invader[3].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[3].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[3].setImage(blueChicken[2]);
                        state[3]++;
                    }
                    if (state[3] == 2 && invader[3].getImage() == blueChicken[2]) {
                        invader[3].setImage(blueChicken[3]);
                        state[3] = 0;
                    }

                }
                if (Bullet.getY() <= invader[4].getY() + 25 && Bullet.getY() >= invader[4].getY() && Bullet.getX() <= invader[4].getX() + 54 && Bullet.getX() >= invader[4].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[4].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[4].setImage(redChicken[2]);
                        state[4]++;
                    }
                    if (state[4] == 2 && invader[4].getImage() == redChicken[2]) {
                        invader[4].setImage(redChicken[3]);
                        state[4] = 0;
                    }

                }
                if (Bullet.getY() <= invader[5].getY() + 25 && Bullet.getY() >= invader[5].getY() && Bullet.getX() <= invader[5].getX() + 54 && Bullet.getX() >= invader[5].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[5].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[5].setImage(redChicken[2]);
                        state[5]++;
                    }
                    if (state[5] == 2 && invader[5].getImage() == redChicken[2]) {
                        invader[5].setImage(redChicken[3]);
                        state[5] = 0;
                    }

                }
                if (Bullet.getY() <= invader[6].getY() + 25 && Bullet.getY() >= invader[6].getY() && Bullet.getX() <= invader[6].getX() + 54 && Bullet.getX() >= invader[6].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[6].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[6].setImage(redChicken[2]);
                        state[6]++;
                    }
                    if (state[6] == 2 && invader[6].getImage() == redChicken[2]) {
                        invader[6].setImage(redChicken[3]);
                        state[6] = 0;
                    }

                }
                if (Bullet.getY() <= invader[7].getY() + 25 && Bullet.getY() >= invader[7].getY() && Bullet.getX() <= invader[7].getX() + 54 && Bullet.getX() >= invader[7].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[7].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[7].setImage(redChicken[2]);
                        state[7]++;
                    }
                    if (state[7] == 2 && invader[7].getImage() == redChicken[2]) {
                        invader[7].setImage(redChicken[3]);
                        state[7] = 0;
                    }

                }
                if (Bullet.getY() <= invader[8].getY() + 25 && Bullet.getY() >= invader[8].getY() && Bullet.getX() <= invader[8].getX() + 54 && Bullet.getX() >= invader[8].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[8].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[8].setImage(yellowChicken[2]);
                        state[8]++;
                    }
                    if (state[8] == 2 && invader[8].getImage() == yellowChicken[2]) {
                        invader[8].setImage(yellowChicken[3]);
                        state[8] = 0;
                    }

                }
                if (Bullet.getY() <= invader[9].getY() + 25 && Bullet.getY() >= invader[9].getY() && Bullet.getX() <= invader[9].getX() + 54 && Bullet.getX() >= invader[9].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[9].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[9].setImage(yellowChicken[2]);
                        state[9]++;
                    }
                    if (state[9] == 2 && invader[9].getImage() == yellowChicken[2]) {
                        invader[9].setImage(yellowChicken[3]);
                        state[9] = 0;
                    }
                }
                if (Bullet.getY() <= invader[10].getY() + 25 && Bullet.getY() >= invader[10].getY() && Bullet.getX() <= invader[10].getX() + 54 && Bullet.getX() >= invader[10].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[10].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[10].setImage(yellowChicken[2]);
                        state[10]++;
                    }
                    if (state[10] == 2 && invader[10].getImage() == yellowChicken[2]) {
                        invader[10].setImage(yellowChicken[3]);
                        state[10] = 0;
                    }

                }
                if (Bullet.getY() <= invader[11].getY() + 25 && Bullet.getY() >= invader[11].getY() && Bullet.getX() <= invader[11].getX() + 54 && Bullet.getX() >= invader[11].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[11].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[11].setImage(yellowChicken[2]);
                        state[11]++;
                    }
                    if (state[11] == 2 && invader[11].getImage() == yellowChicken[2]) {
                        invader[11].setImage(yellowChicken[3]);
                        state[11] = 0;
                    }
                }
                if (Bullet.getY() <= invader[12].getY() + 25 && Bullet.getY() >= invader[12].getY() && Bullet.getX() <= invader[12].getX() + 54 && Bullet.getX() >= invader[12].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[12].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[12].setImage(greenChicken[2]);
                        state[12]++;
                    }
                    if (state[12] == 2 && invader[12].getImage() == greenChicken[2]) {
                        invader[12].setImage(greenChicken[3]);
                        state[12] = 0;
                    }
                }
                if (Bullet.getY() <= invader[13].getY() + 25 && Bullet.getY() >= invader[13].getY() && Bullet.getX() <= invader[13].getX() + 54 && Bullet.getX() >= invader[13].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[13].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[13].setImage(greenChicken[2]);
                        state[13]++;
                    }
                    if (state[13] == 2 && invader[13].getImage() == greenChicken[2]) {
                        invader[13].setImage(greenChicken[3]);
                        state[13] = 0;
                    }
                }
                if (Bullet.getY() <= invader[14].getY() + 25 && Bullet.getY() >= invader[14].getY() && Bullet.getX() <= invader[14].getX() + 54 && Bullet.getX() >= invader[14].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[14].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[14].setImage(greenChicken[2]);
                        state[14]++;
                    }
                    if (state[14] == 2 && invader[14].getImage() == greenChicken[2]) {
                        invader[14].setImage(greenChicken[3]);
                        state[14] = 0;
                    }
                }
                if (Bullet.getY() <= invader[15].getY() + 25 && Bullet.getY() >= invader[15].getY() && Bullet.getX() <= invader[15].getX() + 54 && Bullet.getX() >= invader[15].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[15].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[15].setImage(greenChicken[2]);
                        state[15]++;
                    }
                    if (state[15] == 2 && invader[15].getImage() == greenChicken[2]) {
                        invader[15].setImage(greenChicken[3]);
                        state[15] = 0;
                    }
                }
                if (Bullet.getY() <= invader[16].getY() + 25 && Bullet.getY() >= invader[16].getY() && Bullet.getX() <= invader[16].getX() + 54 && Bullet.getX() >= invader[16].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[16].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[16].setImage(purpleChicken[2]);
                        state[16]++;
                    }
                    if (state[16] == 2 && invader[16].getImage() == purpleChicken[2]) {
                        invader[16].setImage(purpleChicken[3]);
                        state[16] = 0;
                    }

                }
                if (Bullet.getY() <= invader[17].getY() + 25 && Bullet.getY() >= invader[17].getY() && Bullet.getX() <= invader[17].getX() + 54 && Bullet.getX() >= invader[17].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[17].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[17].setImage(purpleChicken[2]);
                        state[17]++;
                    }
                    if (state[17] == 2 && invader[17].getImage() == purpleChicken[2]) {
                        invader[17].setImage(purpleChicken[3]);
                        state[17] = 0;
                    }

                }
                if (Bullet.getY() <= invader[18].getY() + 25 && Bullet.getY() >= invader[18].getY() && Bullet.getX() <= invader[18].getX() + 54 && Bullet.getX() >= invader[18].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[18].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[18].setImage(purpleChicken[2]);
                        state[18]++;
                    }
                    if (state[18] == 2 && invader[18].getImage() == purpleChicken[2]) {
                        invader[18].setImage(purpleChicken[3]);
                        state[18] = 0;
                    }

                }
                if (Bullet.getY() <= invader[19].getY() + 25 && Bullet.getY() >= invader[19].getY() && Bullet.getX() <= invader[19].getX() + 54 && Bullet.getX() >= invader[19].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[19].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[19].setImage(purpleChicken[2]);
                        state[19]++;
                    }
                    if (state[19] == 2 && invader[19].getImage() == purpleChicken[2]) {
                        invader[19].setImage(purpleChicken[3]);
                        state[19] = 0;
                    }

                }
                if (Bullet.getY() <= invader[20].getY() + 25 && Bullet.getY() >= invader[20].getY() && Bullet.getX() <= invader[20].getX() + 54 && Bullet.getX() >= invader[20].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[20].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[20].setImage(blueChicken[2]);
                        state[20]++;
                    }
                    if (state[20] == 2 && invader[20].getImage() == blueChicken[2]) {
                        invader[20].setImage(blueChicken[3]);
                        state[20] = 0;
                    }


                }
                if (Bullet.getY() <= invader[21].getY() + 25 && Bullet.getY() >= invader[21].getY() && Bullet.getX() <= invader[21].getX() + 54 && Bullet.getX() >= invader[21].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[21].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[21].setImage(blueChicken[2]);
                        state[21]++;
                    }
                    if (state[21] == 2 && invader[21].getImage() == blueChicken[2]) {
                        invader[21].setImage(blueChicken[3]);
                        state[21] = 0;
                    }

                }
                if (Bullet.getY() <= invader[22].getY() + 25 && Bullet.getY() >= invader[22].getY() && Bullet.getX() <= invader[22].getX() + 54 && Bullet.getX() >= invader[22].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[22].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[22].setImage(blueChicken[2]);
                        state[22]++;
                    }
                    if (state[22] == 2 && invader[22].getImage() == blueChicken[2]) {
                        invader[22].setImage(blueChicken[3]);
                        state[22] = 0;
                    }

                }
                if (Bullet.getY() <= invader[23].getY() + 25 && Bullet.getY() >= invader[23].getY() && Bullet.getX() <= invader[23].getX() + 54 && Bullet.getX() >= invader[23].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[23].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[23].setImage(blueChicken[2]);
                        state[23]++;
                    }
                    if (state[23] == 2 && invader[23].getImage() == blueChicken[2]) {
                        invader[23].setImage(blueChicken[3]);
                        state[23] = 0;
                    }

                }
                if (Bullet.getY() <= invader[24].getY() + 25 && Bullet.getY() >= invader[24].getY() && Bullet.getX() <= invader[24].getX() + 54 && Bullet.getX() >= invader[24].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[24].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[24].setImage(redChicken[2]);
                        state[24]++;
                    }
                    if (state[24] == 2 && invader[24].getImage() == redChicken[2]) {
                        invader[24].setImage(redChicken[3]);
                        state[24] = 0;
                    }

                }
                if (Bullet.getY() <= invader[25].getY() + 25 && Bullet.getY() >= invader[25].getY() && Bullet.getX() <= invader[25].getX() + 54 && Bullet.getX() >= invader[25].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[25].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[25].setImage(redChicken[2]);
                        state[25]++;
                    }
                    if (state[25] == 2 && invader[25].getImage() == redChicken[2]) {
                        invader[25].setImage(redChicken[3]);
                        state[25] = 0;
                    }

                }
                if (Bullet.getY() <= invader[26].getY() + 25 && Bullet.getY() >= invader[26].getY() && Bullet.getX() <= invader[26].getX() + 54 && Bullet.getX() >= invader[26].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[26].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[26].setImage(redChicken[2]);
                        state[26]++;
                    }
                    if (state[26] == 2 && invader[26].getImage() == redChicken[2]) {
                        invader[26].setImage(redChicken[3]);
                        state[26] = 0;
                    }

                }
                if (Bullet.getY() <= invader[27].getY() + 25 && Bullet.getY() >= invader[27].getY() && Bullet.getX() <= invader[27].getX() + 54 && Bullet.getX() >= invader[27].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[27].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[27].setImage(redChicken[2]);
                        state[27]++;
                    }
                    if (state[27] == 2 && invader[27].getImage() == redChicken[2]) {
                        invader[27].setImage(redChicken[3]);
                        state[27] = 0;
                    }

                }
                if (Bullet.getY() <= invader[28].getY() + 25 && Bullet.getY() >= invader[28].getY() && Bullet.getX() <= invader[28].getX() + 54 && Bullet.getX() >= invader[28].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[28].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[28].setImage(yellowChicken[2]);
                        state[28]++;
                    }
                    if (state[28] == 2 && invader[28].getImage() == yellowChicken[2]) {
                        invader[28].setImage(yellowChicken[3]);
                        state[28] = 0;
                    }

                }
                if (Bullet.getY() <= invader[29].getY() + 25 && Bullet.getY() >= invader[29].getY() && Bullet.getX() <= invader[29].getX() + 54 && Bullet.getX() >= invader[29].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[29].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[29].setImage(yellowChicken[2]);
                        state[29]++;
                    }
                    if (state[29] == 2 && invader[29].getImage() == yellowChicken[2]) {
                        invader[29].setImage(yellowChicken[3]);
                        state[29] = 0;
                    }
                }
                if (Bullet.getY() <= invader[30].getY() + 25 && Bullet.getY() >= invader[30].getY() && Bullet.getX() <= invader[30].getX() + 54 && Bullet.getX() >= invader[30].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[30].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[30].setImage(yellowChicken[2]);
                        state[30]++;
                    }
                    if (state[30] == 2 && invader[30].getImage() == yellowChicken[2]) {
                        invader[30].setImage(yellowChicken[3]);
                        state[30] = 0;
                    }

                }
                if (Bullet.getY() <= invader[31].getY() + 25 && Bullet.getY() >= invader[31].getY() && Bullet.getX() <= invader[31].getX() + 54 && Bullet.getX() >= invader[31].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[31].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[31].setImage(yellowChicken[2]);
                        state[31]++;
                    }
                    if (state[31] == 2 && invader[31].getImage() == yellowChicken[2]) {
                        invader[31].setImage(yellowChicken[3]);
                        state[31] = 0;
                    }
                }
                if (Bullet.getY() <= invader[32].getY() + 25 && Bullet.getY() >= invader[32].getY() && Bullet.getX() <= invader[32].getX() + 54 && Bullet.getX() >= invader[32].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[32].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[32].setImage(greenChicken[2]);
                        state[32]++;
                    }
                    if (state[32] == 2 && invader[32].getImage() == greenChicken[2]) {
                        invader[32].setImage(greenChicken[3]);
                        state[32] = 0;
                    }
                }
                if (Bullet.getY() <= invader[33].getY() + 25 && Bullet.getY() >= invader[33].getY() && Bullet.getX() <= invader[33].getX() + 54 && Bullet.getX() >= invader[33].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[33].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[33].setImage(greenChicken[2]);
                        state[33]++;
                    }
                    if (state[33] == 2 && invader[33].getImage() == greenChicken[2]) {
                        invader[33].setImage(greenChicken[3]);
                        state[33] = 0;
                    }
                }
                if (Bullet.getY() <= invader[34].getY() + 25 && Bullet.getY() >= invader[34].getY() && Bullet.getX() <= invader[34].getX() + 54 && Bullet.getX() >= invader[34].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[34].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[34].setImage(greenChicken[2]);
                        state[34]++;
                    }
                    if (state[34] == 2 && invader[34].getImage() == greenChicken[2]) {
                        invader[34].setImage(greenChicken[3]);
                        state[34] = 0;
                    }
                }
                if (Bullet.getY() <= invader[35].getY() + 25 && Bullet.getY() >= invader[35].getY() && Bullet.getX() <= invader[35].getX() + 54 && Bullet.getX() >= invader[35].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[35].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[35].setImage(greenChicken[2]);
                        state[35]++;
                    }
                    if (state[35] == 2 && invader[35].getImage() == greenChicken[2]) {
                        invader[35].setImage(greenChicken[3]);
                        state[35] = 0;
                    }
                }
                if (Bullet.getY() <= invader[36].getY() + 25 && Bullet.getY() >= invader[36].getY() && Bullet.getX() <= invader[36].getX() + 54 && Bullet.getX() >= invader[36].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[36].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[36].setImage(purpleChicken[2]);
                        state[36]++;
                    }
                    if (state[36] == 2 && invader[36].getImage() == purpleChicken[2]) {
                        invader[36].setImage(purpleChicken[3]);
                        state[36] = 0;
                    }

                }
                if (Bullet.getY() <= invader[37].getY() + 25 && Bullet.getY() >= invader[37].getY() && Bullet.getX() <= invader[37].getX() + 54 && Bullet.getX() >= invader[37].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[37].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[37].setImage(purpleChicken[2]);
                        state[37]++;
                    }
                    if (state[37] == 2 && invader[37].getImage() == purpleChicken[2]) {
                        invader[37].setImage(purpleChicken[3]);
                        state[37] = 0;
                    }

                }
                if (Bullet.getY() <= invader[38].getY() + 25 && Bullet.getY() >= invader[38].getY() && Bullet.getX() <= invader[38].getX() + 54 && Bullet.getX() >= invader[38].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[38].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[38].setImage(purpleChicken[2]);
                        state[38]++;
                    }
                    if (state[38] == 2 && invader[38].getImage() == purpleChicken[2]) {
                        invader[38].setImage(purpleChicken[3]);
                        state[38] = 0;
                    }

                }
                if (Bullet.getY() <= invader[39].getY() + 25 && Bullet.getY() >= invader[39].getY() && Bullet.getX() <= invader[39].getX() + 54 && Bullet.getX() >= invader[39].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[39].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[39].setImage(purpleChicken[2]);
                        state[39]++;
                    }
                    if (state[39] == 2 && invader[39].getImage() == purpleChicken[2]) {
                        invader[39].setImage(purpleChicken[3]);
                        state[39] = 0;
                    }

                }
                if (Bullet.getY() <= invader[40].getY() + 25 && Bullet.getY() >= invader[40].getY() && Bullet.getX() <= invader[40].getX() + 54 && Bullet.getX() >= invader[40].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[40].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[40].setImage(blueChicken[2]);
                        state[40]++;
                    }
                    if (state[40] == 2 && invader[40].getImage() == blueChicken[2]) {
                        invader[40].setImage(blueChicken[3]);
                        state[40] = 0;
                    }


                }
                if (Bullet.getY() <= invader[41].getY() + 25 && Bullet.getY() >= invader[41].getY() && Bullet.getX() <= invader[41].getX() + 54 && Bullet.getX() >= invader[41].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[41].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[41].setImage(blueChicken[2]);
                        state[41]++;
                    }
                    if (state[41] == 2 && invader[41].getImage() == blueChicken[2]) {
                        invader[41].setImage(blueChicken[3]);
                        state[41] = 0;
                    }

                }
                if (Bullet.getY() <= invader[42].getY() + 25 && Bullet.getY() >= invader[42].getY() && Bullet.getX() <= invader[42].getX() + 54 && Bullet.getX() >= invader[42].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[42].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[42].setImage(blueChicken[2]);
                        state[42]++;
                    }
                    if (state[42] == 2 && invader[42].getImage() == blueChicken[2]) {
                        invader[42].setImage(blueChicken[3]);
                        state[42] = 0;
                    }

                }
                if (Bullet.getY() <= invader[43].getY() + 25 && Bullet.getY() >= invader[43].getY() && Bullet.getX() <= invader[43].getX() + 54 && Bullet.getX() >= invader[43].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[43].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[43].setImage(blueChicken[2]);
                        state[43]++;
                    }
                    if (state[43] == 2 && invader[43].getImage() == blueChicken[2]) {
                        invader[43].setImage(blueChicken[3]);
                        state[43] = 0;
                    }

                }
                if (Bullet.getY() <= invader[44].getY() + 25 && Bullet.getY() >= invader[44].getY() && Bullet.getX() <= invader[44].getX() + 54 && Bullet.getX() >= invader[44].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[44].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[44].setImage(redChicken[2]);
                        state[44]++;
                    }
                    if (state[44] == 2 && invader[44].getImage() == redChicken[2]) {
                        invader[44].setImage(redChicken[3]);
                        state[44] = 0;
                    }

                }
                if (Bullet.getY() <= invader[45].getY() + 25 && Bullet.getY() >= invader[45].getY() && Bullet.getX() <= invader[45].getX() + 54 && Bullet.getX() >= invader[45].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[45].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[45].setImage(redChicken[2]);
                        state[45]++;
                    }
                    if (state[45] == 2 && invader[45].getImage() == redChicken[2]) {
                        invader[45].setImage(redChicken[3]);
                        state[45] = 0;
                    }

                }
                if (Bullet.getY() <= invader[46].getY() + 25 && Bullet.getY() >= invader[46].getY() && Bullet.getX() <= invader[46].getX() + 54 && Bullet.getX() >= invader[46].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[46].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[46].setImage(redChicken[2]);
                        state[46]++;
                    }
                    if (state[46] == 2 && invader[46].getImage() == redChicken[2]) {
                        invader[46].setImage(redChicken[3]);
                        state[46] = 0;
                    }

                }
                if (Bullet.getY() <= invader[47].getY() + 25 && Bullet.getY() >= invader[47].getY() && Bullet.getX() <= invader[47].getX() + 54 && Bullet.getX() >= invader[47].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[47].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[47].setImage(redChicken[2]);
                        state[47]++;
                    }
                    if (state[47] == 2 && invader[47].getImage() == redChicken[2]) {
                        invader[47].setImage(redChicken[3]);
                        state[47] = 0;
                    }

                }
                if (Bullet.getY() <= invader[48].getY() + 25 && Bullet.getY() >= invader[48].getY() && Bullet.getX() <= invader[48].getX() + 54 && Bullet.getX() >= invader[48].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[48].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[48].setImage(yellowChicken[2]);
                        state[48]++;
                    }
                    if (state[48] == 2 && invader[48].getImage() == yellowChicken[2]) {
                        invader[48].setImage(yellowChicken[3]);
                        state[48] = 0;
                    }

                }
                if (Bullet.getY() <= invader[49].getY() + 25 && Bullet.getY() >= invader[49].getY() && Bullet.getX() <= invader[49].getX() + 54 && Bullet.getX() >= invader[49].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[49].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[49].setImage(yellowChicken[2]);
                        state[49]++;
                    }
                    if (state[49] == 2 && invader[49].getImage() == yellowChicken[2]) {
                        invader[49].setImage(yellowChicken[3]);
                        state[49] = 0;
                    }
                }
                if (Bullet.getY() <= invader[50].getY() + 25 && Bullet.getY() >= invader[50].getY() && Bullet.getX() <= invader[50].getX() + 54 && Bullet.getX() >= invader[50].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[50].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[50].setImage(yellowChicken[2]);
                        state[50]++;
                    }
                    if (state[50] == 2 && invader[50].getImage() == yellowChicken[2]) {
                        invader[50].setImage(yellowChicken[3]);
                        state[50] = 0;
                    }


                }
                if (Bullet.getY() <= invader[51].getY() + 25 && Bullet.getY() >= invader[51].getY() && Bullet.getX() <= invader[51].getX() + 54 && Bullet.getX() >= invader[51].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[51].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[51].setImage(yellowChicken[2]);
                        state[51]++;
                    }
                    if (state[51] == 2 && invader[51].getImage() == yellowChicken[2]) {
                        invader[51].setImage(yellowChicken[3]);
                        state[51] = 0;
                    }

                }
                if (Bullet.getY() <= invader[52].getY() + 25 && Bullet.getY() >= invader[52].getY() && Bullet.getX() <= invader[52].getX() + 54 && Bullet.getX() >= invader[52].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[52].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[52].setImage(greenChicken[2]);
                        state[52]++;
                    }
                    if (state[52] == 2 && invader[52].getImage() == greenChicken[2]) {
                        invader[52].setImage(greenChicken[3]);
                        state[52] = 0;
                    }

                }
                if (Bullet.getY() <= invader[53].getY() + 25 && Bullet.getY() >= invader[53].getY() && Bullet.getX() <= invader[53].getX() + 54 && Bullet.getX() >= invader[53].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[53].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[53].setImage(greenChicken[2]);
                        state[53]++;
                    }
                    if (state[53] == 2 && invader[53].getImage() == greenChicken[2]) {
                        invader[53].setImage(greenChicken[3]);
                        state[53] = 0;
                    }

                }
                if (Bullet.getY() <= invader[54].getY() + 25 && Bullet.getY() >= invader[54].getY() && Bullet.getX() <= invader[54].getX() + 54 && Bullet.getX() >= invader[54].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[54].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[54].setImage(greenChicken[2]);
                        state[54]++;
                    }
                    if (state[54] == 2 && invader[54].getImage() == greenChicken[2]) {
                        invader[54].setImage(greenChicken[3]);
                        state[54] = 0;
                    }

                }
                if (Bullet.getY() <= invader[55].getY() + 25 && Bullet.getY() >= invader[55].getY() && Bullet.getX() <= invader[55].getX() + 54 && Bullet.getX() >= invader[55].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[55].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[55].setImage(greenChicken[2]);
                        state[55]++;
                    }
                    if (state[55] == 2 && invader[55].getImage() == greenChicken[2]) {
                        invader[55].setImage(greenChicken[3]);
                        state[55] = 0;
                    }

                }
                if (Bullet.getY() <= invader[56].getY() + 25 && Bullet.getY() >= invader[56].getY() && Bullet.getX() <= invader[56].getX() + 54 && Bullet.getX() >= invader[56].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[56].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[56].setImage(purpleChicken[2]);
                        state[56]++;
                    }
                    if (state[56] == 2 && invader[56].getImage() == purpleChicken[2]) {
                        invader[56].setImage(purpleChicken[3]);
                        state[56] = 0;
                    }

                }
                if (Bullet.getY() <= invader[57].getY() + 25 && Bullet.getY() >= invader[57].getY() && Bullet.getX() <= invader[57].getX() + 54 && Bullet.getX() >= invader[57].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[57].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[57].setImage(purpleChicken[2]);
                        state[57]++;
                    }
                    if (state[57] == 2 && invader[57].getImage() == purpleChicken[2]) {
                        invader[57].setImage(purpleChicken[3]);
                        state[57] = 0;
                    }

                }
                if (Bullet.getY() <= invader[58].getY() + 25 && Bullet.getY() >= invader[58].getY() && Bullet.getX() <= invader[58].getX() + 54 && Bullet.getX() >= invader[58].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[58].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[58].setImage(purpleChicken[2]);
                        state[58]++;
                    }
                    if (state[58] == 2 && invader[58].getImage() == purpleChicken[2]) {
                        invader[58].setImage(purpleChicken[3]);
                        state[58] = 0;
                    }

                }
                if (Bullet.getY() <= invader[59].getY() + 25 && Bullet.getY() >= invader[59].getY() && Bullet.getX() <= invader[59].getX() + 54 && Bullet.getX() >= invader[59].getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (invader[59].visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        score[0] += 100;
                        scoreNumber.setText(valueOf(score[0]));
                        invader[59].setImage(purpleChicken[2]);
                        state[59]++;
                    }
                    if (state[59] == 2 && invader[59].getImage() == purpleChicken[2]) {
                        invader[59].setImage(purpleChicken[3]);
                        state[59] = 0;
                    }
                }
                if (Bullet.getY() <= sadView0.getY() + 25 && Bullet.getY() >= sadView0.getY() && Bullet.getX() <= sadView0.getX() + 54 && Bullet.getX() >= sadView0.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (sadView0.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        sadView0.setVisible(false);
                    }
                }
                if (Bullet.getY() <= sadView1.getY() + 25 && Bullet.getY() >= sadView1.getY() && Bullet.getX() <= sadView1.getX() + 54 && Bullet.getX() >= sadView1.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (sadView1.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        sadView1.setVisible(false);
                    }
                }
                if (Bullet.getY() <= sadView2.getY() + 25 && Bullet.getY() >= sadView2.getY() && Bullet.getX() <= sadView2.getX() + 54 && Bullet.getX() >= sadView2.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (sadView2.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        sadView2.setVisible(false);
                    }
                }
                if (Bullet.getY() <= sadView3.getY() + 25 && Bullet.getY() >= sadView3.getY() && Bullet.getX() <= sadView3.getX() + 54 && Bullet.getX() >= sadView3.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (sadView3.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        sadView3.setVisible(false);
                    }
                }
                if (Bullet.getY() <= sadView4.getY() + 25 && Bullet.getY() >= sadView4.getY() && Bullet.getX() <= sadView4.getX() + 54 && Bullet.getX() >= sadView4.getX() - 25 && Bullet.visibleProperty().getValue()) {
                    if (sadView4.visibleProperty().getValue()) {
                        Bullet.setVisible(false);
                        sadView4.setVisible(false);
                    }
                }
            }
        };
        AnimationTimer graphic0 = new AnimationTimer() {
            @Override
            public void handle(long now) {

                counter[0]++;
                if (EB.visibleProperty().getValue()) {
                    EB.setY(EB.getY() + random.nextInt(10) + 3);
                }
                if (ER.visibleProperty().getValue()) {
                    ER.setY(ER.getY() + random.nextInt(10) + 3);
                }
                if (EY.visibleProperty().getValue()) {
                    EY.setY(EY.getY() + random.nextInt(10) + 3);
                }
                if (EG.visibleProperty().getValue()) {
                    EG.setY(EG.getY() + random.nextInt(10) + 3);
                }
                if (EP.visibleProperty().getValue()) {
                    EP.setY(EP.getY() + random.nextInt(10) + 3);
                }
                if (counter[0] % 200 == random.nextInt(200) && EB.getY() > 960) {
                    EB.setX(random.nextInt((int) invader[3].getX() - (int) invader[0].getX()) + invader[0].getX());
                    EB.setY(random.nextInt((int) invader[40].getY() - (int) invader[0].getY()) + invader[0].getY());
                    EB.setVisible(true);
                }
                if (counter[0] % 200 == random.nextInt(200) && ER.getY() > 960) {
                    ER.setX(random.nextInt((int) invader[7].getX() - (int) invader[4].getX()) + invader[4].getX());
                    ER.setY(random.nextInt((int) invader[44].getY() - (int) invader[4].getY()) + invader[4].getY());
                    ER.setVisible(true);
                }
                if (counter[0] % 200 == random.nextInt(200) && EY.getY() > 960) {
                    EY.setX(random.nextInt((int) invader[11].getX() - (int) invader[8].getX()) + invader[8].getX());
                    EY.setY(random.nextInt((int) invader[48].getY() - (int) invader[8].getY()) + invader[8].getY());
                    EY.setVisible(true);

                }
                if (counter[0] % 200 == random.nextInt(200) && EG.getY() > 960) {
                    EG.setX(random.nextInt((int) invader[15].getX() - (int) invader[12].getX()) + invader[12].getX());
                    EG.setY(random.nextInt((int) invader[52].getY() - (int) invader[12].getY()) + invader[12].getY());
                    EG.setVisible(true);

                }
                if (counter[0] % 200 == random.nextInt(200) && EP.getY() > 960) {
                    EP.setX(random.nextInt((int) invader[19].getX() - (int) invader[16].getX()) + invader[16].getX());
                    EP.setY(random.nextInt((int) invader[56].getY() - (int) invader[16].getY()) + invader[16].getY());
                    EP.setVisible(true);

                }

                if (EB.getY() <= sadView0.getY() + 25 && EB.getY() >= sadView0.getY() && EB.getX() <= sadView0.getX() + 54 && EB.getX() >= sadView0.getX() - 25 && EB.visibleProperty().getValue()) {
                    if (sadView0.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView0.setVisible(false);
                    }
                }
                if (EB.getY() <= sadView1.getY() + 25 && EB.getY() >= sadView1.getY() && EB.getX() <= sadView1.getX() + 54 && EB.getX() >= sadView1.getX() - 25 && EB.visibleProperty().getValue()) {
                    if (sadView1.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView1.setVisible(false);
                    }
                }
                if (EB.getY() <= sadView2.getY() + 25 && EB.getY() >= sadView2.getY() && EB.getX() <= sadView2.getX() + 54 && EB.getX() >= sadView2.getX() - 25 && EB.visibleProperty().getValue()) {
                    if (sadView2.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView2.setVisible(false);
                    }
                }
                if (EB.getY() <= sadView3.getY() + 25 && EB.getY() >= sadView3.getY() && EB.getX() <= sadView3.getX() + 54 && EB.getX() >= sadView3.getX() - 25 && EB.visibleProperty().getValue()) {
                    if (sadView3.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView3.setVisible(false);
                    }
                }
                if (EB.getY() <= sadView4.getY() + 25 && EB.getY() >= sadView4.getY() && EB.getX() <= sadView4.getX() + 54 && EB.getX() >= sadView4.getX() - 25 && EB.visibleProperty().getValue()) {
                    if (sadView4.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView4.setVisible(false);
                    }
                }
                if (EB.getY() <= SpaceShip.getY() + 25 && EB.getY() >= SpaceShip.getY() && EB.getX() <= SpaceShip.getX() + 54 && EB.getX() >= SpaceShip.getX() - 25 && EB.visibleProperty().getValue()) {
                    if (SpaceShip.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        SpaceShip.setVisible(false);
                        gameOver.setVisible(true);
                    }
                }
                if (ER.getY() <= sadView0.getY() + 25 && ER.getY() >= sadView0.getY() && ER.getX() <= sadView0.getX() + 54 && ER.getX() >= sadView0.getX() - 25 && ER.visibleProperty().getValue()) {
                    if (sadView0.visibleProperty().getValue()) {
                        ER.setVisible(false);
                        sadView0.setVisible(false);
                    }
                }
                if (ER.getY() <= sadView1.getY() + 25 && ER.getY() >= sadView1.getY() && ER.getX() <= sadView1.getX() + 54 && ER.getX() >= sadView1.getX() - 25 && ER.visibleProperty().getValue()) {
                    if (sadView1.visibleProperty().getValue()) {
                        ER.setVisible(false);
                        sadView1.setVisible(false);
                    }
                }
                if (ER.getY() <= sadView2.getY() + 25 && ER.getY() >= sadView2.getY() && ER.getX() <= sadView2.getX() + 54 && ER.getX() >= sadView2.getX() - 25 && ER.visibleProperty().getValue()) {
                    if (sadView2.visibleProperty().getValue()) {
                        ER.setVisible(false);
                        sadView2.setVisible(false);
                    }
                }
                if (ER.getY() <= sadView3.getY() + 25 && ER.getY() >= sadView3.getY() && ER.getX() <= sadView3.getX() + 54 && ER.getX() >= sadView3.getX() - 25 && ER.visibleProperty().getValue()) {
                    if (sadView3.visibleProperty().getValue()) {
                        ER.setVisible(false);
                        sadView3.setVisible(false);
                    }
                }
                if (ER.getY() <= sadView4.getY() + 25 && ER.getY() >= sadView4.getY() && ER.getX() <= sadView4.getX() + 54 && ER.getX() >= sadView4.getX() - 25 && ER.visibleProperty().getValue()) {
                    if (sadView4.visibleProperty().getValue()) {
                        ER.setVisible(false);
                        sadView4.setVisible(false);
                    }
                }
                if (ER.getY() <= SpaceShip.getY() + 25 && ER.getY() >= SpaceShip.getY() && ER.getX() <= SpaceShip.getX() + 54 && ER.getX() >= SpaceShip.getX() - 25 && ER.visibleProperty().getValue()) {
                    if (SpaceShip.visibleProperty().getValue()) {
                        ER.setVisible(false);
                        SpaceShip.setVisible(false);
                        gameOver.setVisible(true);
                    }
                }
                if (EY.getY() <= sadView0.getY() + 25 && EY.getY() >= sadView0.getY() && EY.getX() <= sadView0.getX() + 54 && EY.getX() >= sadView0.getX() - 25 && EY.visibleProperty().getValue()) {
                    if (sadView0.visibleProperty().getValue()) {
                        EY.setVisible(false);
                        sadView0.setVisible(false);
                    }
                }
                if (EY.getY() <= sadView1.getY() + 25 && EY.getY() >= sadView1.getY() && EY.getX() <= sadView1.getX() + 54 && EY.getX() >= sadView1.getX() - 25 && EY.visibleProperty().getValue()) {
                    if (sadView1.visibleProperty().getValue()) {
                        EY.setVisible(false);
                        sadView1.setVisible(false);
                    }
                }
                if (EY.getY() <= sadView2.getY() + 25 && EY.getY() >= sadView2.getY() && EY.getX() <= sadView2.getX() + 54 && EY.getX() >= sadView2.getX() - 25 && EY.visibleProperty().getValue()) {
                    if (sadView2.visibleProperty().getValue()) {
                        EY.setVisible(false);
                        sadView2.setVisible(false);
                    }
                }
                if (EY.getY() <= sadView3.getY() + 25 && EY.getY() >= sadView3.getY() && EY.getX() <= sadView3.getX() + 54 && EY.getX() >= sadView3.getX() - 25 && EY.visibleProperty().getValue()) {
                    if (sadView3.visibleProperty().getValue()) {
                        EY.setVisible(false);
                        sadView3.setVisible(false);
                    }
                }
                if (EY.getY() <= sadView4.getY() + 25 && EY.getY() >= sadView4.getY() && EY.getX() <= sadView4.getX() + 54 && EY.getX() >= sadView4.getX() - 25 && EY.visibleProperty().getValue()) {
                    if (sadView4.visibleProperty().getValue()) {
                        EY.setVisible(false);
                        sadView4.setVisible(false);
                    }
                }
                if (EY.getY() <= SpaceShip.getY() + 25 && EY.getY() >= SpaceShip.getY() && EY.getX() <= SpaceShip.getX() + 54 && EY.getX() >= SpaceShip.getX() - 25 && EY.visibleProperty().getValue()) {
                    if (SpaceShip.visibleProperty().getValue()) {
                        EY.setVisible(false);
                        SpaceShip.setVisible(false);
                        gameOver.setVisible(true);
                    }
                }
                if (EG.getY() <= sadView0.getY() + 25 && EG.getY() >= sadView0.getY() && EG.getX() <= sadView0.getX() + 54 && EG.getX() >= sadView0.getX() - 25 && EG.visibleProperty().getValue()) {
                    if (sadView0.visibleProperty().getValue()) {
                        EG.setVisible(false);
                        sadView0.setVisible(false);
                    }
                }
                if (EG.getY() <= sadView1.getY() + 25 && EG.getY() >= sadView1.getY() && EG.getX() <= sadView1.getX() + 54 && EG.getX() >= sadView1.getX() - 25 && EG.visibleProperty().getValue()) {
                    if (sadView1.visibleProperty().getValue()) {
                        EG.setVisible(false);
                        sadView1.setVisible(false);
                    }
                }
                if (EG.getY() <= sadView2.getY() + 25 && EG.getY() >= sadView2.getY() && EG.getX() <= sadView2.getX() + 54 && EG.getX() >= sadView2.getX() - 25 && EG.visibleProperty().getValue()) {
                    if (sadView2.visibleProperty().getValue()) {
                        EG.setVisible(false);
                        sadView2.setVisible(false);
                    }
                }
                if (EG.getY() <= sadView3.getY() + 25 && EG.getY() >= sadView3.getY() && EG.getX() <= sadView3.getX() + 54 && EG.getX() >= sadView3.getX() - 25 && EG.visibleProperty().getValue()) {
                    if (sadView3.visibleProperty().getValue()) {
                        EG.setVisible(false);
                        sadView3.setVisible(false);
                    }
                }
                if (EG.getY() <= sadView4.getY() + 25 && EG.getY() >= sadView4.getY() && EG.getX() <= sadView4.getX() + 54 && EG.getX() >= sadView4.getX() - 25 && EG.visibleProperty().getValue()) {
                    if (sadView4.visibleProperty().getValue()) {
                        EG.setVisible(false);
                        sadView4.setVisible(false);
                    }
                }
                if (EG.getY() <= SpaceShip.getY() + 25 && EG.getY() >= SpaceShip.getY() && EG.getX() <= SpaceShip.getX() + 54 && EG.getX() >= SpaceShip.getX() - 25 && EG.visibleProperty().getValue()) {
                    if (SpaceShip.visibleProperty().getValue()) {
                        EG.setVisible(false);
                        SpaceShip.setVisible(false);
                        gameOver.setVisible(true);
                    }
                }
                if (EP.getY() <= sadView0.getY() + 25 && EP.getY() >= sadView0.getY() && EP.getX() <= sadView0.getX() + 54 && EP.getX() >= sadView0.getX() - 25 && EP.visibleProperty().getValue()) {
                    if (sadView0.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView0.setVisible(false);
                    }
                }
                if (EP.getY() <= sadView1.getY() + 25 && EP.getY() >= sadView1.getY() && EP.getX() <= sadView1.getX() + 54 && EP.getX() >= sadView1.getX() - 25 && EP.visibleProperty().getValue()) {
                    if (sadView1.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView1.setVisible(false);
                    }
                }
                if (EP.getY() <= sadView2.getY() + 25 && EP.getY() >= sadView2.getY() && EP.getX() <= sadView2.getX() + 54 && EP.getX() >= sadView2.getX() - 25 && EP.visibleProperty().getValue()) {
                    if (sadView2.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView2.setVisible(false);
                    }
                }
                if (EP.getY() <= sadView3.getY() + 25 && EP.getY() >= sadView3.getY() && EP.getX() <= sadView3.getX() + 54 && EP.getX() >= sadView3.getX() - 25 && EP.visibleProperty().getValue()) {
                    if (sadView3.visibleProperty().getValue()) {
                        EB.setVisible(false);
                        sadView3.setVisible(false);
                    }
                }
                if (EP.getY() <= sadView4.getY() + 25 && EP.getY() >= sadView4.getY() && EP.getX() <= sadView4.getX() + 54 && EP.getX() >= sadView4.getX() - 25 && EP.visibleProperty().getValue()) {
                    if (sadView4.visibleProperty().getValue()) {
                        EP.setVisible(false);
                        sadView4.setVisible(false);
                    }
                }
                if (EP.getY() <= SpaceShip.getY() + 25 && EP.getY() >= SpaceShip.getY() && EP.getX() <= SpaceShip.getX() + 54 && EP.getX() >= SpaceShip.getX() - 25 && EP.visibleProperty().getValue()) {
                    if (SpaceShip.visibleProperty().getValue()) {
                        EP.setVisible(false);
                        SpaceShip.setVisible(false);
                        gameOver.setVisible(true);


                    }
                }

                if (counter[0] % 50 == 0) {
                    if (invader[0].getImage() != blueChicken[2])
                        invader[0].setImage(blueChicken[1]);
                    if (invader[1].getImage() != blueChicken[2])
                        invader[1].setImage(blueChicken[1]);
                    if (invader[2].getImage() != blueChicken[2])
                        invader[2].setImage(blueChicken[1]);
                    if (invader[3].getImage() != blueChicken[2])
                        invader[3].setImage(blueChicken[1]);
                    if (invader[4].getImage() != redChicken[2])
                        invader[4].setImage(redChicken[1]);
                    if (invader[5].getImage() != redChicken[2])
                        invader[5].setImage(redChicken[1]);
                    if (invader[6].getImage() != redChicken[2])
                        invader[6].setImage(redChicken[1]);
                    if (invader[7].getImage() != redChicken[2])
                        invader[7].setImage(redChicken[1]);
                    if (invader[8].getImage() != yellowChicken[2])
                        invader[8].setImage(yellowChicken[1]);
                    if (invader[9].getImage() != yellowChicken[2])
                        invader[9].setImage(yellowChicken[1]);
                    if (invader[10].getImage() != yellowChicken[2])
                        invader[10].setImage(yellowChicken[1]);
                    if (invader[11].getImage() != yellowChicken[2])
                        invader[11].setImage(yellowChicken[1]);
                    if (invader[12].getImage() != greenChicken[2])
                        invader[12].setImage(greenChicken[1]);
                    if (invader[13].getImage() != greenChicken[2])
                        invader[13].setImage(greenChicken[1]);
                    if (invader[14].getImage() != greenChicken[2])
                        invader[14].setImage(greenChicken[1]);
                    if (invader[15].getImage() != greenChicken[2])
                        invader[15].setImage(greenChicken[1]);
                    if (invader[16].getImage() != purpleChicken[2])
                        invader[16].setImage(purpleChicken[1]);
                    if (invader[17].getImage() != purpleChicken[2])
                        invader[17].setImage(purpleChicken[1]);
                    if (invader[18].getImage() != purpleChicken[2])
                        invader[18].setImage(purpleChicken[1]);
                    if (invader[19].getImage() != purpleChicken[2])
                        invader[19].setImage(purpleChicken[1]);
                    if (invader[20].getImage() != blueChicken[2])
                        invader[20].setImage(blueChicken[1]);
                    if (invader[21].getImage() != blueChicken[2])
                        invader[21].setImage(blueChicken[1]);
                    if (invader[22].getImage() != blueChicken[2])
                        invader[22].setImage(blueChicken[1]);
                    if (invader[23].getImage() != blueChicken[2])
                        invader[23].setImage(blueChicken[1]);
                    if (invader[24].getImage() != redChicken[2])
                        invader[24].setImage(redChicken[1]);
                    if (invader[25].getImage() != redChicken[2])
                        invader[25].setImage(redChicken[1]);
                    if (invader[26].getImage() != redChicken[2])
                        invader[26].setImage(redChicken[1]);
                    if (invader[27].getImage() != redChicken[2])
                        invader[27].setImage(redChicken[1]);
                    if (invader[28].getImage() != yellowChicken[2])
                        invader[28].setImage(yellowChicken[1]);
                    if (invader[29].getImage() != yellowChicken[2])
                        invader[29].setImage(yellowChicken[1]);
                    if (invader[30].getImage() != yellowChicken[2])
                        invader[30].setImage(yellowChicken[1]);
                    if (invader[31].getImage() != yellowChicken[2])
                        invader[31].setImage(yellowChicken[1]);
                    if (invader[32].getImage() != greenChicken[2])
                        invader[32].setImage(greenChicken[1]);
                    if (invader[33].getImage() != greenChicken[2])
                        invader[33].setImage(greenChicken[1]);
                    if (invader[34].getImage() != greenChicken[2])
                        invader[34].setImage(greenChicken[1]);
                    if (invader[35].getImage() != greenChicken[2])
                        invader[35].setImage(greenChicken[1]);
                    if (invader[36].getImage() != purpleChicken[2])
                        invader[36].setImage(purpleChicken[1]);
                    if (invader[37].getImage() != purpleChicken[2])
                        invader[37].setImage(purpleChicken[1]);
                    if (invader[38].getImage() != purpleChicken[2])
                        invader[38].setImage(purpleChicken[1]);
                    if (invader[39].getImage() != purpleChicken[2])
                        invader[39].setImage(purpleChicken[1]);
                    if (invader[40].getImage() != blueChicken[2])
                        invader[40].setImage(blueChicken[1]);
                    if (invader[41].getImage() != blueChicken[2])
                        invader[41].setImage(blueChicken[1]);
                    if (invader[42].getImage() != blueChicken[2])
                        invader[42].setImage(blueChicken[1]);
                    if (invader[43].getImage() != blueChicken[2])
                        invader[43].setImage(blueChicken[1]);
                    if (invader[44].getImage() != redChicken[2])
                        invader[44].setImage(redChicken[1]);
                    if (invader[45].getImage() != redChicken[2])
                        invader[45].setImage(redChicken[1]);
                    if (invader[46].getImage() != redChicken[2])
                        invader[46].setImage(redChicken[1]);
                    if (invader[47].getImage() != redChicken[2])
                        invader[47].setImage(redChicken[1]);
                    if (invader[48].getImage() != yellowChicken[2])
                        invader[48].setImage(yellowChicken[1]);
                    if (invader[49].getImage() != yellowChicken[2])
                        invader[49].setImage(yellowChicken[1]);
                    if (invader[50].getImage() != yellowChicken[2])
                        invader[50].setImage(yellowChicken[1]);
                    if (invader[51].getImage() != yellowChicken[2])
                        invader[51].setImage(yellowChicken[1]);
                    if (invader[52].getImage() != greenChicken[2])
                        invader[52].setImage(greenChicken[1]);
                    if (invader[53].getImage() != greenChicken[2])
                        invader[53].setImage(greenChicken[1]);
                    if (invader[54].getImage() != greenChicken[2])
                        invader[54].setImage(greenChicken[1]);
                    if (invader[55].getImage() != greenChicken[2])
                        invader[55].setImage(greenChicken[1]);
                    if (invader[56].getImage() != purpleChicken[2])
                        invader[56].setImage(purpleChicken[1]);
                    if (invader[57].getImage() != purpleChicken[2])
                        invader[57].setImage(purpleChicken[1]);
                    if (invader[58].getImage() != purpleChicken[2])
                        invader[58].setImage(purpleChicken[1]);
                    if (invader[59].getImage() != purpleChicken[2])
                        invader[59].setImage(purpleChicken[1]);

                }
                if (counter[0] % 50 == 25) {
                    if (invader[0].getImage() != blueChicken[2])
                        invader[0].setImage(blueChicken[0]);
                    if (invader[1].getImage() != blueChicken[2])
                        invader[1].setImage(blueChicken[0]);
                    if (invader[2].getImage() != blueChicken[2])
                        invader[2].setImage(blueChicken[0]);
                    if (invader[3].getImage() != blueChicken[2])
                        invader[3].setImage(blueChicken[0]);
                    if (invader[4].getImage() != redChicken[2])
                        invader[4].setImage(redChicken[0]);
                    if (invader[5].getImage() != redChicken[2])
                        invader[5].setImage(redChicken[0]);
                    if (invader[6].getImage() != redChicken[2])
                        invader[6].setImage(redChicken[0]);
                    if (invader[7].getImage() != redChicken[2])
                        invader[7].setImage(redChicken[0]);
                    if (invader[8].getImage() != yellowChicken[2])
                        invader[8].setImage(yellowChicken[0]);
                    if (invader[9].getImage() != yellowChicken[2])
                        invader[9].setImage(yellowChicken[0]);
                    if (invader[10].getImage() != yellowChicken[2])
                        invader[10].setImage(yellowChicken[0]);
                    if (invader[11].getImage() != yellowChicken[2])
                        invader[11].setImage(yellowChicken[0]);
                    if (invader[12].getImage() != greenChicken[2])
                        invader[12].setImage(greenChicken[0]);
                    if (invader[13].getImage() != greenChicken[2])
                        invader[13].setImage(greenChicken[0]);
                    if (invader[14].getImage() != greenChicken[2])
                        invader[14].setImage(greenChicken[0]);
                    if (invader[15].getImage() != greenChicken[2])
                        invader[15].setImage(greenChicken[0]);
                    if (invader[16].getImage() != purpleChicken[2])
                        invader[16].setImage(purpleChicken[0]);
                    if (invader[17].getImage() != purpleChicken[2])
                        invader[17].setImage(purpleChicken[0]);
                    if (invader[18].getImage() != purpleChicken[2])
                        invader[18].setImage(purpleChicken[0]);
                    if (invader[19].getImage() != purpleChicken[2])
                        invader[19].setImage(purpleChicken[0]);
                    if (invader[20].getImage() != blueChicken[2])
                        invader[20].setImage(blueChicken[0]);
                    if (invader[21].getImage() != blueChicken[2])
                        invader[21].setImage(blueChicken[0]);
                    if (invader[22].getImage() != blueChicken[2])
                        invader[22].setImage(blueChicken[0]);
                    if (invader[23].getImage() != blueChicken[2])
                        invader[23].setImage(blueChicken[0]);
                    if (invader[24].getImage() != redChicken[2])
                        invader[24].setImage(redChicken[0]);
                    if (invader[25].getImage() != redChicken[2])
                        invader[25].setImage(redChicken[0]);
                    if (invader[26].getImage() != redChicken[2])
                        invader[26].setImage(redChicken[0]);
                    if (invader[27].getImage() != redChicken[2])
                        invader[27].setImage(redChicken[0]);
                    if (invader[28].getImage() != yellowChicken[2])
                        invader[28].setImage(yellowChicken[0]);
                    if (invader[29].getImage() != yellowChicken[2])
                        invader[29].setImage(yellowChicken[0]);
                    if (invader[30].getImage() != yellowChicken[2])
                        invader[30].setImage(yellowChicken[0]);
                    if (invader[31].getImage() != yellowChicken[2])
                        invader[31].setImage(yellowChicken[0]);
                    if (invader[32].getImage() != greenChicken[2])
                        invader[32].setImage(greenChicken[0]);
                    if (invader[33].getImage() != greenChicken[2])
                        invader[33].setImage(greenChicken[0]);
                    if (invader[34].getImage() != greenChicken[2])
                        invader[34].setImage(greenChicken[0]);
                    if (invader[35].getImage() != greenChicken[2])
                        invader[35].setImage(greenChicken[0]);
                    if (invader[36].getImage() != purpleChicken[2])
                        invader[36].setImage(purpleChicken[0]);
                    if (invader[37].getImage() != purpleChicken[2])
                        invader[37].setImage(purpleChicken[0]);
                    if (invader[38].getImage() != purpleChicken[2])
                        invader[38].setImage(purpleChicken[0]);
                    if (invader[39].getImage() != purpleChicken[2])
                        invader[39].setImage(purpleChicken[0]);
                    if (invader[40].getImage() != blueChicken[2])
                        invader[40].setImage(blueChicken[0]);
                    if (invader[41].getImage() != blueChicken[2])
                        invader[41].setImage(blueChicken[0]);
                    if (invader[42].getImage() != blueChicken[2])
                        invader[42].setImage(blueChicken[0]);
                    if (invader[43].getImage() != blueChicken[2])
                        invader[43].setImage(blueChicken[0]);
                    if (invader[44].getImage() != redChicken[2])
                        invader[44].setImage(redChicken[0]);
                    if (invader[45].getImage() != redChicken[2])
                        invader[45].setImage(redChicken[0]);
                    if (invader[46].getImage() != redChicken[2])
                        invader[46].setImage(redChicken[0]);
                    if (invader[47].getImage() != redChicken[2])
                        invader[47].setImage(redChicken[0]);
                    if (invader[48].getImage() != yellowChicken[2])
                        invader[48].setImage(yellowChicken[0]);
                    if (invader[49].getImage() != yellowChicken[2])
                        invader[49].setImage(yellowChicken[0]);
                    if (invader[50].getImage() != yellowChicken[2])
                        invader[50].setImage(yellowChicken[0]);
                    if (invader[51].getImage() != yellowChicken[2])
                        invader[51].setImage(yellowChicken[0]);
                    if (invader[52].getImage() != greenChicken[2])
                        invader[52].setImage(greenChicken[0]);
                    if (invader[53].getImage() != greenChicken[2])
                        invader[53].setImage(greenChicken[0]);
                    if (invader[54].getImage() != greenChicken[2])
                        invader[54].setImage(greenChicken[0]);
                    if (invader[55].getImage() != greenChicken[2])
                        invader[55].setImage(greenChicken[0]);
                    if (invader[56].getImage() != purpleChicken[2])
                        invader[56].setImage(purpleChicken[0]);
                    if (invader[57].getImage() != purpleChicken[2])
                        invader[57].setImage(purpleChicken[0]);
                    if (invader[58].getImage() != purpleChicken[2])
                        invader[58].setImage(purpleChicken[0]);
                    if (invader[59].getImage() != purpleChicken[2])
                        invader[59].setImage(purpleChicken[0]);
                }

                if (counter[0] % 400 == 0)
                    for (int i = 0; i < 60; i++)
                        invader[i].setX(invader[i].getX() - 50);

                if (counter[0] % 400 == 200)
                    for (int i = 0; i < 60; i++)
                        invader[i].setX(invader[i].getX() + 50);

                if (counter[0] % 1000 == 800)
                    for (int i = 0; i < 60; i++)
                        invader[i].setY(invader[i].getY() + 50);

                if (counter[0] % 10000 == 0) {
                    for (int i = 0; i < 20; i++)
                        invader[i].setVisible(true);

                    for (int i = 0; i < 20; i += 80)
                        invader[i].setX(40 + 80 * i);

                    for (int i = 0; i < 20; i += 80)
                        invader[i].setY(100);


                }
                if (invader[0].getImage() == blueChicken[3]) {
                    invader[0].setVisible(false);
                }
                if (invader[1].getImage() == blueChicken[3]) {
                    invader[1].setVisible(false);
                }
                if (invader[2].getImage() == blueChicken[3]) {
                    invader[2].setVisible(false);
                }
                if (invader[3].getImage() == blueChicken[3]) {
                    invader[3].setVisible(false);
                }
                if (invader[4].getImage() == redChicken[3]) {
                    invader[4].setVisible(false);
                }
                if (invader[5].getImage() == redChicken[3]) {
                    invader[5].setVisible(false);
                }
                if (invader[6].getImage() == redChicken[3]) {
                    invader[6].setVisible(false);
                }
                if (invader[7].getImage() == redChicken[3]) {
                    invader[7].setVisible(false);
                }
                if (invader[8].getImage() == yellowChicken[3]) {
                    invader[8].setVisible(false);
                }
                if (invader[9].getImage() == yellowChicken[3]) {
                    invader[9].setVisible(false);
                }
                if (invader[10].getImage() == yellowChicken[3]) {
                    invader[10].setVisible(false);
                }
                if (invader[11].getImage() == yellowChicken[3]) {
                    invader[11].setVisible(false);
                }
                if (invader[12].getImage() == greenChicken[3]) {
                    invader[12].setVisible(false);
                }
                if (invader[13].getImage() == greenChicken[3]) {
                    invader[13].setVisible(false);
                }
                if (invader[14].getImage() == greenChicken[3]) {
                    invader[14].setVisible(false);
                }
                if (invader[15].getImage() == greenChicken[3]) {
                    invader[15].setVisible(false);
                }
                if (invader[16].getImage() == purpleChicken[3]) {
                    invader[16].setVisible(false);
                }
                if (invader[17].getImage() == purpleChicken[3]) {
                    invader[17].setVisible(false);
                }
                if (invader[18].getImage() == purpleChicken[3]) {
                    invader[18].setVisible(false);
                }
                if (invader[19].getImage() == purpleChicken[3]) {
                    invader[19].setVisible(false);
                }
                if (invader[20].getImage() == blueChicken[3]) {
                    invader[20].setVisible(false);
                }
                if (invader[21].getImage() == blueChicken[3]) {
                    invader[21].setVisible(false);
                }
                if (invader[22].getImage() == blueChicken[3]) {
                    invader[22].setVisible(false);
                }
                if (invader[23].getImage() == blueChicken[3]) {
                    invader[23].setVisible(false);
                }
                if (invader[24].getImage() == redChicken[3]) {
                    invader[24].setVisible(false);
                }
                if (invader[25].getImage() == redChicken[3]) {
                    invader[25].setVisible(false);
                }
                if (invader[26].getImage() == redChicken[3]) {
                    invader[26].setVisible(false);
                }
                if (invader[27].getImage() == redChicken[3]) {
                    invader[27].setVisible(false);
                }
                if (invader[28].getImage() == yellowChicken[3]) {
                    invader[28].setVisible(false);
                }
                if (invader[29].getImage() == yellowChicken[3]) {
                    invader[29].setVisible(false);
                }
                if (invader[30].getImage() == yellowChicken[3]) {
                    invader[30].setVisible(false);
                }
                if (invader[31].getImage() == yellowChicken[3]) {
                    invader[31].setVisible(false);
                }
                if (invader[32].getImage() == greenChicken[3]) {
                    invader[32].setVisible(false);
                }
                if (invader[33].getImage() == greenChicken[3]) {
                    invader[33].setVisible(false);
                }
                if (invader[34].getImage() == greenChicken[3]) {
                    invader[34].setVisible(false);
                }
                if (invader[35].getImage() == greenChicken[3]) {
                    invader[35].setVisible(false);
                }
                if (invader[36].getImage() == purpleChicken[3]) {
                    invader[36].setVisible(false);
                }
                if (invader[37].getImage() == purpleChicken[3]) {
                    invader[37].setVisible(false);
                }
                if (invader[38].getImage() == purpleChicken[3]) {
                    invader[38].setVisible(false);
                }
                if (invader[39].getImage() == purpleChicken[3]) {
                    invader[39].setVisible(false);
                }
                if (invader[40].getImage() == blueChicken[3]) {
                    invader[40].setVisible(false);
                }
                if (invader[41].getImage() == blueChicken[3]) {
                    invader[41].setVisible(false);
                }
                if (invader[42].getImage() == blueChicken[3]) {
                    invader[42].setVisible(false);
                }
                if (invader[43].getImage() == blueChicken[3]) {
                    invader[43].setVisible(false);
                }
                if (invader[44].getImage() == redChicken[3]) {
                    invader[44].setVisible(false);
                }
                if (invader[45].getImage() == redChicken[3]) {
                    invader[45].setVisible(false);
                }
                if (invader[46].getImage() == redChicken[3]) {
                    invader[46].setVisible(false);
                }
                if (invader[47].getImage() == redChicken[3]) {
                    invader[47].setVisible(false);
                }
                if (invader[48].getImage() == yellowChicken[3]) {
                    invader[48].setVisible(false);
                }
                if (invader[49].getImage() == yellowChicken[3]) {
                    invader[49].setVisible(false);
                }
                if (invader[50].getImage() == yellowChicken[3]) {
                    invader[50].setVisible(false);
                }
                if (invader[51].getImage() == yellowChicken[3]) {
                    invader[51].setVisible(false);
                }
                if (invader[52].getImage() == greenChicken[3]) {
                    invader[52].setVisible(false);
                }
                if (invader[53].getImage() == greenChicken[3]) {
                    invader[53].setVisible(false);
                }
                if (invader[54].getImage() == greenChicken[3]) {
                    invader[54].setVisible(false);
                }
                if (invader[55].getImage() == greenChicken[3]) {
                    invader[55].setVisible(false);
                }
                if (invader[56].getImage() == purpleChicken[3]) {
                    invader[56].setVisible(false);
                }
                if (invader[57].getImage() == purpleChicken[3]) {
                    invader[57].setVisible(false);
                }
                if (invader[58].getImage() == purpleChicken[3]) {
                    invader[58].setVisible(false);
                }

                if (invader[59].getImage() == purpleChicken[3]) {
                    invader[59].setVisible(false);
                }

            }
        };
        Image login = new Image("account.png");
        ImageView loginView = new ImageView(login);
        loginView.setFitWidth(50);
        loginView.setFitHeight(50);
        Image speaker = new Image("speaker.png");
        ImageView speakerView = new ImageView(speaker);
        speakerView.setFitWidth(50);
        speakerView.setFitHeight(50);
        Image account = new Image("login.png");
        ImageView accountView = new ImageView(account);
        accountView.setFitWidth(50);
        accountView.setFitHeight(50);
        Image password = new Image("pass.png");
        ImageView passwordView = new ImageView(password);
        passwordView.setFitWidth(50);
        passwordView.setFitHeight(30);
        MenuItem createAccount = new MenuItem("Login");
        createAccount.setGraphic(accountView);
        createAccount.setStyle("-fx-skin-color: none");
        MenuItem changeUsername = new MenuItem("Change Password");
        changeUsername.setGraphic(passwordView);
        Menu loginMenu = new Menu("Acoount");
        loginMenu.setStyle("-fx-text-fill: white;");
        loginMenu.setGraphic(loginView);
        loginMenu.getItems().add(createAccount);
        loginMenu.getItems().add(changeUsername);
        Menu soundMenu = new Menu("Sound");
        soundMenu.setGraphic(speakerView);
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 30px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-text-fill: white");
        menuBar.getMenus().add(loginMenu);
        menuBar.getMenus().add(soundMenu);
        VBox vBoxLogin = new VBox(menuBar);


        Group game = new Group(bgGame, invader[0], invader[1], invader[2], invader[3], invader[4], invader[5], invader[6], invader[7],
                invader[8], invader[9], invader[10], invader[11], SpaceShip, invader[12], invader[13],
                invader[14], invader[15], invader[16], invader[17], invader[18], invader[19], invader[20], invader[21],
                invader[22], invader[23], invader[24], invader[25], invader[26], invader[27], invader[28], invader[29],
                invader[30], invader[31], invader[32], invader[33], invader[34], invader[35], invader[36], invader[37],
                invader[38], invader[39], invader[40], invader[41], invader[42], invader[43], invader[44], invader[45], invader[46], invader[47],
                invader[48], invader[49], invader[50], invader[51], invader[52], invader[53], invader[54], invader[55], invader[56], invader[57],
                invader[58], invader[59], scoreNumber, scoreText, messageText, backButton, Bullet, sadView0,
                sadView1, sadView2, sadView3, sadView4, EB, ER, EG, EY, EP, gameOver);


        Group menu = new Group(bgStart, startNewGameButton, exitButton, resumeButton, highScoreButton, title,
                biginvader, vBoxLogin);
        Group highs = new Group();

        //groundPlayer.setAutoPlay(true);

        Scene gameScene = new Scene(game, 1880, 960);
        gameScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styleSheet.css")).toExternalForm());


        Scene menuScene = new Scene(menu, 1880, 960);


        Scene scene = new Scene(new Group());

        TableView table = new TableView();

        final Label label = new Label("High Scores");
        label.setFont(new Font("Boardway", 20));

        table.setEditable(true);

        TableColumn userCol = new TableColumn("User");
        userCol.setMinWidth(100);
        userCol.setCellValueFactory(new PropertyValueFactory<String, String>("user"));

        TableColumn scoreCol = new TableColumn("Score");
        scoreCol.setMinWidth(100);
        scoreCol.setCellValueFactory(new PropertyValueFactory<String, String>("score"));
        table.getColumns().addAll(userCol, scoreCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        highScoreButton.setOnMouseClicked(event -> {
            primaryStage.setScene(scene);
        });

        ////////////////////////////////////////////////


        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.NO, ButtonType.YES);
        exitAlert.setHeaderText("We will lose you...");
        exitAlert.setContentText("Are you sure?");
        exitAlert.setTitle("exit");
        exitAlert.setResult(exitAlert.getResult());
        DialogPane dialogPane = exitAlert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styleSheet.css")).toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        SpaceShip.requestFocus();


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
            if (event.getCode() == KeyCode.SPACE) {

                Bullet.setVisible(true);
                Bullet.setX(SpaceShip.getX() + 25);
                Bullet.setY(SpaceShip.getY() + 50);
                animationTimer.start();
                shootPlayer.play();
                shootPlayer.stop();
                shootPlayer.play();
                shootPlayer.stop();
            }
            if (event.getCode() == KeyCode.S) {
                System.out.println(score[0]);
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                graphic0.stop();
                primaryStage.setScene(menuScene);
            }
            event.consume();
        };
        gameScene.setOnKeyPressed(keyListener);
        menuScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                exitAlert.showAndWait();
                if (exitAlert.getResult() == ButtonType.YES) {
                    primaryStage.close();
                }
            }
        });

        primaryStage.setTitle("Spaceinvaders");
        primaryStage.getIcons().add(new Image("blue0.png"));
        primaryStage.setScene(menuScene);
        primaryStage.show();


        startNewGameButton.setOnMouseClicked(event -> {
            for (ImageView i : invader) {
                i.setVisible(true);
            }

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 20; i += 80) {
                    invader[i + (j * 20)].setX(40 + 80 * i);
                }
            }

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 20; i += 80) {
                    invader[i + (j * 20)].setY(100 + 80 * j);
                }
            }
            SpaceShip.setVisible(true);
            gameOver.setVisible(false);
            sadView0.setVisible(true);
            sadView1.setVisible(true);
            sadView2.setVisible(true);
            sadView3.setVisible(true);
            sadView4.setVisible(true);
            primaryStage.setScene(gameScene);
            graphic0.start();
            SpaceShip.requestFocus();
        });
        resumeButton.setOnMouseClicked(event -> {
            primaryStage.setScene(gameScene);
            graphic0.start();
            SpaceShip.requestFocus();
        });
        resumeButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(gameScene);
                graphic0.start();
                SpaceShip.requestFocus();
            }
        });
        exitButton.setOnMouseClicked(event -> {
            exitAlert.showAndWait();
            if (exitAlert.getResult() == ButtonType.YES) {
                primaryStage.close();
            }
        });
        backButton.setOnMouseClicked(event -> {
            graphic0.stop();
            primaryStage.setScene(menuScene);
        });


        startNewGameButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                for (ImageView i : invader)
                    i.setVisible(true);

                for (int j = 0; j < 3; j++)
                    for (int i = 0; i < 20; i += 80)
                        invader[i + (j * 20)].setX(40 + 80 * i);

                for (int j = 0; j < 3; j++)
                    for (int i = 0; i < 20; i += 80)
                        invader[i + (j * 20)].setY(100 + 80 * j);

                SpaceShip.setVisible(true);
                gameOver.setVisible(false);
                primaryStage.setScene(gameScene);
                graphic0.start();
                SpaceShip.requestFocus();
            }
        });
        exitButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                exitAlert.showAndWait();
                if (exitAlert.getResult() == ButtonType.YES) {
                    primaryStage.close();
                }
            }
        });
        bigGraphic.start();
        if (gameOver.visibleProperty().getValue()) {
            graphic0.stop();
            animationTimer.stop();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }


}