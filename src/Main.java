import tokenizer.tokenizer;
import tokenizer.tokenizer.Line;
public class Main {
    public static void main(String[] args) {
        tokenizer tok = new tokenizer();
        Line a = tok.get_tree("mav mdicik = 5.6;");

        System.out.println("ayyeee");

    }
}
