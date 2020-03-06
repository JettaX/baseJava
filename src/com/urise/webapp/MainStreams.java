package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreams {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 3, 7, 1, 5, 4, 9, 2};
        System.out.println(minValue(arr));

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            list.add(i);
        }

        List<Integer> list2 = new ArrayList<>(oddOrEven(list));
        for (Integer iter: list2) {
            System.out.print(iter + " ");
        }
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values).filter(x -> x > 0 && x < 10).distinct().sorted().reduce(0, (acc, q) ->  acc * 10 + q);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
       return integers.stream().filter(x -> (x % 2 == 0 && integers.stream().reduce(0, Integer::sum) % 2 == 0) || (x % 2 != 0 && integers.stream().reduce(0, Integer::sum) % 2 != 0))
               .collect(Collectors.toList());
    }
}