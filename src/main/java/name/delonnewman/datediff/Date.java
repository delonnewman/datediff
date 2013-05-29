package name.delonnewman.datediff;

/**
 *
 * Represents a date with year, month, and day values
 *
 * @author delon.newman@gmail.com (Delon Newman)
 *
 */
public final class Date {
    private static final int   EPOCH_YEAR = 1970; // In honor of Unix
    private static final int[] MONTH_DAYS = {
            31, // January
            28, // February
            31, // March
            30, // April
            31, // May
            30, // June
            31, // July
            31, // August
            30, // September
            31, // October
            30, // November
            31  // December
    };

    private final int  year;
    private final int  month;
    private final int  day;
    private final long epochDays;

    /**
     * Construct <code>Date</code> instance from year, month, and day
     * <code>int</code> values.
     *
     * @param year
     * @param month
     * @param day
     */
    public Date(int year, int month, int day) {
        this.year      = year;
        this.month     = month;
        this.day       = day;
        this.epochDays = getEpochDays();
    }

    /**
     * Return year value
     *
     * @return int
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Return month value
     *
     * @return int
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Return day value
     *
     * @return int
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Return <code>true</code> if the Date's year is a leap year
     * return false otherwise.
     *
     * @return boolean
     */
    public boolean isLeapYear() {
        return this.year % 4 == 0;
    }

    /**
     * Find the difference between two date values in days.
     *
     * @param that
     * @return long
     */
    public long diff(Date that) {
        return this.epochDays - that.epochDays;
    }

    /**
     * Return <code>Date</code> value as a <code>String</code>
     * in DD-MM-YYYY format.
     *
     * @return String
     */
    public String toString() {
        return Utils.padZeros(this.day) + '-' +
                Utils.padZeros(this.month) + '-' +
                this.year;
    }

    private int getEpochDays() {
        int leap  = leapYearsSinceEpoch();
        int years = yearsSinceEpoch() - leap;
        int days  = (years * 365) + (leap * 366);

        for (int i = 0; i < this.month - 1; i++) {
            // days are 29 if it's a leap year and the month is February
            if ( this.isLeapYear() && i == 1 ) {
                days += 29;
            }
            else {
                days += MONTH_DAYS[i];
            }
        }

        return days + this.day;
    }

    private int yearsSinceEpoch() {
        return this.year - EPOCH_YEAR;
    }

    private int leapYearsSinceEpoch() {
        int n     = yearsSinceEpoch();
        int leaps = n / 4;

        if ( n % 4 < 2 ) return leaps;
        else             return leaps + 1;
    }
}
