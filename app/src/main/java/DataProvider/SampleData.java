package DataProvider;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import Database.WGUTermRoomDatabase;
import Model.Assessment;
import Model.Course;
import Model.Mentor;
import Model.Note;
import Model.Term;

public class SampleData extends AppCompatActivity {

    Term term1;
    Term term2;
    Term term3;

    Course course1;
    Course course2;
    Course course3;

    Assessment assessment1;
    Assessment assessment2;
    Assessment assessment3;

    Mentor mentor1;
    Mentor mentor2;
    Mentor mentor3;

    Note note1;
    Note note2;
    Note note3;

    WGUTermRoomDatabase db;

    public void populateData(Context context) {
        db = WGUTermRoomDatabase.getDatabase(context);

        // order is important since some objects rely on others existing.

        populateTerms();
        //populateMentors();
        //populateCourses();
        //populateAssessments();
        //populateNotes();

    }

    private void populateTerms() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        term1 = new Term("Spring 2020", start.getTime(), end.getTime());
        db.termDao().insert(term1);

//        end.add(Calendar.MONTH, 6);
//        term1 = new Term("Spring 2020", start.getTime(), end.getTime());
//        db.termDao().insert(term1);
//
//        start.add(Calendar.MONTH, 6);
//        end.add(Calendar.MONTH, 6);
//        term2 = new Term("Fall 2020", start.getTime(), end.getTime());
//        db.termDao().insert(term2);
//
//        start.add(Calendar.MONTH, 6);
//        end.add(Calendar.MONTH, 6);
//        term3 = new Term("Spring 2021", start.getTime(), end.getTime());
//        db.termDao().insert(term3);
    }

    private void populateCourses() {

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.MONTH, 2);
        course1 = new Course("Bioloy 101", start.getTime(), end.getTime(), term1.getId(), mentor1.getId());
        db.courseDao().insert(course1);

        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 2);
        course2 = new Course("Math 518", start.getTime(), end.getTime(), term1.getId(), mentor2.getId());
        db.courseDao().insert(course2);

        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 2);
        course3 = new Course("Computer Science 165", start.getTime(), end.getTime(), term3.getId(), mentor2.getId());
        db.courseDao().insert(course3);

    }

    private void populateAssessments() {

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.DATE, 6);
        assessment1 = new Assessment("First Attempt", start.getTime(), end.getTime(), course1.getId());
        db.assessmentDao().insert(assessment1);

        start.add(Calendar.DATE, 6);
        end.add(Calendar.DATE, 6);
        assessment2 = new Assessment("Second Attempt", start.getTime(), end.getTime(), course1.getId());
        db.assessmentDao().insert(assessment2);

        start.add(Calendar.DATE, 6);
        end.add(Calendar.DATE, 6);
        assessment3 = new Assessment("Another Attempt", start.getTime(), end.getTime(), course2.getId());
        db.assessmentDao().insert(assessment3);

    }

    private void populateMentors() {
        mentor1 = new Mentor("Amanda Hugenkiss", "270-493-8182", "man2hugNkiss@fakeNews.com");
        db.mentorDao().insert(mentor1);

        mentor2 = new Mentor("Hugh Jazz", "850-941-9099", "HubertJazz@fakeNews.com");
        db.mentorDao().insert(mentor2);

        mentor3 = new Mentor("Mein Utzich", "978-493-4985", "butnotreally@fakeNews.com");
        db.mentorDao().insert(mentor3);
    }

    private void populateNotes() {
        note1 = new Note("This is a test note. Shouldn't do much more than this.", assessment1.getId());
        db.noteDao().insert(note1);

        note2 = new Note("Another test note for another assessment. This assessment is horrible!", assessment3.getId());
        db.noteDao().insert(note1);

        note3 = new Note("Yet one more note test for the assessments.", assessment1.getId());
        db.noteDao().insert(note1);
    }

}
