package model.service.impl;

import model.dao.*;
import model.dao.impl.*;
import model.domain.*;
import model.service.IManterCadastros;

public class ManterCadastros implements IManterCadastros {

    @Override
    public void cadastrarMedico(Medico medico) throws Exception {
        if (medico.getCpf() == null) {
            throw new Exception("CPF inválido.");
        }
        if (medico.getCrm() < 0) {
            throw new Exception("CRM inválido.");
        }
        if (medico.getNome() == null) {
            throw new Exception("Nome inválido.");
        }
        if (medico.getTelefone() < 0) {
            throw new Exception("Telefone inválido.");
        }
        if (medico.getHora1() == null) {
            throw new Exception("Horário de trabalho 1 inválido.");
        }
        if (medico.getHora2() == null) {
            throw new Exception("Horário de trabalho 2 inválido.");
        }
        if (medico.getHora3() == null) {
            throw new Exception("Horário de trabalho 3 inválido.");
        }
        if (medico.getHoraIntervalo() == null) {
            throw new Exception("Horário de intervalo inválido.");
        }

        IMedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.inserir(medico);
    }
    
    @Override
    public void cadastrarEquipamento(Equipamento equipamento) throws Exception {
        
        if (equipamento.getCodigoTipoExame() < 0) {
            throw new Exception("Tipo de exmae inválido.");
        }
        if (equipamento.getNome() == null) {
            throw new Exception("Nome do equipamento inválido.");
        }
        
        IEquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        equipamentoDAO.inserir(equipamento);
    }

}
