package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import DataProvider.Converter;
import DataProvider.CourseStatus;

@Entity(tableName = "course_table", foreignKeys = {
        @ForeignKey(entity = Term.class,
                parentColumns = "id",
                childColumns = "term_id",
                onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Mentor.class,
                parentColumns = "id",
                childColumns = "mentor_id",
                onUpdate = ForeignKey.CASCADE)},
        indices = {@Index("term_id"), @Index("mentor_id")}
)
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String mTitle;

    @TypeConverters(Converter.class)
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @TypeConverters(Converter.class)
    @ColumnInfo(name = "end_date")
    private Date mEndDate;

    @TypeConverters(Converter.class)
    @ColumnInfo(name = "course_status")
    private CourseStatus mStatus;

    @ColumnInfo(name = "term_id")
    private int mTermId;

    @ColumnInfo(name = "mentor_id")
    private int mMentorId;


    public int getId() {
        return id;
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

    public CourseStatus getmStatus() {
        return mStatus;
    }

    public void setmStatus(CourseStatus mStatus) {
        this.mStatus = mStatus;
    }

    public int getmTermId() {
        return mTermId;
    }

    public void setmTermId(int mTermId) {
        this.mTermId = mTermId;
    }

    public int getmMentorId() {
        return mMentorId;
    }

    public void setmMentorId(int mMentorId) {
        this.mMentorId = mMentorId;
    }

    public void setId(int id) {
        this.id = id;
    }

}
