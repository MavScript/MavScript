
package tokenizer;
import tokenizer.*;
import tokenizer.tokenizer;
import java.io.*;
import java.util.*;
import java.io.IOException;



/**
 * Created by justa on 9/30/2017.
 */

public class parse extends tokenizer {
    //cli command_line= new cli();

    //String file_name= command_line.file_name;
    String file_name = "helloabc.mav";
    int index = file_name.indexOf('.');
    String new_file_name = file_name.substring(0, index);

    String file_dec = new_file_name + ".java";

    public void parse_syntax_list(List<Line> AST) throws IOException {
        System.out.println("WTF");
        Javafy javafy = new Javafy();

        // iterate over lines
        for (Line cur : AST) {
            String type = cur.type;
            if (type.equals("assign")) {
                String j;
                if (cur.var.type.equals("string")) {
                    j = javafy.assign_str(cur);
                } else {
                    j = javafy.assign_num(cur);
                }
                System.out.println('s'); // write to file

            } else if (type.equals("control")) {
                Control c = cur.cont;
                String ctype = c.type;
                String args = c.args;
                List<Line> inline = cur.block;

            }
        }
    }


    void file_java_write() throws IOException {
        System.out.println("WTF");
        File file = new File(file_dec);
        FileWriter out = new FileWriter(file);
        PrintWriter printr = new PrintWriter(out);
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
        printr.println("public class " + new_file_name);
        printr.println("{");
        printr.println("public static void main(String[] args");
        printr.println("{");
        printr.println("}");
        printr.println("}");
        System.out.println("got here");


    }


    class Javafy {


        String assign_num(Line cur) {
            Variable v = cur.var;
            String name = v.name;
            String val = v.val;
            String var_type = v.type;

            return var_type + " " + name + " = " + val + ";";
        }

        String assign_str(Line cur) {
            Variable v = cur.var;
            return v.type + " " + v.name + " = \"" + v.val + "\";";
        }

        String assign_if(Line cur) {
            Control c = cur.cont;
            // iterate over inline liens
            return null; // TODO:
        }
    }
}