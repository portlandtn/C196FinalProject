package ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import Model.Mentor;
import Repo.MentorRepository;

public class MentorViewModel extends AndroidViewModel {

    private MentorRepository mRepository;
    private LiveData<Mentor> mMentor;
    private LiveData<Mentor> mCourse;

    public MentorViewModel(Application application) {
        super(application);
        mRepository = new MentorRepository(application);
        mMentor = mRepository.getMentorFromCourseId();
    }

    public LiveData<Mentor> getMentorFromCourseId() {return mMentor;}

    public void insert(Mentor mentor) { mRepository.insert(mentor);}
    public void update(Mentor mentor) { mRepository.update(mentor);}
    public void delete(Mentor mentor) { mRepository.delete(mentor);}

}
