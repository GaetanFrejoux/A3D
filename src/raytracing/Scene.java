package raytracing;

import java.util.ArrayList;

/**
 * The type Scene.
 */
public class Scene {

    private final ArrayList<IntersectObject> objects;
    private final ArrayList<Light> lights;
    private Color ambientLight;

    /**
     * Instantiates a new Scene.
     *
     * @param ambientLight the ambient light
     */
    public Scene(Color ambientLight) {
        this.objects = new ArrayList<>();
        this.lights = new ArrayList<>();
        this.ambientLight = ambientLight;
    }

    /**
     * Add object.
     *
     * @param object the object
     */
    public void addObject(IntersectObject object) {
        this.objects.add(object);
    }

    /**
     * Add light.
     *
     * @param light the light
     */
    public void addLight(Light light) {
        this.lights.add(light);
    }

    /**
     * Gets ambient light.
     *
     * @return the ambient light
     */
    public Color getAmbientLight() {
        return ambientLight;
    }

    /**
     * Sets ambient light.
     *
     * @param ambientLight the ambient light
     */
    public void setAmbientLight(Color ambientLight) {
        this.ambientLight = ambientLight;
    }

    /**
     * Find color.
     *
     * @param P     the p
     * @param v     the v
     * @param depth the depth
     * @return the color
     */
    public Color findColor(Vec3d P, Vec3d v, int depth) {

        if(depth <= 0) return ambientLight;

        double nearestDistance = Double.MAX_VALUE; // the nearest distance to an object
        IntersectObject nearestObject = null; // the nearest object to the ray

        // find the nearest object with its distance and color.

        for (IntersectObject object : this.objects) {

            double distance = object.getIntersection(P, v);

            if (distance > 0d && distance < nearestDistance) {
                nearestDistance = distance;
                nearestObject = object;
            }

        }

        if (nearestObject == null) {
            return ambientLight;
        }
        nearestDistance -= 0.001d;


        Vec3d I = P.add(v.scale(nearestDistance));
        Vec3d N = nearestObject.getNormal(I);

        //if we are inside the object, we need to flip the normal
        boolean insideObject = v.dotProduct(N) > 0d;

        if (insideObject) {
            N = N.scale(-1.0d);
        }

        Color colorMaterial = nearestObject.getMaterialDiffuse(I);
        Color colorAnswer = ambientLight.multiply(colorMaterial);

        for (Light light : this.lights) {

            boolean visible = true;

            Vec3d IS = light.getPosition().sub(I);

            for (IntersectObject object : this.objects) {

                double t = object.getIntersection(I, IS);

                if (t > 0d && t < 1d) {
                    visible = false;
                    break; // if we are in the shadow, we don't need to continue
                }
            }
            if (visible) {

                IS.setNormalize();
                Vec3d vTemp = v.normalize();

                Color diffuse = light.getLightColor().multiply(colorMaterial.scale(Math.max(N.dotProduct(IS), 0d)));
                Vec3d R = IS.sub(N.scale(Math.max(N.dotProduct(IS), 0d) * 2d));
                Color specular = light.getSpecularColor().multiply(nearestObject.getMaterialSpecular().scale(Math.pow(Math.max(R.dotProduct(vTemp), 0d), nearestObject.getShininess())));

                colorAnswer = colorAnswer.add(diffuse).add(specular);
            }
        }

        if (nearestObject.getReflection() > 0d) {
            Vec3d R = v.sub(N.scale(2.0D * N.dotProduct(v))).setNormalize();
            colorAnswer = colorAnswer.add(findColor(I, R, depth - 1).scale(nearestObject.getReflection()));
        }

        if (nearestObject.getRefraction() > 0d) {

            final double eta = ((insideObject) ? nearestObject.getRefractionIndex() : (1d / nearestObject.getRefractionIndex()));
            final double c1 = (N.scale(-1d)).dotProduct(v);
            final double c2 = Math.sqrt(1d - eta * eta * (1d - c1 * c1));
            final Vec3d refractDir = v.scale(eta).add(N.scale( (eta * c1 - c2))).normalize();

            colorAnswer = colorAnswer.add(findColor(I,refractDir,depth - 1).scale(nearestObject.getRefraction()));
        }

        return colorAnswer;
    }


    /**
     * Example scene.
     */
    public void exampleScene() {

    }

}
