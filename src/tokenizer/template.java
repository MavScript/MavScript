package tokenizer;
import tokenizer.*;
import tokenizer.tokenizer;
import java.io.*;
import java.util.*;
import java.io.IOException;

public class template{

     cli command_line= new cli();
     String file_name= command_line.file_name;
     int index=file_name.indexOf('.');
     String file_dec=file_name.substring(0,'.')+".java";
     

    public void file_java_write() throws IOException
    {
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
        System.out.println("got here");
}
}