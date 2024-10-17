import java.util.*;
import java.io.*;
import java.lang.*;

public class USACO_2018_December_Contest_Bronze_Problem_1_Mixing_Milk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] capacity = new int[3];
        int[] amountOfMilk = new int[3];


        for(int i = 0; i < 3; i++) {
            capacity[i] = sc.nextInt();
            amountOfMilk[i] = sc.nextInt();
        }

/*
SAMPLE INPUT:
10 3
11 4
12 5

SAMPLE OUTPUT:
0
10
2
 */

        for(int i = 0; i < 100; i++) {            
            int remainder = i % 3;

            if (remainder == 0) { // pour from a to b
                int transferAmount = Math.min(amountOfMilk[0], capacity[1] - amountOfMilk[1]);
                amountOfMilk[0] -= transferAmount;              
                amountOfMilk[1] += transferAmount;
            } else if (remainder == 1) { // pour from b to c
                int transferAmount = Math.min(amountOfMilk[1], capacity[2] - amountOfMilk[2]);
                amountOfMilk[1] -= transferAmount;              
                amountOfMilk[2] += transferAmount;
            } else { // pour from c to a
                int transferAmount = Math.min(amountOfMilk[2], capacity[0] - amountOfMilk[0]);
                amountOfMilk[2] -= transferAmount;              
                amountOfMilk[0] += transferAmount;
            }

        }

        for(int i = 0; i < 3; i++) {
            System.out.println(amountOfMilk[i]);
        }
    }
}
