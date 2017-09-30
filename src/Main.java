import tokenizer.tokenizer;
import tokenizer.tokenizer.Line;

public class Main {
    public static void main(String[] args) {
        tokenizer tok = new tokenizer();
        Line a = tok.get_tree("if (a == b) {");
        Line b = tok.get_tree("while (adarsh == gay) {");

        System.out.println("ayyeee");

    }
}
