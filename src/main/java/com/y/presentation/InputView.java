package com.y.presentation;

import com.y.presentation.dto.Number;
import com.y.presentation.dto.Order;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public Order buyProduct() {
        System.out.println("구매할 제품id와 구매 수량을 입력하세요. (예시: 1-5)");
        String input = scanner.nextLine().trim();
        return Order.from(input);
    }

    public Order sellProduct() {
        System.out.println("판매된 제품id와 판매 수량을 입력하세요. (예시: 1-5)");
        String input = scanner.nextLine().trim();
        return Order.from(input);
    }

    public Number choice() {
        System.out.println("\n1.전체재고조회 2.기존제품구매 3.기존제품판매 4.잔액조회 5.종료");
        int input = scanner.nextInt();
        scanner.nextLine();
        return new Number(input);
    }

}
