package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button continuarButton;

    @FXML
    private ListView<String> examesList;

    @FXML
    private Label titulo;
    
    private ToggleGroup groupExames;

    @FXML
    void initialize() {
        assert continuarButton != null : "fx:id=\"continuarButton\" was not injected: check your FXML file 'janelaExames.fxml'.";
        assert examesList != null : "fx:id=\"examesTable\" was not injected: check your FXML file 'janelaExames.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'janelaExames.fxml'.";
        
        ITipoExameDAO tipoExameDAO = new TipoExameDAO();
        List<TipoExame> tipoExames;
        try {
            tipoExames = tipoExameDAO.listarTiposExame();
            
            groupExames = new ToggleGroup();
            for (TipoExame tipoExame : tipoExames) {
                final RadioButton radioButton = new RadioButton(tipoExame.getNome());
                radioButton.setToggleGroup(groupExames);
                examesList.getItems().add(tipoExame.getNome());
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
                    FXMLLoader loader = 
                            new FXMLLoader(JanelaExamesController.class.getResource("/agendamentoExame.fxml"));
                    page = (AnchorPane) loader.load();
                    AgendamentoExameController controller = 
                            loader.<AgendamentoExameController>getController();
                    // RadioButton selectedExame = (RadioButton) groupExames.getSelectedToggle();
                    //controller.initSelectedNomeTipoExame(selectedExame.getText());
                    controller.initSelectedNomeTipoExame(examesList.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(page);
                    scene.getStylesheets().add("stylesheet.css");
                    stage.setScene(scene);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                }
            }
        });
        
        
    }

}
