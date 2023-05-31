package raytracing;

/**
 * The type Check plane.
 */
public class CheckPlane extends Plane {
    private final Color alternativeColor;

    /**
     * Instantiates a new Check plane.
     *
     * @param color            the color
     * @param alternativeColor the alternative color
     * @param materialSpecular the material specular
     * @param reflection       the reflection
     * @param refraction       the refraction
     * @param shininess        the shininess
     * @param refractionIndex  the refraction index
     * @param normals          the normals
     * @param distance         the distance
     */
    CheckPlane (Color color, Color alternativeColor, Color materialSpecular, double reflection, double refraction, double shininess, double refractionIndex, Vec3d normals, double distance){
        super(color, materialSpecular, reflection, refraction, shininess, refractionIndex, normals, distance);
        this.alternativeColor = alternativeColor;
    }

    @Override
    public Color getMaterialDiffuse(Vec3d i) {
        return (Math.floor(i.x) + Math.floor(i.z)) % 2.0d == 0.0d ? this.materialDiffuse : alternativeColor;
    }
}
