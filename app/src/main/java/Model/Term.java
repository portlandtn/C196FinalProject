package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "term_table")
public
class Term {

    @PrimaryKey
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

    public Term(@NonNull String title,@NonNull Date startDate,@NonNull Date endDate) {
        this.mTitle = title;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
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
    public Integer getId() {return this.id; }

}
