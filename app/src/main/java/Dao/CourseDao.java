package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Course;

@Dao
public interface CourseDao {

    @Query("SELECT * FROM course_table WHERE id = :courseId")
    LiveData<Course> getCourse(Integer courseId);

    @Query("SELECT * FROM course_table WHERE term_title = :termTitle")
    LiveData<List<Course>> getCoursesForTerm(String termTitle);


    @Delete(entity = Course.class)
    void deleteCourse(Course course);

    @Update(entity = Course.class)
    void updateCourse(Course course);

    @Insert(entity = Course.class)
    void insertCourse(Course course);

}
