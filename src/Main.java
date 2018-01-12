import Helpers.Compiler;
import Helpers.FileGenerator;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Anthony Vardaro
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));

        if (args.length == 0) {
            System.out.println("\nPlease supply cmd arguments");
            return;
        }

        String flag = args[0];

        String filename;

        // check if the -f flag is present
        // meaning a single file should be compiled
        if (flag.equals("-f") || flag.equals("-file")) {
            filename = args[1];
            Compiler c = new Compiler();
            String java = c.compileMavScript(filename);
            FileGenerator.writeJavaToFile(java, filename);
        }

        // check for the -d comand, meaning an entire
        // folder should be compiled
        if (flag.equals("-d") || flag.equals("-directory")) {

        }

        System.out.println("\nSuccess");
    }
}