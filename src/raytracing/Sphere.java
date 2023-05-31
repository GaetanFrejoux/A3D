package raytracing;

/**
 * The type Sphere.
 */
public class Sphere extends IntersectObject {

  private final double radius;
  private final Vec3d center;

    /**
     * Instantiates a new Sphere.
     *
     * @param materialDiffuse  the material diffuse
     * @param materialSpecular the material specular
     * @param reflection       the reflection
     * @param refraction       the refraction
     * @param shininess        the shininess
     * @param refractionIndex  the refraction index
     * @param center           the center
     * @param radius           the radius
     */
    public Sphere(Color materialDiffuse, Color materialSpecular, double reflection, double refraction, double shininess, double refractionIndex, Vec3d center, double radius) {
    super(materialDiffuse, materialSpecular, reflection, refraction, shininess, refractionIndex);
    this.radius = radius;
    this.center = center;
  }

  @Override
  public double getIntersection(Vec3d P, Vec3d v) {
    Vec3d C = P.sub(center);
    double a = v.dotProduct(v);
    double b = 2d * v.dotProduct(C);
    double c = C.dotProduct(C) - radius * radius;
    double delta = b * b - 4d * a * c;
    if (delta < 0d) {
      return -1d;
    }
    double lambda1 = (-b -  Math.sqrt(delta)) / (2d * a);
    double lambda2 = (-b +  Math.sqrt(delta)) / (2d * a);
    if (lambda1 < 0d && 0d < lambda2) return lambda2;
    else if (0d < lambda1 && lambda1 < lambda2) return lambda1;
    else return -1d;
  }

  @Override
  public Vec3d getNormal(Vec3d i) {
    return i.sub(center).normalize();
  }
}
