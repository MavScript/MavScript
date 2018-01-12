package Helpers;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by justa on 1/11/2018.
 */
public class FileGenerator {

    public static void writeJavaToFile(String java, String path) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path + ".java"));
            out.write(java);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FUCK");
        }
    }
}
