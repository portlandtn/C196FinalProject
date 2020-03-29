package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentor_table")

public class Mentor {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @NonNull
    @ColumnInfo(name = "phone")
    private String mPhone;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    public Mentor(@NonNull String mName, @NonNull String mPhone, @NonNull String email) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.email = email;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getPhone() {
        return mPhone;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
