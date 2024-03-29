package model.dao.postgres;

import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.dao.PostgresDaoFactory;
import model.dao.ProfessorDao;
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
public class PostgresProfessorDao implements ProfessorDao {

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
            sql += "  FROM usuario u ";
            sql += " WHERE u.id = ? ";
            sql += "   AND u.tipo = 2 ";
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
            sql += "  AND u.tipo = 2 ";
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

    
    @Override
    public List<Curso> getCursos(int idProfessor) {
        List<Curso> cursos = new ArrayList<Curso>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            String sql = "";

            sql += "SELECT c.id, c.nome ";
            sql += "  FROM curso c ";
            sql += "  LEFT JOIN professor_curso pc ";
            sql += "    ON c.id = pc.curso_id ";
            sql += " WHERE pc.professor_id = ? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProfessor);

            rs = ps.executeQuery();
            
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
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

        return cursos;
    }

    @Override
    public boolean addCurso(int idProfessor, Curso curso){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("INSERT INTO professor_curso (professor_id, curso_id) VALUES (?, ?)");            
            ps.setInt(1, idProfessor);
            ps.setInt(2, curso.getId());

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
    public boolean delCurso(int idProfessor, int idCurso) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            ps = conn.prepareStatement("DELETE FROM professor_curso WHERE professor_id = ? AND curso_id = ?;");
            ps.setInt(1, idProfessor);
            ps.setInt(2, idCurso);

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
    public List<Professor> buscarPeloNome(String nome) {
        List<Professor> professores = new ArrayList<Professor>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT ";
            sql += "    u.id, ";
            sql += "    u.nome, ";
            sql += "    u.matricula ";
            sql += "  FROM usuario u ";
            sql += " WHERE u.data_fim IS NULL ";
            sql += "   AND u.tipo = 2 ";
            sql += "   AND u.nome LIKE ?";
            sql += " ORDER BY u.id ASC ;";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");

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
    public List<Professor> buscarPelaMatricula(int matricula) {
        List<Professor> professores = new ArrayList<Professor>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += "SELECT ";
            sql += "    u.id, ";
            sql += "    u.nome, ";
            sql += "    u.matricula ";
            sql += "  FROM usuario u ";
            sql += " WHERE u.data_fim IS NULL ";
            sql += "   AND u.tipo = 2 ";
            sql += "   AND u.matricula = ?";
            sql += " ORDER BY u.id ASC ;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, matricula);

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

}
