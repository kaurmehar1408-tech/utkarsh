import java.util.*;
class Book {
    private String id;
    private String title;
    private boolean isAvailable;
    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
abstract class Member {
    protected String memberId;
    protected String name;
    protected List<Book> borrowedBooks;
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public abstract int getMaxLimit();
    public boolean canBorrow() {
        return borrowedBooks.size() < getMaxLimit();
    }
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }
    public int getBorrowedCount() {
        return borrowedBooks.size();
    }
}
class StudentMember extends Member {
    public StudentMember(String id, String name) {
        super(id, name);
    }
    @Override
    public int getMaxLimit() {
        return 2;
    }
}
class FacultyMember extends Member {
    public FacultyMember(String id, String name) {
        super(id, name);
    }
    @Override
    public int getMaxLimit() {
        return 5;
    }
}
class GuestMember extends Member {
    public GuestMember(String id, String name) {
        super(id, name);
    }
    @Override
    public int getMaxLimit() {
        return 1;
    }
}
class Library {
    private Map<String, Book> books = new HashMap<>();
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    public void borrowBook(Member member, String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Borrow failed: Book not found");
        } else if (!book.isAvailable()) {
            System.out.println("Borrow failed: Book unavailable");
        } else if (!member.canBorrow()) {
            System.out.println("Borrow failed: Borrowing limit reached");
        } else {
            book.setAvailable(false);
            member.borrowBook(book);
            System.out.println("Borrowed: " + book.getTitle());
        }
    }
    public void returnBook(Member member, String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Return failed: Book not found");
        } else if (member.returnBook(book)) {
            book.setAvailable(true);
            System.out.println("Returned: " + book.getTitle());
        } else {
            System.out.println("Return failed: Book not borrowed by member");
        }
    }
}

public class librarymanagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Library library = new Library();
        for (int i = 0; i < n; i++) {
            String bookId = sc.next();
            String title = sc.next();
            library.addBook(new Book(bookId, title));
        }
        String memberType = sc.next();
        String memberId = sc.next();
        String memberName = sc.next();
        Member member = null;
        if (memberType.equalsIgnoreCase("STUDENT")) {
            member = new StudentMember(memberId, memberName);
        } else if (memberType.equalsIgnoreCase("FACULTY")) {
            member = new FacultyMember(memberId, memberName);
        } else if (memberType.equalsIgnoreCase("GUEST")) {
            member = new GuestMember(memberId, memberName);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String action = sc.next();
            String bookId = sc.next();
            if (action.equalsIgnoreCase("BORROW")) {
                library.borrowBook(member, bookId);
            } else if (action.equalsIgnoreCase("RETURN")) {
                library.returnBook(member, bookId);
            }
        }
        if (member != null) {
            System.out.println("Books Borrowed: " + member.getBorrowedCount());
        }
    }
}