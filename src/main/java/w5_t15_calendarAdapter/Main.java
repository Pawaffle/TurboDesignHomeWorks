package w5_t15_calendarAdapter;

public class Main {
  public static void main(String[] args) {
    NewDateInterface date = new CalendarToNewDateAdapter();

    date.setYear(2025);
    date.setMonth(12);
    date.setDay(30);

    System.out.println("Initial date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

    date.advanceDays(10);
    System.out.println("After 10 days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

    date.advanceDays(20);
    System.out.println("After 20 more days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
  }
}

