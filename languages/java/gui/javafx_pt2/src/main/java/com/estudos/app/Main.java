package com.estudos.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // O FXMLLoader lê o arquivo visual de dentro da pasta resources
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tela_principal.fxml"));

        // Carrega o layout raiz e define o tamanho da janela (largura 350, altura 200)
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);

        primaryStage.setTitle("Primeira Tela FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}