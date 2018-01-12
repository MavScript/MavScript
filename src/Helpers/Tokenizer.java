package Helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Vardaro on 9/30/2017.
 *
 * the tokenizer simple reads a single line and determines what to do with it
 * in terms of how it gets formatted in the abstract syntax tree
 * <p>
*/
public class Tokenizer {

    // current line in iteration
    private String input;

    /**
     * utility function return s a substring between two characters
     * @param start character to start
     * @param end character to end
     * @return substring between two characters
     */
    private String get_str_between(String start, String end) {
        String str = this.input;

        str = str.substring(str.indexOf(start) + 1);
        str = str.substring(0, str.indexOf(end));
        return str.trim();
    }

    /**
     * variables are created with the mav keyword
     * ex: mav a = 5;
     *     mav g = mavup;
     * @return
     */
    private Boolean isAssignment() {
        return this.input.contains("mav ");
    }

    /**
     * Arrays in mavscript are "mav stampedes"
     * ex: mav stampede = [1, 2, 4];
     * this function will check if the this.input is an array declaration.
     * @return
     */
    private Boolean isArray() {
        return this.input.contains("mav stampede");
    }

    /**
     * if statements are self-explanatory
     * this function checks if this.input is can if statement
     * @return
     */
    private Boolean isIf() {
        return this.input.startsWith("if");
    }
    // extracts metadata about assignemnt
    private Line parse_assignment() {
        String name = get_str_between(" ", "=");
        String val = get_str_between("=", ";");

        String[] meta = {name, val};

        return new Line("assign", meta);
    }



    private Line parse_if() {
        String[] if_args = {"if", get_str_between("(", ")")};
        return new Line("control", if_args);
    }

    private Boolean is_for() {
        return this.input.startsWith("for");
    }

    private Line parse_for() {
        String[] for_args = {"for", get_str_between("(", ")")};
        return new Line("control", for_args);
    }

    private Boolean is_while() {
        return this.input.startsWith("while");
    }

    private Line parse_while() {
        String[] while_args = {"while", get_str_between("(", ")")};
        return new Line("control", while_args);
    }

    private Boolean is_function_dec() {
        return this.input.startsWith("blaze ");
    }

    private Line build_function_dec() {
        String args = get_str_between("(", ")");
        String name = get_str_between(" ", "(" ).trim();
        String[] meta = {name, args};

        return new Line("function", meta);
    }

    Boolean is_function_call() {
        return this.input.startsWith("blaze.");
    }

    Line ref_function() {
        String func = get_str_between(".", "(");
        String args = get_str_between("(", ")");
        String[] meta = {func, args};
        return new Line("function", meta);
        //return true;
    }

    public Line get_tree(String input) {
        this.input = input.trim();

        if (isIf()) {
            return parse_if();
        }

        if (is_for()) {
            return parse_for();
        }

        if (is_while()) {
            return parse_while();
        }

        if (isAssignment()) {
            return parse_assignment();
        }

        if (is_function_dec()) {
            return build_function_dec();
        }

        if (is_function_call()) {
            return ref_function();
        }
        return null;
    }

    public class Line {
        public String type;
        String[] metadata;
        //public Object exe;
        public Variable var;
        public Control cont;
        public Function func;

        List<Line> block = new ArrayList<Line>();

        Line(String type, String[] metadata) {
            this.type = type;
            this.metadata = metadata;
            set_exe();
        }

        void set_exe() {
            switch (this.type) {
                case "assign": {
                    this.var = new Variable(this.metadata[0], this.metadata[1]);
                    break;
                }

                case "control": {
                    this.cont = new Control(this.metadata[0], this.metadata[1]);
                    break;
                }

                case "function": {
                    this.func = new Function(this.metadata[0], this.metadata[1]);
                    break;
                }
            }
        }

        public void set_block(List<Line> b) {
            this.block = b;
        }

    }

    class Variable {
        public String name;
        public String type;
        public String val;

        Variable(String name, String val) {
            this.name = name;
            this.val = val;
            this.type = determine_type(this.val);

            this.val = this.val.replaceAll("'", "");

        }

        /**
         * takes a strign and determiens the type
         *
         * @param val
         * @return
         */
        private String determine_type(String val) {
            if (val.equals("mavup") || val.equals("mavdown")) {
                this.val = this.val.equals("mavup") ? "true" : "false";
                return "Boolean";
            } else if (val.startsWith("\'")) {
                return "String";
            } else if (val.startsWith("[")) {
                // if its an array, get the first element check the type of that to determine the type of the array
                String firstele = val.substring(1, val.indexOf(','));

                String type = determine_type(firstele);

                return "array " + type;

            } else {
                if (val.contains(".")) {
                    return "double";
                } else {
                    return "int";
                }

            }
        }

        public String get_name() {
            return this.name;
        }

        public String get_type() {
            return this.type;
        }

        public String get_val() {
            return this.val;
        }
    }

    class Control {
        String type;
        String args;

        Control(String type, String args) {
            this.type = type;

            if (args.contains("!diversity")) {
                args = args.replace("!diversity", "==");
            } else if (args.contains("diversity")) {
                args = args.replace("diversity", "!=");
            }

            if (type.equals("for")) {
                args = args.replace("mav", "int");
            }
            this.args = args;
        }

        public String get_type() {
            return this.type;
        }

        public String args() {
            return this.args;
        }
    }

    class Function {
        String name;
        String args;
        String java_wrap;
        Function(String name, String args) {
            this.name = name;
            this.args = args;
            this.java_wrap = get_func_wrap().replace("ARGS", args);

        }
        String get_func_wrap() {
            switch (this.name) {
                //println
                case "neigh": return "System.out.println(ARGS);";
                case "neighf": return "System.out.print(ARGS);";
                case "tingle": return "for (int i = 0; i < 100; i++) { System.out.println(\"MY MAV SENSES ARE TINGING\");}";
                default: return "WTF";
            }
        }
    }
}

// if u got this far, im sorry
