package raytracing;

/**
 * The type Color.
 */
public class Color {

    private final double blue, green, red;

    /**
     * The constant WHITE.
     */
    public final static Color WHITE = new Color(255d, 255d, 255d);
    /**
     * The constant BLACK.
     */
    public final static Color BLACK = new Color(0d, 0d, 0d);
    /**
     * The constant RED.
     */
    public final static Color RED = new Color(255d, 0d, 0d);
    /**
     * The constant GREEN.
     */
    public final static Color GREEN = new Color(0d, 255d, 0d);
    /**
     * The constant BLUE.
     */
    public final static Color BLUE = new Color(0d, 0d, 255d);
    /**
     * The constant YELLOW.
     */
    public final static Color YELLOW = new Color(255d, 255d, 0d);
    /**
     * The constant CYAN.
     */
    public final static Color CYAN = new Color(0d, 255d, 255d);
    /**
     * The constant MAGENTA.
     */
    public final static Color MAGENTA = new Color(255d, 0d, 255d);
    /**
     * The constant GRAY.
     */
    public final static Color GRAY = new Color(128d, 128d, 128d);
    /**
     * The constant LIGHT_GRAY.
     */
    public final static Color LIGHT_GRAY = new Color(192d, 192d, 192d);
    /**
     * The constant DARK_GRAY.
     */
    public final static Color DARK_GRAY = new Color(64d, 64d, 64d);

    /**
     * Instantiates a new Color.
     *
     * @param red   the red
     * @param green the green
     * @param blue  the blue
     */
    public Color(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Gets blue.
     *
     * @return the blue
     */
    public double getBlue() {
        return red;
    }

    /**
     * Gets green.
     *
     * @return the green
     */
    public double getGreen() {
        return green;
    }

    /**
     * Gets red.
     *
     * @return the red
     */
    public double getRed() {
        return blue;
    }


    /**
     * Add color.
     *
     * @param c the c
     * @return the color
     */
    public Color add(Color c) {
        return new Color(Math.min(this.red + c.red, 255d), Math.min(this.green + c.green, 255d), Math.min(this.blue + c.blue, 255d));
    }

    /**
     * Multiply color.
     *
     * @param c the c
     * @return the color
     */
    public Color multiply(Color c) {
        return new Color((this.red * c.red)/255d, (this.green * c.green)/255d, (this.blue * c.blue)/255d);
    }

    /**
     * Scale color.
     *
     * @param d the d
     * @return the color
     */
    public Color scale(double d) {
        return new Color(Math.min(this.red * d, 255d), Math.min(this.green * d, 255d), Math.min(this.blue * d, 255d));
    }
}
