
package tokenizer;
import java.io.*;
import java.util.*;
import java.io.IOException;

public class finalize extends tokenizer{

    public void final_run() throws IOException
    {
//        String file_n=parser.file_dec;
//        String new_file_n=parser.new_file_name;
//        Process p=Runtime.getRuntime().exec(
//                new String[]{"javac "+file_n+"&& java "+new_file_n });
        Runtime.getRuntime().exec("javac examples/compiled/mylitfile.java");
        Runtime.getRuntime().exec("java examples/compiled/mylitfile");
    }
}