package Fill.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateTool {

    private final static SimpleDateFormat NORM_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final static SimpleDateFormat NORM_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final static SimpleDateFormat NORM_DATE_FORMAT5 = new SimpleDateFormat("yyyy-MM");

    private final static SimpleDateFormat NORM_DATE_FORMAT2 = new SimpleDateFormat("yyyy/MM/dd");

    private final static SimpleDateFormat NORM_DATE_FORMAT3 = new SimpleDateFormat("MM-dd HH:mm");

    private final static SimpleDateFormat NORM_DATE_FORMAT4 = new SimpleDateFormat("HH:mm");

    /**
     * TIPS 判断是否是 “YYYY-MM-DD”
     *
     * @Author:hihuzi 2018/7/18 16:32
     */

    public static boolean isDate(String date) {

        Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");
        return p.matcher(date).matches();
    }

    /**
     * TIPS 判断是否是 “HH:mm:ss”
     *
     * @Author:hihuzi 2018/7/18 16:32
     */

    public static boolean isTime(String time) {

        Pattern p = Pattern.compile("((((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        return p.matcher(time).matches();
    }

    /**
     * TIPS 判断是否是 “YYYY-MM-DD HH:mm:ss”或“YYYY-MM-DD”
     *
     * @Author:hihuzi 2018/7/18 16:32
     */
    public static boolean isDateTime(String datetime) {

        Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        return p.matcher(datetime).matches();
    }

    public static void main(String[] args) {

        System.out.println(isDate("2018-01-01"));
    }

    /**
     * TIPS “YYYY-MM-DD”
     *
     * @Author:hihuzi 2018/7/18 16:42
     */

    public static Date parse(String value) throws ParseException {

        return NORM_DATE_FORMAT.parse(value);
    }

}
