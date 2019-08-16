package pl.sdacademy.prog.examples.generics;

import java.util.Collection;
import java.util.Map;

public class Util {
    public static <K, V> boolean areEntriesEqual(Map.Entry<K, V> p1, Map.Entry<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

}
