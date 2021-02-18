package in.techrebounce.roomwordssamplemvvm.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordRoomDataBase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static volatile WordRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WordRoomDataBase getDataBase(final Context context) {
        if(INSTANCE == null) {
            synchronized (WordRoomDataBase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDataBase.class,"word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
