package com.y.presentation.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Order(
        Long productId,
        int quantity
) {
    private static final Pattern INPUT_PATTERN = Pattern.compile("\\d+-\\d+");

    private static void validateInput(String input){
        Matcher matcher = INPUT_PATTERN.matcher(input);
        if(!matcher.matches()){
            throw new IllegalArgumentException();
        }
    }

    public static Order from(String input){
        validateInput(input);
        String[] split = input.split("-");
        Long productId = Long.parseLong(split[0]);
        int quantity = Integer.parseInt(split[0]);
        return new Order(productId, quantity);
    }

}
