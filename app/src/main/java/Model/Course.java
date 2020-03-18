package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "course_table", foreignKeys = {
        @ForeignKey(entity = Term.class,
                parentColumns = "title",
                childColumns = "term_title"),
        @ForeignKey(entity = Mentor.class,
                parentColumns = "id",
                childColumns = "mentor_id")
})
public class Course {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @NonNull
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @NonNull
    @ColumnInfo(name = "end_date")
    private Date mEndDate;

    @NonNull
    @ColumnInfo(name = "term_title")
    private String mTermTitle;

    @NonNull
    @ColumnInfo(name = "mentor_id")
    private Integer mMentorId;

    public Course(@NonNull String title, @NonNull Date startDate, @NonNull Date endDate, @NonNull String termTitle, @NonNull Integer mentorId) {
        this.mTitle = title;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
        this.mTermTitle = termTitle;
        this.mMentorId = mentorId;
    }

    @NonNull
    public Integer getId() {
        return this.id;
    }

    @NonNull
    public String getmTitle() {
        return this.mTitle;
    }

    @NonNull
    public Date getmStartDate() {
        return this.mStartDate;
    }

    @NonNull
    public Date getmEndDate() {
        return this.mEndDate;
    }

    @NonNull
    public String getmTermTitle() {
        return this.mTermTitle;
    }

    @NonNull
    public Integer getmMentorId() {
        return this.mMentorId;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
