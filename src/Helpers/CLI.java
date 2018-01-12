package Helpers;

import java.io.IOException;

/**
 * Created by justa on 1/11/2018.
 */
public class CLI {
    String[] args;

    public CLI(String[] args) {
        this.args = args;
    }

    public void file() throws IOException {
        String filename = this.args[1];
        System.out.println(filename);
        Compiler c = new Compiler();
        String java = c.compileMavScript(filename);
        FileGenerator.writeJavaToFile(java, filename);
        System.out.println("Success");
    }

    public void directory() {

    }

    public void help() {
        System.out.println("MavScript\nCMD options:\n\n");
        System.out.println("[-f <path_to_file>] - Compiles the .mav file given in the path");
        System.out.println("[-file <path_to_file>] - Compiles a single .mav file (same function as -f)");
        System.out.println("[-d <path_to_folder>] - Compiles all .mav files in directory");
        System.out.println("[-directory <path_to_folder>] - Compiles all .mav files in directory (same as -d)");
        System.out.println("[-v] - shows current version");
        System.out.println("[-h] - shows all available flags");
    }

    public void version() {
        System.out.println("MavScript: 1.0");
    }
}
