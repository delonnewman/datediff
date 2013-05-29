package name.delonnewman.datediff;

/**
 *
 * Takes two dates as command-line arguments and returns the difference
 * between them in days.
 *
 * @author delon.newman@gmail.com (Delon Newman)
 *
 */
public class App {
    public static void main(String[] argv) {
        if ( argv.length < 2 ) {
            System.out.println("Usage: datediff DD-MM-YYYY DD-MM-YYYY");
            System.exit(1);
        }

        Date d1  = DateParser.parse(argv[0]);
        Date d2  = DateParser.parse(argv[1]);
        long res = d2.diff(d1);

        System.out.println("From " + d1 + " to " + d2 + ": " + res + " days");
        System.exit(0);
    }
}
