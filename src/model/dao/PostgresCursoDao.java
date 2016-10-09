package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Curso;

/**
 * Classe PostgresCursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 09/10/2016
 *
 * @package model.dao
 *
 */
public class PostgresCursoDao implements CursoDao {

    @Override
    public boolean insert(Curso curso) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("INSERT INTO curso (id, nome) VALUES (?, ?)");
            ps.setInt(1, curso.getId());
            ps.setString(2, curso.getNome());

            return ps.execute();

        } catch (SQLException ex) {
            System.out.println("Mensagem: " + ex.getMessage()); // SQLException
            System.out.println("Status: " + ex.getSQLState()); // SQLState
            System.out.println("Código: " + ex.getErrorCode()); // VendorError
            return false;
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

    @Override
    public boolean update(String id, Curso curso) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Curso load(int id) {
        return null;
    }

    @Override
    public void listar() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("SELECT id, nome FROM curso ORDER BY id");

            rs = ps.executeQuery();

            while (rs.next()) {
                int idCurso = rs.getInt("id");
                String nomeCurso = rs.getString("nome");

                System.out.println("ID: " + idCurso + " - nome: " + nomeCurso);
            }

        } catch (SQLException ex) {
            System.out.println("Mensagem: " + ex.getMessage()); // SQLException
            System.out.println("Status: " + ex.getSQLState()); // SQLState
            System.out.println("Código: " + ex.getErrorCode()); // VendorError
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
    }

}
