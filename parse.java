
package tokenizer;
import tokenizer.*;
import tokenizer.tokenizer.Line;
import java.io.*;
import java.util.*;
import java.io.IOException;



/**
 * Created by justa on 9/30/2017.
 */

public class parse extends tokenizer{
    cli command_line= new cli();

    //String file_name= command_line.file_name;
    String file_name="helloabc.mav";
    int index=file_name.indexOf('.');
    String new_file_name=file_name.substring(0,index);

    String file_dec=new_file_name+".java";

    public void parse_syntax_list(List<Line> a) throws IOException {
        ArrayList syntax_app = new ArrayList();
        int size = a.size();
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }






    void file_java_write() throws IOException{
        File file = new File(file_dec);
        FileWriter out = new FileWriter(file);
        PrintWriter printr= new PrintWriter(out);
        printr.println("import java.util.*");
        printr.println("import java.lang.*");
        printr.println("import java.io.*");
        printr.println("import java.net.*");
        printr.println("import java.security.*");
        printr.println("import java.sql.*");
        printr.println("import java.swing.*");
        printr.println("import java.rmi.*");
        printr.println("import java.nio.*");
        printr.println("import java.text.*");
        printr.println("import java.awt.*");
        printr.println("public class "+new_file_name);
        printr.println("{");
        printr.println("public static void main(String[] args");
        printr.println("{");
        printr.println("}");
        printr.println("}");





    }



}

