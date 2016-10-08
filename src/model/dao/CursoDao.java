package model.dao;

import model.Curso;

/**
 * Classe CursoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 10/09/2016
 *
 * @package dao
 *
 */
public class CursoDao extends Dao {

    public void insert(Curso obj) {

        String sql;
        sql = "INSERT aluno";
        sql += " (matricula, nome)";
        sql += " VALUE (";
        sql += "'" + obj.getNome() + "'";
        sql += ");";

        System.out.println(sql);
    }

    public void update(Curso obj) {

        String sql;
        sql = "UPDATE aluno";
        sql += " SET";
        sql += " nome = '" + obj.getNome() + "'";
        sql += " WHERE ";
        sql += " id='" + obj.getId() + "'";
        sql += ";";

        System.out.println(sql);
    }

    public void delete(Curso obj) {

        String sql;
        sql = "DELETE FROM aluno";
        sql += " nome = '" + obj.getNome() + "'";
        sql += " WHERE ";
        sql += " matricula='" + obj.getId() + "'";
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
        sql = "SELECT * FROM aluno;";

        System.out.println(sql);
    }

}
