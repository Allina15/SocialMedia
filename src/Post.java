import java.time.LocalDate;
import java.util.Arrays;

public class Post {
    private String image;
    private  String description;
    private LocalDate created;
    private Comment [] comments;
    private int Id;

    public Post(String image, String description, LocalDate created, Comment[] comments) {
        this.image = image;
        this.description = description;
        this.created = created;
        this.comments = comments;
        for (int i = 0; i < comments.length; i++) {
            comments[i].setId(i+1);
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public String updateComment(int commentId, String newText){
        for (int i = 0; i < comments.length ; i++) {
            if (comments[i].getId()==commentId){
                comments[i].setText(newText);
                Comment [] newComments = Arrays.copyOf(comments,comments.length);
                setComments(newComments);
               return "comment updated ";
           }
        }
        return null;
    }
    public String deleteComment(Comment comment){
        for (int i = 0; i < comments.length; i++) {
            boolean aa = false;
            Comment [] comments1 = new Comment[comments.length-1];
            if (!comments[i].equals(comment)){
                comments1[i]=comments[i];
            }else{
                aa=true;
            }
            if(aa){
                comments1[i]=comments[i+1];
                setComments(comments1);
                for (int j = 0; j < comments1.length; j++) {
                    comments1[j].setId(j);
                }
                return "comment is deleted ";
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nPost " +
                "image = " + image +
                ", description = " + description +
                ", created = " + created +
                ", comments = " + Arrays.toString(comments) +
                ", postId = "+Id +"\n";
    }
}
