package DataProvider;

import androidx.room.TypeConverter;

public class AssessmentStatusConverter {

    @TypeConverter
    public static String assessmentStatusToString(AssessmentStatus status) {
        return status == null ? null : status.toString();
    }

    @TypeConverter
    public static AssessmentStatus assessmentStatusStringToStatus(String status) {
        return status == null ? null : AssessmentStatus.valueOf(status);
    }

}
