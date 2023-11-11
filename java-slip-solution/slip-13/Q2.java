import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Q2 {
    public static void main(String[] args) {
        // Get the current date and time
        Date now = new Date();

        // Define different date and time formats
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat format3 = new SimpleDateFormat("EEEE MMMM dd yyyy");
        SimpleDateFormat format4 = new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy");
        SimpleDateFormat format5 = new SimpleDateFormat("dd/MM/yy HH:mm:ss a Z");

        // Display the current date and time in various formats
        System.out.println("Current date is : " + format1.format(now));
        System.out.println("Current date is : " + format2.format(now));
        System.out.println("Current date is : " + format3.format(now));
        System.out.println("Current date and time is : " + format4.format(now));
        System.out.println("Current date and time is : " + format5.format(now));

        // Print the time zone
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("Time Zone: " + timeZone.getDisplayName());
    }
}
