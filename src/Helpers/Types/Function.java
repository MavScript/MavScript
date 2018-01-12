package Helpers.Types;

/**
 * Created by justa on 1/12/2018.
 */
public class Function {
    public String name;
    public String args;
    public String java_wrap;

    public Function(String name, String args) {
        this.name = name;
        this.args = args;
        this.java_wrap = get_func_wrap().replace("ARGS", args);

    }

    /**
     * This function handles MavScripts built-in functions
     * @return
     */
    public String get_func_wrap() {
        switch (this.name) {
            //println
            case "neigh": return "System.out.println(ARGS);";
            case "neighf": return "System.out.print(ARGS);";
            case "tingle": return "for (int i = 0; i < 100; i++) { System.out.println(\"MY MAV SENSES ARE TINGING\");}";
            default: return "WTF";
        }
    }
}
