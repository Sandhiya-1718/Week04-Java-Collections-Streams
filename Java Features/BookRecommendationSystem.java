import java.util.*;
import java.util.stream.Collectors;
public class BookRecommendationSystem {
    static class Book
    {
        String title;
        String author;
        String genre;
        double rating;
        Book(String title, String author, String genre, double rating)
        {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
    }
    static class BookRecommendation {
        String title;
        double rating;

        BookRecommendation(String title, double rating)
        {
            this.title = title;
            this.rating = rating;
        }
        @Override
        public String toString()
        {
            return title + " (Rating: " + rating + ")";
        }
    }
    public static void recommendBooks(List<Book> books)
    {
        List<BookRecommendation> sciFiBooks = books.stream()
                .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted((a, b) -> Double.compare(b.rating, a.rating))
                .limit(10)
                .collect(Collectors.toList());
        int pageSize = 5;
        int totalPages = (int) Math.ceil((double) sciFiBooks.size() / pageSize);
        for (int page = 1; page <= totalPages; page++)
        {
            System.out.println("\nPage " + page + ":");
            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, sciFiBooks.size());
            sciFiBooks.subList(start, end).forEach(System.out::println);
        }
    }
    public static void main(String[] args)
    {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.3),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.6),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.0),
                new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.3),
                new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.2),
                new Book("1984", "George Orwell", "Dystopian", 4.6)
        );
        recommendBooks(books);
    }
}
