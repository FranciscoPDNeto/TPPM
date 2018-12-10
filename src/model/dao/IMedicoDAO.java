package model.dao;

import java.util.List;
import model.domain.Especialidade;
import model.domain.Medico;

public interface IMedicoDAO {
    
    public void inserir(Medico medico) throws ClassNotFoundException, Exception;
    public Medico consultarPorCpf(String cpf) throws ClassNotFoundException, Exception;
    public List<Medico> consultarPorEspecialidade(Especialidade especialidade) throws ClassNotFoundException, Exception;
    public Medico consultarPorNome(String nome) throws ClassNotFoundException, Exception;

}