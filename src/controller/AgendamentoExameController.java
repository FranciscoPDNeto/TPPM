package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.dao.ITipoExameDAO;
import model.dao.impl.TipoExameDAO;
import model.domain.TipoExame;


public class AgendamentoExameController {
    
    private class MedicoByAgendaEquipamento {
        private StringProperty nomeMedico;
        public void setNomeMedico(String value) { nomeMedicoProperty().set(value); }
        public String getNomeMedico() { return nomeMedicoProperty().get(); }
        public StringProperty nomeMedicoProperty() { 
            if (nomeMedico == null) nomeMedico = new SimpleStringProperty(this, "nomeMedico");
            return nomeMedico; 
        }

        private StringProperty nomeEquipamento;
        public void setNomeEquipamento(String value) { nomeEquipamentoProperty().set(value); }
        public String getNomeEquipamento() { return nomeEquipamentoProperty().get(); }
        public StringProperty nomeEquipamentoProperty() { 
            if (nomeEquipamento == null) nomeEquipamento = new SimpleStringProperty(this, "nomeEquipamento");
            return nomeEquipamento; 
        } 
        
        private StringProperty horaDisponivel;
        public void setHoraDisponivel(String value) { horaDisponivelProperty().set(value); }
        public String getHoraDisponivel() { return horaDisponivelProperty().get(); }
        public StringProperty horaDisponivelProperty() { 
            if (horaDisponivel == null) horaDisponivel = new SimpleStringProperty(this, "horaDisponivel");
            return horaDisponivel; 
        } 
    }
    /*
    private class MedicoByAgendaEquipamento {
        private String nomeMedico;
        private String nomeEquipamento;
        private String horaDisponivel;
        
        public MedicoByAgendaEquipamento(String nomeMedico, String nomeEquipamento, String horaDisponivel) {
            this.nomeMedico = nomeMedico;
            this.nomeEquipamento = nomeEquipamento;
            this.horaDisponivel = horaDisponivel;
        }
        
        
    }
    */
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup atendimento;

    @FXML
    private Button buscarButton;

    @FXML
    private Button continuarButton;

    @FXML
    private RadioButton convenioRadioButton;

    @FXML
    private TextField dataTextField;

    @FXML
    private TextArea especificacaoTextArea;

    @FXML
    private Pane medico;

    @FXML
    private TableView<MedicoByAgendaEquipamento> medicosTable;

    @FXML
    private TextField pacienteTextField;

    @FXML
    private RadioButton particularRadioButton;

    @FXML
    private TextField telefoneTextField;

    @FXML
    private Label titulo;

    @FXML
    private Button voltarButton;
    
    private TipoExame tipoExame;


    @FXML
    void initialize() {
        assert atendimento != null : "fx:id=\"atendimento\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert buscarButton != null : "fx:id=\"buscarButton\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert continuarButton != null : "fx:id=\"continuarButton\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert convenioRadioButton != null : "fx:id=\"convenioRadioButton\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert dataTextField != null : "fx:id=\"dataTextField\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert especificacaoTextArea != null : "fx:id=\"especificacaoTextArea\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert medico != null : "fx:id=\"medico\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert medicosTable != null : "fx:id=\"medicosTable\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert pacienteTextField != null : "fx:id=\"pacienteTextField\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert particularRadioButton != null : "fx:id=\"particularRadioButton\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert telefoneTextField != null : "fx:id=\"telefoneTextField\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'agendamentoExame.fxml'.";
        assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'agendamentoExame.fxml'.";

        voltarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = (Stage) voltarButton.getScene().getWindow();
                AnchorPane page;
                try {
                    page = (AnchorPane) FXMLLoader.load(AgendamentoExameController.class.getResource("/janelaExames.fxml"));
                    Scene scene = new Scene(page);
                    scene.getStylesheets().add("stylesheet.css");
                    stage.setScene(scene);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                }
            }
        });
        continuarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pacienteTextField.getText().isEmpty() || telefoneTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há campos que não podem ser vazios");
                    return;
                }
                final Stage stage = (Stage) continuarButton.getScene().getWindow();
                AnchorPane page;
                try {
                    page = (AnchorPane) FXMLLoader.load(AgendamentoExameController.class.getResource(
                      convenioRadioButton.isSelected() ? "/convenio.fxml" : "/particular.fxml"));
                    Scene scene = new Scene(page);
                    scene.getStylesheets().add("stylesheet.css");
                    stage.setScene(scene);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                }
            }
        });
        buscarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Pendencia. Lógica de busca dos medicos pelo tipo de especialidade.
            }
        });
    }

    void initSelectedNomeTipoExame(String selectedNomeTipoExame) throws Exception {
        ITipoExameDAO tipoExameDAO = new TipoExameDAO();
        tipoExame = tipoExameDAO.consultarPorNome(selectedNomeTipoExame);
    }

}
