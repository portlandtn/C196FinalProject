package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import DataProvider.DateTypeConverter;

@Entity(tableName = "term_table")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "title")
    private String mTitle;

    @TypeConverters(DateTypeConverter.class)
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @TypeConverters(DateTypeConverter.class)
    @ColumnInfo(name = "end_date")
    private Date mEndDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
