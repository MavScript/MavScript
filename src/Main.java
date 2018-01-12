import Helpers.CLI;

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
        CLI cli = new CLI(args);
        String flag = args[0];

        // check if the -f flag is present
        // meaning a single file should be compiled
        if (flag.equals("-f") || flag.equals("-file")) {
            cli.file();
        }

        // check for the -d comand, meaning an entire
        // folder should be compiled
        if (flag.equals("-d") || flag.equals("-directory")) {
            cli.directory();
        }

        if (flag.equals("-h")) {
            cli.help();
        }

        if (flag.equals("-v")) {
            cli.version();
        }
    }
}