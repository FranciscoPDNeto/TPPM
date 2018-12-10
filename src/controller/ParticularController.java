package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class ParticularController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label aviso;

    @FXML
    private Button cancelarlButton;

    @FXML
    private RadioButton cartaoCreditoRadioButton;

    @FXML
    private RadioButton cartaoDebitoRadioButton;

    @FXML
    private RadioButton chequeRadioButton;

    @FXML
    private TextField cvvCCTextField;

    @FXML
    private TextField cvvCDTextField;

    @FXML
    private RadioButton emEspecieRadioButton;

    @FXML
    private Button finalizarButton;

    @FXML
    private Pane medico;

    @FXML
    private TextField nomeTitularCCTextField;

    @FXML
    private TextField nomeTitularCDTextField;

    @FXML
    private TextField numeroCCTextField;

    @FXML
    private TextField numeroCDTextField;

    @FXML
    private ToggleGroup pagamento;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label titulo;
    
    private ToggleGroup groupPagamento;


    @FXML
    void initialize() {
        assert aviso != null : "fx:id=\"aviso\" was not injected: check your FXML file 'particular.fxml'.";
        assert cancelarlButton != null : "fx:id=\"cancelarlButton\" was not injected: check your FXML file 'particular.fxml'.";
        assert cartaoCreditoRadioButton != null : "fx:id=\"cartaoCreditoRadioButton\" was not injected: check your FXML file 'particular.fxml'.";
        assert cartaoDebitoRadioButton != null : "fx:id=\"cartaoDebitoRadioButton\" was not injected: check your FXML file 'particular.fxml'.";
        assert chequeRadioButton != null : "fx:id=\"chequeRadioButton\" was not injected: check your FXML file 'particular.fxml'.";
        assert cvvCCTextField != null : "fx:id=\"cvvCCTextField\" was not injected: check your FXML file 'particular.fxml'.";
        assert cvvCDTextField != null : "fx:id=\"cvvCDTextField\" was not injected: check your FXML file 'particular.fxml'.";
        assert emEspecieRadioButton != null : "fx:id=\"emEspecieRadioButton\" was not injected: check your FXML file 'particular.fxml'.";
        assert finalizarButton != null : "fx:id=\"finalizarButton\" was not injected: check your FXML file 'particular.fxml'.";
        assert medico != null : "fx:id=\"medico\" was not injected: check your FXML file 'particular.fxml'.";
        assert nomeTitularCCTextField != null : "fx:id=\"nomeTitularCCTextField\" was not injected: check your FXML file 'particular.fxml'.";
        assert nomeTitularCDTextField != null : "fx:id=\"nomeTitularCDTextField\" was not injected: check your FXML file 'particular.fxml'.";
        assert numeroCCTextField != null : "fx:id=\"numeroCCTextField\" was not injected: check your FXML file 'particular.fxml'.";
        assert numeroCDTextField != null : "fx:id=\"numeroCDTextField\" was not injected: check your FXML file 'particular.fxml'.";
        assert pagamento != null : "fx:id=\"pagamento\" was not injected: check your FXML file 'particular.fxml'.";
        assert progressBar != null : "fx:id=\"progressBar\" was not injected: check your FXML file 'particular.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'particular.fxml'.";

        groupPagamento = new ToggleGroup();
        cartaoCreditoRadioButton.setToggleGroup(pagamento);
        cartaoDebitoRadioButton.setToggleGroup(pagamento);
        
        progressBar.setVisible(false);
        aviso.setVisible(false);
        numeroCCTextField.setVisible(false);
        nomeTitularCCTextField.setVisible(false);
        cvvCCTextField.setVisible(false);
        
        numeroCDTextField.setVisible(false);
        nomeTitularCDTextField.setVisible(false);
        cvvCDTextField.setVisible(false);
        cartaoDebitoRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                numeroCDTextField.setVisible(isNowSelected);
                nomeTitularCDTextField.setVisible(isNowSelected);
                cvvCDTextField.setVisible(isNowSelected);
            }
        });
        cartaoCreditoRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                numeroCCTextField.setVisible(isNowSelected);
                nomeTitularCCTextField.setVisible(isNowSelected);
                cvvCCTextField.setVisible(isNowSelected);
            }
        });
        
        finalizarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Pendencia. Salvar no banco de dados o exame agendado.
                JOptionPane.showMessageDialog(null, "Exame agendado com sucesso");
                AnchorPane page;
                final Stage stage = (Stage) finalizarButton.getScene().getWindow();
                try {
                    page = (AnchorPane) FXMLLoader.load(AgendamentoExameController.class.getResource(
                      "/janelaInicial.fxml"));
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
