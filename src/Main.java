package tokenizer;
import tokenizer.*;
import tokenizer.tokenizer.Line;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        tokenizer tok = new tokenizer();         
        //Line a = tok.get_tree("mav mdicik = 5.6;");

        String n; 
        int k=0;
        try
        {
            FileReader fr=new FileReader("helloworld.mav");
            BufferedReader in=new BufferedReader(fr);

            //System.out.println("Following are the details in the file:");
            while((n=in.readLine())!=null)
            {                
                k++;
            }
            in.close();
            fr.close();

            Line AST[]=new Line[k];
            int i=0;
            fr=new FileReader("helloworld.mav");
            in=new BufferedReader(fr);
            while((n=in.readLine())!=null)
            {
                Line a=tok.get_tree(n); 
                AST[i]=a;
                i++;            
            }
            in.close();
            fr.close();
        }
        catch(FileNotFoundException e)
        {
            //System.err.println(e);
        }     

        
        
        System.out.println("ayyeee");
    }
}
