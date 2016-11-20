package model.dao;

import util.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import util.Config;
import util.Log;

/**
 * Classe PostgresEmprestimoDao
 *
 * @author Jean Barcellos
 * @date 19/11/2016
 *
 * @package model.dao
 *
 */
public class PostgresEmprestimoDao implements EmprestimoDao {

    @Override
    public boolean insert(Emprestimo emprestimo) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            
            Config config = Config.getInstance();          
            int diasEmprestimo = Integer.parseInt(config.getValue("diasEmprestimo"));

            Date dataAgora = Data.sqlDataAtual();
            Date dataPrevisao = Data.sqlSomarDias(dataAgora, diasEmprestimo);

            String sql = "";
            sql += "INSERT INTO emprestimo ";
            sql += "(id, usuario_id, exemplar_id, data_emprestimo, data_devolucao_previsao, data_devolucao) ";
            sql += "VALUES (?, ?, ?, ?, ?, ?);";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, emprestimo.getId());
            ps.setInt(2, emprestimo.getUsuario().getId());
            ps.setInt(3, emprestimo.getExemplar().getId());
            ps.setDate(4, dataAgora);
            ps.setDate(5, dataPrevisao);
            ps.setDate(6, null);

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
    public boolean update(Emprestimo emprestimo) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("UPDATE emprestimo SET nome = ? WHERE id = ? ;");
//            ps.setString(1, emprestimo.getNome());
//            ps.setInt(2, emprestimo.getId());

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
    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("DELETE FROM emprestimo WHERE id = ? ;");
            ps.setInt(1, id);

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
    public Emprestimo load(int id) {
        return null;
    }

    @Override
    public List<Emprestimo> all() {
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("SELECT id, nome FROM emprestimo ORDER BY id");
            rs = ps.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));
//                emprestimo.setNome(rs.getString("nome"));
                emprestimos.add(emprestimo);
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

        return emprestimos;
    }

    @Override
    public int lastId() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int lastId = 0;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("SELECT MAX(id) AS last_id FROM emprestimo LIMIT 1");
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

    @Override
    public List<Emprestimo> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
