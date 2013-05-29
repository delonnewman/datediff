package name.delonnewman.datediff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TestDate {
    @Test
    public void testDateParse() throws Exception {
        Date date = DateParser.parse("22-05-2013");
        assertEquals(22, date.getDay());
        assertEquals(5, date.getMonth());
        assertEquals(2013, date.getYear());
    }

    @Test
    public void testDateToString() throws Exception {
        Date d = new Date(2013, 5, 28);
        assertEquals("28-05-2013", d.toString());
    }

    @Test
    public void testDateDiff50() throws Exception {
        Date d1   = DateParser.parse("01-06-1983");
        Date d2   = DateParser.parse("21-07-1983");
        long diff = d2.diff(d1);
        assertEquals(50, diff);
    }

    @Test
    public void testDateDiff180() throws Exception {
        Date d1   = DateParser.parse("02-01-1983");
        Date d2   = DateParser.parse("01-07-1983");
        long diff = d2.diff(d1);
        assertEquals(180, diff);
    }

    @Test
    public void testDateDiff11174() throws Exception {
        Date d1   = DateParser.parse("30-05-1974");
        Date d2   = DateParser.parse("01-01-2005");
        long diff = d2.diff(d1);
        assertEquals(11174, diff);
    }
}
