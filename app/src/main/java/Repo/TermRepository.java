package Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.TermDao;
import Database.WGUTermRoomDatabase;
import Model.Term;

class TermRepository {

    private TermDao mTermDao;
    private LiveData<List<Term>> mAllTerms;
    private LiveData<Term> mCurrentTerm;

    TermRepository(Application application) {
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(application);
        mTermDao = db.termDao();
        mAllTerms = mTermDao.getAllTerms();
        mCurrentTerm = mTermDao.getTerm(1); // Fix ME!!!!
    }

    LiveData<List<Term>> getAllTerms() {
        return mAllTerms;
    }

    LiveData<Term> getCurrentTerm() {
        return mCurrentTerm;
    }

    void insert(final Term term) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTermDao.insert(term);
            }
        });
    }

    void update(final Term term) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTermDao.update(term);
            }
        });
    }

    void delete(final Term term) {
        WGUTermRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTermDao.delete(term);
            }
        });
    }


}
