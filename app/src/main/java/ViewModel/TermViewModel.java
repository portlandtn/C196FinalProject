package ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Model.Term;
import Repo.TermRepository;

public class TermViewModel extends AndroidViewModel {

    private TermRepository mRepository;
    private LiveData<List<Term>> mTerms;
    private LiveData<Term> mCurrentTerm;

    public TermViewModel(Application application) {
        super(application);
        mRepository = new TermRepository(application);
        mTerms = mRepository.getAllTerms();
        mCurrentTerm = mRepository.getCurrentTerm();
    }

    public LiveData<List<Term>> getAllTerms() {return mTerms;}
    public LiveData<Term> getCurrentTerm() {return mCurrentTerm; }

    public void insert(Term term) { mRepository.insert(term);}
    public void update(Term term) { mRepository.update(term);}
    public void delete(Term term) { mRepository.delete(term);}

}
