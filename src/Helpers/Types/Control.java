package Helpers.Types;

/**
 * Created by justa on 1/12/2018.
 */
public class Control {
    public String type;
    public String args;

    public Control(String type, String args) {
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
