module edu.sharif.chickeninvaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens edu.sharif.chickeninvaders to javafx.fxml;
    exports edu.sharif.chickeninvaders;
}