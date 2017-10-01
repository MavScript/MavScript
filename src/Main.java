import tokenizer.*;
import tokenizer.tokenizer.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        tokenizer tok = new tokenizer();
        //Line b = tok.get_tree("if (true) {");

        String n;
        List<Line> AST = new ArrayList<Line>();
        try {
            FileReader fr = new FileReader("examples/blocks.mav");
            BufferedReader in = new BufferedReader(fr);

            // declare ast list for line objects

            while ((n = in.readLine()) != null) {

                // if whitespace, skip the line
                if (n.trim().isEmpty()) continue;


                Line cur = tok.get_tree(n);
                // check if parent new code block is being init
                if (n.contains("{")) {
                    List<Line> clust = get_block_cluster(in);
                    cur.set_block(clust);
                }
                AST.add(cur);
            }
            in.close();
            fr.close();
        } catch (FileNotFoundException e) {
            //System.err.println(e);
        }
        parse p = new parse();

        p.parse_syntax_list(AST);
        System.out.println("ayyeee");
    }

    private static List<Line> get_block_cluster(BufferedReader br) throws IOException {
        String n;
        tokenizer t = new tokenizer();
        List<Line> clust = new ArrayList<Line>();
        while (!(n = br.readLine()).contains("}")) {
            n = n.trim();
            // tune out whitespace
            if (n.isEmpty()) continue;


            Line cur = t.get_tree(n);
            if (n.contains("{")) {
                List<Line> nest_block = get_block_cluster(br);
                cur.set_block(nest_block);
            }
            clust.add(cur);
        }
        return clust;
    }
}
