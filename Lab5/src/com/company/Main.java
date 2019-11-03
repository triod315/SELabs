package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    static void writeFullLine(char ch,int n)
    {
        for (int i=0;i<n;i++)
        {
            System.out.print(ch);
        }
    }

    static void printRectangle(char ch,char spaceCh,int width,int height)
    {
        System.out.println("Rectangle\n");
        writeFullLine(ch,width);
        System.out.println(' ');
        for (int i=0;i<height-2;i++)
        {
            System.out.print(ch);
            writeFullLine(spaceCh,width-2);
            System.out.println(ch);
        }
        writeFullLine(ch,width);
    }

    static void printRectangle(char ch,int width,int height)
    {
        printRectangle(ch,' ',width,height);
    }

    static void printRightTriangle(char ch,char spaceChar,int n)
    {
        System.out.println("\nRight triangle");
        System.out.println(ch);
        for (int i=0;i<n;i++)
        {
            System.out.print(ch);
            writeFullLine(spaceChar,i);
            System.out.println(ch);
        }
        writeFullLine(ch,n+2);
    }

    static void printRightTriangle(char ch,int n)
    {
        printRightTriangle(ch,' ',n);
    }


    /**
     * Виводить преший рядок піраміди - одну зірку по середині
     * @param h висота піраміди
     */
    static void writeFirstLine(char ch,int h)
    {
        //виводимо пробіли до середини
        writeFullLine(' ',h-1);
        System.out.print(ch);
        //виводимо пробіли після середини
        writeFullLine(' ',h-1);
        System.out.println("");
    }

    /**
     * Метод виводить останній рядок - всі зірки
     * @param h висота піраміди
     */
    static void writeEndLine(char ch,int h)
    {
        for (int i=0;i<2*h-1;i++)
        {
            System.out.print(ch);
        }
        System.out.println("");
    }

    /**
     * Виводить звичайний рядок де є дві зірки
     * @param i номер рядка, нумерація з 0!
     * @param h висота піраміди
     */
    static void writeStandardLine(char ch,char spaceCh,int i, int h)
    {
        //виводимо пробіли до ершої зірки
        writeFullLine(' ',h-i-1);

        System.out.print(ch);
        //виводимо пробіли між зірками
        writeFullLine(spaceCh,2*i-1);
        System.out.print(ch);

        //виводимо пробіли після зірки
        writeFullLine(' ',h-i-1);

        System.out.println("");
    }

    static void printTrueTriangle(char ch,char spaceCh,int n)
    {
        System.out.println("\nTrue triangle");
        writeFirstLine(ch,n);
        for(int i=1;i<n-1;i++)
            writeStandardLine(ch, spaceCh, i, n);
        writeEndLine(ch,n);
    }

    static void printTrueTriangle(char ch,int n)
    {
        printTrueTriangle(ch,' ',n);
    }

    static void printRhombus(char ch,char spaceCh,int n)
    {
        System.out.println("\nRhombus");
        writeFirstLine(ch,n);
        for(int i=1;i<n-1;i++)
            writeStandardLine(ch, spaceCh, i, n);
        for(int i=n-1;i>=1;i--)
            writeStandardLine(ch, spaceCh, i, n);
        writeFirstLine(ch,n);
    }

    static void printRhombus(char ch,int n)
    {
        printRhombus(ch,' ',n);
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        String command;

        System.out.println("FIGURE\nwrite help to get help");

        while (true)
        {
            System.out.print("\nfigure > ");
            command=sc.nextLine();

            if (command.equals("help"))
            {
                String help="";
                String format="%-40s %15s";
                System.out.printf( format,"rect <width> <height> [char]","Draw rectangle using character char or '*' by default\n");
                System.out.printf( format,"rectf <width> <height> [char] <fchar>","Draw filled rectangle using character char or '*' by default and fill using character fchar\n");


                System.out.printf( format,"rtriangle <n>","Draw right triangle using '*'\n");
                System.out.printf( format,"rtrianglef <n> [char] <fchar> ","Draw right triangle using character char or '*' by default and fill using character fchar\n");

                System.out.printf( format,"regtriangle <n> [char] ","Draw regular triangle using '*' or character char\n");
                System.out.printf( format,"regtrianglef <n> [char] <fchar> ","Draw regular triangle using character char or '*' by default and fill using character fchar\n");

                System.out.printf( format,"rhombus <n> [char] ","Draw rhombus using '*' or character char\n");
                System.out.printf( format,"rhombusf <n> [char] <fchar> ","Draw rhombus using character char or '*' by default and fill using character fchar\n");


                System.out.printf( format,"quit","Exit from program");
            }

            try {

                if (command.equals("quit")) {
                    System.out.println("Figure stoped");
                    return;
                }

                String[] params = command.split(" ");

                if (params[0].equals("rect")) {
                    if (params.length == 3)
                        printRectangle('*', Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                    else if (params.length == 4)
                        printRectangle(params[3].charAt(0), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                }

                if (params[0].equals("rectf")) {
                    if (params.length == 4)
                        printRectangle('*', params[3].charAt(0), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                    else if (params.length == 5)
                        printRectangle(params[3].charAt(0), params[4].charAt(0), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                }

                if (params[0].equals("rtriangle") && params.length == 2)
                    printRightTriangle('*', Integer.parseInt(params[1]));
                if (params[0].equals("rtrianglef") && params.length == 4)
                    printRightTriangle(params[2].charAt(0), params[3].charAt(0), Integer.parseInt(params[1]));
                if (params[0].equals("rtrianglef") && params.length == 3)
                    printRightTriangle('*', params[2].charAt(0), Integer.parseInt(params[1]));


                if (params[0].equals("regtriangle")) {
                    if (params.length == 2)
                        printTrueTriangle('*', Integer.parseInt(params[1]));
                    else if (params.length == 3)
                        printTrueTriangle(params[2].charAt(0), Integer.parseInt(params[1]));
                }

                if (params[0].equals("regtrianglef")) {
                    if (params.length == 3)
                        printTrueTriangle('*', params[2].charAt(0), Integer.parseInt(params[1]));
                    else if (params.length == 4)
                        printTrueTriangle(params[2].charAt(0), params[3].charAt(0), Integer.parseInt(params[1]));
                }

                if (params[0].equals("rhombus")) {
                    if (params.length == 2)
                        printRhombus('*', Integer.parseInt(params[1]));
                    else if (params.length == 3)
                        printRhombus(params[2].charAt(0), Integer.parseInt(params[1]));
                }

                if (params[0].equals("rhombusf")) {
                    if (params.length == 3)
                        printRhombus('*', params[2].charAt(0), Integer.parseInt(params[1]));
                    else if (params.length == 4)
                        printRhombus(params[2].charAt(0), params[3].charAt(0), Integer.parseInt(params[1]));
                }
            }catch (Exception err) {
                System.out.println("Ooops, something went wrong :(");
                System.out.println(err.getMessage());
            }
        }
    }
}
