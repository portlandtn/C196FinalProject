package Dao;

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
    Assessment getAssessment(Integer assessmentId);

    @Query("SELECT * FROM assessment_table ORDER BY id")
    List<Assessment> getAllAssessments();

    @Query("SELECT * FROM assessment_table WHERE courseId = :courseId")
    List<Assessment> getAssessmentsForCourse(Integer courseId);

    @Insert
    void insert(Assessment assessment);

    @Insert
    void insertAllAssessments(Assessment... assessments);

    @Update
    void update(Assessment assessment);

    @Delete
    void delete(Assessment assessment);

    @Query("DELETE FROM assessment_table")
    void deleteAllAssessments();

}
