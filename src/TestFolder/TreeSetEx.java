package TestFolder;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        int[] numbers = {9, 5, 2, 1, 4, 10};

        for(int i=0; i<numbers.length; i++) {
            treeSet.add(new Integer(numbers[i]));
        }

        NavigableSet<Integer> headSet = treeSet.headSet(new Integer(5), true);
        NavigableSet<Integer> tailSet = treeSet.tailSet(new Integer(5), false);
        NavigableSet<Integer> subSet = treeSet.subSet(new Integer(4), true, new Integer(10), false);

        //향상된 for문을 사용해 전체 객체 반복하기
        System.out.println("headSet 결과");
        for(Integer num : headSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("tailSet 결과");
        for(Integer num : tailSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("subSet 결과");
        for(Integer num : subSet) {
            System.out.print(num + " ");
        }

    }
}
