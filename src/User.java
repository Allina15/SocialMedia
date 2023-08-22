import java.util.Arrays;

public class User {
    private String userName;
    private String email;
    private int password;
    public static int nextId = 1;
    private int Id;
    private Profile profile;

    public User(String userName, String email, int password, Profile profile) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.Id = nextId++;
        profile.setId(Id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String searchPost(String query) {
        for (int i = 0; i < getProfile().getPosts().length; i++) {
            if (getProfile().getPosts()[i].getImage().equalsIgnoreCase(query)) {
                return "post by your query " + getProfile().getPosts()[i];
            }
        }
        return null;
    }

    public String deletePostById(int id) {
        boolean found = false;
        Post[] posts = getProfile().getPosts();
        Post[] newPosts = new Post[posts.length - 1];
        for (int i = 0; i < posts.length; i++) {
            if (!found && posts[i].getId() != id) {
                newPosts[i] = posts[i];
            } else {
                found = true;
            }
            if (found && i + 1 < posts.length) {
                newPosts[i] = posts[i + 1];
            }
        }
        getProfile().setPosts(newPosts);
        for (int j = 0; j < newPosts.length; j++) {
            newPosts[j].setId(j);
            return "Post is deleted " + Arrays.toString(newPosts);
        }
        return  null;
    }

    @Override
    public String toString() {
        return "User " +
                "userName = " + userName +
                ", email = " + email +
                ", password = " + password +
                ", userId = " + Id +
                ", profile = " + profile+"\n";
    }
}
