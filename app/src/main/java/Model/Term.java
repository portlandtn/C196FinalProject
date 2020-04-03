package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import DataProvider.DateTimeConverter;

@Entity(tableName = "term_table")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String mTitle;

    @TypeConverters(DateTimeConverter.class)
    @ColumnInfo(name = "start_date")
    private Date mStartDate;

    @TypeConverters(DateTimeConverter.class)
    @ColumnInfo(name = "end_date")
    private Date mEndDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMTitle() {
        return mTitle;
    }

    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getMStartDate() {
        return mStartDate;
    }

    public void setMStartDate(Date mStartDate) {
        this.mStartDate = mStartDate;
    }

    public Date getMEndDate() {
        return mEndDate;
    }

    public void setMEndDate(Date mEndDate) {
        this.mEndDate = mEndDate;
    }
}
