import java.io.*;
class TokenStream
{
    public static void main()throws IOException
    {
        String n;    
        try
        {
            FileReader fr=new FileReader("helloworld.mav");
            BufferedReader in=new BufferedReader(fr);

            System.out.println("Following are the details in the file:");
            while((n=in.readLine())!=null)
            {
                System.out.println(n); //pass the line in this command
            }
            in.close();
            fr.close();
        }
        catch(FileNotFoundException e)
        {
            //System.err.println(e);
        }
    }
}
 