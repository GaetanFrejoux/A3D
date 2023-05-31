package raytracing;

/**
 * The type Vec 3 d.
 */
public class Vec3d {
    /**
     * The X.
     */
    public double x, /**
     * The Y.
     */
    y, /**
     * The Z.
     */
    z;

    /**
     * Instantiates a new Vec 3 d.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Instantiates a new Vec 3 d.
     *
     * @param v the v
     */
    public Vec3d(Vec3d v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    /**
     * Add vec 3 d.
     *
     * @param v the v
     * @return the vec 3 d
     */
    public Vec3d add(Vec3d v) {
        return new Vec3d(x + v.x, y + v.y, z + v.z);
    }

    /**
     * Sub vec 3 d.
     *
     * @param v the v
     * @return the vec 3 d
     */
    public Vec3d sub(Vec3d v) {
        return new Vec3d(x - v.x, y - v.y, z - v.z);
    }

    /**
     * Scale vec 3 d.
     *
     * @param k the k
     * @return the vec 3 d
     */
    public Vec3d scale(double k) {
        return new Vec3d(x * k, y * k, z * k);
    }

    /**
     * Dot product double.
     *
     * @param v the v
     * @return the double
     */
    public double dotProduct(Vec3d v) {
        return x * v.x + y * v.y + z * v.z;
    }

    /**
     * Cross product vec 3 d.
     *
     * @param v the v
     * @return the vec 3 d
     */
    public Vec3d crossProduct(Vec3d v) {
        return new Vec3d(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Sets normalize.
     *
     * @return the normalize
     */
    public Vec3d setNormalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    /**
     * Normalize vec 3 d.
     *
     * @return the vec 3 d
     */
    public Vec3d normalize() {
        return new Vec3d(x, y, z).setNormalize();
    }


}
