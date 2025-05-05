package com.y.presentation.dto;

import java.util.List;

public record Number(int number) {

    private static List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5);

    public Number{
        validate(number);
    }

    private void validate(int number) {
        if (!NUMBERS.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

}
