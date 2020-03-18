package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.CourseDao;
import Database.WGUTermRoomDatabase;
import Model.Course;

class CourseRepository {

    private CourseDao mCourseDao;
    private LiveData<Course> mCourseFromCourseId;
    private LiveData<List<Course>> mCourseFromTermId;

    CourseRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mCourseDao = db.courseDao();
        mCourseFromCourseId = mCourseDao.getCourse(1); // Fix ME
        mCourseFromTermId = mCourseDao.getCoursesForTerm(1); // Fix ME!!!!
    }

    LiveData<List<Course>> getCoursesFromTermId() {
        return mCourseFromTermId;
    }

    LiveData<Course> getCourse() {
        return mCourseFromCourseId;
    }

    void insert(final Course course) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCourseDao.insert(course);
            }
        });
    }

    void update(final Course course) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCourseDao.update(course);
            }
        });
    }

    void delete(final Course course) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCourseDao.delete(course);
            }
        });
    }

}
