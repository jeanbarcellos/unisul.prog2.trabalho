package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

            int retorno = ps.executeUpdate();

            return retorno == 1;

        } catch (SQLException ex) {
            // Gravar log
//            System.out.println("Mensagem: " + ex.getMessage());
//            System.out.println("Status: " + ex.getSQLState());
//            System.out.println("Código: " + ex.getErrorCode());
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
    public boolean update(int id, Curso curso) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("UPDATE curso SET nome = ? WHERE id = ? ;");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getId());

            int retorno = ps.executeUpdate();

            return retorno == 1;

        } catch (SQLException ex) {
            // Gravar log
//            System.out.println("Mensagem: " + ex.getMessage());
//            System.out.println("Status: " + ex.getSQLState());
//            System.out.println("Código: " + ex.getErrorCode());
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
    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("DELETE FROM curso WHERE id = ? ;");
            ps.setInt(1, id);

            int retorno = ps.executeUpdate();

            return retorno == 1;

        } catch (SQLException ex) {
            // Gravar log
//            System.out.println("Mensagem: " + ex.getMessage());
//            System.out.println("Status: " + ex.getSQLState());
//            System.out.println("Código: " + ex.getErrorCode());
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
    public Curso load(int id) {
        return null;
    }

    @Override
    public List<Curso> all() {
        List<Curso> cursos = new ArrayList<Curso>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("SELECT id, nome FROM curso ORDER BY id");
            rs = ps.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
            }

        } catch (SQLException ex) {
            // Gravar log
//            System.out.println("Mensagem: " + ex.getMessage());
//            System.out.println("Status: " + ex.getSQLState());
//            System.out.println("Código: " + ex.getErrorCode());
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

        return cursos;
    }
}
