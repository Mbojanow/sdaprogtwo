package pl.sdacademy.prog.examples.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {

        Stream<Object> streamA = Stream.empty();

        Collection<Object> collection = Collections.emptyList();
        Stream<Object> streamB = collection.stream();


        List<Object> lst = new ArrayList<>();
        Stream<Object> listStream = lst.stream();

        Set<Object> set = new HashSet<>();
        Stream<Object> setStream = set.stream();

        Map<Object, Object> map = new HashMap<>();
        // map.stream() - nie istnieje!
        Stream<Map.Entry<Object, Object>> entryStream = map.entrySet().stream();

        Queue<Object> queue = new ArrayDeque<>();
        queue.stream();

        Stream<Double> doubleStream = Stream.of(2.3, 4.1, 19.0, 18.5);


        Stream<String> stringStream = Arrays.stream(new String[]{"str1", "str2", "str3"});

        Stream.<String>builder()
                .add("strA")
                .add("strB")
                .add("strC")
                .build();

        Stream<String> streamGenerated = Stream.generate(() -> "generatedElement").limit(10);

        Stream<Integer> streamIterated = Stream.iterate(5, n -> n + 3).limit(15);

        IntStream intStreamA = IntStream.of(1, 2, 6);
        IntStream intStreamB = IntStream.builder().add(1).add(3).build();
        IntStream intStreamC = IntStream.range(1, 10);

        LongStream longStream = LongStream.rangeClosed(2, 10);

        Consumer<Double> consumer = d -> System.out.println(d);
        Consumer<Double> consumerr = System.out::println;
    }
}
