package src.model.dao.impl;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.domain.Especialidade;
import model.dao.ITipoEspecialidadeDAO;


public class EspecialidadeDAO implements IEspecialidadeDAO {

    @Override
    public List<Especialidade> listarEspecialidade() throws ClassNotFoundException, Exception {
        List<Especialidade> especialidades = new ArrayList<>();

        Connection connection = ConnectionManager.getInstance().getConnection();

        String sql = "SELECT a.cod_especialidade, a.nom_especialidade FROM especialidade a";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Especialidade especialidade = new Especialidade();
            especialidade.setCodigo(rs.getInt("cod_especialidade"));
            especialidade.setNome(rs.getString("nom_especialidade"));
            
            especialidades.add(especialidade);
        }
        
        rs.close();
        pstmt.close();
        connection.close();

        return especialidades;
    }
    
}
