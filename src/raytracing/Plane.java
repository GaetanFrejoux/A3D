package raytracing;

/**
 * The type Plane.
 */
public class Plane extends IntersectObject {
    private final Vec3d normals;
    private final double distance;

    /**
     * Instantiates a new Plane.
     *
     * @param materialDiffuse  the material diffuse
     * @param materialSpecular the material specular
     * @param reflection       the reflection
     * @param refraction       the refraction
     * @param shininess        the shininess
     * @param refractionIndex  the refraction index
     * @param normals          the normals
     * @param distance         the distance
     */
    Plane (Color materialDiffuse, Color materialSpecular, double reflection, double refraction, double shininess, double refractionIndex, Vec3d normals, double distance){
        super(materialDiffuse, materialSpecular, reflection, refraction, shininess, refractionIndex);
        this.normals = normals;
        this.distance = distance;
    }

    @Override
    public double getIntersection(Vec3d P, Vec3d v) {
        if(v.dotProduct(normals) == 0){
            return -1;
        }
        double lambda = (-normals.dotProduct(P) + distance) / v.dotProduct(normals);
        if(lambda < 0){
            return -1;
        }
        return lambda;
    }

    @Override
    public Vec3d getNormal(Vec3d i) {
        return normals;
    }

}
