public class Book extends Item {
    private String author;
    private String title;

    public Book(int volume, String itemId, String author, String title){
        super(volume, itemId);
        this.author = author;
        this.title = title;
    }

    public Book(Book book) {
        super(book);
        this.author = book.author;
        this.title = book.title;
    }



    @Override
    public String toString() {
        return "[Book] author: " + this.author + ", title: " + this.title + " " + super.toString(); 
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        if (o == this) return true;
        Book tmp = (Book) o;
        // System.out.println(this.mark + tmp.mark);
        return super.equals(tmp) && this.author.equals(tmp.author) && this.title.equals(tmp.title);
    }
}