package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Main {
    /*
     * Номер заліковки: 9717
     * С2=1
     * С3=0
     * С5=2
     * С7=1
     * С11=4
     */
    public static void main(String[] args) {

        try {
            byte[][] a = {{1, 2}, {3, 4}};
            byte[][] b = {{5, 6}, {7, 8}};

            System.out.println("A");
            Matrix.PrintMatrix(a);

            System.out.println("B");
            Matrix.PrintMatrix(b);


            byte[][] c = Matrix.add(a, b);
            System.out.println("C=A+B");
            Matrix.PrintMatrix(c);

            System.out.println("Sum of max elements: " + Matrix.SecondResult(c));
        }catch (Exception e)
        {
            System.out.print("Error: "+e.getMessage());
        }
    }
}
