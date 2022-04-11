package edu.sharif.chickeninvaders;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.animation.AnimationTimer;
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

import java.util.Objects;
import java.util.Random;

import static java.lang.String.valueOf;


public class ChickenInvaders extends Application {
    Color color = new Color(1, 1, 1, 1);
    final double SCENE_HEIGHT = 1020;
    final double SCENE_WIDTH = 1840;


    public String fetchResource(String path) {
        return Objects.requireNonNull(getClass().getResource(path)).toString();
    }

    @Override
    public void start(Stage primaryStage) {
        final int[] score = {0};

        Random random = new Random();
        Media shotSound = new Media(fetchResource("shoot.wav"));
        Media backgroundMusic = new Media(fetchResource("spaceInvader.wav"));

        MediaPlayer shotSoundPlayer = new MediaPlayer(shotSound);
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(backgroundMusic);

        Image backgroundImage = new Image(fetchResource("background.jpg"));
        Image nestImage = new Image(fetchResource("nest.png"));
        Image blueEggImage = new Image(fetchResource("blueEgg.png"));

        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setX(0);
        backgroundImageView.setY(0);
        backgroundImageView.setFitHeight(SCENE_HEIGHT);
        backgroundImageView.setFitWidth(SCENE_WIDTH);

        ImageView bgStart = new ImageView(backgroundImage);
        bgStart.setX(0);
        bgStart.setY(0);
        bgStart.setFitHeight(SCENE_HEIGHT);
        bgStart.setFitWidth(SCENE_WIDTH);


        ImageView blueEgg = new ImageView(blueEggImage);
        blueEgg.setFitWidth(40);
        blueEgg.setFitHeight(40);
        blueEgg.setX(100);
        blueEgg.setY(1000);
        blueEgg.setVisible(false);


        ImageView[] nests = new ImageView[5];
        for (int i = 0; i < nests.length; i++) {
            nests[i] = new ImageView(nestImage);
            nests[i].setFitHeight(100);
            nests[i].setFitWidth(140);
            nests[i].setX(300 * (1 + i));
            nests[i].setY(700);
        }


        Button backButton = new Button();
        backButton.setText("Back");
        backButton.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 38px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
        backButton.setLayoutX(1650);
        backButton.setLayoutY(10);
        backButton.setMinSize(50, 15);
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
        scoreNumber.setStyle("-fx-font-size: 38px;" + "-fx-font-family: Broadway");


        Label scoreText = new Label();
        scoreText.setText("Score");
        scoreText.setLayoutX(25);
        scoreText.setLayoutY(20);
        scoreText.setTextFill(color);
        scoreText.setStyle("-fx-font-size: 38px;" + "-fx-font-family: Broadway");

        Label messageText = new Label();
        messageText.setText("Press ctrl to use your gift");
        messageText.setLayoutX(SCENE_WIDTH / 2);
        messageText.setLayoutY(20);
        messageText.setTextFill(color);
        messageText.setStyle("-fx-font-size: 25px;" + "-fx-font-family: Broadway");



        Image spaceShipImage = new Image(fetchResource("spaceShip.png"));
        ImageView spaceShip = new ImageView(spaceShipImage);
        spaceShip.setX(SCENE_WIDTH / 2);
        spaceShip.setY(SCENE_HEIGHT - 150);
        spaceShip.setFitHeight(100);
        spaceShip.setFitWidth(100);



        Label title = new Label();
        title.setText("CHICKEN INVADERS");
        title.setLayoutX(475);
        title.setLayoutY(100);
        title.setTextFill(color);
        title.setStyle("-fx-font-size: 100px;" + "-fx-font-family: Broadway; -fx-border-color: white;" + "-fx-border-radius: 20px");


        Image[] blueChicken = new Image[4];
        for (int i = 0; i < 4; i++)
            blueChicken[i] = new Image(fetchResource("blue" + i + ".png"));


        ImageView[] invaders = new ImageView[60];
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 20; i++)
                invaders[i + 20 * j] = new ImageView(blueChicken[0]);
        }


        final int[] bigwig = {1};

        Image bigChickenImageFirstState = new Image(fetchResource("white0.png"));
        Image bigChickenImageSecondState = new Image(fetchResource("white1.png"));
        ImageView bigChicken = new ImageView(bigChickenImageFirstState);
        bigChicken.setX(150);
        bigChicken.setY(300);
        bigChicken.setFitHeight(400);
        bigChicken.setFitWidth(400);
        bigChicken.setPreserveRatio(true);

        AnimationTimer bigGraphic = new AnimationTimer() {
            int timer = 0;
            @Override
            public void handle(long now) {
                if(timer % 25 == 0)
                    bigChicken.setImage(bigChicken.getImage() == bigChickenImageFirstState ? bigChickenImageSecondState : bigChickenImageFirstState);
                timer++;
            }
        };


        for (ImageView i : invaders) {
            i.setFitHeight(80);
            i.setFitWidth(80);
            i.setPreserveRatio(true);
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 20; i++) {
                invaders[i + (j * 20)].setX(40 + (40 * j) + (80 * i));
                invaders[i + (j * 20)].setY(100 + (80 * j));
            }
        }


        Image bulletImage = new Image(fetchResource("bullet.png"));
        ImageView bullet = new ImageView(bulletImage);
        bullet.setFitHeight(50);
        bullet.setFitWidth(50);
        bullet.setPreserveRatio(true);
        bullet.setVisible(false);


        final int[] chickensState = new int[60];


        AnimationTimer graphic0 = new AnimationTimer() {
            int counter = 0;
            @Override
            public void handle(long now) {
                counter++;
                if (blueEgg.visibleProperty().getValue()) {
                    blueEgg.setY(blueEgg.getY() + random.nextInt(10) + 3);
                }
                if (counter % 200 == random.nextInt(200) && blueEgg.getY() > SCENE_HEIGHT) {
                    blueEgg.setX(random.nextInt((int) invaders[19].getX() - (int) invaders[0].getX()) + invaders[0].getX());
                    blueEgg.setY(random.nextInt((int) invaders[59].getY() - (int) invaders[0].getY()) + invaders[0].getY());
                    blueEgg.setVisible(true);
                }

                for (ImageView nest : nests) {
                    double blueEggY = blueEgg.getY();
                    double blueEggX = blueEgg.getX();

                    if (blueEggY <= nest.getY() + 25 && blueEggY >= nest.getY() && blueEggX <= nest.getX() + 54 && blueEggX >= nest.getX() - 25 && blueEgg.visibleProperty().getValue()) {
                        if (nest.visibleProperty().getValue()) {
                            blueEgg.setVisible(false);
                            nest.setVisible(false);
                        }
                    }
                }

                if (counter % 50 == 0) {
                    for (ImageView invader : invaders) {
                        if (invader.getImage() != blueChicken[2]) invader.setImage(blueChicken[1]);
                    }
                }
                if (counter % 50 == 25) {
                    for (ImageView invader : invaders) {
                        if (invader.getImage() != blueChicken[2]) invader.setImage(blueChicken[0]);
                    }
                }

                if (counter % 400 == 0) for (int i = 0; i < 60; i++)
                    invaders[i].setX(invaders[i].getX() - 50);

                if (counter % 400 == 200) for (int i = 0; i < 60; i++)
                    invaders[i].setX(invaders[i].getX() + 50);

                if (counter % 1000 == 800) for (int i = 0; i < 60; i++)
                    invaders[i].setY(invaders[i].getY() + 50);

                if (counter % 10000 == 0) {
                    for (int i = 0; i < 20; i++)
                        invaders[i].setVisible(true);
                    for (int i = 0; i < 20; i++) {
                        invaders[i].setX(40 + 80 * i);
                        invaders[i].setY(100);
                    }
                }
                // Death of the chicken
                for (ImageView invader : invaders) {
                    if (invader.getImage() == blueChicken[3]) {
                        invader.setVisible(false);
                    }
                }

            }
        };
        Image login = new Image(fetchResource("account.png"));
        ImageView loginView = new ImageView(login);
        loginView.setFitWidth(50);
        loginView.setFitHeight(50);

        Image speaker = new Image(fetchResource("speaker.png"));
        ImageView speakerView = new ImageView(speaker);
        speakerView.setFitWidth(50);
        speakerView.setFitHeight(50);

        Image account = new Image(fetchResource("login.png"));
        ImageView accountView = new ImageView(account);
        accountView.setFitWidth(50);
        accountView.setFitHeight(50);

        Image password = new Image(fetchResource("pass.png"));
        ImageView passwordView = new ImageView(password);
        passwordView.setFitWidth(50);
        passwordView.setFitHeight(30);

        MenuItem createAccount = new MenuItem("Login");
        createAccount.setGraphic(accountView);
        createAccount.setStyle("-fx-skin-color: none");

        MenuItem changeUsername = new MenuItem("Change Password");
        changeUsername.setGraphic(passwordView);

        Menu loginMenu = new Menu("Account");
        loginMenu.setStyle("-fx-text-fill: white;");
        loginMenu.setGraphic(loginView);
        loginMenu.getItems().add(createAccount);
        loginMenu.getItems().add(changeUsername);

        Menu soundMenu = new Menu("Sound");
        soundMenu.getStyleClass().add("sound-menu");
        soundMenu.setGraphic(speakerView);

        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-font-family: Broadway; -fx-background-color: none; -fx-border-color: white; -fx-font-size: 30px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-text-fill: white");
        menuBar.getMenus().add(loginMenu);
        menuBar.getMenus().add(soundMenu);

        VBox vBoxLogin = new VBox(menuBar);


        Group game = new Group(backgroundImageView, scoreNumber, scoreText, messageText, backButton, blueEgg, spaceShip);
        for (ImageView invader : invaders) {
            game.getChildren().add(invader);
        }
        for (ImageView nest : nests) {
            game.getChildren().add(nest);

        }

        Group menu = new Group(bgStart, startNewGameButton, exitButton, resumeButton, highScoreButton, title, bigChicken, vBoxLogin);

        backgroundMusicPlayer.setAutoPlay(true);

        Scene gameScene = new Scene(game);
        gameScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styleSheet.css")).toExternalForm());

        Scene menuScene = new Scene(menu);

        Scene scene = new Scene(new Group());

        TableView<String> table = new TableView<>();

        final Label label = new Label("High Scores");
        label.setFont(new Font("Broadway", 20));

        table.setEditable(true);

        TableColumn<String, String> userCol = new TableColumn<>("User");
        userCol.setMinWidth(100);
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        TableColumn<String, String> scoreCol = new TableColumn<>("Score");
        scoreCol.setMinWidth(100);
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        table.getColumns().addAll(userCol, scoreCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        highScoreButton.setOnMouseClicked(event -> primaryStage.setScene(scene));

        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.NO, ButtonType.YES);
        exitAlert.setHeaderText("We will lose you...");
        exitAlert.setContentText("Are you sure?");
        exitAlert.setTitle("exit");
        exitAlert.setResult(exitAlert.getResult());
        DialogPane dialogPane = exitAlert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styleSheet.css")).toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        spaceShip.requestFocus();


        EventHandler<KeyEvent> keyListener = event -> {
            if (event.getCode() == KeyCode.RIGHT && spaceShip.getX() < SCENE_WIDTH - 100) {
                spaceShip.setX(spaceShip.getX() + 20);
            }
            if (event.getCode() == KeyCode.LEFT && spaceShip.getX() > 0) {
                spaceShip.setX(spaceShip.getX() - 20);
            }
            if (event.getCode() == KeyCode.UP && spaceShip.getY() > 0) {
                spaceShip.setY(spaceShip.getY() - 20);
            }
            if (event.getCode() == KeyCode.DOWN && (spaceShip.getY() < SCENE_HEIGHT - 100)) {
                spaceShip.setY(spaceShip.getY() + 20);
            }
            if (event.getCode() == KeyCode.SPACE) {
                ImageView b = new ImageView(bulletImage);
                b.setFitHeight(50);
                b.setFitWidth(50);
                b.setPreserveRatio(true);
                game.getChildren().add(b);
                b.setX(spaceShip.getX() + 25);
                b.setY(spaceShip.getY() + 50);
                b.setVisible(true);
                AnimationTimer animationTimer = new AnimationTimer() {

                    @Override
                    public void handle(long now) {
                        b.setY(b.getY() - 3);
                        if (b.getY() < -49) {
                            b.setVisible(false);
                        }
                        for (int i = 0; i < invaders.length; i++) {
                            double bulletY = b.getY();
                            double bulletX = b.getX();
                            double invaderX = invaders[i].getX();
                            double invaderY = invaders[i].getY();
                            boolean isBulletVisible = b.visibleProperty().getValue();
                            boolean isInvaderVisible = invaders[i].visibleProperty().getValue();
                            if ((bulletY <= (invaderY + 25)) && (bulletY >= invaderY) && (bulletX <= invaderX + 54) && (bulletX >= (invaderX - 25)) && isBulletVisible) {
                                if (isInvaderVisible) {
                                    b.setVisible(false);
                                    scoreNumber.setText(valueOf(score[0] += 100));
                                    invaders[i].setImage(blueChicken[2]);
                                    chickensState[i]++;
                                }
                                if (chickensState[i] == 2 && invaders[i].getImage() == blueChicken[2]) {
                                    invaders[i].setImage(blueChicken[3]);
                                    chickensState[i] = 0;
                                }

                            }
                        }

                        for (ImageView nest : nests) {
                            if (b.getY() <= nest.getY() + 25 && b.getY() >= nest.getY() && b.getX() <= nest.getX() + 54 && b.getX() >= nest.getX() - 25 && b.visibleProperty().getValue()) {
                                if (nest.visibleProperty().getValue()) {
                                    b.setVisible(false);
                                    nest.setVisible(false);
                                }
                            }
                        }
                    }
                };

                animationTimer.start();
                shotSoundPlayer.play();
                shotSoundPlayer.setCycleCount(1);

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

        primaryStage.setTitle("Space Invaders");
        primaryStage.getIcons().add(new Image(fetchResource("blue0.png")));
        primaryStage.setScene(menuScene);
        primaryStage.show();


        startNewGameButton.setOnMouseClicked(event -> {
            for (ImageView i : invaders) {
                i.setVisible(true);
            }

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 20; i++) {
                    invaders[i + (j * 20)].setX(100 + (50 * i));
                    invaders[i + (j * 20)].setY(100 + (80 * j));
                }
            }

            spaceShip.setVisible(true);
            for (ImageView nest : nests) {
                nest.setVisible(true);
            }
            primaryStage.setScene(gameScene);
            graphic0.start();
            spaceShip.requestFocus();
        });
        resumeButton.setOnMouseClicked(event -> {
            primaryStage.setScene(gameScene);
            graphic0.start();
            spaceShip.requestFocus();
        });
        resumeButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(gameScene);
                graphic0.start();
                spaceShip.requestFocus();
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
                for (ImageView i : invaders)
                    i.setVisible(true);

                for (int j = 0; j < 3; j++)
                    for (int i = 0; i < 20; i += 80)
                        invaders[i + (j * 20)].setX(40 + 80 * i);

                for (int j = 0; j < 3; j++)
                    for (int i = 0; i < 20; i += 80)
                        invaders[i + (j * 20)].setY(100 + 80 * j);

                spaceShip.setVisible(true);
//                gameOverLabel.setVisible(false);
                primaryStage.setScene(gameScene);
                graphic0.start();
                spaceShip.requestFocus();
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
//        if (gameOverLabel.visibleProperty().getValue()) {
//            graphic0.stop();
//        }
    }


    public static void main(String[] args) {
        launch(args);
    }


}