package hr.dreamfactory.lectures.week2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    @Test
    public void streamTest() throws Exception {
        IntUnaryOperator intUnaryOperator = i -> i + 2;
        IntUnaryOperator multiply = i -> i * 2;

        int[] oddNumbers =
                IntStream.iterate(1,
                        intUnaryOperator)
                .limit(100)
                .toArray();

        int sum = Arrays.stream(oddNumbers)
                .map(t -> t * 2)
                .filter(t -> t % 9 == 0)
                .sum();

        Map<Integer, Integer> collect = Arrays.stream(oddNumbers)
                .map(t -> t * 2)
                .filter(t -> t % 9 == 0)
                .boxed()
                .collect(Collectors.toMap(t ->t, t -> t + 2));


        System.out.println(Arrays.toString(oddNumbers));
        System.out.println(sum);

    }
}
