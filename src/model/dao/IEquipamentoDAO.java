package model.dao;

import java.util.List;
import model.domain.TipoExame;
import model.domain.Equipamento;

public interface IEquipamentoDAO {
    
    public void inserir(Equipamento equipamento) throws ClassNotFoundException, Exception;
    public List<Equipamento> consultarPorTipoExame(TipoExame especialidade) throws ClassNotFoundException, Exception;

}