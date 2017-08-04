package edu.berliner.bookdatabasegroup.controllers;


import edu.berliner.bookdatabasegroup.Books;
import edu.berliner.bookdatabasegroup.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
public class MainController
{
    @Autowired //prevents requirement to reinstantiate in every method
    BookRepository bookRepository;

    @GetMapping("/addbook")
    public String addBook(Model model)
    {
        model.addAttribute("addbook", new Books());
        return "addbook";
    }

    @GetMapping("/addstarterbooks")
    public String addStarterBooks()
    {
        long skus[]={1001,1002,1003,1004,1005,1006};
        String titles[]={"Head First Java", "Thinking in Java", "OCP: Oracle Certified Professional Java SE", "Automate the Boring Stuff with Python", "The Maker's Guide to the Zombie Apocalypse", "Raspberry Pi Projects for the Evil Genius"};
        String authors[]={"Kathy Sierra and Bert Bates", "Bruce Eckel", "Jeanne Boyarsky", "Al Sweigart", "Simon Monk", "Donald Norris"};
        double prices[]={47.50, 20.00, 45.00, 10.50, 16.50, 14.75};
        String descriptions[]={"Easy to read Java workbook", "Details about Java under the hood", "Details about Java under the hood", "Fun with Python", "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", "A dozen fiendishly fun projects for the Raspberry Pi!"};

        Books addStarter;
        for(int counter=0; counter<6; counter++)
        {
            addStarter = new Books();
            addStarter.setSku(skus[counter]);
            addStarter.setTitle(titles[counter]);
            addStarter.setAuthor(authors[counter]);
            addStarter.setPrice(prices[counter]);
            addStarter.setDescription(descriptions[counter]);
            bookRepository.save(addStarter);
        }
        return "addstarterbooks";
    }

    @PostMapping("/addbook")//book add
    public String productSubmit(@ModelAttribute("addbook") Books book, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "additem";
        }
        bookRepository.save(book);
        return "showbook";
    }

    @GetMapping("/showallbooks")
    public String showAllBooks(Model model)
    {

        Iterable <Books> bookList = bookRepository.findAll();
        for(Books book: bookList)
        {
            System.out.println(book.getAuthor());
        }
        model.addAttribute("bookList", bookList);

        return "showallbooks";
    }


}
