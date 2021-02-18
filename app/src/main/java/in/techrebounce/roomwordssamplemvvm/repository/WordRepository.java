package in.techrebounce.roomwordssamplemvvm.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import in.techrebounce.roomwordssamplemvvm.db.Word;
import in.techrebounce.roomwordssamplemvvm.db.WordDao;
import in.techrebounce.roomwordssamplemvvm.db.WordRoomDataBase;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    WordRepository(Application application) {
        WordRoomDataBase db = WordRoomDataBase.getDataBase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Word word) {
        WordRoomDataBase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
