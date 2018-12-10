package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import src.controller.JanelaExamesController.ExameEscolhido;
import src.model.dao.IEspecialidadeDAO;

public class JanelaEspecialidadesController {
	
	public class EspecialidadeEscolhida {
        private final RadioButton radio;
        private final String nomTipoEspecialidade;
        public EspecialidadeEscolhida(RadioButton radio, String nomTipoEspecialidade) {
            this.radio = radio;
            this.nomTipoEspecialidade = nomTipoEspecialidade;
        }
        public RadioButton getRadio() {
            return radio;
        }
        public String getNomTipoEspecialidade() {
            return nomTipoEespecialidade;
        }
    }

    @FXML
    private Button continuarButton;

    @FXML
    private TableView<?> especialidadesTable;
    
    @FXML
    private Label titulo;

    @FXML
    private Button voltarButton;
    
    @FXML
    void initialize() {
    	assert continuarButton != null : "fx:id=\"continuarButton\" was not injected: check your FXML file 'janelaEspecialidades.fxml'.";
    	assert voltarButton != null : "fx:id=\"voltarButton\" was not injected: check your FXML file 'janelaEspecialidades.fxml'.";
    	
    	IEspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    	List<Especialidade> especialidade;
    	
    	try {
            especialidade = especialidadeDAO.listarEspecialidade();
            
            ToggleGroup group = new ToggleGroup();
            for (Especialidade especialidade : especialidade) {
                final RadioButton radioButton = new RadioButton();
                radioButton.setToggleGroup(group);
                final String nomeEspecialidade = especialidade.getNome();

                especialidadeTable.getItems().add(new EspecialidadeEscolhida(radioButton, nomeEspecialidade));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "A lista não pôde ser carregada");
        }
    	
    	 voltarButton.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                 final Stage stage = (Stage) voltarButton.getScene().getWindow();
                 AnchorPane page;
                 try {
                     page = (AnchorPane) FXMLLoader.load(JanelaExamesController.class.getResource("/janelainicial.fxml"));
                     Scene scene = new Scene(page);
                     scene.getStylesheets().add("stylesheet.css");
                     stage.setScene(scene);
                 } catch (IOException ex) {
                     JOptionPane.showMessageDialog(null, "A tela não pôde ser carregada.");
                 }
             }
         });
    	 
    	 continuarButton.setOnAction(new EventHandler<ActionEvent>(){
    		 @Override
    		 public void handle(ActionEvent event) {
    			 final Stage stage = (Stage) continuarButton.getScene().getWindow();
    			 AnchorPane page;
    			 try {
                     page = (AnchorPane) FXMLLoader.load(JanelaEspecialidadesController.class.getResource("/agendamentoMedico.fxml"));
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
