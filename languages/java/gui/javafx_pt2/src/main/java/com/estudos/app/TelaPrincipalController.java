package com.estudos.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaPrincipalController {

    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtCliente;

    @FXML
    private Label lblStatus;

    @FXML
    public void initialize() {
        lblStatus.setText("");
    }

    @FXML
    protected void realizarVenda() {
        String produto = txtProduto.getText();
        String cliente = txtCliente.getText();

        if (produto.isBlank() || cliente.isBlank()) {
            lblStatus.setText("Erro: Preencha produto e cliente!");
            lblStatus.setStyle("-fx-text-fill: red;");
            System.out.println("Erro: Campos obrigatórios vazios.");
        } else {
            lblStatus.setText("Venda realizada: " + produto + " para " + cliente);
            lblStatus.setStyle("-fx-text-fill: green;");
            System.out.println("Venda registrada -> Produto: " + produto + " | Cliente: " + cliente);

            txtProduto.clear();
            txtCliente.clear();
        }
    }
}