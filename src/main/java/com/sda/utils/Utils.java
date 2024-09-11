package com.sda.utils;

import com.sda.model.Article;

import java.util.List;
import java.util.Scanner;

public class Utils {

    public static Object chooseArticle(List<?> productList, Scanner scanner) {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
        System.out.print("Choose article: ");
        int index = scanner.nextInt();
        return productList.get(index - 1);
    }
}
