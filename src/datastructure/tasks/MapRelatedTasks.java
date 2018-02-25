package datastructure.tasks;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class MapRelatedTasks {
    //    1. Write a Java program to associate the specified value with the specified key in a Tree Map.
    static <K, V> TreeMap<K, V> task1(K key, V value) {
        TreeMap<K, V> retValue = new TreeMap<>();
        retValue.put(key, value);
        return retValue;
    }
//    2. Write a Java program to copy a Tree Map content to another Tree Map. 

    static <K, V> void task2(TreeMap<K, V> map1, TreeMap<K, V> map2) {
        map2.putAll(map1);
    }

    //    3. Write a Java program to search a key in a Tree Map.
    static <K, V> boolean task3(TreeMap<K, V> map, K key) {
        return map.containsKey(key);
    }

    //    4. Write a Java program to search a value in a Tree Map.
    static <K, V> boolean task4(TreeMap<K, V> map, K key) {
        return map.containsValue(key);
    }

    //    5. Write a Java program to get all keys from the given a Tree Map.
    static <K, V> Set<K> task5(TreeMap<K, V> map) {
        return map.keySet();
    }

    //    6. Write a Java program to delete all elements from a given Tree Map. 
    static <K, V> void task6(TreeMap<K, V> map) {
        map.clear();
    }

    //    7. Write a Java program to sort keys in Tree Map by using comparator. 
    static <K, V> void task7(TreeMap<K, V> map, Comparator<K> comparator) {
        TreeMap<K, V> map1 = new TreeMap<>(comparator);
        map1.putAll(map);
        map = map1;
    }

    //    8. Write a Java program to get a key-value mapping associated with the greatest key and the least key in a map. 
    static <K, V> void task8(TreeMap<K, V> map, Comparator<K> comparator) {
        //harc@ chem haskacel
    }

    //        9. Write a Java program to get the first (lowest) key and the last (highest) key currently in a map. 
    static <K, V> void task9(TreeMap<K, V> map) {
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
    }

    //10. Write a Java program to get a reverse order view of the keys contained in a given map.
    static <K, V> void task10(TreeMap<K, V> map) {
        List<K> list = new ArrayList<>(map.keySet());
        Collections.reverse(list);
        System.out.print(list);
    }

    //11. Write a Java program to get a key-value mapping associated with the greatest key less than or equal to the given key. 
    static <K, V> Map.Entry task11(TreeMap<K, V> map, K key) {
        return map.floorEntry(key);
    }

    //12. Write a Java program to get the greatest key less than or equal to the given key. 
    static <K, V> K task12(TreeMap<K, V> map, K key) {
        return map.floorKey(key);
    }

    //13. Write a Java program to get the portion of a map whose keys are strictly less than a given key. 
    static <K, V> SortedMap<K, V> task13(TreeMap<K, V> map, K key) {
        return map.headMap(key);
    }

    //14. Write a Java program to get the portion of this map whose keys are less than (or equal to, if inclusive is true) a given key. 
    static <K, V> SortedMap<K, V> task14(TreeMap<K, V> map, K key) {
        return map.headMap(key, true);
    }

    //15. Write a Java program to get the least key strictly greater than the given key. Return null if there is no such key.  
    static <K, V> K task15(TreeMap<K, V> map, K key) {
        return map.higherKey(key);
    }

    //16. Write a Java program to get a key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.
    static <K, V> Map.Entry<K, V> task16(TreeMap<K, V> map, K key) {
        return map.lowerEntry(key);
    }

    //17. Write a Java program to get the greatest key strictly less than the given key. Return null if there is no such key.
    static <K, V> K task17(TreeMap<K, V> map, K key) {
        return map.lowerKey(key);
    }

    //18. Write a Java program to get NavigableSet view of the keys contained in a map. 
    static <K, V> NavigableSet<K> task18(TreeMap<K, V> map, K key) {
        return map.navigableKeySet();
    }

    //19. Write a Java program to remove and get a key-value mapping associated with the least key in a map. 
    static <K, V> Map.Entry<K, V> task19(TreeMap<K, V> map, K key) {
        Map.Entry<K, V> lastEntry = map.lastEntry();
        map.remove(map.lastKey());
        return lastEntry;
    }

    //20. Write a Java program to remove and get a key-value mapping associated with the greatest key in this map. 
    static <K, V> Map.Entry<K, V> task20(TreeMap<K, V> map, K key) {
        Map.Entry<K, V> firstEntry = map.firstEntry();
        map.remove(map.firstKey());
        return firstEntry;
    }

    //21. Write a Java program to get the portion of a map whose keys range from a given key (inclusive), to another key (exclusive).
    static <K, V> SortedMap<K, V> task21(K fromKey, K toKey, TreeMap<K, V> map) {
        return map.subMap(fromKey, toKey);
    }

    //22. Write a Java program to get the portion of a map whose keys range from a given key to another key.
    static <K, V> SortedMap<K, V> task22(K fromKey, K toKey, TreeMap<K, V> map) {
        return map.subMap(fromKey, true, toKey, true);
    }

    //23. Write a Java program to get a portion of a map whose keys are greater than or equal to a given key.
    static <K, V> SortedMap<K, V> task23(K key, TreeMap<K, V> map) {
        return map.tailMap(key);
    }

    //24. Write a Java program to get a portion of a map whose keys are greater than to a given key.
    static <K, V> SortedMap<K, V> task24(K key, TreeMap<K, V> map) {
        return map.tailMap(key,false);
    }

    //25. Write a Java program to get a key-value mapping associated with the least key greater than or equal to the given key. Return null if there is no such key.
    static <K, V> Map.Entry<K, V> task25(K key, TreeMap<K, V> map) {
        return map.ceilingEntry(key);
    }

    //26. Write a Java program to get the least key greater than or equal to the given key. Returns null if there is no such key.
    static <K, V> K task26(K key, TreeMap<K, V> map) {
        return map.ceilingKey(key);
    }


    public static void main(String[] args) {


    }

}

/*

1. Write a Java program to associate the specified value with the specified key in a Tree Map. 
2. Write a Java program to copy a Tree Map content to another Tree Map. 
3. Write a Java program to search a key in a Tree Map.
4. Write a Java program to search a value in a Tree Map. 
5. Write a Java program to get all keys from the given a Tree Map.
6. Write a Java program to delete all elements from a given Tree Map. 
7. Write a Java program to sort keys in Tree Map by using comparator. 
8. Write a Java program to get a key-value mapping associated with the greatest key and the least key in a map. 
9. Write a Java program to get the first (lowest) key and the last (highest) key currently in a map. 
10. Write a Java program to get a reverse order view of the keys contained in a given map. 
11. Write a Java program to get a key-value mapping associated with the greatest key less than or equal to the given key. 
12. Write a Java program to get the greatest key less than or equal to the given key. 
13. Write a Java program to get the portion of a map whose keys are strictly less than a given key. 
14. Write a Java program to get the portion of this map whose keys are less than (or equal to, if inclusive is true) a given key.
15. Write a Java program to get the least key strictly greater than the given key. Return null if there is no such key. 
16. Write a Java program to get a key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.
17. Write a Java program to get the greatest key strictly less than the given key. Return null if there is no such key.
18. Write a Java program to get NavigableSet view of the keys contained in a map. 
19. Write a Java program to remove and get a key-value mapping associated with the least key in a map. 
20. Write a Java program to remove and get a key-value mapping associated with the greatest key in this map.
21. Write a Java program to get the portion of a map whose keys range from a given key (inclusive), to another key (exclusive).
22. Write a Java program to get the portion of a map whose keys range from a given key to another key.
23. Write a Java program to get a portion of a map whose keys are greater than or equal to a given key.
24. Write a Java program to get a portion of a map whose keys are greater than to a given key.
25. Write a Java program to get a key-value mapping associated with the least key greater than or equal to the given key. Return null if there is no such key.
26. Write a Java program to get the least key greater than or equal to the given key. Returns null if there is no such key.

*/