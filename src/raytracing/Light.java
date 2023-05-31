package raytracing;

/**
 * The type Light.
 */
public class Light {

    private final Vec3d position;
    private final Color lightColor, specularColor;

    /**
     * Instantiates a new Light.
     *
     * @param position      the position
     * @param lightColor    the light color
     * @param specularColor the specular color
     */
    public Light(Vec3d position, Color lightColor, Color specularColor) {
        this.position = position;
        this.lightColor = lightColor;
        this.specularColor = specularColor;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Vec3d getPosition() {
        return position;
    }

    /**
     * Gets light color.
     *
     * @return the light color
     */
    public Color getLightColor() {
        return lightColor;
    }

    /**
     * Gets specular color.
     *
     * @return the specular color
     */
    public Color getSpecularColor() {
        return specularColor;
    }
}

