import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(
                    book.getTitle() + " - " +
                            book.getAuthor() + " - " +
                            book.getIsbn()
            );
        }
    }


    public void removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(book);
                saveBooks();
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void searchBook(String keyword) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())
                    || book.getIsbn().equalsIgnoreCase(keyword)) {

                System.out.println(
                        book.getTitle() + " - " +
                                book.getAuthor() + " - " +
                                book.getIsbn()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }
    public void saveBooks() {
        try (FileWriter writer = new FileWriter("Books.txt")) {
            for (Book book : books) {
                writer.write(
                        book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.getIsbn() + "\n"
                );
            }

            System.out.println("Books saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }
    public void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length == 3) {
                    Book book = new Book(data[0], data[1], data[2]);
                    books.add(book);
                }
            }

            System.out.println("Books loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }
}



