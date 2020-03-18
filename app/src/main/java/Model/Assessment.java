package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "assessment_table", foreignKeys = @ForeignKey(entity = Course.class,
parentColumns = "id",
childColumns = "courseId"))
class Assessment {

    @PrimaryKey
    @NonNull
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

    Assessment(@NonNull Integer id, @NonNull String mTitle, @NonNull Date mStartDate, @NonNull Date endDate) {
        this.id = id;
        this.mTitle = mTitle;
        this.mStartDate = mStartDate;
        mEndDate = endDate;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    @NonNull
    public String getmTitle() {
        return mTitle;
    }

    @NonNull
    public Date getmStartDate() {
        return mStartDate;
    }

    @NonNull
    public Date getmEndDate() {
        return mEndDate;
    }

}
