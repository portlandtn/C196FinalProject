package com.jedmay.c196finalproject;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Objects;

import DataProvider.SampleData;
import Database.WGUTermRoomDatabase;
import Model.Course;

import static org.junit.Assert.assertEquals;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class SampleDataTests {

    private Context context = ApplicationProvider.getApplicationContext();

    @Test
    public void coursesExist() {
        SampleData data = new SampleData();
        WGUTermRoomDatabase db = WGUTermRoomDatabase.getDatabase(context);
        data.populateData(context);

        LiveData<Course> courses = db.courseDao().getCourse(1);
        String title = Objects.requireNonNull(courses.getValue()).getTitle();

        assertEquals(title, "No");

    }
}