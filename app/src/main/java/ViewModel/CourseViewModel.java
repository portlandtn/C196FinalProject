package ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Model.Course;
import Repo.CourseRepository;

public class CourseViewModel extends AndroidViewModel {

    private CourseRepository mRepository;
    private LiveData<List<Course>> mAllCourses;
    private LiveData<Course> mCourse;

    public CourseViewModel(Application application) {
        super(application);
        mRepository = new CourseRepository(application);
        mAllCourses = mRepository.getCoursesFromTermId();
        mCourse = mRepository.getCourse();
    }

    public LiveData<List<Course>> getCoursesFromTermId() {return mAllCourses;}
    public LiveData<Course> getCourse() {return mCourse; }

    public void insert(Course course) { mRepository.insert(course);}
    public void update(Course course) { mRepository.update(course);}
    public void delete(Course course) { mRepository.delete(course);}

}
