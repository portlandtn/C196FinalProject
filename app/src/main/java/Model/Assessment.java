package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
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
    private Integer id;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @TypeConverters(DateTypeConverter.class)
    @NonNull
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @TypeConverters(DateTypeConverter.class)
    @NonNull
    @ColumnInfo(name = "end_date")
    private Date mEndDate;

    @NonNull
    @ColumnInfo(name = "courseId")
    private Integer mCourseId;

    public Assessment(@NonNull String mTitle, @NonNull Date mStartDate, @NonNull Date endDate, @NonNull Integer mCourseId) {
        this.mTitle = mTitle;
        this.mStartDate = mStartDate;
        mEndDate = endDate;
        this.mCourseId = mCourseId;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    @NonNull
    public Date getStartDate() {
        return mStartDate;
    }

    @NonNull
    public Date getEndDate() {
        return mEndDate;
    }

    @NonNull
    public Integer getCourseId() {
        return mCourseId;
    }

    public void setId(Integer id) {this.id = id; }
}
