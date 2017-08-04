package edu.berliner.bookdatabasegroup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Books
{
   @NotNull
   @Size(min=2, max=100)
   private String title;
   @NotNull
   @Size(min=2, max=100)
   private String author;
   @NotNull
   @Size(min=2, max=300)
   private String description;
   @NotNull
   @Id
   private long sku;
   @NotNull
   private double price;



    public long getSku()
    {
        return sku;
    }

    public void setSku(long sku)
    {
        this.sku = sku;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
