package cds_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class CDs_collections {

    public static void main(String[] args) {

        System.out.println("======== ArrayList ========");
        System.out.println("");
        ArrayList<String> CdCollection = new ArrayList();
        CdArrayList(CdCollection, 10000);

        System.out.println("======== TreeSet ========");
        System.out.println("");
        TreeSet CDts = new TreeSet();
        CdTreeset(CDts, 10000);

        System.out.println("======== HashSet ========");
        System.out.println("");
        HashSet CDhs = new HashSet();
        addHashSet(CDhs, 10000);

    }

    public static void CdArrayList(ArrayList CdArray, int num) {
        int i = 0;
        Random random = new Random();
        while (i < num) {
            int n = random.nextInt(num) + 1;
            if (!CdArray.contains(n)) {
                CdArray.add(n);
                i++;
            }
        }
        Collections.sort(CdArray);
        int x = num / 100;
        int y = 0;
        int ind = 0;
        while (x > y) {
            System.out.println(CdArray.get(ind + 99));
            ind += 100;
            y++;
        }

    }

    public static void CdTreeset(TreeSet CdTreeSet, int num) {
        int i = 0;
        Random random = new Random();
        while (i < num) {
            int n = random.nextInt(num) + 1;
            if (!CdTreeSet.contains(n)) {
                CdTreeSet.add(n);
                i++;
            }
        }
        int x = num / 100;
        int y = 0;
        int index = 2;
        while (x > y) {
            System.out.println(CdTreeSet.headSet(index + 99).size());
            index += 100;
            y++;
        }

    }
      
    /*HashSet--- not ordered/sorted*
    one way to do "Add all your objects to the TreeSet, you will get a sorted Set."*/
    public static void addHashSet(HashSet HsArray, int num) {
        System.out.println("HashSet--- not ordered/sorted");
        int i = 0;
        Random random = new Random();
        while (i < num) {
            int n = random.nextInt(num) + 1;
            if (!HsArray.contains(n)) {
                HsArray.add(n);
                i++;
            }
        }
        int x = num / 100;
        int y = 0;
        int index = 0;
        while (x > y) {
            //System.out.println(array.get(ind + 99); 
            index += 100;
            y++;
        }

    }
}
