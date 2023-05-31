Projet Ray tracing made by Frejoux Gaetan


Inside the src,

To compile :
  use makefile with : make

To run :
  use makefile with : make run

To clean :
  use makefile with : make clean

The list of classes :

    - IntersectObject : Abstract class for all object that can be intersected
        - Sphere : Sphere object
        - Plane : Plane object
            - CheckPlane : Plane object with a checkerboard texture
    - Color : RGB color class with some arithmetic operators
    - Vec3d : 3D double vector class with some arithmetic operators*
    - Raytracing : The main class that contains the main function
    - Scene : The scene class that contains all the objects, lights and the camera
    - Light : A point light class


The project come with an example of scene based on the example from the course.
To create your own scene you must edit the main function in the Raytracing class.

Here is the configuration of the example scene (add to the main function inside Ratracing class) :

	scene.addObject(new CheckPlane(Color.BLACK, Color.WHITE, Color.WHITE, 0.3,0.0d,1000.0d, 0.0d, new Vec3d(0.0d,1.0d,0.0d), -1.0d));
      scene.addObject(new Sphere(Color.RED, Color.RED, 0.4d, 0d, 1000.0d, 0.0d, new Vec3d(7.0d, 3.0d, 0.0d), 3.0f));
      scene.addObject(new Sphere(Color.GREEN, Color.GREEN, 0.6d, 0d, 1000.0d, 0.0d, new Vec3d(0.0d, 3.0d, 0.0d), 3.0f));
      scene.addObject(new Sphere(Color.BLUE, Color.BLUE, 0.8d, 0d, 1000.0d, 0.0d, new Vec3d(-7.0d, 3.0d, 0.0d), 3.0f));
      scene.addLight(new Light(new Vec3d(0d, 20d, 0d), Color.WHITE, Color.LIGHT_GRAY));

	generateTga(new Vec3d(0,3,22), 2000, 2000, scene, "output", new Vec3d(0,0,-1));