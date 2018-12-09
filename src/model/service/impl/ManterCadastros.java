package model.service.impl;

import model.dao.IMedicoDAO;
import model.dao.impl.MedicoDAO;
import model.domain.Medico;
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

}
