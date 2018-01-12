import Helpers.FileGenerator;
import Helpers.Parser;
import Helpers.Tokenizer;
import Helpers.Tokenizer.Line;
import Helpers.Compiler;
import Helpers.FileGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String filename = "";

        // check if the -f flag is present
        if (args[0].equals("-f")) {
            filename = args[1];
        } else {
            System.out.println("wat");
        }

        // write java string to file
        Compiler c = new Compiler();

        String java = c.compileMavScript(filename);

        FileGenerator.writeJavaToFile(java, filename);
        System.out.println("\nSuccess");
    }
}