package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table",
        foreignKeys = @ForeignKey(entity = Assessment.class,
        parentColumns = "id",
        childColumns = "assessment_id",
        onUpdate = ForeignKey.CASCADE),
        indices = @Index("assessment_id"))

public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "note")
    private String mNote;

    @ColumnInfo(name = "assessment_id")
    private int mAssessmentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmNote() {
        return mNote;
    }

    public void setmNote(String mNote) {
        this.mNote = mNote;
    }

    public int getmAssessmentId() {
        return mAssessmentId;
    }

    public void setmAssessmentId(int mAssessmentId) {
        this.mAssessmentId = mAssessmentId;
    }
}
