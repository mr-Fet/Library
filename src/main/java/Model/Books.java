package Model;

import lombok.*;
@ToString
@EqualsAndHashCode
public class Books {
   private Integer id;
     private String name;
     private Integer authorId;
     private String category;

    private Books(BooksBuilder booksBuilder) {
        this.id = booksBuilder.id;
        this.name = booksBuilder.name;
        this.authorId = booksBuilder.authorId;
        this.category = booksBuilder.category;
    }

    public static class BooksBuilder{
        private Integer id;
        private String name;
        private Integer authorId;
        private String category;

        public BooksBuilder(Integer id) {
            this.id = id;
        }

        public BooksBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BooksBuilder setAuthorId(Integer authorId) {
            this.authorId = authorId;
            return this;
        }

        public BooksBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Books build(){

            return new Books(this);
        }
    }
}
