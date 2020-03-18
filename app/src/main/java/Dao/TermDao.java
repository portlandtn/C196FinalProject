package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Term;

@Dao
public interface TermDao {

    @Query("SELECT * FROM term_table")
    LiveData<List<Term>> getAllTerms();

    @Query("SELECT * FROM term_table WHERE id = :termId")
    LiveData<Term> getTerm(Integer termId);

    @Insert(entity = Term.class)
    void insert(Term term);

    @Update(entity = Term.class)
    void update(Term term);

    @Delete(entity = Term.class)
    void delete(Term term);

}
