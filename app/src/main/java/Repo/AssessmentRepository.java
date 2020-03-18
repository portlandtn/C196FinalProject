package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.AssessmentDao;
import Database.WGUTermRoomDatabase;
import Model.Assessment;

public class AssessmentRepository {

    private AssessmentDao mAssessmentDao;
    private LiveData<List<Assessment>> mAllAssessmentsForCourse;
    private LiveData<Assessment> mCurrentAssessment;

    public AssessmentRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mAssessmentDao = db.assessmentDao();
        mAllAssessmentsForCourse = mAssessmentDao.getAssessmentsForCourse(1); // Fix ME
        mCurrentAssessment = mAssessmentDao.getAssessment(1); // Fix ME!!!!
    }

    public LiveData<List<Assessment>> getAssessmentsForCourse() {
        return mAllAssessmentsForCourse;
    }

    public LiveData<Assessment> getAssessment() {
        return mCurrentAssessment;
    }

    public void insert(final Assessment assessment) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAssessmentDao.insert(assessment);
            }
        });
    }

    public void update(final Assessment assessment) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAssessmentDao.update(assessment);
            }
        });
    }

    public void delete(final Assessment assessment) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mAssessmentDao.delete(assessment);
            }
        });
    }

}
