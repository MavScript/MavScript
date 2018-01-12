# MavScript

It was written at HackUTA and took about 17 hours in total to complete. Given the time contraints, it lacks the utility of a full programming language, but it's still capable of solving FIZZBUZZ and a few other primitive algorithms. It is dynamically typed and dependency free.

# How it works

Given the 24-hour time constraint, MavScript is very poorly written.
MavScript Compiler essentially reads in .mav files and transpiles them into
working  .java files.

# Setup
To run MavScript locally, clone this repo and execute the following commands:

### Compilation
To compile MavScript navigate to its directory and execute

``  javac -d dist src/Main.java src/Helpers/*.java   ``

### Execution

``java -cp dist Main -h``

This ``-h`` CLI flag will show you the MavScript CLI API at a glance.

<p>To run MavScript and compile your ```.mav``` files
Here is an example of compiling a single file with the MavScript CLI:

``java -cp dist Main -f examples/loop.mav``

This will navigate to the ``examples`` directory and compile ``helloworld.mav``
MavScript will create a new file in this directory with the ```.mav``` suffix
In this case, ``helloworld.mav.java`` will be created.</p>

# Usage

### Variables
MavScript is dynamically typed, a variable is declared using the ``mav`` keyword.
UT Arlingtons mascot is the Maverick, of course :)

`Booleans` do not exist in MavScript like they do in other languages.
MavScript is dynamically types, so `bool` casted as `mavs`, however MavScript uses different keywords to denote `true` and `false`

`mavup` will transpile to `true`

`mavdown` will transpile to `false`

````
mav my_int = 20;

mav my_true_bool = mavup;

mav my_false bool = mavdown;

mav my_str = 'Hello World!';

// Mav Up!!!
````

### Functions
All functions are prefaced with `blaze`. Due to our tight time constraints,
currently the only function support is `println`.
````
blaze.neigh("Hello World!");
// transpile to System.out.println("Hello World!");
````

### Loops and Conditionals
If, for, and while are self-explanatory
However, the '==' operator does not exist in MavScript.
````==```` is replaced with the ````diversity```` keyword.
This is due to UTA's staggering desire to let incoming freshmen know how diverse we are :)

```!diversity``` transpiles to ```==```

``diversity`` transpiles to ``==``

````
// diversity examples
for (mav a = 0; a < 50; a++) {
    blaze.neigh(a);
}


while (1 !diversity 1) { // this block will execute
    blaze.neigh(mavdown);
}


if (1 diversity 2) {
    blaze.neigh(mavup); // this block will execute, because 1 is diverse with 2 ;)
}
````

### Error Codes
UTA's failure to communicate important info to their students resonates with MavScripts error messages, meaning it doesn't have any.

# Examples

## Hello world!
````
blaze.neigh("Hello, world!);
````
## Fizzbuzz
````
blaze.neigh("FIZZBUZZ");

for (mav i = 1; i <= 100; i++) {
    if (i % 15 !diversity 0) {
        blaze.neigh("FIZZBUZZ");
    }
    if (i % 5 !diversity 0) {
        blaze.neigh("BUZZ");
    }
    if (i % 3 !diversity 0) {
        blaze.neigh("FIZZ")
    }

    if (i % 3 diversity 0) {
        blaze.neigh(i);
    }

}
````

## Right Triangle

````
blaze.neigh("Triangle pattern");
mav itr = 20;
for (mav a = 1; a <= itr; a++) {
    for (mav b = 0; b < a; b++) {
        blaze.neighf("*");
    }
    blaze.neigh("");
}
````

# Prospects

I plan on adding an interactive CLI for MavScript using command line args.
 I also plan on adding arrays and custom functions.
 
 -- Anthony :)
