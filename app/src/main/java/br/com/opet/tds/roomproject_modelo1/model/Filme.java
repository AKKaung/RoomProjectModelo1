package br.com.opet.tds.roomproject_modelo1.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Diego on 24/09/2018.
 */
@Entity(tableName = "filme_table")
public class Filme {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String titulo;
    private String genero;
    private int ano_producao;
    private int avaliacao;

    public Filme() {
    }

    public Filme(long id, String titulo, String genero, int ano_producao, int avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano_producao = ano_producao;
        this.avaliacao = avaliacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno_producao() {
        return ano_producao;
    }

    public void setAno_producao(int ano_producao) {
        this.ano_producao = ano_producao;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}
