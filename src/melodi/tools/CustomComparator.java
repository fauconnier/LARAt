package melodi.tools;

import java.util.Comparator;

import melodi.internal.Item;

public class CustomComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.compareTo(o2);
    }
}
