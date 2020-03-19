package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import DataProvider.DateTypeConverter;

@Entity(tableName = "term_table")
public
class Term {

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

    @NonNull
    public Integer getId() {return this.id; }

    public void setId(Integer id) {
        this.id = id;
    }
}
