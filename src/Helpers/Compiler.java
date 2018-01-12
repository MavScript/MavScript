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
        Parser tok = new Parser();
        //Line b = tok.buildTree("if (true) {");
        String n;
        List<Line> AST = new ArrayList<Line>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);

            // declare ast list for line objects

            while ((n = in.readLine()) != null) {

                // if whitespace, skip the line
                if (n.trim().isEmpty()) continue;


                Line cur = tok.buildTree(n);
                // check if parent new code block is being init
                if (n.contains("{")) {
                    List<Line> clust = getBlockCluster(in);
                    cur.set_block(clust);
                }
                AST.add(cur);
            }
            in.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File path not found! :(\n");
        }
        Javafier p = new Javafier();

        return p.parse_syntax_list(AST);

    }

    private List<Line> getBlockCluster(BufferedReader br) throws IOException {
        String n;
        Parser t = new Parser();
        List<Line> clust = new ArrayList<Line>();
        while (!(n = br.readLine()).contains("}")) {
            n = n.trim();
            // tune out whitespace
            if (n.isEmpty()) continue;

            Line cur = t.buildTree(n);
            if (n.contains("{")) {
                List<Line> nest_block = getBlockCluster(br);
                cur.set_block(nest_block);
            }
            clust.add(cur);
        }
        return clust;
    }
}
