package src.miscellaneously.interview;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {

    public static void main(String[] args) {
        Set<Integer> linkedHash = new LinkedHashSet<>();

        linkedHash.add(2);
        linkedHash.add(3);
        linkedHash.add(5);
        System.out.println(linkedHash.stream().findFirst());
        linkedHash.add(2);
        System.out.println(linkedHash.stream().findFirst());
        linkedHash.add(3);
        System.out.println(linkedHash.stream().findFirst());

    }

}
