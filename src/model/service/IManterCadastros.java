package model.service;

import model.domain.Medico;
import model.domain.Equipamento;

public interface IManterCadastros {
    
    public void cadastrarMedico(Medico medico) throws Exception;
    public void cadastrarEquipamento(Equipamento equipamento) throws Exception;
    
}
