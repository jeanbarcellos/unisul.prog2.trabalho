package model;

import java.io.Serializable;

/**
 * Modelo Exemplar
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 07/09/2016
 *
 * @package model
 *
 */
public class Exemplar implements Serializable {

    private static final long serialVersionUID = 1053690196859830776L;

    private int id;
    private Livro livro;
    private String edicao;
    private String localizacao;

    public Exemplar() {
    }

    public Exemplar(int id, String edicao, String localizacao) {
        this.id = id;
        this.edicao = edicao;
        this.localizacao = localizacao;
    }

    public Exemplar(int id, Livro livro, String edicao, String localizacao) {
        this.id = id;
        this.livro = livro;
        this.edicao = edicao;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Exemplar{" + "id=" + id + ", livroId=" + livro + ", edicao=" + edicao + ", localizacao=" + localizacao + "}\n";
    }

}
