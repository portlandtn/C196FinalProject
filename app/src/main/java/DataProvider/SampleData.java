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

    Term term1 = new Term();
    Term term2 = new Term();
    Term term3 = new Term();

    Course course1 = new Course();
    Course course2 = new Course();
    Course course3 = new Course();

    Assessment assessment1 = new Assessment();
    Assessment assessment2 = new Assessment();
    Assessment assessment3 = new Assessment();

    Mentor mentor1 = new Mentor();
    Mentor mentor2 = new Mentor();
    Mentor mentor3 = new Mentor();

    Note note1 = new Note();
    Note note2 = new Note();
    Note note3 = new Note();

    WGUTermRoomDatabase db;

    public void populateData(Context context) {
        db = WGUTermRoomDatabase.getDatabase(context);

        // order is important since some objects rely on others existing (foreign keys).
        populateTerms();
        populateMentors();
        populateCourses();
        populateAssessments();
        populateNotes();

    }

    private void populateTerms() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.MONTH, 6);
        term1.setmTitle("Spring 2020");
        term1.setmStartDate(start.getTime());
        term1.setmEndDate(end.getTime());

        start.add(Calendar.MONTH, 6);
        end.add(Calendar.MONTH, 6);
        term2.setmTitle("Fall 2020");
        term2.setmStartDate(start.getTime());
        term2.setmEndDate(end.getTime());

        start.add(Calendar.MONTH, 6);
        end.add(Calendar.MONTH, 6);
        term3.setmTitle("Spring 2021");
        term3.setmStartDate(start.getTime());
        term3.setmEndDate(end.getTime());

        db.termDao().insertAllTerms(term1, term2, term3);
    }

    private void populateCourses() {

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.MONTH, 2);
        course1.setmTitle("Biology 101");
        course1.setmStartDate(start.getTime());
        course1.setmEndDate(end.getTime());
        course1.setmTermId(term1.getId());
        course1.setmMentorId(mentor1.getId());

        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 2);
        course2.setmTitle("Math 518");
        course2.setmStartDate(start.getTime());
        course2.setmEndDate(end.getTime());
        course2.setmTermId(term1.getId());
        course2.setmMentorId(mentor1.getId());

        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 2);
        course3.setmTitle("Computer Science 165");
        course3.setmStartDate(start.getTime());
        course3.setmEndDate(end.getTime());
        course3.setmTermId(term2.getId());
        course3.setmMentorId(mentor2.getId());

        db.courseDao().insertAllCourses(course1, course2, course3);

    }

    private void populateAssessments() {

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.DATE, 6);
        assessment1.setmTitle("First Attempt");
        assessment1.setmStartDate(start.getTime());
        assessment1.setmEndDate(end.getTime());
        assessment1.setmCourseId(course1.getId());

        start.add(Calendar.DATE, 6);
        end.add(Calendar.DATE, 6);
        assessment2.setmTitle("Second Attempt");
        assessment2.setmStartDate(start.getTime());
        assessment2.setmEndDate(end.getTime());
        assessment2.setmCourseId(course1.getId());

        start.add(Calendar.DATE, 6);
        end.add(Calendar.DATE, 6);
        assessment3.setmTitle("Another Attempt");
        assessment3.setmStartDate(start.getTime());
        assessment3.setmEndDate(end.getTime());
        assessment3.setmCourseId(course3.getId());


        db.assessmentDao().insertAllAssessments(assessment1, assessment2, assessment3);
    }

    private void populateMentors() {
        mentor1.setmName("Amanda Hugenkiss");
        mentor1.setmPhone("270-493-8182");
        mentor2.setmEmail("man2hugNkiss@fakeNews.com");

        mentor2.setmName("Hugh Jazz");
        mentor2.setmPhone("850-941-9099");
        mentor2.setmEmail("HubertJazz@fakeNews.com");

        mentor3.setmName("Mein Utzich");
        mentor3.setmPhone("978-493-4958");
        mentor3.setmEmail("butnotreally@fakeNews.com");

        db.mentorDao().insertAllMentors(mentor1, mentor2, mentor3);

    }

    private void populateNotes() {
        note1.setmNote("This is a test note. Shouldn't do much more than this.");
        note1.setmAssessmentId(assessment1.getId());

        note2.setmNote("Another test note for another assessment. This assessment is horrible!");
        note2.setmAssessmentId(assessment3.getId());

        note3.setmNote("Yet one more note test for the assessments.");
        note3.setmAssessmentId(assessment3.getId());

        db.noteDao().insertAllNotes(note1, note2, note3);

    }

}
