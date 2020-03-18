package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Assessment;

@Dao
public interface AssessmentDao {

    @Query("SELECT * FROM assessment_table WHERE id = :assessmentId")
    LiveData<Assessment> getAssessment(Integer assessmentId);

    @Query("SELECT * FROM assessment_table WHERE courseId = :courseId")
    LiveData<List<Assessment>> getAssessmentsForCourse(Integer courseId);

    @Insert(entity = Assessment.class)
    void insert(Assessment assessment);

    @Update(entity = Assessment.class)
    void update(Assessment assessment);

    @Delete(entity = Assessment.class)
    void delete(Assessment assessment);

}
