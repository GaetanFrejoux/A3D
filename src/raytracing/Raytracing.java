package raytracing;

import java.util.logging.Logger;

/**
 * The type Main scene.
 */
public class Raytracing extends JavaTga {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Raytracing.class.getName());
        Scene scene = new Scene(Color.DARK_GRAY);

        //adding objects to the scene
        scene.addObject(new CheckPlane(Color.BLACK, Color.WHITE, Color.WHITE, 0.3,0.0d,1000.0d, 0.0d, new Vec3d(0.0d,1.0d,0.0d), -1.0d));
        scene.addObject(new Sphere(Color.RED, Color.RED, 0.4d, 0d, 1000.0d, 0.0d, new Vec3d(7.0d, 3.0d, 0.0d), 3.0f));
        scene.addObject(new Sphere(Color.GREEN, Color.GREEN, 0.6d, 0d, 1000.0d, 0.0d, new Vec3d(0.0d, 3.0d, 0.0d), 3.0f));
        scene.addObject(new Sphere(Color.BLUE, Color.BLUE, 0.8d, 0d, 1000.0d, 0.0d, new Vec3d(-7.0d, 3.0d, 0.0d), 3.0f));
        scene.addLight(new Light(new Vec3d(0d, 20d, 0d), Color.WHITE, Color.LIGHT_GRAY));

        logger.info("Generating the tga file");

        generateTga(new Vec3d(0,3,30), 2000, 2000, scene, "output", new Vec3d(0,0,-1));

        logger.info("tga file generated");
    }

    /**
     * Generate tga.
     *
     * @param eye       the eye
     * @param w         the w
     * @param h         the h
     * @param scene     the scene
     * @param filename  the filename
     * @param direction the direction
     */
    static void generateTga(Vec3d eye, int w, int h, Scene scene, String filename, Vec3d direction) {
        byte buffer[]=new byte[3*w*h];

        for(int row = 0; row < h; row++){ // for each row of the image
            for(int col = 0; col < w; col++){ // for each column of the image

                int index = 3*((row*w)+col); // compute index of color for pixel (x,y) in the buffer

                Vec3d v = new Vec3d(direction.x + (col - w/2.0d)/h, direction.y + (row - h/2.0d)/h, direction.z);
                Color color = scene.findColor(eye, v, 5);

                buffer[index]=(byte) color.getBlue();       // blue
                buffer[index+1]=(byte) color.getGreen();    // green
                buffer[index+2]=(byte) color.getRed();      // red
            }
        }
        try {
            saveTGA(filename + ".tga",buffer,w,h);
        }
        catch(Exception e)
        {
            System.err.println("TGA file not created :"+e);
        }


    }
}
