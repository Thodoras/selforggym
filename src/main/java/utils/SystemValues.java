package utils;

import java.awt.*;

public final class SystemValues {

    private static final SystemValues INSTANCE = new SystemValues();

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private SystemValues() {

    }

    public static SystemValues getInstance() {
        return INSTANCE;
    }

    public double getScreenSizeWidth() {
        return screenSize.getWidth();
    }

    public double getScreenSizeHeight() {
        return screenSize.getHeight();
    }

}
