package com.gqdostark.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    /**
     * - Classe responsavel por abstrair o acesso as diversas fonte de dados
     * - Lida com operações de dados, fornecendo uma API limpa para o restante
     * da aplicação para os dados da mesma
     * - Gerencia tópicos de consulta e permite usar vários abck-ends
     * */

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    /* Construtor que obtem identificado para o BD e inicializa as variáveis*/
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
//        mAllWords = mWordDao.getAllWords();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
