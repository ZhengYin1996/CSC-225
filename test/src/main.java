
import java.util.*;
public class main {
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(46);
        arrayList.add(25);
        arrayList.add(22);
        arrayList.add(23);
        arrayList.add(27);
        arrayList.add(18);
        arrayList.add(13);
        arrayList.add(4);
        arrayList.add(29);
        arrayList.add(20);
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(11);
        arrayList.add(14);
        arrayList.add(16);

        arrayList.add(19);
        arrayList.add(50);
        arrayList.add(15);
        arrayList.add(10);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(30);
        arrayList.add(24);
        arrayList.add(6);
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(45);
        arrayList.add(44);


        int j=0;
        for(int i =1; i<51; i++)
        {
           if (arrayList.contains(i))
               continue;
           j++;
           System.out.println(i);

        }
        System.out.println();
        System.out.println(j);
    }

}
