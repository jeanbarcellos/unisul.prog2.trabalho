/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.dao.PostgresDaoFactory;
import util.Config;
import util.Data;

/**
 *
 * @author Jean Barcellos
 */
public class InserData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            Config config = Config.getInstance();

            int diasEmprestimo = Integer.parseInt(config.getValue("diasEmprestimo"));           

            Date dataAgora = Data.sqlDataAtual();
//            Date dataPrevisao = new Data().sqlSomarDias(dataAgora, 15);
            Date dataPrevisao = new Date(dataAgora.getTime() + (8640000 * diasEmprestimo));

            String sql = "";
            sql += "INSERT INTO emprestimo ";
            sql += "(id, usuario_id, exemplar_id, data_emprestimo, data_devolucao_previsao, data_devolucao) ";
            sql += "VALUES (?, ?, ?, ?, ?, ?);";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setInt(2, 3);
            ps.setInt(3, 13);
            ps.setDate(4, dataAgora);
            ps.setDate(5, dataPrevisao);
            ps.setDate(6, null);
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }

    }

}
