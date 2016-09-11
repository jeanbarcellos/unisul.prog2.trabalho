package dao;

import model.Aluno;

/**
 * Classe AlunoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package dao
 *
 */
public class AlunoDao extends Dao {

    public void insert(Aluno obj) {

        String sql;
        sql = "INSERT aluno";
        sql += " (matricula, nome)";
        sql += " VALUE (";
        sql += "'" + obj.getMatricula() + "', ";
        sql += "'" + obj.getNome() + "'";
        sql += ");";

        System.out.println(sql);
    }

    public void update(Aluno obj) {

        String sql;
        sql = "UPDATE aluno";
        sql += " SET";
        sql += " nome = '" + obj.getNome() + "'";
        sql += " WHERE ";
        sql += " matricula='" + obj.getMatricula() + "'";
        sql += ";";

        System.out.println(sql);
    }

    public void delete(Aluno obj) {

        String sql;
        sql = "DELETE FROM aluno";
        sql += " nome = '" + obj.getNome() + "'";
        sql += " WHERE ";
        sql += " matricula='" + obj.getMatricula() + "'";
        sql += ";";

        System.out.println(sql);
    }

    public void getObject(int id) {

        String sql;
        sql = "SELECT * FROM aluno";
        sql += " WHERE ";
        sql += " matricula='" + id + "'";
        sql += ";";

        System.out.println(sql);
    }

    public void getAll() {

        String sql;
        sql = "SELECT * FROM aluno";
        sql += ";";

        System.out.println(sql);
    }

}

