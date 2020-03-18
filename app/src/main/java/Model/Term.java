package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "term_table")
class Term {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @NonNull
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @NonNull
    @ColumnInfo(name = "end_date")
    private Date mEndDate;

    public Term(@NonNull String title,@NonNull Date startDate,@NonNull Date endDate) {
        this.mTitle = title;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
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

}
