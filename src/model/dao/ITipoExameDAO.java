/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.TipoExame;

/**
 *
 * @author franc
 */
public interface ITipoExameDAO {
    public List<TipoExame> listarTiposExame() throws ClassNotFoundException, Exception;
}
