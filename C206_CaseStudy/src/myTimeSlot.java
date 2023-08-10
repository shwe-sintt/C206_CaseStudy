import java.util.ArrayList;

public class myTimeSlot {

    private static final int OPTION_VIEW = 1;
    private static final int OPTION_ADD = 2;
    private static final int OPTION_REMOVE = 3;
    private static final int OPTION_UPDATE = 4;
    private static final int OPTION_QUIT = 5;

    public static void main(String[] args) {

        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();

        timeSlotList.add(new TimeSlot("TS001", "Monday", "13:00", "2023/08/10"));

        int option = 0;

        while (option != OPTION_QUIT) {

            menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_VIEW) {
                // View all time slots
                myTimeSlot.setHeader("VIEW ALL TIME SLOTS");
                viewAllTimeSlots(timeSlotList);

            } else if (option == OPTION_ADD) {
                // Add a new time slot
                myTimeSlot.setHeader("ADD NEW TIME SLOT");
                addTimeSlot(timeSlotList);

            } else if (option == OPTION_REMOVE) {
                // Remove a time slot
                myTimeSlot.setHeader("REMOVE TIME SLOT");
                removeTimeSlot(timeSlotList);

            } else if (option == OPTION_UPDATE) {
                // Update a time slot
                myTimeSlot.setHeader("UPDATE TIME SLOT");
                updateTimeSlot(timeSlotList);

            } else if (option == OPTION_QUIT) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    public static void menu() {
        myTimeSlot.setHeader("TIME SLOT REGISTRATION APP");
        System.out.println("1. View all time slots");
        System.out.println("2. Add new time slot");
        System.out.println("3. Remove existing time slot");
        System.out.println("4. Update existing time slot");
        System.out.println("5. Quit");
        Helper.line(80, "-");
    }

    public static void setHeader(String header) {
        Helper.line(30, "-");
        System.out.println(header);
        Helper.line(30, "-");
    }

    // Option 1 View
    public static void viewAllTimeSlots(ArrayList<TimeSlot> timeSlotList) {
        System.out.printf("%-10s %-10s %-10s %-20s\n", "Slot ID", "Day", "Time", "Date");

        for (TimeSlot timeSlot : timeSlotList) {
            System.out.printf("%-10s %-10s %-10s %-20s\n",
                    timeSlot.getId(), timeSlot.getDay(), timeSlot.getTime(), timeSlot.getDate());
        }
    }

    // Option 2 Add
    public static void addTimeSlot(ArrayList<TimeSlot> slots) {
        String newSlotId = Helper.readString("Enter slot ID (TS----) > ");
        String newDay = Helper.readString("Enter day > ");
        String newTime = Helper.readString("Enter time > ");
        String newDate = Helper.readString("Enter date (yyyy/mm/dd) > ");

        TimeSlot newTimeSlot = new TimeSlot(newSlotId, newDay, newTime, newDate);
        slots.add(newTimeSlot);

        System.out.println("Time slot added successfully!");
    }


    // Option 3 Remove
    public static boolean removeTimeSlot(ArrayList<TimeSlot> timeSlotList) {
        String removeSlotId = Helper.readString("Enter slot ID to remove (TS---) > ");

        boolean timeSlotFound = false;
        for (TimeSlot timeSlot : timeSlotList) {
            if (timeSlot.getId().equals(removeSlotId)) {
                timeSlotList.remove(timeSlot);
                timeSlotFound = true;
                System.out.println("Time slot removed successfully!");
                break;
            }
        }

        if (!timeSlotFound) {
            System.out.println("Time slot not found!");
        }

        return timeSlotFound;
    }

    // Option 4 Update
    public static boolean updateTimeSlot(ArrayList<TimeSlot> timeSlotList) {
        String updateSlotId = Helper.readString("Enter slot ID to update > ");

        boolean timeSlotFound = false;
        for (TimeSlot timeSlot : timeSlotList) {
            if (timeSlot.getId().equals(updateSlotId)) {
                String newDay = Helper.readString("Enter new day > ");
                String newTime = Helper.readString("Enter new time > ");
                String newDate = Helper.readString("Enter new date (yyyy/mm/dd) > ");

                timeSlot.setDay(newDay);
                timeSlot.setTime(newTime);
                timeSlot.setDate(newDate);

                timeSlotFound = true;
                System.out.println("Time slot updated successfully!");
                break;
            }
        }

        if (!timeSlotFound) {
            System.out.println("Time slot not found!");
        }

        return timeSlotFound;
    }
}