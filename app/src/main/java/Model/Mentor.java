package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentor_table",
        foreignKeys = @ForeignKey(entity = Course.class,
        parentColumns = "id",
        childColumns = "courseId",
        onUpdate = ForeignKey.CASCADE),
indices = @Index("courseId"))

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

    @NonNull
    @ColumnInfo(name = "courseId")
    private Integer mCourseId;

    public Mentor(@NonNull String mName, @NonNull String mPhone, @NonNull String email, @NonNull Integer mCourseId) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.email = email;
        this.mCourseId = mCourseId;
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
    public Integer getCourseId() {
        return mCourseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
