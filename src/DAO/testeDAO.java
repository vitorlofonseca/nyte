/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author vitorlofonseca
 */
public class testeDAO {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Connection conn = Connect.conectar();
        ItemDAO.getItemPorNome(conn, "Arco oBathame");
    }
}
