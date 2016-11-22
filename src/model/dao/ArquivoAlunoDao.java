package model.dao;

import model.Aluno;

import java.util.ArrayList;
import java.util.List;

import util.PersistenciaArquivo;

/**
 * Classe ArquivoAlunoDao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 18/11/2016
 *
 * @package model.dao
 *
 */
class ArquivoAlunoDao implements AlunoDao {

    private List<Aluno> alunos = new ArrayList<Aluno>();
    private PersistenciaArquivo persistArquivo;

    public ArquivoAlunoDao() {
        this.persistArquivo = new PersistenciaArquivo("alunos.bin", "usuario_seq.txt");
        this.alunos = this.all();
    }

    @Override
    public boolean insert(Aluno aluno) {

        // Adicionar a lista temporária local
        this.alunos.add(aluno);

        // Serializar arquivo
        this.persistArquivo.serializar(this.alunos);

        // Sequenciar arquivo
        this.persistArquivo.sequenciar();

        return true;
    }

    @Override
    public boolean update(Aluno aluno) {

        Aluno alunoRef = this.load(aluno.getId());

        if (alunoRef != null) {

            // Altera somente o nome
            alunoRef.setNome(aluno.getNome());

            // Persistir
            this.persistArquivo.serializar(this.alunos);

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        Aluno alunoRef = this.load(id);

        if (alunoRef != null) {

            // Remover a lista
            this.alunos.remove(alunoRef);

            // Persistir
            this.persistArquivo.serializar(this.alunos);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Aluno load(int id) {
        Aluno retorno = null;
        for (Aluno alunoExt : alunos) {
            if (alunoExt.getId() == id) {
                retorno = alunoExt;
            }
        }
        return retorno;
    }

    @Override
    public List<Aluno> all() {
        return this.persistArquivo.deserializar();
    }

    @Override
    public int lastId() {
        return this.persistArquivo.getLastId();
    }

    @Override
    public List<Aluno> buscarPeloNome(String nome) {
        List<Aluno> lista = new ArrayList<Aluno>();

        for (Aluno aluno : this.alunos) {
            System.out.println(aluno);
            if (aluno.getNome().equals(nome)) {
                lista.add(aluno);
            }
        }
        return lista;
    }

    @Override
    public List<Aluno> buscarPelaMatricula(int matricula) {
        List<Aluno> lista = new ArrayList<Aluno>();

        for (Aluno aluno : this.alunos) {
            if (aluno.getMatricula() == matricula) {
                lista.add(aluno);
            }
        }
        return lista;
    }

}
