package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.AssessmentDao;
import Database.WGUTermRoomDatabase;
import Model.Assessment;

class AssessmentRepository {

    private AssessmentDao mAssessmentDao;
    private LiveData<List<Assessment>> mAllAssessmentsForCourse;
    private LiveData<Assessment> mCurrentAssessment;

    AssessmentRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mAssessmentDao = db.assessmentDao();
        mAllAssessmentsForCourse = mAssessmentDao.getAssessmentsForCourse(1); // Fix ME
        mCurrentAssessment = mAssessmentDao.getAssessment(1); // Fix ME!!!!
    }

    LiveData<List<Assessment>> getAssessmentsForCourse() {
        return mAllAssessmentsForCourse;
    }

    LiveData<Assessment> getAssessment() {
        return mCurrentAssessment;
    }

    void insert(final Assessment assessment) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAssessmentDao.insert(assessment);
            }
        });
    }

    void update(final Assessment assessment) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAssessmentDao.update(assessment);
            }
        });
    }

    void delete(final Assessment assessment) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAssessmentDao.delete(assessment);
            }
        });
    }

}
