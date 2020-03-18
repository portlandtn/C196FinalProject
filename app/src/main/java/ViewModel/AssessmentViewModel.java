package ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Model.Assessment;
import Repo.AssessmentRepository;

public class AssessmentViewModel extends AndroidViewModel {

    private AssessmentRepository mRepository;
    private LiveData<List<Assessment>> mAllAssessments;
    private LiveData<Assessment> mAssessment;

    public AssessmentViewModel(Application application) {
        super(application);
        mRepository = new AssessmentRepository(application);
        mAllAssessments = mRepository.getAssessmentsForCourse();
        mAssessment = mRepository.getAssessment();
    }

    public LiveData<List<Assessment>> getAllAssessmentsForCourse() {return mAllAssessments;}
    public LiveData<Assessment> getAssessment() {return mAssessment; }

    public void insert(Assessment assessment) { mRepository.insert(assessment);}
    public void update(Assessment assessment) { mRepository.update(assessment);}
    public void delete(Assessment assessment) { mRepository.delete(assessment);}

}
