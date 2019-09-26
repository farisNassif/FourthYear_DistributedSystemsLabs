package ie.gmit.ds;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "book")
@JsonRootName(value="book")

@XmlType(propOrder = { "author", "name", "publisher", "isbn" })
@JsonPropertyOrder({ "author", "name", "publisher", "isbn" })
public class Book {

    private String name;
    private String author;
    private String publisher;
    private String isbn;
    
    @XmlElement(name = "title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}