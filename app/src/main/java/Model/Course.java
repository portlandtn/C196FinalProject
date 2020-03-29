package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import DataProvider.DateTypeConverter;

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
    @ColumnInfo(name = "term_id")
    private Integer mTermId;

    @NonNull
    @ColumnInfo(name = "mentor_id")
    private Integer mMentorId;

    public Course(@NonNull String title, @NonNull Date startDate, @NonNull Date endDate, @NonNull Integer termId, @NonNull Integer mentorId) {
        this.mTitle = title;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
        this.mTermId = termId;
        this.mMentorId = mentorId;
    }

    @NonNull
    public Integer getId() {
        return this.id;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public Date getStartDate() {
        return this.mStartDate;
    }

    @NonNull
    public Date getEndDate() {
        return this.mEndDate;
    }

    @NonNull
    public Integer getTermId() {
        return this.mTermId;
    }

    @NonNull
    public Integer getMentorId() {
        return this.mMentorId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
