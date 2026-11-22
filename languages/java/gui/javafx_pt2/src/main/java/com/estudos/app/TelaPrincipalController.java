package com.estudos.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaPrincipalController {

    // O nome da variável DEVE ser idêntico ao fx:id definido no FXML
    @FXML
    private Label lblMensagem;

    private int contador = 0;

    // O nome do método DEVE ser idêntico ao onAction (sem o #)
    @FXML
    protected void aoClicarNoBotao() {
        contador++;
        lblMensagem.setText("Você clicou " + contador + " vez(es)!");
    }
}