package model.dao.postgre;

import util.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Emprestimo;
import model.Exemplar;
import model.Livro;
import model.Professor;
import model.Usuario;
import model.dao.EmprestimoDao;
import model.dao.PostgresDaoFactory;
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

            Date dataAgora = Data.setDataSql(emprestimo.getDataEmprestimo());
            Date dataPrevisao = Data.setDataSql(emprestimo.getDataDevolucaoPrevista());

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
    public boolean emprestar(Emprestimo emprestimo) {
        return this.insert(emprestimo);
    }

    @Override
    public boolean devolver(int emprestimoId, java.util.Date dataDevolucao) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PostgresDaoFactory.openConnection();
            
            Date dataAgora = Data.setDataSql(dataDevolucao);

            ps = conn.prepareStatement("UPDATE emprestimo SET data_devolucao = ? WHERE id = ? ;");
            ps.setDate(1, dataAgora);
            ps.setInt(2, emprestimoId);

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

            String sql = "";
            sql += " SELECT ";
            sql += "   em.id, ";
            sql += "   em.usuario_id, ";
            sql += "     u.tipo AS usuario_tipo, ";
            sql += "     u.nome AS usuario_nome, ";
            sql += "     u.matricula AS usuario_matricula, ";
            sql += "   em.exemplar_id, ";
            sql += "     l.id AS livro_id, ";
            sql += "     l.titulo AS livro_titulo, ";
            sql += "     l.autor AS livro_autor, ";
            sql += "     ex.edicao As exemplar_edicao, ";
            sql += "     ex.localizacao AS exemplar_localizacao, ";
            sql += "   em.data_emprestimo, ";
            sql += "   em.data_devolucao_previsao, ";
            sql += "   em.data_devolucao ";
            sql += "  FROM emprestimo em ";
            sql += "  LEFT JOIN exemplar ex ";
            sql += "    ON em.exemplar_id = ex.id ";
            sql += "  LEFT JOIN livro l ";
            sql += "    ON ex.livro_id = l.id ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON em.usuario_id = u.id ";
            sql += "   AND data_devolucao IS NULL";
            sql += " WHERE em.data_devolucao IS NULL";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Monta o livro
                Livro livro = new Livro();
                livro.setId(rs.getInt("livro_id"));
                livro.setTitulo(rs.getString("livro_titulo"));
                livro.setAutor(rs.getString("livro_autor"));

                // Monta o exemplar
                Exemplar exemplar = new Exemplar();
                exemplar.setId(rs.getInt("exemplar_id"));
                exemplar.setLivro(livro);
                exemplar.setEdicao(rs.getString("exemplar_edicao"));
                exemplar.setLocalizacao(rs.getString("exemplar_localizacao"));

                int tipo = rs.getInt("usuario_tipo");

                Usuario usuario;

                if (tipo == 1) {
                    usuario = new Aluno();
                    usuario.setId(rs.getInt("usuario_id"));
                    usuario.setNome(rs.getString("usuario_nome"));
                    usuario.setMatricula(rs.getInt("usuario_matricula"));
                } else {
                    usuario = new Professor();
                    usuario.setId(rs.getInt("usuario_id"));
                    usuario.setNome(rs.getString("usuario_nome"));
                    usuario.setMatricula(rs.getInt("usuario_matricula"));
                }

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));
                emprestimo.setExemplar(exemplar);
                emprestimo.setUsuario(usuario);
                emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
                emprestimo.setDataDevolucaoPrevista(rs.getDate("data_devolucao_previsao"));
                emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));

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
    public List<Emprestimo> getEmprestimosPorUsuario(int usuarioId) {
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PostgresDaoFactory.openConnection();

            String sql = "";
            sql += " SELECT ";
            sql += "   em.id, ";
            sql += "   em.usuario_id, ";
            sql += "     u.tipo AS usuario_tipo, ";
            sql += "     u.nome AS usuario_nome, ";
            sql += "     u.matricula AS usuario_matricula, ";
            sql += "   em.exemplar_id, ";
            sql += "     l.id AS livro_id, ";
            sql += "     l.titulo AS livro_titulo, ";
            sql += "     l.autor AS livro_autor, ";
            sql += "     ex.edicao As exemplar_edicao, ";
            sql += "     ex.localizacao AS exemplar_localizacao, ";
            sql += "   em.data_emprestimo, ";
            sql += "   em.data_devolucao_previsao, ";
            sql += "   em.data_devolucao ";
            sql += "  FROM emprestimo em ";
            sql += "  LEFT JOIN exemplar ex ";
            sql += "    ON em.exemplar_id = ex.id ";
            sql += "  LEFT JOIN livro l ";
            sql += "    ON ex.livro_id = l.id ";
            sql += "  LEFT JOIN usuario u ";
            sql += "    ON em.usuario_id = u.id ";
            sql += " WHERE em.usuario_id = ?";
            sql += "   AND data_devolucao IS NULL";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, usuarioId);

            rs = ps.executeQuery();

            while (rs.next()) {
                // Monta o livro
                Livro livro = new Livro();
                livro.setId(rs.getInt("livro_id"));
                livro.setTitulo(rs.getString("livro_titulo"));
                livro.setAutor(rs.getString("livro_autor"));

                // Monta o exemplar
                Exemplar exemplar = new Exemplar();
                exemplar.setId(rs.getInt("exemplar_id"));
                exemplar.setLivro(livro);
                exemplar.setEdicao(rs.getString("exemplar_edicao"));
                exemplar.setLocalizacao(rs.getString("exemplar_localizacao"));

                int tipo = rs.getInt("usuario_tipo");

                Usuario usuario;
                if (tipo == 1) {
                    usuario = new Aluno();
                    usuario.setId(rs.getInt("usuario_id"));
                    usuario.setNome(rs.getString("usuario_nome"));
                    usuario.setMatricula(rs.getInt("usuario_matricula"));
                } else {
                    usuario = new Professor();
                    usuario.setId(rs.getInt("usuario_id"));
                    usuario.setNome(rs.getString("usuario_nome"));
                    usuario.setMatricula(rs.getInt("usuario_matricula"));
                }

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));
                emprestimo.setExemplar(exemplar);
                emprestimo.setUsuario(usuario);
                emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
                emprestimo.setDataDevolucaoPrevista(rs.getDate("data_devolucao_previsao"));
                emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));

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

}
