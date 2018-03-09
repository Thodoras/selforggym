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
    public void testGetResolutionHightReturnsCorrectValue() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        double expected = screenSize.getHeight();
        double actual = SystemValues.getInstance().getScreenSizeHeight();

        assertEquals(expected, actual, ERROR_MARGIN);
    }

    @Test
    public void testGetResolutionWidthReturnsCorrectValue() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        double expected = screenSize.getWidth();
        double actual = SystemValues.getInstance().getScreenSizeWidth();

        assertEquals(expected, actual, ERROR_MARGIN);
    }
    
}
