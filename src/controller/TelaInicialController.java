package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class TelaInicialController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agendaConsultaButton;

    @FXML
    private Button agendaExameButton;

    @FXML
    private Button encerraSessaoButton;

    @FXML
    private Button gerenciaAgendasButton;

    @FXML
    private Label titulo;


    @FXML
    void initialize() {
        assert agendaConsultaButton != null : "fx:id=\"agendaConsultaButton\" was not injected: check your FXML file 'janelaInicial.fxml'.";
        assert agendaExameButton != null : "fx:id=\"agendaExameButton\" was not injected: check your FXML file 'janelaInicial.fxml'.";
        assert encerraSessaoButton != null : "fx:id=\"encerraSessaoButton\" was not injected: check your FXML file 'janelaInicial.fxml'.";
        assert gerenciaAgendasButton != null : "fx:id=\"gerenciaAgendasButton\" was not injected: check your FXML file 'janelaInicial.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'janelaInicial.fxml'.";

        agendaConsultaButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = (Stage) agendaConsultaButton.getScene().getWindow();
                AnchorPane page;
                try {
                    page = (AnchorPane) FXMLLoader.load(TelaInicialController.class.getResource("/janelaEspecialidades.fxml"));
                    Scene scene = new Scene(page);
                    scene.getStylesheets().add("stylesheet.css");
                    stage.setScene(scene);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                }
            }
            
        });
        encerraSessaoButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = (Stage) agendaConsultaButton.getScene().getWindow();
                stage.close();
            }
            
        });
        agendaExameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = (Stage) agendaExameButton.getScene().getWindow();
                AnchorPane page;
                try {
                    page = (AnchorPane) FXMLLoader.load(TelaInicialController.class.getResource("/janelaExames.fxml"));
                    Scene scene = new Scene(page);
                    scene.getStylesheets().add("stylesheet.css");
                    stage.setScene(scene);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                }
            }
        });
        gerenciaAgendasButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = (Stage) gerenciaAgendasButton.getScene().getWindow();
                AnchorPane page;
                try {
                    page = (AnchorPane) FXMLLoader.load(TelaInicialController.class.getResource("/edicaoAgenda.fxml"));
                    Scene scene = new Scene(page);
                    scene.getStylesheets().add("stylesheet.css");
                    stage.setScene(scene);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                }
            }
        });
    }

}
