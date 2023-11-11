import java.util.Scanner;

class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    public void setTime(int hours, int minutes, int seconds) {
        if (isValidTime(hours, minutes, seconds)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            setAMPM(hours);
        } else {
            System.out.println("Invalid time.");
        }
    }

    private boolean isValidTime(int hours, int minutes, int seconds) {
        return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59 && seconds >= 0 && seconds <= 59;
    }

    private void setAMPM(int hours) {
        if (hours >= 0 && hours <= 11) {
            System.out.println("Time set to AM mode.");
        } else if (hours >= 12 && hours <= 23) {
            System.out.println("Time set to PM mode.");
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Clock clock = new Clock();
        System.out.print("Enter time in H M S:");
        int hours = sc.nextInt();
        int minutes = sc.nextInt();
        int seconds = sc.nextInt();
        clock.setTime(hours,minutes,seconds);
        sc.close();
    }
}