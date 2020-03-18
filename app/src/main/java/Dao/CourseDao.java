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

    @Query("SELECT * FROM course_table WHERE id = :id")
    LiveData<List<Course>> getCoursesForTerm(Integer id);

    @Delete(entity = Course.class)
    void delete(Course course);

    @Update(entity = Course.class)
    void update(Course course);

    @Insert(entity = Course.class)
    void insert(Course course);

}
