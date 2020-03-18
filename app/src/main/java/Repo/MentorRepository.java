package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import Dao.MentorDao;
import Database.WGUTermRoomDatabase;
import Model.Mentor;

class MentorRepository {

    private MentorDao mMentorDao;
    private LiveData<Mentor> mMentorFromCourseId;

    MentorRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mMentorDao = db.mentorDao();
        mMentorFromCourseId = mMentorDao.getMentor(1); // Fix ME!!!!
    }

    LiveData<Mentor> getMentorFromCourseId() {
        return mMentorFromCourseId;
    }

    void insert(final Mentor mentor) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mMentorDao.insert(mentor);
            }
        });
    }

    void update(final Mentor mentor) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mMentorDao.update(mentor);
            }
        });
    }

    void delete(final Mentor mentor) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mMentorDao.delete(mentor);
            }
        });
    }

}
