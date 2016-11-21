package model.dao;

import model.Aluno;
import model.Curso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Log;

/**
 * Classe PostgresAlunoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 16/11/2016
 *
 * @package model.dao
 *
 */
public class PostgresAlunoDao implements AlunoDao {

    @Override
    public boolean insert(Aluno aluno) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            Date dataAgora = new Date(System.currentTimeMillis());

            ps = conn.prepareStatement("INSERT INTO usuario (id, nome, tipo) VALUES (?, ?, ?)");
            ps.setInt(1, aluno.getId());
            ps.setString(2, aluno.getNome());
            ps.setInt(3, 1);

            int retorno1 = ps.executeUpdate();

            ps2 = conn.prepareStatement("INSERT INTO aluno (usuario_id, curso_id, matricula, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)");
            ps2.setInt(1, aluno.getId());
            ps2.setInt(2, aluno.getCurso().getId());
            ps2.setInt(3, aluno.getMatricula());
            ps2.setDate(4, dataAgora);
            ps2.setDate(5, null);

            int retorno2 = ps2.executeUpdate();

            return retorno1 == 1 && retorno2 == 1;

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
    public boolean update(Aluno aluno) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("UPDATE usuario SET nome = ? WHERE id = ? ;");
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getId());

            int retorno1 = ps.executeUpdate();

            ps2 = conn.prepareStatement("UPDATE aluno SET matricula = ?, curso_id = ? WHERE usuario_id = ? ;");
            ps2.setInt(1, aluno.getMatricula());
            ps2.setInt(2, aluno.getCurso().getId());
            ps2.setInt(3, aluno.getId());

            int retorno2 = ps2.executeUpdate();

            return retorno1 == 1 && retorno2 == 1;

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

            ps = conn.prepareStatement("UPDATE aluno SET data_fim = ? WHERE usuario_id = ? ;");
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
    public Aluno load(int id) {
        Aluno aluno = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT ";
            sql += "    a.usuario_id AS id, ";
            sql += "    u.nome, ";
            sql += "    a.matricula, ";
            sql += "    a.curso_id, ";
            sql += "      c.nome AS curso_nome ";
            sql += "  FROM aluno a ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON a.usuario_id = u.id ";
            sql += "  LEFT JOIN curso c ";
            sql += "    ON a.curso_id = c.id ";
            sql += " WHERE a.usuario_id = ? ";
            sql += " ORDER BY a.usuario_id DESC ";
            sql += " LIMIT 1 ;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setCurso(new Curso(rs.getInt("curso_id"), rs.getString("curso_nome")));
                aluno.setNome(rs.getString("nome"));
                aluno.setMatricula(rs.getInt("matricula"));
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

        return aluno;
    }

    @Override
    public List<Aluno> all() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT ";
            sql += "    a.usuario_id AS id, ";
            sql += "    u.nome, ";
            sql += "    a.matricula, ";
            sql += "    a.curso_id, ";
            sql += "      c.nome AS curso_nome ";
            sql += "  FROM aluno a ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON a.usuario_id = u.id ";
            sql += "  LEFT JOIN curso c ";
            sql += "    ON a.curso_id = c.id ";
            sql += " WHERE a.data_fim IS NULL ";
            sql += " ORDER BY a.usuario_id ASC ;";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setCurso(new Curso(rs.getInt("curso_id"), rs.getString("curso_nome")));
                aluno.setNome(rs.getString("nome"));
                aluno.setMatricula(rs.getInt("matricula"));
                alunos.add(aluno);
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

        return alunos;
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

    @Override
    public List<Aluno> buscarPeloNome(String nome) {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT ";
            sql += "    a.usuario_id AS id, ";
            sql += "    u.nome, ";
            sql += "    a.matricula, ";
            sql += "    a.curso_id, ";
            sql += "      c.nome AS curso_nome ";
            sql += "  FROM aluno a ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON a.usuario_id = u.id ";
            sql += "  LEFT JOIN curso c ";
            sql += "    ON a.curso_id = c.id ";
            sql += " WHERE a.data_fim IS NULL ";
            sql += "   AND u.nome LIKE ?";
            sql += " ORDER BY a.usuario_id ASC ;";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setCurso(new Curso(rs.getInt("curso_id"), rs.getString("curso_nome")));
                aluno.setNome(rs.getString("nome"));
                aluno.setMatricula(rs.getInt("matricula"));
                alunos.add(aluno);
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

        return alunos;
    }

    @Override
    public List<Aluno> buscarPelaMatricula(int matricula) {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT ";
            sql += "    a.usuario_id AS id, ";
            sql += "    u.nome, ";
            sql += "    a.matricula, ";
            sql += "    a.curso_id, ";
            sql += "      c.nome AS curso_nome ";
            sql += "  FROM aluno a ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON a.usuario_id = u.id ";
            sql += "  LEFT JOIN curso c ";
            sql += "    ON a.curso_id = c.id ";
            sql += " WHERE a.data_fim IS NULL ";
            sql += "   AND a.matricula = ?";
            sql += " ORDER BY a.usuario_id ASC ;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, matricula);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setCurso(new Curso(rs.getInt("curso_id"), rs.getString("curso_nome")));
                aluno.setNome(rs.getString("nome"));
                aluno.setMatricula(rs.getInt("matricula"));
                alunos.add(aluno);
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

        return alunos;
    }

}
