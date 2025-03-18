package alatoo.edu.librarymanagementsystem.dto;

public class BookDTO {
    private Long id;
    private String isbn;
    private String name;
    private String serialName;
    private String description;

    public BookDTO(Long id, String isbn, String name, String serialName, String description) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.serialName = serialName;
        this.description = description;
    }

    public BookDTO() {
    }

    public Long getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getName() { return name; }
    public String getSerialName() { return serialName; }
    public String getDescription() { return description; }
}
