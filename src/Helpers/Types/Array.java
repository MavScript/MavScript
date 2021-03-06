package Helpers.Types;


import Helpers.Parser;

/**
 * Created by justa on 1/12/2018.
 */
public class Array {
    public String name;
    public String type;
    public String val;
    public Variable[] array;

    public Array(String name, String val) {
        this.name = name;

        System.out.println(val);

        // now determine type of array by instantiating variable instance of the first element
        String firstElement = Parser.getStrBetween(val, "[", ",");
        this.type = TypeChecker.determineType(firstElement);

        String data = Parser.getStrBetween(val, "[", "]");
        this.val = data;

        String[] split = data.split(",");
        int len = split.length;
        Variable[] individualVals = new Variable[len];

        for (int i = 0; i < len; i++) {
            String cur = split[i].trim();
            Variable v = new Variable(Integer.toString(i), cur, this.type);
            individualVals[i] = v;
        }

//        if ("String".equals(this.type)) {
//            this.val = this.val.replace("'", "\"");
//        }

        this.array = individualVals;
    }
}
