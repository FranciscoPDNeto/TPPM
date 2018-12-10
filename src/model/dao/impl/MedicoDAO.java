package model.dao.impl;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dao.IMedicoDAO;
import model.domain.Especialidade;
import model.domain.Medico;

public class MedicoDAO implements IMedicoDAO {

    @Override
    public void inserir(Medico medico) throws ClassNotFoundException, Exception {
        Connection connection = ConnectionManager.getInstance().getConnection();
        
        String sql = "INSERT INTO medico (cod_crm, cod_cpf, nome_medico, num_telefone, des_email, hora_inicial1, hora_inicial2, hora_inicial3, hora_intervalo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, medico.getCrm());
        pstmt.setString(2, medico.getCpf());
        pstmt.setString(3, medico.getNome());
        pstmt.setLong(4, medico.getTelefone());
        pstmt.setString(5, medico.getEmail());
        pstmt.setDate(6, medico.getHora1());
        pstmt.setDate(7, medico.getHora2());
        pstmt.setDate(8, medico.getHora3());
        pstmt.setDate(9, medico.getHoraIntervalo());
        
        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    @Override
    public Medico consultarPorCpf(String cpf) throws ClassNotFoundException, Exception {
        Medico medico = null;
        Connection connection = ConnectionManager.getInstance().getConnection();
        
        String sql = "SELECT * FROM medico WHERE cod_cpf = ?";
        
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, cpf);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            medico = new Medico();
            medico.setCrm(rs.getInt("cod_crm"));
            medico.setCpf(cpf);
            medico.setNome(rs.getString("nom_medico"));
            medico.setTelefone(rs.getLong("num_telefone"));
            medico.setEmail(rs.getString("des_email"));
            medico.setHora1(rs.getDate("hora_inicial1"));
            medico.setHora2(rs.getDate("hora_inicial2"));
            medico.setHora3(rs.getDate("hora_inicial3"));
            medico.setHoraIntervalo(rs.getDate("hora_intervalo"));
        }
        
        rs.close();
        pstmt.close();
        connection.close();
        
        return medico;
    }

    @Override
    public List<Medico> consultarPorEspecialidade(Especialidade especialidade) throws ClassNotFoundException, Exception {
        List<Medico> medicos = new ArrayList<Medico>();

        Connection connection = ConnectionManager.getInstance().getConnection();

        String sql = "SELECT a.cod_cpf, a.cod_crm, a.nom_medico, a.num_telefone, a.des_email, a.hora_inicial1, a.hora_inicial2, a.hora_inicial3, a.hora_intervalo FROM medico a JOIN medicoespecialidade b ON a.cod_cpf = b.cod_cpf WHERE b.cod_especialidade = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, especialidade.getCodigo());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setCrm(rs.getInt("cod_crm"));
            medico.setCpf(rs.getString("cod_cpf"));
            medico.setNome(rs.getString("nom_medico"));
            medico.setTelefone(rs.getLong("num_telefone"));
            medico.setEmail(rs.getString("des_email"));
            medico.setHora1(rs.getDate("hora_inicial1"));
            medico.setHora2(rs.getDate("hora_inicial2"));
            medico.setHora3(rs.getDate("hora_inicial3"));
            medico.setHoraIntervalo(rs.getDate("hora_intervalo"));
            medicos.add(medico);
        }
        
        rs.close();
        pstmt.close();
        connection.close();

        return medicos;
    }
    
    @Override
    public Medico consultarPorNome(String nome) throws ClassNotFoundException, Exception {
        Medico medico = null;
        Connection connection = ConnectionManager.getInstance().getConnection();
        
        String sql = "SELECT * FROM medico WHERE nom_medico = ?";
        
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, nome);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            medico = new Medico();
            medico.setCrm(rs.getInt("cod_crm"));
            medico.setCpf(rs.getString("cod_cpf"));
            medico.setNome(nome);
            medico.setTelefone(rs.getLong("num_telefone"));
            medico.setEmail(rs.getString("des_email"));
            medico.setHora1(rs.getDate("hora_inicial1"));
            medico.setHora2(rs.getDate("hora_inicial2"));
            medico.setHora3(rs.getDate("hora_inicial3"));
            medico.setHoraIntervalo(rs.getDate("hora_intervalo"));
        }
        
        rs.close();
        pstmt.close();
        connection.close();
        
        return medico;
    }

}
