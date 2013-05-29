package name.delonnewman.datediff;

public class Utils {
    /**
     * Take <code>int</code> value and return <code>String</code>
     * value with a prepended zero if it's less than 10.
     *
     * @param value
     * @return String
     */
    public static String padZeros(int value) {
        if ( value < 10 ) return "0" + value;
        else              return String.valueOf(value);
    }
}
