import java.util.Scanner;


static void main() {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();
    library.loadBooks();
    int choice;

    do {
        System.out.println("\n--- Library Management System ---");
        System.out.println("1. Add Book");
        System.out.println("2. Display Books");
        System.out.println("3. Remove Book");
        System.out.println("4. Search Book");
        System.out.println("5. Exit");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Enter a number.");
            scanner.next();
            System.out.print("Enter your choice: ");
        }

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();

                System.out.print("Enter author name: ");
                String author = scanner.nextLine();

                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();

                if (title.isBlank() || author.isBlank() || isbn.isBlank()) {
                    System.out.println("Fields cannot be empty!");
                } else {
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                }
                break;

            case 2:
                library.displayBooks();
                break;

            case 3:
                System.out.print("Enter ISBN of the book to remove: ");
                String isbnToRemove = scanner.nextLine();
                library.removeBook(isbnToRemove);
                break;


            case 4:
                System.out.print("Enter title, author, or ISBN to search: ");
                String keyword = scanner.nextLine();

                if (keyword.isBlank()) {
                    System.out.println("Search field cannot be empty!");
                } else {
                    library.searchBook(keyword);
                }
                break;

            case 5:
                System.out.println("Exiting program. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice! Choose a number from 1 to 5.");
        }

    } while (choice != 5);

    scanner.close();
}

