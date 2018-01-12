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

        if (type.equals("assign")) {
            trans = ("String".equals(cur.var.type)) ? assignString(cur) : assignNum(cur);
        } else if (type.equals("control")) {
            trans = assignControl(cur);
        } else if (type.equals("function")) {
            trans = cur.func.java_wrap;
        }

        if (trans.isEmpty()) {
            System.out.println("WTF");
            return null;
        } else {
            return trans;
        }
    }
    String assignNum(Line cur) {
        Variable v = cur.var;
        String name = v.name;
        String val = v.val;
        String var_type = v.type;

        return var_type + " " + name + " = " + val + ";";
    }

    String assignString(Line cur) {
        Variable v = cur.var;
        return "String " + v.name + " = \"" + v.val + "\";";
    }

    String assignControl(Line cur) {
        Control c = cur.ctrl;

        // first build if statement
        String statement = "TYPE (ARGS) {\n".replace("ARGS", c.args).replace("TYPE", c.type);

        // iterate over inline liens
        for (Line cur_inline : cur.block) {
            statement += feed(cur_inline) + "\n ";
        }
        return statement + '}';
    }

    public void setMainMethod() {
        String mainMethodSkeleton =
                "package compiled;\n\n" +
                    "public class Compiled {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                            "\t\t<code>\n" +
                        "\t}\n" +
                    "}\n";
        this.code = mainMethodSkeleton.replace("<code>", this.code);
    }

    public void setCode(String append) {
        this.code += append;
    }
}