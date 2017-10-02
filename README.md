# MavScript

MavScript is an esoteric, dynamically typed, UTA themed programming language written at HackUTA

# How it works

Given the 24-hour time constraint, MavScript is very poorly written.
MavScript Compiler essentially reads in .mav files and transpiles them into
working  .java files.

# Usage

MavScript is dynamically typed, a variable is declared using the 'mav' keyword.
````
mav my_int = 20;

mav my_true_bool = mavup;

mav my_false bool = mavdown;

mav my_str = 'Hello World!';
````

All functions are prefaced with "blaze." due to our tight time constraints.
Currently the only function support is println.
````
blaze.neigh("Hello World!");
````

If, for, and while are self-explanatory
However, the '==' operator does not exist in MavScript.
'==' is replace with the keyword 'diversity';

== is '!diversity'

!= is 'diversity'

````
for (mav a = 0; a < 50; a++) {
    blaze.neigh(a);
}


while (1 !diversity 1) {
    blaze.neigh(mavdown);
}


if (1 diversity 2) {
    blaze.neigh(true);
}
````

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

In the we aim to implement comments and functions into the language, as well as better design in the tokenizer, parser, and how the syntax tree is built.
