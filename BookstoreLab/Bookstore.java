import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Bookstore
 */
public class Bookstore {

    private String name, address;
    private static final LocalTime OPEN = LocalTime.of(8, 00, 00);
    private static final LocalTime CLOSE = LocalTime.of(20, 00, 00);
    private int sqFeet;
    private boolean openWeekends, hasUsedBooks;
    private ArrayList<String> titles;

    public Bookstore() {
        setName(setAddress(null));
        setSqFeet(0);
        setOpenWeekends(setHasUsedBooks(false));
    }

    public Bookstore(String name, String address) {
        this.setName(name);
        this.setAddress(address);
        titles = new ArrayList<String>();
        loadTitles();
    }

    public Bookstore(String name, String address, int sqFeet, boolean openWeekends, boolean hasUsedBooks) {
        this.setName(name);
        this.setAddress(address);
        this.setSqFeet(sqFeet);
        this.setOpenWeekends(openWeekends);
        this.setHasUsedBooks(hasUsedBooks);
        titles = new ArrayList<String>();
        loadTitles();
    }

    public boolean isHasUsedBooks() {
        return hasUsedBooks;
    }

    public boolean setHasUsedBooks(boolean hasUsedBooks) {
        this.hasUsedBooks = hasUsedBooks;
        return hasUsedBooks;
    }

    public boolean isOpenWeekends() {
        return openWeekends;
    }

    public void setOpenWeekends(boolean openWeekends) {
        this.openWeekends = openWeekends;
    }

    public int getSqFeet() {
        return sqFeet;
    }

    public void setSqFeet(int sqFeet) {
        this.sqFeet = sqFeet;
    }

    public String getClose() {
        return CLOSE.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public String getOpen() {
        return OPEN.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public String isOpen(LocalTime t) {
        if(t.isAfter(OPEN) && t.isBefore(CLOSE)) {
            return "Yes, it is open right now!";
        } else {
            return "No, it is not open right now.";
        }
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles);
        }
        catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();
        }
    }

    // public void getBooks() {
    //     for(String ele : titles) {
    //         System.out.println(ele);
    //     }
    // }

    public int getNumberBooks() {
        return titles.size();
    }

    public void searchTitles(String search) {
        int count = 0;
        for(String ele : titles) {
            if(ele.toLowerCase().contains(search.toLowerCase())) {
                System.out.println(ele);
                count ++;
            }
        }
        if(count == 0) {
            System.out.println("Sorry no matches found.");
        }
    }

    public String toString() {
        return 
            "Name :" + name +
            "Address " + address +
            "Opens at: " + OPEN.format(DateTimeFormatter.ofPattern("hh:mm a")) + 
            "Closes at: " + CLOSE.format(DateTimeFormatter.ofPattern("hh:mm a")) + 
            "Open on weekends: " + openWeekends + 
            "Has used books: " + hasUsedBooks + 
            "Square footage: " + sqFeet;
    }
}