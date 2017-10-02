package compiled; public class Compiled { public static void main(String[] args) {System.out.println("FIZZBUZZ");for (int i = 1; i <= 100; i++) {
if (i % 15 == 0) {
System.out.println("FIZZBUZZ");
 }
 if (i % 5 == 0) {
System.out.println("BUZZ");
 }
 if (i % 3 == 0) {
System.out.println("FIZZ");
 }
 if (i % 3 != 0) {
System.out.println(i);
 }
 }}}