package raytracing;

/**
 * The type Intersect object.
 */
public abstract class IntersectObject {

  /**
   * The Material diffuse.
   */
  protected final Color materialDiffuse, /**
   * The Material specular.
   */
  materialSpecular;
  /**
   * The Reflection.
   */
  protected final double reflection, /**
   * The Refraction.
   */
  refraction, /**
   * The Shininess.
   */
  shininess;
  /**
   * The Refraction index.
   */
  protected final double refractionIndex;

  /**
   * Instantiates a new Intersect object.
   *
   * @param materialDiffuse  the material diffuse
   * @param materialSpecular the material specular
   * @param reflection       the reflection
   * @param refraction       the refraction
   * @param shininess        the shininess
   * @param refractionIndex  the refraction index
   */
  protected IntersectObject(Color materialDiffuse, Color materialSpecular, double reflection, double refraction, double shininess, double refractionIndex) {
    this.materialDiffuse = materialDiffuse;
    this.materialSpecular = materialSpecular;
    this.reflection = reflection;
    this.refraction = refraction;
    this.shininess = shininess;
    this.refractionIndex = refractionIndex;
  }

  /**
   * Gets intersection.
   *
   * @param P the p
   * @param v the v
   * @return the intersection
   */
  public abstract double getIntersection(Vec3d P, Vec3d v);

  /**
   * Gets normal.
   *
   * @param i the
   * @return the normal
   */
  public abstract Vec3d getNormal(Vec3d i);

  /**
   * Gets material diffuse.
   *
   * @param i the
   * @return the material diffuse
   */
  public Color getMaterialDiffuse(Vec3d i) {
    return materialDiffuse;
  }

  /**
   * Gets material specular.
   *
   * @return the material specular
   */
  public Color getMaterialSpecular() {
    return materialSpecular;
  }

  /**
   * Gets reflection.
   *
   * @return the reflection
   */
  public double getReflection() {
    return reflection;
  }

  /**
   * Gets refraction.
   *
   * @return the refraction
   */
  public double getRefraction() {
    return refraction;
  }

  /**
   * Gets shininess.
   *
   * @return the shininess
   */
  public double getShininess() {
    return shininess;
  }

  /**
   * Gets refraction index.
   *
   * @return the refraction index
   */
  public double getRefractionIndex() {
    return refractionIndex;
  }
}
