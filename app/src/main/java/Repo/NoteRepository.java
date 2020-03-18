package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.AssessmentDao;
import Dao.NoteDao;
import Database.WGUTermRoomDatabase;
import Model.Assessment;
import Model.Note;

class NoteRepository {

    private NoteDao mNoteDao;
    private LiveData<List<Note>> mAllNotesForAssessment;
    private LiveData<Note> mNoteFromNoteId;

    NoteRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mNoteDao = db.noteDao();
        mAllNotesForAssessment = mNoteDao.getNoteForAssessments(1); // Fix ME
        mNoteFromNoteId = mNoteDao.getNote(1); // Fix ME!!!!
    }

    LiveData<List<Note>> getAllNotesForAssessment() {
        return mAllNotesForAssessment;
    }

    LiveData<Note> getNote() {
        return mNoteFromNoteId;
    }

    void insert(final Note note) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mNoteDao.insert(note);
            }
        });
    }

    void update(final Note note) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mNoteDao.update(note);
            }
        });
    }

    void delete(final Note note) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mNoteDao.delete(note);
            }
        });
    }

}
