package ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Model.Note;
import Repo.NoteRepository;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository mRepository;
    private LiveData<List<Note>> mAllNotesForCourse;
    private LiveData<Note> mNote;

    public NoteViewModel(Application application) {
        super(application);
        mRepository = new NoteRepository(application);
        mAllNotesForCourse = mRepository.getAllNotesForAssessment();
        mNote = mRepository.getNote();
    }

    public LiveData<List<Note>> getNotesForCourse() {return mAllNotesForCourse;}
    public LiveData<Note> getNote() {return mNote; }

    public void insert(Note note) { mRepository.insert(note);}
    public void update(Note note) { mRepository.update(note);}
    public void delete(Note note) { mRepository.delete(note);}

}
