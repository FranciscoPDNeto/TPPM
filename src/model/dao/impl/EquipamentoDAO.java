package model.dao.impl;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dao.IEquipamentoDAO;
import model.domain.TipoExame;
import model.domain.Equipamento;

public class EquipamentoDAO implements IEquipamentoDAO {

    @Override
    public void inserir(Equipamento equipamento) throws ClassNotFoundException, Exception {
        Connection connection = ConnectionManager.getInstance().getConnection();
        
        String sql = "INSERT INTO equipamento (cod_tipoExame, nom_equipamento, idt_defeito) VALUES(?, ?, ?)";
        
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, equipamento.getCodigoTipoExame());
        pstmt.setString(2, equipamento.getNome());
        pstmt.setBoolean(3, equipamento.isDefeito());
        
        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    @Override
    public List<Equipamento> consultarPorTipoExame(TipoExame especialidade) throws ClassNotFoundException, Exception {
        List<Equipamento> equipamentos = new ArrayList<Equipamento>();

        Connection connection = ConnectionManager.getInstance().getConnection();

        String sql = "SELECT a.cod_equipamento, a.cod_tipoExame, a.nom_equipamento, a.idt_defeito FROM equipamento a JOIN tipoexame b ON a.cod_tipoExame = b.cod_tipoExame WHERE b.cod_tipoExame = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, especialidade.getCodigo());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Equipamento equipamento = new Equipamento();
            equipamento.setCodigoEquipamento(rs.getInt("cod_equipamento"));
            equipamento.setCodigoTipoExame(rs.getInt("cod_tipoExame"));
            equipamento.setNome(rs.getString("nom_equipamento"));
            equipamento.setDefeito(rs.getBoolean("idt_defeito"));
            
            equipamentos.add(equipamento);
        }
        
        rs.close();
        pstmt.close();
        connection.close();

        return equipamentos;
    }

}
