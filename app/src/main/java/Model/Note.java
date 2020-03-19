package Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table", foreignKeys = @ForeignKey(entity = Assessment.class,
parentColumns = "id",
childColumns = "assessment_id"))
public class Note {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    @NonNull
    @ColumnInfo(name = "assessment_id")
    private Integer mAssessmentId;

    public Note(@NonNull String note, @NonNull Integer mAssessmentId) {
        this.mNote = note;
        this.mAssessmentId = mAssessmentId;
    }

    @NonNull
    public Integer getId() {
        return this.id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getNote() {
        return this.mNote;
    }

    @NonNull
    public Integer getAssessmentId() {
        return mAssessmentId;
    }
}
