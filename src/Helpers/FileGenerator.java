package Helpers;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by justa on 1/11/2018.
 */
public class FileGenerator {

    public static void writeJavaToFile(String java, String path) {
        try {
            String filename = path.substring(0, path.indexOf('.'));
            BufferedWriter out = new BufferedWriter(new FileWriter(filename + ".java"));
            out.write(java);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FUCK");
        }
    }
}
