package Helpers.Types;

/**
 * Created by justa on 1/12/2018.
 */
public class TypeChecker {
    String input;

    /**
     * variables are created with the mav keyword
     * ex: mav a = 5;
     *     mav g = mavup;
     * @return bool whether this.line is an assignment statement
     */
    public Boolean isAssignment() {
        return this.input.contains("mav ");
    }

    /**
     * Arrays in mavscript are "mav stampedes"
     * ex: mav stampede = [1, 2, 4];
     * this function will check if the this.input is an array declaration.
     * @return
     */
    public Boolean isArray() {
        return this.input.contains("mav stampede");
    }

    /**
     * if statements are self-explanatory
     * this function checks if this.input is can if statement
     * @return
     */
    public Boolean isIf() {
        return this.input.startsWith("if");
    }


    /**
     * checks if this.input is a for loop
     * @return
     */
    public Boolean isFor() {
        return this.input.startsWith("for");
    }

    /**
     * checks if this.input is a while loop
     *
     * @return
     */
    public Boolean isWhile() {
        return this.input.startsWith("while");
    }

    public Boolean isFunctionDeclaration() {
        return this.input.startsWith("blaze ");
    }

    public void setInput(String input) {
        this.input = input;
    }

}
