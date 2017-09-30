package tokenizer;


import javax.swing.*;

/**
 * Created by justa on 9/30/2017.
 * <p>
 * Whitespace and comments are skipped over, no tokens are returned.
 * <p>
 * In order to write the tokenizer we need to look more closely into the syntax of our language. The idea is to notice that depending on the current character (as returned by input.peek()) we can decide what kind of token to read:
 * <p>
 * First off, skip over whitespace.
 * If input.eof() then return null.
 * If it's a sharp sign (#), skip comment (retry after the end of line).
 * If it's a quote then read a string.
 * If it's a digit, then we proceed to read a number.
 * If it's a “letter”, then read an identifier or a keyword token.
 * If it's one of the punctuation characters, return a punctuation token.
 * If it's one of the operator characters, return an operator token.
 * If none of the above, error out with input.croak().
 * So here's the “read_next” function — the “core” of the tokeniz
 */
public class tokenizer {
    private String input;

    final private String[] keywords = {"diversity", "mav", "blaze", "nut"};

    // returns a substring between two characters
    private String get_str_between(String start, String end) {
        String str = this.input;

        str = str.substring(str.indexOf(start) + 1);
        str = str.substring(0, str.indexOf(end));
        return str.trim();
    }

    // checks if the line is delcaring a var
    private Boolean is_assignment() {
        return this.input.contains("mav ");
    }

    // extracts metadata about assignemnt
    private Line parse_assignment() {
        String name = get_str_between(" ", "=");
        String val = get_str_between("=", ";");

        String[] meta = {name, val};

        return new Line("assign", meta);
    }


    public Line get_tree(String input) {
        this.input = input;
        if (is_assignment()) {
            return parse_assignment();
        }
        return null;
    }

    public class Line {
        String type;
        String[] metadata;
        Object exe;

        Line(String type, String[] metadata) {
            this.type = type;
            this.metadata = metadata;
            set_exe();
        }

        void set_exe() {
            switch (this.type) {
                case "assign": {
                    this.exe = new Variable(this.metadata[0], this.metadata[1]);
                    break;
                }

                case "call": {

                }
            }
        }

    }

    class Variable {
        String name;
        String type;
        String val;

        Variable(String name, String val) {
            this.name = name;
            this.val = val;
            this.type = determine_type(this.val);
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
                return "boolean";
            } else if (val.startsWith("\'")) {
                return "string";
            } else if (val.startsWith("[")) {
                // if its an array, get the first element check the type of that to determine the type of the array
                String firstele = val.substring(1, val.indexOf(','));

                String type = determine_type(firstele);

                return "array " + type;

            } else {
                try {
                    Double.parseDouble(val);
                    return "double";
                } catch (NumberFormatException n) {
                    return "int";
                } catch (Exception e) {
                    System.out.println("WTF");
                    return "WTF";
                }
            }
        }
    }
}

