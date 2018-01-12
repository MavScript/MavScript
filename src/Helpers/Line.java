package Helpers;

import Helpers.Types.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justa on 1/12/2018.
 */
public class Line {
    public String type;
    String[] metadata;
    //public Object exe;
    public Variable var;
    public Control ctrl;
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
                this.ctrl = new Control(this.metadata[0], this.metadata[1]);
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