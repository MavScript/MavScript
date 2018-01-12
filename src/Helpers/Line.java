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
    public Array arr;

    List<Line> block = new ArrayList<Line>();

    Line(String type, String[] metadata) {
        this.type = type;
        this.metadata = metadata;
        appendToAST();
    }

    void appendToAST() {
        switch (this.type) {
            case "assign": {
                this.var = new Variable(this.metadata[0], this.metadata[1], null);
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

            case "array": {
                this.arr = new Array(this.metadata[0], this.metadata[1]);
            }
        }
    }

    public void setBlock(List<Line> b) {
        this.block = b;
    }

}