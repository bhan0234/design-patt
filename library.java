class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // A book is available by default
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false; // Mark as borrowed
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true; // Mark as available
    }
}



class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow this book.");
        }
    }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add a book to the library collection
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    // Remove a book from the library collection
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed book: " + book.getTitle());
    }

    // Find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Add a user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("Added user: " + user.getName());
    }
}


public class Main {
    public static void main(String[] args) {
        // Create the library system
        Library library = new Library();

        // Create books
        Book book1 = new Book(1, "Java Programming", "John Doe");
        Book book2 = new Book(2, "Design Patterns", "Gang of Four");

        // Create users
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Add users to the library
        library.addUser(user1);
        library.addUser(user2);

        // Users borrow books
        user1.borrowBook(book1); // Alice borrows Java Programming
        user2.borrowBook(book2); // Bob borrows Design Patterns

        // Searching for a book
        Book searchedBook = library.findBookByTitle("Design Patterns");
        if (searchedBook != null) {
            System.out.println("Found book: " + searchedBook.getTitle());
        }

        // User returns a book
        user1.returnBook(book1); // Alice returns Java Programming
    }
}
