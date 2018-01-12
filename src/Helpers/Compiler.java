package Helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Vardaro on 1/11/2018.
 */
public class Compiler {

    public String compileMavScript(String filename) throws IOException {
        Tokenizer tok = new Tokenizer();
        //Line b = tok.get_tree("if (true) {");
        String n;
        List<Tokenizer.Line> AST = new ArrayList<Tokenizer.Line>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);

            // declare ast list for line objects

            while ((n = in.readLine()) != null) {

                // if whitespace, skip the line
                if (n.trim().isEmpty()) continue;


                Tokenizer.Line cur = tok.get_tree(n);
                // check if parent new code block is being init
                if (n.contains("{")) {
                    List<Tokenizer.Line> clust = getBlockCluster(in);
                    cur.set_block(clust);
                }
                AST.add(cur);
            }
            in.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File path not found! :(\n");
        }
        Parser p = new Parser();

        return p.parse_syntax_list(AST);

    }

    private List<Tokenizer.Line> getBlockCluster(BufferedReader br) throws IOException {
        String n;
        Tokenizer t = new Tokenizer();
        List<Tokenizer.Line> clust = new ArrayList<Tokenizer.Line>();
        while (!(n = br.readLine()).contains("}")) {
            n = n.trim();
            // tune out whitespace
            if (n.isEmpty()) continue;

            Tokenizer.Line cur = t.get_tree(n);
            if (n.contains("{")) {
                List<Tokenizer.Line> nest_block = getBlockCluster(br);
                cur.set_block(nest_block);
            }
            clust.add(cur);
        }
        return clust;
    }
}
