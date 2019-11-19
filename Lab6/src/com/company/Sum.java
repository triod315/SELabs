package com.company;

public class Sum {
    static int O1(int i,int j){
        return i-j;
    }

    static int O2(int i,int j){
        if (j!=0)
            return i%j;
        else return 0;
    }

    public static int doIt(short n,short m, int C)
    {
        int sum=0;
        for (short i=0;i<=n;i++)
            for (short j=0;j<=m;j++)
                if (O1(i,C)!=0)
                    sum+=O2(i,j)/O1(i,C);
        return sum;
    }
}
