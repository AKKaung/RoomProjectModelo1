package br.com.opet.tds.roomproject_modelo1.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.opet.tds.roomproject_modelo1.DAO.FilmeDAO;
import br.com.opet.tds.roomproject_modelo1.database.FilmeRoomDatabase;
import br.com.opet.tds.roomproject_modelo1.model.Filme;

/**
 * Created by Diego on 24/09/2018.
 */

public class FilmeRepository {
    private FilmeDAO mFilmeDAO;
    private List<Filme> mFilmes;

    public FilmeRepository(Context context){
        FilmeRoomDatabase db = FilmeRoomDatabase.getDatabase(context);
        mFilmeDAO = db.filmeDAO();
        mFilmes = mFilmeDAO.loadFilmes();
    }

    public List<Filme> getAllFilmes(){
        return mFilmes;
    }

    public void insert(Filme filme){
        new insertAsyncTask(mFilmeDAO).execute(filme);
    }

    private static class insertAsyncTask extends AsyncTask<Filme,Void,Void>{

        private FilmeDAO mAsyncTaskDAO;

        insertAsyncTask(FilmeDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Filme... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
