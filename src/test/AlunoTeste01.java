package test;

import model.Aluno;
import dao.AlunoDao;

public class AlunoTeste01 {

    public static void main(String[] args) {

        AlunoDao alunoDao = new AlunoDao();

        Aluno aluno = new Aluno();
        aluno.setMatricula(1);
        aluno.setNome("Jean Barcellos");

        // Insere no Banco de Dados
        alunoDao.insert(aluno);

        // Altera do Banco de Dados
        alunoDao.update(aluno);

        // Deleta do Banco de Dados
        alunoDao.delete(aluno);

        // Retorna um objeto específico
        alunoDao.getObject(1);

        // Retorna todos os objetos
        alunoDao.getAll();

    }

}
