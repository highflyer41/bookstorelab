import java.time.LocalTime;

/**
 * BookstoreDriver
 */
public class BookstoreDriver {

    public static void main(String[] args) {
        Bookstore store = new Bookstore("Narnes & Boble", "1414 S Tryon St.", 4000, true, true);

        System.out.println("What is the address?");
        System.out.println(store.getAddress());
        System.out.println("What time does the store open today?");
        System.out.println(store.getOpen());
        System.out.println("What time does it close?");
        System.out.println(store.getClose());
        System.out.println("Is it open right now?");
        System.out.println(store.isOpen(LocalTime.now()));
        System.out.println("How big is the store?");
        System.out.println(store.getSqFeet() + " square feet");
        System.out.println("Does the store have new or used books?");
        System.out.println(store.isHasUsedBooks() ? "Both" : "New only");

        System.out.println("\nNumber of books: ");
        System.out.println(store.getNumberBooks());
        System.out.println("\nSearch for 'java': ");
        store.searchTitles("java");

    }//End of Main
}//End of Class