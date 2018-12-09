/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.domain.TipoExame;
import model.dao.ITipoExameDAO;

/**
 *
 * @author franc
 */
public class TipoExameDAO implements ITipoExameDAO {

    @Override
    public List<TipoExame> listarTiposExame() throws ClassNotFoundException, Exception {
        List<TipoExame> tipoExames = new ArrayList<>();

        Connection connection = ConnectionManager.getInstance().getConnection();

        String sql = "SELECT a.cod_tipoExame, a.nom_tipoExame FROM tipoexame a";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            TipoExame tipoExame = new TipoExame();
            tipoExame.setCodigo(rs.getInt("cod_tipoExame"));
            tipoExame.setNome(rs.getString("nom_tipoExame"));
            
            tipoExames.add(tipoExame);
        }
        
        rs.close();
        pstmt.close();
        connection.close();

        return tipoExames;
    }
    
}
