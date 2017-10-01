package tokenizer;
import tokenizer.*;
import tokenizer.tokenizer;
import java.io.*;
import java.util.*;
import java.io.IOException;

public class finalize extends{
    cli command_line=new cli();
    void execute() throws IOException{
        Process p= Runtime.getRuntime().exec("javac "+command_line.file_dec+".java");
        Process q= Runtime.getRuntime().exec("java "+command_line.file_name.substring(0,command_line.index));
    }

}