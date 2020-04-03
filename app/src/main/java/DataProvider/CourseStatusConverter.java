package DataProvider;

import androidx.room.TypeConverter;

public class CourseStatusConverter {

    @TypeConverter
    public static String courseStatusToString(CourseStatus status) {
        return status == null ? null : status.toString();
    }

    @TypeConverter
    public static CourseStatus courseStatusStringToStatus(String status) {
        return status == null ? null : CourseStatus.valueOf(status);
    }

}
