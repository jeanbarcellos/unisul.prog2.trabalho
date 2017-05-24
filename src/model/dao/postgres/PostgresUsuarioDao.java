package model.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.dao.PostgresDaoFactory;
import model.dao.UsuarioDao;
import util.Log;

/**
 * Classe PostgresUsuarioDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 17/11/2016
 *
 * @package model.dao
 *
 */
public class PostgresUsuarioDao implements UsuarioDao {

    public PostgresUsuarioDao() {
    }

    @Override
    public Usuario load(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> all() {
        List<Usuario> professores = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            String sql = "";

            sql += "SELECT p.usuario_id AS id, u.nome, p.matricula ";
            sql += "FROM professor p ";
            sql += "LEFT JOIN usuario u ";
            sql += "ON p.usuario_id = u.id ";
            sql += "WHERE p.data_fim IS NULL ";
            sql += "ORDER BY p.usuario_id ASC";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
//                Usuario professor = new Usuario();
//                professor.setId(rs.getInt("id"));
//                professor.setNome(rs.getString("nome"));
//                professor.setMatricula(rs.getInt("matricula"));
//                professores.add(professor);
            }

        } catch (SQLException ex) {
            Log.write(ex.getErrorCode() + " - " + ex.getMessage());
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

        return professores;
    }

    @Override
    public int lastId() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int lastId = 0;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("SELECT MAX(id) AS last_id FROM usuario LIMIT 1");
            rs = ps.executeQuery();

            while (rs.next()) {
                lastId = rs.getInt("last_id");
            }

        } catch (SQLException ex) {
            Log.write(ex.getErrorCode() + " - " + ex.getMessage());
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

        return lastId;
    }

}
