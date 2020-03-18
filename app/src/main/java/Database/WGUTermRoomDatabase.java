package Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Dao.AssessmentDao;
import Dao.CourseDao;
import Dao.MentorDao;
import Dao.NoteDao;
import Dao.TermDao;
import Model.Assessment;
import Model.Course;
import Model.Mentor;
import Model.Note;
import Model.Term;

@Database(entities = {Assessment.class, Course.class, Mentor.class, Note.class, Term.class}, version = 1, exportSchema = false)
public abstract class WGUTermRoomDatabase extends RoomDatabase {

    public abstract AssessmentDao assessmentDao();
    public abstract CourseDao courseDao();
    public abstract MentorDao mentorDao();
    public abstract NoteDao noteDao();
    public abstract TermDao termDao();

    private static volatile WGUTermRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WGUTermRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WGUTermRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WGUTermRoomDatabase.class, "WGU_term_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
