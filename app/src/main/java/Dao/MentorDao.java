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

    @Query("SELECT * FROM mentor_table WHERE id = :courseId")
    LiveData<Mentor> getMentor(Integer courseId);

    @Insert(entity = Mentor.class)
    void insert(Mentor mentor);

    @Update(entity = Mentor.class)
    void update(Mentor mentor);

    @Delete(entity = Mentor.class)
    void delete(Mentor mentor);
}
