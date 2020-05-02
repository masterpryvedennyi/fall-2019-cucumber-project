package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BooksTableStepDefs {
    BooksPage booksPage = new BooksPage();

    @Then("search table should contain results matching {}")
    public void search_table_should_contain_results_matching(String bookName) {
        List<String> actualRows = BrowserUtils.getElementsText(booksPage.allRows);

        boolean found = true;
        for (String row : actualRows) {
            if(!row.contains(bookName)){
                found = false;
            }
        }
        assertTrue(bookName + " was not found in books table", found);
    }

    @When("I edit book {}")
    public void i_edit_book_(String book) {
        System.out.println("Book = " + book);
        BrowserUtils.waitForClickability(booksPage.search, 5).sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();
        System.out.println("Book = " + book);
    }

    //register a data table type that uses a custom class
    @DataTableType
    public Book convertBook(Map<String,String> dataTable){
        Book book = new Book(dataTable.get("name"),
                             dataTable.get("author"),
                             dataTable.get("year"));
        return book;
    }

    @Then("I verify book information")
    public void i_verify_book_information(Book book) {
        System.out.println(book);
        System.out.println("book.getName() = " + book.getName());
        System.out.println("book.getAuthor() = " + book.getAuthor());
        System.out.println("book.getYear() = " + book.getYear());

        assertEquals("Book name did not match", book.getName(), booksPage.bookName.getAttribute("value"));
        assertEquals("Book author did not match", book.getAuthor(), booksPage.author.getAttribute("value"));
        assertEquals("Book year did not match", book.getYear(), booksPage.year.getAttribute("value"));

    }

}
