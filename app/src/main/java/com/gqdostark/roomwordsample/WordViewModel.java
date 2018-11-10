package com.gqdostark.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    /**
     * Fornece dados para a interface do usuário.
     * Atua como centro de comunicação entre o Repositório e a interface do usuário.
     * É possivél usa-lo para compatilhar dados entre fragmentos.
     * Repositorio e a interface do usuário são complementamente separados
     * não há chamadas de banco de dados aqui no ViewModel.
     */

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);

        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

/**
 * Aviso: nunca passe o contexto para ViewModelinstâncias. Não armazene Activity,
 * Fragmentou Viewinstale ou seus Contextno ViewModel.     *
 * Por exemplo, um Activitypode ser destruído e criado muitas vezes durante o ciclo de vida de
 * um ViewModelconforme o dispositivo é girado. Se você armazena uma referência ao Activityno
 * ViewModel, você acaba com referências que apontam para o destruído Activity. Isso é
 * um vazamento de memória.
 *
 * Se você precisar do contexto do aplicativo, use AndroidViewModel, conforme mostrado
 * neste codelab
 *
 * */
}

