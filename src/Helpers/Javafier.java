package Helpers;

import Helpers.Types.*;

/**
 * Created by Anthony Vardaro on 9/30/2017.
 */

public class Javafier {
    //cli command_line= new cli();

    //String file_name= command_line.file_name

    String feed(Line cur) {
        String type = cur.type;
        String trans = "";
        if (type.equals("assign")) {
            trans = ("String".equals(cur.var.type)) ? assign_str(cur) : assign_num(cur);
        } else if (type.equals("control")) {
            trans = assign_control(cur);
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
    String assign_num(Line cur) {
        Variable v = cur.var;
        String name = v.name;
        String val = v.val;
        String var_type = v.type;

        return var_type + " " + name + " = " + val + ";";
    }

    String assign_str(Line cur) {
        Variable v = cur.var;
        return "String " + v.name + " = \"" + v.val + "\";";
    }

    String assign_control(Line cur) {
        Control c = cur.ctrl;

        // first build if statement
        String if_temp = "TYPE (ARGS) {\n".replace("ARGS", c.args).replace("TYPE", c.type);

        // iterate over inline liens
        for (Line cur_inline : cur.block) {
            if_temp += feed(cur_inline) + "\n ";
        }
        return if_temp + '}';
    }
}