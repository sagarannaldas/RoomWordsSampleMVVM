package in.techrebounce.roomwordssamplemvvm.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import in.techrebounce.roomwordssamplemvvm.db.Word;
import in.techrebounce.roomwordssamplemvvm.repository.WordRepository;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;

    private final LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mWordRepository.insert(word);
    }

}
