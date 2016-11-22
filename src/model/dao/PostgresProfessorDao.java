package model.dao;

import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import util.Log;

/**
 * Classe PostgresProfessorDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 15/11/2016
 *
 * @package model.dao
 *
 */
class PostgresProfessorDao implements ProfessorDao {

    @Override
    public boolean insert(Professor professor) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            Date dataAgora = new Date(System.currentTimeMillis());

            String sql1 = "";
            sql1 += "INSERT INTO usuario (id, nome, tipo, matricula, data_inicio, data_fim) ";
            sql1 += "VALUES (?, ?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, professor.getId());
            ps.setString(2, professor.getNome());
            ps.setInt(3, 2);
            ps.setInt(4, professor.getMatricula());
            ps.setDate(5, dataAgora);
            ps.setDate(6, null);

            int retorno1 = ps.executeUpdate();

//            ps2 = conn.prepareStatement("INSERT INTO professor (usuario_id, matricula, data_inicio, data_fim) VALUES (?, ?, ?, ?)");
//            ps2.setInt(1, professor.getId());
//            int retorno2 = ps2.executeUpdate();

//            return retorno1 == 1 && retorno2 == 1;
            return retorno1 == 1;

        } catch (SQLException ex) {
            Log.write(ex.getErrorCode() + " - " + ex.getMessage());
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
    public boolean update(Professor professor) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("UPDATE usuario SET nome = ?, matricula = ? WHERE id = ? ;");
            ps.setString(1, professor.getNome());
            ps.setInt(2, professor.getMatricula());
            ps.setInt(3, professor.getId());

            int retorno1 = ps.executeUpdate();

            return retorno1 == 1;

        } catch (SQLException ex) {
            Log.write(ex.getErrorCode() + " - " + ex.getMessage());
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

            ps = conn.prepareStatement("UPDATE usuario SET data_fim = ? WHERE id = ? ;");
            ps.setDate(1, new Date(System.currentTimeMillis()));
            ps.setInt(2, id);

            int retorno = ps.executeUpdate();

            return retorno == 1;

        } catch (SQLException ex) {
            Log.write(ex.getErrorCode() + " - " + ex.getMessage());
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
    public Professor load(int id) {
        Professor professor = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT u.id, u.nome, u.matricula ";
            sql += "  FROM professor p ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON p.usuario_id = u.id ";
            sql += " WHERE p.usuario_id = ? ";
            sql += " ORDER BY p.usuario_id DESC ";
            sql += " LIMIT 1 ;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setMatricula(rs.getInt("matricula"));
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

        return professor;
    }

    @Override
    public List<Professor> all() {
        List<Professor> professores = new ArrayList<Professor>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            String sql = "";

            sql += "SELECT u.id, u.nome, u.matricula ";
            sql += "FROM usuario u ";
            sql += "WHERE u.data_fim IS NULL ";
            sql += "ORDER BY u.id ASC";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setMatricula(rs.getInt("matricula"));
                professores.add(professor);
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
