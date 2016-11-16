package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Exemplar;
import utils.Log;

/**
 * Classe PostgresExemplarDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 02/11/2016
 *
 * @package model.dao
 *
 */
public class PostgresExemplarDao implements ExemplarDao {

    @Override
    public boolean insert(Exemplar exemplar) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = PostgresDaoFactory.openConnection();

            Timestamp dataAgora = new Timestamp(System.currentTimeMillis());

            ps = conn.prepareStatement("INSERT INTO exemplar (id, livro_id, localizacao, edicao, data_cadastro, data_exclusao) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, exemplar.getId());
            ps.setInt(2, exemplar.getLivroId());
            ps.setString(3, exemplar.getLocalizacao());
            ps.setString(4, exemplar.getEdicao());
            ps.setTimestamp(5, dataAgora);
            ps.setTimestamp(6, null);

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
    public boolean update(Exemplar exemplar) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("UPDATE exemplar SET localizacao = ?, edicao = ?  WHERE id = ? ;");
            ps.setString(1, exemplar.getLocalizacao());
            ps.setString(2, exemplar.getEdicao());
            ps.setInt(3, exemplar.getId());

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

            ps = conn.prepareStatement("UPDATE exemplar SET data_exclusao = ? WHERE id = ? ;");
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
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
    public Exemplar load(int id) {
        Exemplar exemplar = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            String sql = "";

            sql += "SELECT id, livro_id, localizacao, edicao ";
            sql += "FROM exemplar ";
            sql += "WHERE id = ? ";
//            sql += "AND data_exclusao IS NULL ";
            sql += "LIMIT 1;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            rs.next();
            
            exemplar = new Exemplar();
            exemplar.setId(rs.getInt("id"));
            exemplar.setLivroId(rs.getInt("livro_id"));
            exemplar.setLocalizacao(rs.getString("localizacao"));
            exemplar.setEdicao(rs.getString("edicao"));            

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

        return exemplar;
    }

    @Override
    public List<Exemplar> all() {
        List<Exemplar> exemplares = new ArrayList<Exemplar>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            String sql = "";

            sql += "SELECT id, livro_id, localizacao, edicao ";
            sql += "FROM exemplar ";
            sql += "WHERE data_exclusao IS NULL ";
            sql += "ORDER BY id ASC";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Exemplar exemplar = new Exemplar();
                exemplar.setId(rs.getInt("id"));
                exemplar.setLivroId(rs.getInt("livro_id"));
                exemplar.setLocalizacao(rs.getString("localizacao"));
                exemplar.setEdicao(rs.getString("edicao"));
                exemplares.add(exemplar);
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

        return exemplares;
    }

    @Override
    public int lastId() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int lastId = 0;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("SELECT MAX(id) AS last_id FROM exemplar LIMIT 1");
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
    public int total(int livroId) {
        int total = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            String sql = "";

            sql += "SELECT COUNT(*) AS total ";
            sql += "FROM exemplar ";
            sql += "WHERE livro_id = ? ";
            sql += "AND data_exclusao IS NULL;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, livroId);

            rs = ps.executeQuery();

            while (rs.next()) {
                total = rs.getInt("total");
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

        return total;
    }

    @Override
    public List<Exemplar> listar(int livroId) {
        List<Exemplar> exemplares = new ArrayList<Exemplar>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            
            String sql = "";
            sql += "SELECT id, livro_id, localizacao, edicao ";
            sql += "FROM exemplar ";
            sql += "WHERE livro_id = ? ";
            sql += "AND data_exclusao IS NULL ";
            sql += "ORDER BY id ASC;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, livroId);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Exemplar exemplar = new Exemplar();
                exemplar.setId(rs.getInt("id"));
//                exemplar.setLivroId(rs.getInt("livro_id"));
                exemplar.setLocalizacao(rs.getString("localizacao"));
                exemplar.setEdicao(rs.getString("edicao"));
                exemplares.add(exemplar);
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

        return exemplares;
    }

    
}
