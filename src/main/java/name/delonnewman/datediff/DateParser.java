package name.delonnewman.datediff;

import java.lang.StringBuilder;

/**
 *
 * Parses date strings and returns <code>Date</code> instances
 *
 * @author delon.newman@gmail.com (Delon Newman)
 *
 */
public final class DateParser {
    /**
     * Parse date string in DD-MM-YYYY format and
     * return <code>Date</code> instance
     *
     * @param string
     * @return A Date instance
     */
    public static Date parse(String string) {
        return parseDateFromString(string);
    }

    private static Date parseDateFromString(String string) {
        // events
        boolean dayEnded   = false;
        boolean monthEnded = false;

        StringBuilder day   = new StringBuilder();
        StringBuilder month = new StringBuilder();
        StringBuilder year  = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ( dayEnded == false ) {
                if ( c != '-' ) day.append(c);
                else {
                    dayEnded = true;
                    continue;
                }
            }

            if ( dayEnded == true ) {
                if ( monthEnded == false ) {
                    if ( c != '-' ) month.append(c);
                    else {
                        monthEnded = true;
                        continue;
                    }
                }

                if ( monthEnded == true ) {
                    year.append(c);
                }
            }
        }

        return new Date(
            Integer.valueOf(year.toString()),
            Integer.valueOf(month.toString()),
            Integer.valueOf(day.toString())
        );
    }
}
