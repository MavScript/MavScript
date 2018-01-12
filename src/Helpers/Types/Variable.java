package Helpers.Types;

/**
 * Created by justa on 1/12/2018.
 */
public class Variable {
    public String name;
    public String type;
    public String val;

    public Variable(String name, String val) {
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
    public String determine_type(String val) {
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
}
