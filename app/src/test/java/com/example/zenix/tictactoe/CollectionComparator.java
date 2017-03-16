package com.example.zenix.tictactoe;

import java.util.*;

public class CollectionComparator
{
    public static <T> boolean isListContentEqual(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        HashSet<T> set = new HashSet<>(list2);
        for (T t : list1) {
            if (!set.contains(t)) {
                return false;
            }
        }
        return true;
    }

    public static <K,T> boolean isMapContentEquals(Map<K, T> map1, Map<K, T> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }


        // TODO Java 8 support
        //add support for Java 8 to project if it doesn't hurt backward comparability


        //Set<T> set = map2.entrySet()
        //        .stream()
        //        .map(Map.Entry::getValue)
        //        .collect(Collectors.toSet());

        Set<T> set = new HashSet<>();

        for (Map.Entry<K, T> entry : map2.entrySet()) {
            set.add(entry.getValue());
        }

        for (Map.Entry<K, T> ktEntry : map1.entrySet()) {
            if(!set.contains(ktEntry.getValue())) return false;
        }
        return true;
    }
}
