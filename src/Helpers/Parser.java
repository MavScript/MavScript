package Helpers;

import Helpers.Types.TypeChecker;

import java.io.IOException;
import java.util.List;

/**
 * Created by Anthony Vardaro on 9/30/2017.
 *
 * the tokenizer simple reads a single line and determines what to do with it
 * in terms of how it gets formatted in the abstract syntax tree
 * <p>
*/
public class Parser {
    
    // current line in iteration
    private String input;
    TypeChecker tc = new TypeChecker();

    /**
     * utility function return s a substring between two characters
     * @param start character to start
     * @param end character to end
     * @return substring between two characters
     */
    public String getStrBetween(String start, String end) {
        String str = this.input;

        str = str.substring(str.indexOf(start) + 1);
        str = str.substring(0, str.indexOf(end));
        return str.trim();
    }
    
    // extracts metadata about assignemnt
    private Line parse_assignment() {
        String name = getStrBetween(" ", "=");
        String val = getStrBetween("=", ";");

        String[] meta = {name, val};

        return new Line("assign", meta);
    }



    private Line parse_if() {
        String[] if_args = {"if", getStrBetween("(", ")")};
        return new Line("control", if_args);
    }



    private Line parse_for() {
        String[] for_args = {"for", getStrBetween("(", ")")};
        return new Line("control", for_args);
    }


    private Line parse_while() {
        String[] while_args = {"while", getStrBetween("(", ")")};
        return new Line("control", while_args);
    }

    private Line build_function_dec() {
        String args = getStrBetween("(", ")");
        String name = getStrBetween(" ", "(" ).trim();
        String[] meta = {name, args};

        return new Line("function", meta);
    }

    Boolean is_function_call() {
        return this.input.startsWith("blaze.");
    }

    Line ref_function() {
        String func = getStrBetween(".", "(");
        String args = getStrBetween("(", ")");
        String[] meta = {func, args};
        return new Line("function", meta);
        //return true;
    }

    public String parseAST(List<Line> AST) throws IOException {
        Javafier javafy = new Javafier("");

        // iterate over lines
        for (Line cur : AST) {
            String transpilation = javafy.feed(cur);
            javafy.setCode(transpilation);
        }

        javafy.setMainMethod();
        return javafy.code;
    }

    public Line buildTree(String input) {
        this.input = input.trim();
        tc.setInput(this.input);

        if (tc.isIf()) {
            return parse_if();
        }

        if (tc.isFor()) {
            return parse_for();
        }

        if (tc.isWhile()) {
            return parse_while();
        }

        if (tc.isAssignment()) {
            return parse_assignment();
        }

        if (tc.isFunctionDeclaration()) {
            return build_function_dec();
        }

        // if non of the above,
        // assume the line is a function call
        return ref_function();
    }

}

// if u got this far, im sorry
