package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.CourseDao;
import Database.WGUTermRoomDatabase;
import Model.Course;

public class CourseRepository {

    private CourseDao mCourseDao;
    private LiveData<Course> mCourseFromCourseId;
    private LiveData<List<Course>> mCourseFromTermId;

    public CourseRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mCourseDao = db.courseDao();
        mCourseFromCourseId = mCourseDao.getCourse(1); // Fix ME
        mCourseFromTermId = mCourseDao.getCoursesForTerm(1); // Fix ME!!!!
    }

    public LiveData<List<Course>> getCoursesFromTermId() {
        return mCourseFromTermId;
    }

    public LiveData<Course> getCourse() {
        return mCourseFromCourseId;
    }

    public void insert(final Course course) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCourseDao.insert(course);
            }
        });
    }

    public void update(final Course course) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCourseDao.update(course);
            }
        });
    }

    public void delete(final Course course) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCourseDao.delete(course);
            }
        });
    }

}
