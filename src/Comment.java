import java.time.LocalDate;

public class Comment {
    private String text;
    private LocalDate commentDate;
    private int Id;

    public Comment(String text, LocalDate commentDate) {
        this.text = text;
        this.commentDate = commentDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "\nComment{" +
                "text='" + text + '\'' +
                ", commentDate=" + commentDate +
                ", Id=" + Id +
                '}';
    }
}
