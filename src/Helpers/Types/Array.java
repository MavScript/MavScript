package Helpers.Types;


/**
 * Created by justa on 1/12/2018.
 */
public class Array {
    public String name;
    public String type;
    public String val;

    public Array(String name, String val) {
        this.name = name;
        this.val = val;

        // now determine type of array by instantiating variable instance of the first element
//        String type = Variable.determine_type("");

        this.val = this.val.replaceAll("'", "");

    }
}
