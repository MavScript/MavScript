import Helpers.Parser;
import Helpers.Tokenizer;
import Helpers.Tokenizer.Line;
import Helpers.Compiler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (args.length == 0) {
            System.out.println("\nPlease supply cmd arguments");
            return;
        }
        String filename = "";

        // check if the -f flag is present
        if (args[0].equals("-f") && args[1] != null) {
            filename = args[1];
        } else {
            System.out.println("wat");
        }
//
//        Tokenizer tok = new Tokenizer();
//        //Line b = tok.get_tree("if (true) {");
//        String n;
//        List<Line> AST = new ArrayList<Line>();
//        try {
//            FileReader fr = new FileReader(filename);
//            BufferedReader in = new BufferedReader(fr);
//
//            // declare ast list for line objects
//
//            while ((n = in.readLine()) != null) {
//
//                // if whitespace, skip the line
//                if (n.trim().isEmpty()) continue;
//
//
//                Line cur = tok.get_tree(n);
//                // check if parent new code block is being init
//                if (n.contains("{")) {
//                    List<Line> clust = getBlockCluster(in);
//                    cur.set_block(clust);
//                }
//                AST.add(cur);
//            }
//            in.close();
//            fr.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File path not found! :(\n");
//            return;
//        }
//        Parser p = new Parser();
//
//        String java = p.parse_syntax_list(AST);

        // write java string to file
        Compiler c = new Compiler();

        String java = c.compileMavScript(filename);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename + ".java"));
            out.write(java);
            out.close();



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FUCK");
            return;
        }
        System.out.println("\nSuccess");
    }

    private static List<Line> getBlockCluster(BufferedReader br) throws IOException {
        String n;
        Tokenizer t = new Tokenizer();
        List<Line> clust = new ArrayList<Line>();
        while (!(n = br.readLine()).contains("}")) {
            n = n.trim();
            // tune out whitespace
            if (n.isEmpty()) continue;

            Line cur = t.get_tree(n);
            if (n.contains("{")) {
                List<Line> nest_block = getBlockCluster(br);
                cur.set_block(nest_block);
            }
            clust.add(cur);
        }
        return clust;
    }
}