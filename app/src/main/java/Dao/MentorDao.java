package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Mentor;

@Dao
public interface MentorDao {

    @Query("SELECT * FROM mentor_table WHERE id = :mentorId")
    LiveData<Mentor> getMentor(Integer mentorId);

    @Query("SELECT * FROM mentor_table WHERE courseId = :courseId")
    LiveData<List<Mentor>> getMentorForCourse(Integer courseId);

    @Insert(entity = Mentor.class)
    void insertMentor(Mentor mentor);

    @Update(entity = Mentor.class)
    void updateMentor(Mentor mentor);

    @Delete(entity = Mentor.class)
    void deleteMentor(Mentor mentor);
}
