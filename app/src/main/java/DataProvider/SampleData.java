package DataProvider;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import Database.WGUTermRoomDatabase;
import Model.Assessment;
import Model.Course;
import Model.Mentor;
import Model.Note;
import Model.Term;

@SuppressLint("Registered")
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

    public void populateDatabaseWithSampleData(Context context) {
        db = WGUTermRoomDatabase.getDatabase(context);

        // order is important since some objects rely on others existing (foreign keys).
        populateTerms();
        populateMentors();
        populateCourses();
        populateAssessments();
        populateNotes();

    }

    public void deleteAllDataFromDatabase(Context context) {
        db = WGUTermRoomDatabase.getDatabase(context);

        // order is important. Dependencies (foreign keys)
        db.noteDao().deleteAllNotes();
        db.mentorDao().deleteAllMentors();
        db.assessmentDao().deleteAllAssessments();
        db.courseDao().deleteAllCourses();
        db.termDao().deleteAllTerms();
    }

    private void populateTerms() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.MONTH, 6);
        term1.setMTitle("Spring 2020");
        term1.setMStartDate(start.getTime());
        term1.setMEndDate(end.getTime());

        start.add(Calendar.MONTH, 6);
        end.add(Calendar.MONTH, 6);
        term2.setMTitle("Fall 2020");
        term2.setMStartDate(start.getTime());
        term2.setMEndDate(end.getTime());

        start.add(Calendar.MONTH, 6);
        end.add(Calendar.MONTH, 6);
        term3.setMTitle("Spring 2021");
        term3.setMStartDate(start.getTime());
        term3.setMEndDate(end.getTime());

        db.termDao().insertAllTerms(term1, term2, term3);
    }

    private void populateCourses() {

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.MONTH, 2);
        course1.setMTitle("Biology 101");
        course1.setMStartDate(start.getTime());
        course1.setMEndDate(end.getTime());
        course1.setMTermId(1);

        //        course1.setMTermId(term1.getId());
        course1.setMMentorId(mentor1.getId());
        course1.setMStatus(CourseStatus.PLAN_TO_TAKE);

        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 2);
        course2.setMTitle("Math 518");
        course2.setMStartDate(start.getTime());
        course2.setMEndDate(end.getTime());
       // course2.setMTermId(1);

        course2.setMTermId(term1.getId());
        course2.setMMentorId(mentor1.getId());

        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 2);
        course3.setMTitle("Computer Science 165");
        course3.setMStartDate(start.getTime());
        course3.setMEndDate(end.getTime());
        course3.setMTermId(2);

//        course3.setMTermId(term2.getId());
        course3.setMMentorId(mentor2.getId());

        db.courseDao().insertAllCourses(course1, course2, course3);

    }

    private void populateAssessments() {

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        end.add(Calendar.DATE, 6);
        assessment1.setMTitle("First Attempt");
        assessment1.setMStartDate(start.getTime());
        assessment1.setMEndDate(end.getTime());
        assessment1.setMCourseId(course1.getId());

        start.add(Calendar.DATE, 6);
        end.add(Calendar.DATE, 6);
        assessment2.setMTitle("Second Attempt");
        assessment2.setMStartDate(start.getTime());
        assessment2.setMEndDate(end.getTime());
        assessment2.setMCourseId(course1.getId());

        start.add(Calendar.DATE, 6);
        end.add(Calendar.DATE, 6);
        assessment3.setMTitle("Another Attempt");
        assessment3.setMStartDate(start.getTime());
        assessment3.setMEndDate(end.getTime());
        assessment3.setMCourseId(course3.getId());


        db.assessmentDao().insertAllAssessments(assessment1, assessment2, assessment3);
    }

    private void populateMentors() {
        mentor1.setMName("Amanda Huginkiss");
        mentor1.setMPhone("270-493-8182");
        mentor2.setMEmail("man2hugNkiss@fakeNews.com");

        mentor2.setMName("Hugh Jazz");
        mentor2.setMPhone("850-941-9099");
        mentor2.setMEmail("HubertJazz@fakeNews.com");

        mentor3.setMName("Mein Utzich");
        mentor3.setMPhone("978-493-4958");
        mentor3.setMEmail("butnotreally@fakeNews.com");

        db.mentorDao().insertAllMentors(mentor1, mentor2, mentor3);

    }

    private void populateNotes() {
        note1.setMNote("This is a test note. Shouldn't do much more than this.");
        note1.setMAssessmentId(assessment1.getId());

        note2.setMNote("Another test note for another assessment. This assessment is horrible!");
        note2.setMAssessmentId(assessment3.getId());

        note3.setMNote("Yet one more note test for the assessments.");
        note3.setMAssessmentId(assessment3.getId());

        db.noteDao().insertAllNotes(note1, note2, note3);

    }


}
