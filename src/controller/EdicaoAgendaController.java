package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class EdicaoAgendaController {

    @FXML
    private ToggleGroup tipo;

    @FXML
    private Pane busca;

    @FXML
    private Label titulo;

    @FXML
    private Button buscarButton;

    @FXML
    private Button voltarButton;
    
    void initialize() {
    	assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'edicaoAgenda.fxml'.";
    	assert buscarButton != null : "fx:id=\"buscarButton\" was not injected: check your FXML file 'edicaoAgenda.fxml'.";
    	
    voltarButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            final Stage stage = (Stage) agendaExameButton.getScene().getWindow();
            AnchorPane page;
            try {
                page = (AnchorPane) FXMLLoader.load(TelaInicialController.class.getResource("/telaInicial.fxml"));
                Scene scene = new Scene(page);
                scene.getStylesheets().add("stylesheet.css");
                stage.setScene(scene);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
            }
        }
    });
    
    buscarButton.setOnAction(new EventHandler<ActionEvent>() {
        //@TODO: Completar essa lógica
    });
    }
}
