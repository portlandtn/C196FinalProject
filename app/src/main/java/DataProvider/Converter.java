package DataProvider;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converter {

    @TypeConverter
    public static Date timestampToDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static String courseStatusToString(CourseStatus status) { return status == null ? null : status.toString(); }

    @TypeConverter
    public static CourseStatus courseStatusStringToStatus(String status) { return status == null ? null : CourseStatus.valueOf(status); }

    @TypeConverter
    public static String assessmentStatusToString(CourseStatus status) { return status == null ? null : status.toString(); }

    @TypeConverter
    public static AssessmentStatus assessmentStatusStringToStatus(String status) { return status == null ? null : AssessmentStatus.valueOf(status); }

}
