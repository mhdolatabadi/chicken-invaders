package edu.sharif.chickeninvaders;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

import static java.lang.String.valueOf;


public class ChickenInvaders extends Application {
    Color color = new Color(1, 1, 1, 1);

    final int[] score = {0};
    final double SCENE_HEIGHT = 1020;
    final double SCENE_WIDTH = 1840;
    final VBox vbox = new VBox();
    Image bigChickenImageFirstState = new Image(fetchResource("white0.png"));
    Image bigChickenImageSecondState = new Image(fetchResource("white1.png"));
    Image[] blueChicken = new Image[4];
    Image[] redChicken = new Image[4];
    Image[] greenChicken = new Image[4];
    Image[] yellowChicken = new Image[4];
    Image[] purpleChicken = new Image[4];
    ImageView bigChicken = new ImageView(bigChickenImageFirstState);
    ImageView backgroundImageView = new ImageView(fetchResource("background.jpg"));
    ImageView bgStart = new ImageView(fetchResource("background.jpg"));
    ImageView spaceShip = new ImageView(fetchResource("spaceShip.png"));
    ImageView loginView = new ImageView(fetchResource("account.png"));
    ImageView speakerView = new ImageView(fetchResource("speaker.png"));
    ImageView accountView = new ImageView(fetchResource("login.png"));
    ImageView passwordView = new ImageView(fetchResource("pass.png"));
    ImageView[] invaders = new ImageView[60];
    Label title = new Label();
    Label scoreNumber = new Label();
    Label scoreText = new Label();
    Label messageText = new Label();
    Button backButton = new Button();
    Button startNewGameButton = new Button();
    Button exitButton = new Button();
    Button resumeButton = new Button();
    Button highScoreButton = new Button();
    MenuItem createAccount = new MenuItem("Login");
    MenuItem changeUsername = new MenuItem("Change Password");
    Menu loginMenu = new Menu("Account");
    Menu soundMenu = new Menu("Sound");
    MenuBar menuBar = new MenuBar();

    private void initializeChickensScale() {
        for (ImageView i : invaders) {
            i.setFitHeight(60);
            i.setFitWidth(60);
            i.setPreserveRatio(true);
        }
    }

    private void initializeChickensPosition() {
        for (int j = 0; j < invaders.length / 20; j++)
            for (int i = 0; i < 20; i++) {
                invaders[i + (j * 20)].setX(100 + 70 * i + Math.floorDiv(i, 4) * 50);
                invaders[i + (j * 20)].setY(100 + 80 * j);
            }

    }

    private void initializeChickensColor() {
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 20; i++)
                invaders[i + 20 * j] = new ImageView(getChickenImage(i / 4 == 0 ? "blue" : i / 4 == 1 ? "red" : i / 4 == 2 ? "yellow" : i / 4 == 3 ? "green" : "purple", 0));
    }

    private void initializeImageViews() {
        for (int i = 0; i < 4; i++)
            blueChicken[i] = new Image(fetchResource("blue" + i + ".png"));
        for (int i = 0; i < 4; i++)
            redChicken[i] = new Image(fetchResource("red" + i + ".png"));
        for (int i = 0; i < 4; i++)
            greenChicken[i] = new Image(fetchResource("green" + i + ".png"));
        for (int i = 0; i < 4; i++)
            yellowChicken[i] = new Image(fetchResource("yellow" + i + ".png"));
        for (int i = 0; i < 4; i++)
            purpleChicken[i] = new Image(fetchResource("purple" + i + ".png"));
    }


    private String fetchResource(String path) {
        return Objects.requireNonNull(getClass().getResource(path)).toString();
    }

    private Image getChickenImage(String url, int index) {
        if (url.contains("blue")) return blueChicken[index];
        else if (url.contains("red")) return redChicken[index];
        else if (url.contains("green")) return greenChicken[index];
        else if (url.contains("yellow")) return yellowChicken[index];
        return purpleChicken[index];
    }

    private void createBulletShot(ImageView bullet, Group game) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                bullet.setY(bullet.getY() - 3);
                if (bullet.getY() < -49) {
                    game.getChildren().remove(bullet);
                    this.stop();
                }

                double bulletY = bullet.getY();
                double bulletX = bullet.getX();
                boolean isBulletVisible = bullet.visibleProperty().getValue();
                for (ImageView invader : invaders) {
                    double invaderX = invader.getX();
                    double invaderY = invader.getY();
                    boolean isInvaderVisible = invader.visibleProperty().getValue();
                    if ((bulletY <= (invaderY + 25)) && (bulletY >= invaderY) && (bulletX <= invaderX + 54) && (bulletX >= (invaderX - 25)) && isBulletVisible && isInvaderVisible) {
                        bullet.setVisible(false);
                        if (invader.getImage().getUrl().contains("2"))
                            invader.setImage(getChickenImage(invader.getImage().getUrl(), 3));
                        else {
                            scoreNumber.setText(valueOf(score[0] += 100));
                            invader.setImage(getChickenImage(invader.getImage().getUrl(), 2));
                        }

                    }
                }
            }
        }.start();
    }


    @Override
    public void start(Stage primaryStage) {
        initializeImageViews();
        initializeChickensColor();
        initializeChickensPosition();
        initializeChickensScale();

        MediaPlayer shotSoundPlayer = new MediaPlayer(new Media(fetchResource("shoot.wav")));
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(new Media(fetchResource("spaceInvader.wav")));
        backgroundMusicPlayer.setAutoPlay(true);

        backgroundImageView.setX(0);
        backgroundImageView.setY(0);
        backgroundImageView.setFitHeight(SCENE_HEIGHT);
        backgroundImageView.setFitWidth(SCENE_WIDTH);

        bgStart.setX(0);
        bgStart.setY(0);
        bgStart.setFitHeight(SCENE_HEIGHT);
        bgStart.setFitWidth(SCENE_WIDTH);

        // Menu page buttons
        title.setText("CHICKEN INVADERS");
        title.setLayoutX(475);
        title.setLayoutY(100);
        title.setTextFill(color);
        title.getStyleClass().add("title");

        backButton.setText("Back");
        backButton.getStyleClass().add("main-menu-button");
        backButton.setLayoutX(1650);
        backButton.setLayoutY(10);
        backButton.setMinSize(50, 15);
        backButton.setTextFill(color);

        startNewGameButton.setText("Start New Game");
        startNewGameButton.getStyleClass().add("main-menu-button");
        startNewGameButton.setLayoutX(735);
        startNewGameButton.setLayoutY(400);
        startNewGameButton.setTextFill(color);

        exitButton.setText("Exit");
        exitButton.getStyleClass().add("main-menu-button");
        exitButton.setLayoutX(860);
        exitButton.setLayoutY(600);
        exitButton.setTextFill(color);

        resumeButton.setText("Resume");
        resumeButton.getStyleClass().add("main-menu-button");
        resumeButton.setLayoutX(820);
        resumeButton.setLayoutY(300);
        resumeButton.setTextFill(color);

        highScoreButton.setText("High Scores");
        highScoreButton.getStyleClass().add("main-menu-button");
        highScoreButton.setLayoutX(790);
        highScoreButton.setLayoutY(500);
        highScoreButton.setTextFill(color);

        scoreNumber.setText(valueOf(score[0]));
        scoreNumber.setLayoutX(170);
        scoreNumber.setLayoutY(20);
        scoreNumber.setTextFill(color);

        scoreText.setText("Score");
        scoreText.setLayoutX(25);
        scoreText.setLayoutY(20);
        scoreText.setTextFill(color);

        messageText.setText("");
        messageText.setLayoutX((SCENE_WIDTH / 2) - messageText.getTranslateX());
        messageText.setLayoutY(20);
        messageText.setTextFill(color);

        spaceShip.setX(SCENE_WIDTH / 2);
        spaceShip.setY(SCENE_HEIGHT - 150);
        spaceShip.setFitHeight(100);
        spaceShip.setFitWidth(100);

        bigChicken.setX(150);
        bigChicken.setY(300);
        bigChicken.setFitHeight(400);
        bigChicken.setFitWidth(400);
        bigChicken.setPreserveRatio(true);

        for (ImageView imageView : new ImageView[]{loginView, speakerView, accountView, passwordView}) {
            imageView.setFitWidth(50);
            if (imageView == passwordView) imageView.setFitHeight(30);
            else imageView.setFitHeight(50);

        }

        createAccount.setGraphic(accountView);
        changeUsername.setGraphic(passwordView);
        loginMenu.setGraphic(loginView);
        loginMenu.getItems().addAll(createAccount, changeUsername);

        soundMenu.getStyleClass().add("sound-menu");
        soundMenu.setGraphic(speakerView);

        menuBar.getStyleClass().add("menu-bar");
        menuBar.getMenus().addAll(loginMenu, soundMenu);

        VBox vBoxLogin = new VBox(menuBar);

        Group game = new Group(backgroundImageView, scoreNumber, scoreText, messageText, backButton, spaceShip);
        for (ImageView invader : invaders)
            game.getChildren().add(invader);

        Scene gameScene = new Scene(game);
        gameScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        Group menu = new Group(bgStart, startNewGameButton, exitButton, resumeButton, highScoreButton, title, bigChicken, vBoxLogin);
        Scene menuScene = new Scene(menu);
        menuScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        AnimationTimer chickenFly = new AnimationTimer() {
            int counter = 0;

            @Override
            public void handle(long l) {
                counter++;
                if (counter % 50 == 0) for (ImageView invader : invaders) {
                    if (!invader.getImage().getUrl().contains("2"))
                        invader.setImage(getChickenImage(invader.getImage().getUrl(), 1));
                }
                if (counter % 50 == 25) for (ImageView invader : invaders)
                    if (!invader.getImage().getUrl().contains("2"))
                        invader.setImage(getChickenImage(invader.getImage().getUrl(), 0));
            }
        };

        AnimationTimer chickenMovement = new AnimationTimer() {
            int counter = 0;

            @Override
            public void handle(long l) {
                counter++;
                if (counter % 400 == 0) for (int i = 0; i < 60; i++)
                    invaders[i].setX(invaders[i].getX() - 50);

                if (counter % 400 == 200) for (int i = 0; i < 60; i++)
                    invaders[i].setX(invaders[i].getX() + 50);

                if (counter % 1000 == 800) for (int i = 0; i < 60; i++)
                    invaders[i].setY(invaders[i].getY() + 50);
            }
        };

        AnimationTimer cleanDeathChickens = new AnimationTimer() {
            int counter = 0;

            @Override
            public void handle(long l) {
                counter++;
                for (ImageView invader : invaders)
                    if (invader.getImage().getUrl().contains("3") || !invader.visibleProperty().getValue()) {
                        invader.setVisible(false);
                        game.getChildren().remove(invader);
                    }
            }
        };

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
        table.getColumns().add(scoreCol);
        table.getColumns().add(userCol);

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
        dialogPane.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        spaceShip.requestFocus();

        EventHandler<KeyEvent> spaceListener = spaceshipShotHandler(game, shotSoundPlayer);

        EventHandler<KeyEvent> keyListener = spaceshipMovementHandler(primaryStage, menuScene);

        gameScene.setOnKeyPressed(keyListener);
        gameScene.setOnKeyReleased(spaceListener);

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


        EventHandler<Event> startNewGameButtonEvent = event -> {
            for (ImageView i : invaders)
                i.setVisible(true);

            initializeChickensPosition();

            spaceShip.setVisible(true);
            primaryStage.setScene(gameScene);
            chickenFly.start();
            chickenMovement.start();
            cleanDeathChickens.start();
            spaceShip.requestFocus();

        };

        startNewGameButton.setOnMouseClicked(startNewGameButtonEvent);
        startNewGameButton.setOnKeyPressed(startNewGameButtonEvent);

        EventHandler<Event> resumeButtonEvent = event -> {
            primaryStage.setScene(gameScene);
            spaceShip.requestFocus();
        };

        resumeButton.setOnMouseClicked(resumeButtonEvent);
        resumeButton.setOnKeyPressed(resumeButtonEvent);

        exitButton.setOnMouseClicked(event -> {
            exitAlert.showAndWait();
            if (exitAlert.getResult() == ButtonType.YES) {
                primaryStage.close();
            }
        });
        backButton.setOnMouseClicked(event -> primaryStage.setScene(menuScene));

        exitButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                exitAlert.showAndWait();
                if (exitAlert.getResult() == ButtonType.YES) {
                    primaryStage.close();
                }
            }
        });
        new AnimationTimer() {
            int timer = 0;

            @Override
            public void handle(long now) {
                if (timer % 25 == 0)
                    bigChicken.setImage(bigChicken.getImage() == bigChickenImageFirstState ? bigChickenImageSecondState : bigChickenImageFirstState);
                timer++;
            }
        }.start();
    }

    private EventHandler<KeyEvent> spaceshipMovementHandler(Stage primaryStage, Scene menuScene) {
        return event -> {
            if (event.getCode() == KeyCode.RIGHT && spaceShip.getX() < SCENE_WIDTH - 100)
                spaceShip.setX(spaceShip.getX() + 20);
            if (event.getCode() == KeyCode.LEFT && spaceShip.getX() > 0) spaceShip.setX(spaceShip.getX() - 20);
            if (event.getCode() == KeyCode.UP && spaceShip.getY() > 0) spaceShip.setY(spaceShip.getY() - 20);
            if (event.getCode() == KeyCode.DOWN && (spaceShip.getY() < SCENE_HEIGHT - 100))
                spaceShip.setY(spaceShip.getY() + 20);

            if (event.getCode() == KeyCode.S) {
                System.out.println(score[0]);
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.setScene(menuScene);
            }
            event.consume();
        };
    }

    private EventHandler<KeyEvent> spaceshipShotHandler(Group game, MediaPlayer shotSoundPlayer) {
        return event -> {
            if (event.getCode() == KeyCode.SPACE) {
                ImageView bullet = new ImageView(fetchResource("bullet.png"));
                bullet.setFitHeight(50);
                bullet.setFitWidth(50);
                bullet.setPreserveRatio(true);
                game.getChildren().add(bullet);
                bullet.setX(spaceShip.getX() + 25);
                bullet.setY(spaceShip.getY() + 50);
                bullet.setVisible(true);
                createBulletShot(bullet, game);
                shotSoundPlayer.play();
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}