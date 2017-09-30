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
        try {
            FileReader fr = new FileReader("examples/blocks.mav");
            BufferedReader in = new BufferedReader(fr);

            // declare ast list for line objects
            List<Line> AST = new ArrayList<Line>();

            // childblock is an array list of code within parent code block.
            // it gets appended to the block property
            List<Line> childblock = new ArrayList<Line>();
            Line parent = null;
            List<Line> parentblock = new ArrayList<Line>();
            Boolean in_code_block = false;
            while ((n = in.readLine()) != null) {

                // check if parent new code block is being init
                if (n.contains("{")) {
                    in_code_block = true;
                    parentblock.add(tok.get_tree(n));
                    int size = parentblock.size();
                    AST.add(parentblock.get(size - 1));
                    continue;
                }

                if (n.contains("}")) {
                    in_code_block = false;
                    parentblock.get(parentblock.size() - 1).set_block(childblock);
                    parentblock.remove(parentblock.size() - 1);
                    childblock = new ArrayList<Line>();
                }
                //parent=tok.get_tree(n);
                if (in_code_block) {
                    // add the curret iterations to the childblock list
                    childblock.add(tok.get_tree(n));

                } else {
                    AST.add(tok.get_tree(n));
                }
            }
            in.close();
            fr.close();
        } catch (FileNotFoundException e) {
            //System.err.println(e);
        }

        System.out.println("ayyeee");
    }
}
