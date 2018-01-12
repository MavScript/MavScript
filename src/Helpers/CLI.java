package Helpers;

/**
 * Created by justa on 1/11/2018.
 */
public class CLI {
    void help() {
        System.out.println("MavScript\nCMD options:\n\n");
        System.out.println("[-f <path_to_file>] - Compiles the .mav file given in the path");
        System.out.println("[-file <path_to_file>] - Compiles a single .mav file (same function as -f)");
        System.out.println("[-d <path_to_folder>] - Compiles all .mav files in directory");
        System.out.println("[-directory <path_to_folder>] - Compiles all .mav files in directory (same as -d)");
    }
}
