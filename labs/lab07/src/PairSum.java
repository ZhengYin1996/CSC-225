import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PairSum {
    public static boolean pair_sum(int[] array)
    {
        int[] freq = new int[226];
        for(int i =0; i<array.length;++i)
        {
            if(array[i]<=225)
            {
                freq[array[i]] = 1;
            }
        }
        for(int i = 0;i<226;++i)
        {
            if(freq[i]==1&&freq[225-i]==1)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner s;
        if (args.length > 0){
            try{
                s = new Scanner(new File(args[0]));
            } catch(java.io.FileNotFoundException e){
                System.out.printf("Unable to open %s\n",args[0]);
                return;
            }
            System.out.printf("Reading input values from %s.\n",args[0]);
        }else{
            s = new Scanner(System.in);
            System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
        }
        Vector<Integer> inputVector = new Vector<Integer>();

        int v;
        while(s.hasNextInt() && (v = s.nextInt()) >= 0)
            inputVector.add(v);

        int[] array = new int[inputVector.size()];

        for (int i = 0; i < array.length; i++)
            array[i] = inputVector.get(i);

        System.out.printf("Read %d values.\n",array.length);

        System.out.println("paired:" + pair_sum(array));


    }
}
