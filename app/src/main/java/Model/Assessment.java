package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import DataProvider.DateTypeConverter;

@Entity(tableName ="assessment_table",
        foreignKeys = @ForeignKey(entity = Course.class,
        parentColumns = "id",
        childColumns = "courseId",
        onUpdate = ForeignKey.CASCADE),
        indices = {@Index("courseId")})

public class Assessment {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String mTitle;

    @TypeConverters(DateTypeConverter.class)
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @TypeConverters(DateTypeConverter.class)
    @ColumnInfo(name = "end_date")
    private Date mEndDate;

    @ColumnInfo(name = "courseId")
    private int mCourseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmStartDate() {
        return mStartDate;
    }

    public void setmStartDate(Date mStartDate) {
        this.mStartDate = mStartDate;
    }

    public Date getmEndDate() {
        return mEndDate;
    }

    public void setmEndDate(Date mEndDate) {
        this.mEndDate = mEndDate;
    }

    public int getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(int mCourseId) {
        this.mCourseId = mCourseId;
    }

}
