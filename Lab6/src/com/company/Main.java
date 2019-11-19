package com.company;
import java.util.Scanner;
import java.lang.Math;

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
            Scanner in = new Scanner(System.in);


            int C = 0;

            short n, m;

            System.out.print("n=");
            n = in.nextShort();

            System.out.print("m=");
            m = in.nextShort();

            System.out.println("Result=" + Sum.doIt(n, m,C));
        }catch (Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
	// write your code here
    }
}
