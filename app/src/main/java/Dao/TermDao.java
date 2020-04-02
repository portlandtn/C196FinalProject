package Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Term;

@Dao
public interface TermDao {

    @Query("SELECT * FROM term_table ORDER BY id")
    List<Term> getAllTerms();

    @Query("SELECT * FROM term_table WHERE id = :termId")
    Term getTerm(Integer termId);

    @Insert
    void insert(Term term);

    @Insert
    void insertAllTerms(Term... terms);

    @Update
    void update(Term term);

    @Delete
    void delete(Term term);

    @Query("DELETE FROM term_table")
    void deleteAllTerms();

}
