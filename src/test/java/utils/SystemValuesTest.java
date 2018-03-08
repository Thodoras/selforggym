package utils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class SystemValuesTest {

    private static double ERROR_MARGIN = 0.001;

    @Before
    public void setup() {}

    @Test
    public void testGetScreenSizeHeightReturnsCorrectValue() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        double expected = screenSize.getHeight();
        double actual = SystemValues.getInstance().getScreenSizeHeight();

        assertEquals(expected, actual, ERROR_MARGIN);
    }
}
