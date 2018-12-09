package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.dao.ITipoExameDAO;
import model.dao.impl.TipoExameDAO;
import model.domain.TipoExame;


public class JanelaExamesController {
    
    public class ExameEscolhido {
        private final RadioButton radio;
        private final String nomTipoExame;
        public ExameEscolhido(RadioButton radio, String nomTipoExame) {
            this.radio = radio;
            this.nomTipoExame = nomTipoExame;
        }
        public RadioButton getRadio() {
            return radio;
        }
        public String getNomTipoExame() {
            return nomTipoExame;
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button continuarButton;

    @FXML
    private TableView<ExameEscolhido> examesTable;

    @FXML
    private Label titulo;


    @FXML
    void initialize() {
        assert continuarButton != null : "fx:id=\"continuarButton\" was not injected: check your FXML file 'janelaExames.fxml'.";
        assert examesTable != null : "fx:id=\"examesTable\" was not injected: check your FXML file 'janelaExames.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'janelaExames.fxml'.";
        
        ITipoExameDAO tipoExameDAO = new TipoExameDAO();
        List<TipoExame> tipoExames;
        try {
            tipoExames = tipoExameDAO.listarTiposExame();
            
            ToggleGroup group = new ToggleGroup();
            for (TipoExame tipoExame : tipoExames) {
                final RadioButton radioButton = new RadioButton();
                radioButton.setToggleGroup(group);
                final String tipoExameNome = tipoExame.getNome();

                examesTable.getItems().add(new ExameEscolhido(radioButton, tipoExameNome));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "A lista não pôde ser carregada");
        }
        
        continuarButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = (Stage) continuarButton.getScene().getWindow();
                AnchorPane page;
                try {
                    page = (AnchorPane) FXMLLoader.load(JanelaExamesController.class.getResource("/agendamentoExame.fxml"));
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
