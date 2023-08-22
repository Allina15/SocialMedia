import java.time.LocalDate;
import java.util.Arrays;

public class Profile {
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String bio;
    private Post [] posts;
    private int Id;
    public Profile(String fullName, LocalDate dateOfBirth, String gender, String bio, Post[] posts) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bio = bio;
        this.posts = posts;
        for (int i = 1; i < posts.length; i++) {
            posts[i].setId(Id+1);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public String findCommentByPostId(int postId){
        for (Post post:posts) {
        if (post.getId()==postId){
            return "Comments this post " + Arrays.toString(post.getComments());
        }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nProfile " +
                "fullName = " + fullName +
                ", dateOfBirth = " + dateOfBirth +
                ", gender = " + gender +
                ", bio = " + bio +
                ", posts = " + Arrays.toString(posts) +
                ", profileId = " + Id+"\n";
    }
}
