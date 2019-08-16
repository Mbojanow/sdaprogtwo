package pl.sdacademy.prog.zadB;

import org.apache.logging.log4j.util.PropertySource;
import org.springframework.util.comparator.Comparators;

import java.util.*;

public class NumUtil {

    public static<T extends Number> double findMedian(final List<T> collection) {
        assert collection.size() > 0;
        final List<T> collectionCopy = new ArrayList<>(collection);
        collectionCopy.sort(Comparator.comparingDouble(Number::doubleValue));
        if (isSizeUneven(collectionCopy)) {
            return collectionCopy.get(collectionCopy.size() / 2).doubleValue();
        }

        return (collectionCopy.get(collectionCopy.size() / 2 - 1).doubleValue() + collectionCopy.get(collectionCopy.size() / 2).doubleValue()) / 2;
    }

    private static <T> boolean isSizeUneven(final List<T> collection) {
        return collection.size() % 2 == 1;
    }

    public static void main(String[] args) {
        final List<Number> values = new ArrayList<>();
        values.add(5);
        values.add(6.5);
        values.add(7);
        values.add(12.2);
        values.add(10L);

        System.out.println(findMedian(values));
    }
}
