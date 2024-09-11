package com.sda;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sda.modules.UiModule;
import com.sda.services.ArticleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new UiModule());
        ArticleService articleService = injector.getInstance(ArticleService.class);
        Scanner scanner = injector.getInstance(Scanner.class);
//        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("0. Exit");
            System.out.println("1. List Articles");
            System.out.println("2. Add Article");
            System.out.println("3. Edit Article");
            System.out.println("4. Delete Article");

            int input = scanner.nextInt();

            if (input == 0){
                break;
            }
            switch (input){
                case 1:
                    System.out.println(articleService.listArticles());
                    break;
                case 2:
                    articleService.createArticle();
                    break;
                case 3:
                    articleService.editArticle();
                    break;
                case 4:
                    articleService.deleteArticle();
                    break;
                default:
                    break;
            }
        }
    }

}