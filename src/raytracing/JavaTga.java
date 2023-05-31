package raytracing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * The type Java tga.
 *
 * @author P. Meseure based on a Java Adaptation of a C code by B. Debouchages (M1, 2018-2019)
 */
public class JavaTga
{
    /**
     * Write short.
     *
     * @param fout : output file stream
     * @param n    : short to write to disc in little endian
     * @throws IOException the io exception
     */
    protected static void writeShort(FileOutputStream fout,int n) throws IOException
    {
        fout.write(n&255);
        fout.write((n>>8)&255);
    }

    /**
     * Save tga.
     *
     * @param filename name of final TGA file
     * @param buffer   buffer that contains the image. 3 bytes per pixel ordered this way : Blue, Green, Red
     * @param width    Width of the image
     * @param height   Height of the image
     * @throws IOException                  Thrown if the file cannot be written
     * @throws UnsupportedEncodingException Thrown if the encoding is not supported
     */
    protected static void saveTGA(String filename, byte buffer[], int width, int height) throws IOException {

        FileOutputStream out = new FileOutputStream(filename);

        out.write(0); // Comment size, no comment
        out.write(0); // Colormap type: No colormap
        out.write(2); // Image type
        writeShort(out,0); // Origin
        writeShort(out,0); // Length
        out.write(0); // Depth
        writeShort(out,0); // X origin
        writeShort(out,0); // Y origin
        writeShort(out,width); // Width of the image
        writeShort(out,height); // Height of the image
        out.write(24); // Pixel size in bits (24bpp)
        out.write(0); // Descriptor

        /* Write the buffer */
        out.write(buffer);

        out.close();
    }

    /**
     * The entry point of application.
     *
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        int w=1024;
        int h=768;
        byte buffer[]=new byte[3*w*h];
        
        for(int row = 0; row < h; row++){ // for each row of the image
            for(int col = 0; col < w; col++){ // for each column of the image
                
                int index = 3*((row*w)+col); // compute index of color for pixel (x,y) in the buffer
                
                // Ensure that the pixel is black
                buffer[index]=0; // blue : take care, blue is the first component !!!
                buffer[index+1]=0; // green
                buffer[index+2]=0; // red (red is the last component !!!)




            }
        }
        try {
            saveTGA("imagetest.tga",buffer,w,h);
        }
        catch(Exception e)
        {
            System.err.println("TGA file not created :"+e);
        }
    }  
}

