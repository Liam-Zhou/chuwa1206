public class Client {
    public static void main(String[] args) {
        Book book = new Book.Builder()
                .title("Harry Potter")
                .author("JK Rolin")
                .isbn("9723232216781")
                .publishYear("1999")
                .build();
    }
}

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publishYear;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
        this.publishYear = builder.publishYear;
    }

    public static final class Builder {
        private String title;
        private String author;
        private String isbn;
        private String publishYear;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder publishYear(String publishYear) {
            this.publishYear = publishYear;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}