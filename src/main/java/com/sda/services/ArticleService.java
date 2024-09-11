package com.sda.services;

import com.google.inject.Inject;
import com.sda.model.Article;
import com.sda.utils.Utils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ArticleService {

    @Inject
    private Session session;

    @Inject
    private Scanner scanner;
    public List<Article> listArticles(){
        Query<Article> query = session.createQuery("SELECT a FROM Article a", Article.class);
        return query.getResultList();
    }
    public void createArticle(){
        Article a = new Article();
        System.out.print("Author : ");
        scanner.nextLine();
        a.setAuthor(scanner.nextLine());
        System.out.print("Title : ");
        a.setTitle(scanner.nextLine());
        a.setPublishingDate(new Date());
        System.out.print("Content : ");
        a.setContent(scanner.nextLine());


        Transaction t = session.beginTransaction();
        session.persist(a);
        t.commit();
    }
    public void editArticle(){

        Article a = (Article) Utils.chooseArticle(listArticles(), scanner);

        System.out.print("Author : ");
        scanner.nextLine();
        a.setAuthor(scanner.nextLine());
        System.out.print("Title : ");
        a.setTitle(scanner.nextLine());
        a.setPublishingDate(new Date());
        System.out.print("Content : ");
        a.setContent(scanner.nextLine());


        Transaction t = session.beginTransaction();
        session.merge(a);
        t.commit();

    }

    public void deleteArticle(){

        Article a = (Article) Utils.chooseArticle(listArticles(), scanner);


        Transaction t = session.beginTransaction();
        session.remove(a);
        t.commit();
    }
}
