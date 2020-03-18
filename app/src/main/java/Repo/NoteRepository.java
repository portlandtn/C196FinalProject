package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.AssessmentDao;
import Dao.NoteDao;
import Database.WGUTermRoomDatabase;
import Model.Assessment;
import Model.Note;

public class NoteRepository {

    private NoteDao mNoteDao;
    private LiveData<List<Note>> mAllNotesForAssessment;
    private LiveData<Note> mNoteFromNoteId;

    public NoteRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mNoteDao = db.noteDao();
        mAllNotesForAssessment = mNoteDao.getNoteForAssessments(1); // Fix ME
        mNoteFromNoteId = mNoteDao.getNote(1); // Fix ME!!!!
    }

    public LiveData<List<Note>> getAllNotesForAssessment() {
        return mAllNotesForAssessment;
    }

    public LiveData<Note> getNote() {
        return mNoteFromNoteId;
    }

    public void insert(final Note note) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mNoteDao.insert(note);
            }
        });
    }

    public void update(final Note note) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mNoteDao.update(note);
            }
        });
    }

    public void delete(final Note note) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mNoteDao.delete(note);
            }
        });
    }

}
