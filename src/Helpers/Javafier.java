package Helpers;

import Helpers.Types.*;

/**
 * Created by Anthony Vardaro on 9/30/2017.
 */

public class Javafier {

    public String code;

    public Javafier(String code) {
        this.code = code;

    }

    String feed(Line cur) {
        String type = cur.type;
        String trans = "";

        switch (type) {
            case "assign":
                trans = ("String".equals(cur.var.type)) ? assignString(cur) : assignGenericVar(cur);
                break;
            case "control":
                trans = assignControl(cur);
                break;
            case "function":
                trans = cur.func.java_wrap;
                break;
            case "array":
                trans = assignArray(cur);
                break;
        }

        if (trans.isEmpty()) {
            System.out.println("WTF");
            return null;
        } else {
            return trans;
        }
    }
    String assignGenericVar(Line cur) {
        Variable v = cur.var;
        String name = v.name;
        String val = v.val;
        String var_type = v.type;

        return var_type + " " + name + " = " + val + ";";
    }

    String assignString(Line cur) {
        Variable v = cur.var;
        return "String " + v.name + " = " + v.val + ";";
    }


    String assignArray(Line cur) {

        Array a = cur.arr;
        String name = a.name;
        String type = a.type;

        // Build the arrayBody (data that goes between the brackets)
        StringBuilder arrayBody = new StringBuilder();
        int len = a.array.length;

        // iterate of the Line.arr.array Variable array and build the body
        for (int i = 0; i < len; i++) {
            // if the current iteration is NOT the last iteration, tack on a comma bc its important
            if (i < len-1) {
                arrayBody.append(a.array[i].val).append(", ");
            } else {
                // on the last iteration ignore the comma
                arrayBody.append(a.array[i].val);
            }
        }
        return type + "[] " + name + " = {" + arrayBody + "};";
    }

    String assignControl(Line cur) {
        Control c = cur.ctrl;

        // first build if statement
        String statement = "TYPE (ARGS) {".replace("ARGS", c.args).replace("TYPE", c.type);

        // iterate over inline liens
        for (Line cur_inline : cur.block) {
            statement += feed(cur_inline) + " ";
        }
        return statement + "}";
    }
    
    public void setMainMethod() {
        String mainMethodSkeleton =
                    "public class Main {" +
                        "\tpublic static void main(String[] args) {" +
                            "<code>" +
                        "\t}" +
                    "}";
        this.code = mainMethodSkeleton.replace("<code>", this.code);
    }

    public void setPackage(String packageName) {
        // apply the ;
        packageName += ";";

        // make the skeleton
        String prototype =
                "package " + packageName +
                        "<code>";
        this.code = prototype.replace("<code>", this.code);
    }

    public void setCode(String append) {
        this.code += append;
    }
}