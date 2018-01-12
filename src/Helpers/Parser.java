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
    private TypeChecker tc = new TypeChecker();
    /**
     * utility function return s a substring between two characters
     * @param start character to start
     * @param end character to end
     * @return substring between two characters
     */
    public static String getStrBetween(String str, String start, String end) {


        str = str.substring(str.indexOf(start) + 1);
        str = str.substring(0, str.indexOf(end));
        return str.trim();
    }
    
    // extracts metadata about assignemnt
    private Line parseAssignment() {
        String name = getStrBetween(this.input, " ", "=");
        String val = getStrBetween(this.input, "=", ";");

        String[] meta = {name, val};

        return new Line("assign", meta);
    }

    private Line parseArray() {
        String name = getStrBetween(this.input, "e ", "=");
        String val = getStrBetween(this.input, "=", ";");

        String[] meta = {name, val};
        return new Line("array", meta);
    }

    private Line parseIf() {
        String[] if_args = {"if", getStrBetween(this.input,"(", ")")};
        return new Line("control", if_args);
    }



    private Line parseFor() {
        String[] for_args = {"for", getStrBetween(this.input, "(", ")")};
        return new Line("control", for_args);
    }


    private Line parseWhile() {
        String[] while_args = {"while", getStrBetween(this.input, "(", ")")};
        return new Line("control", while_args);
    }



    private Line buildFunctionDec() {
        String args = getStrBetween(this.input, "(", ")");
        String name = getStrBetween(this.input, " ", "(" ).trim();
        String[] meta = {name, args};

        return new Line("function", meta);
    }

    Boolean isFunctionCall() {
        return this.input.startsWith("blaze.");
    }

    Line refFunction() {
        String func = getStrBetween(this.input, ".", "(");
        String args = getStrBetween(this.input, "(", ")");
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
            return parseIf();
        }

        if (tc.isFor()) {
            return parseFor();
        }

        if (tc.isWhile()) {
            return parseWhile();
        }

        if (tc.isArray()) {
            return parseArray();
        }

        if (tc.isAssignment()) {
            return parseAssignment();
        }

        if (tc.isFunctionDeclaration()) {
            return buildFunctionDec();
        }

        // if non of the above,
        // assume the line is a function call
        return refFunction();
    }

}

// if u got this far, im sorry
