package Dao;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Course;
import Model.Note;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note_table WHERE id = :noteId")
    LiveData<Note> getNote(Integer noteId);

    @Query("SELECT * FROM note_table WHERE assessment_id = :assessmentId")
    LiveData<List<Note>> getNoteForAssessments(Integer assessmentId);

    @Insert(entity = Course.class)
    void insert(Note note);

    @Delete(entity = Note.class)
    void deleteNote(Note note);

    @Update(entity = Note.class)
    void updateNote(Note note);

}