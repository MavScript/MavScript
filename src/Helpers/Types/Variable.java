package Helpers.Types;

/**
 * Created by justa on 1/12/2018.
 */
public class Variable {
    public String name;
    public String type;
    public String val;

    public Variable(String name, String val, String type) {
        this.name = name;
        this.val = val;

        if (type == null) {
            this.type = TypeChecker.determineType(this.val);
        } else {
            this.type = type;
        }

        // Booleans in MS are reskinned as mavup and mavdown for true / false respectively
        // strings are reskinned with single quotes '
        // int and double dont matter that much bc they are not reskinned
        switch (this.type) {
            case "Boolean": {
                setBool();
                break;
            }
            case "String": {
                setString();
                break;
            }
        }
    }

    public void setBool() {
        this.val = this.val.equals("mavup") ? "true" : "false";
    }

    public void setString() {
        this.val = this.val.replaceAll("'", "");
    }
}
