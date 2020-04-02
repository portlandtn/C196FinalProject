package Dao;

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
    Course getCourse(Integer courseId);

    @Query("SELECT * FROM course_table WHERE term_id = :termId")
    List<Course> getCoursesForTerm(Integer termId);

    @Delete
    void delete(Course course);

    @Update
    void update(Course course);

    @Insert
    void insert(Course course);

    @Insert
    void insertAllCourses(Course... courses);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

}
