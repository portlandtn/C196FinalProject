package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentor_table")

public class Mentor {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "phone")
    private String mPhone;

    @ColumnInfo(name = "email")
    private String mEmail;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String email) {
        this.mEmail = email;
    }



}
