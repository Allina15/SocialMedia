import java.util.Arrays;

public class DataBase {
    private User[]users;
    private Profile[]profiles;

    public DataBase(User[] users, Profile[]profiles) {
        this.users = users;
        this.profiles=profiles;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Profile[] getProfiles() {
        return profiles;
    }

    public void setProfiles(Profile[] profiles) {
        this.profiles = profiles;
    }

    public String saveUser(User user){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==user.getId()) {
                return "Такой пользователь уже есть";

            } }

                User[] users1;
                users1 = Arrays.copyOf(users, users.length + 1);
                users1[users.length] = user;
                users = Arrays.copyOf(users1, users1.length);
                setUsers(users);
                System.out.println(Arrays.toString(users));
        return "";
    }
    public String findUserById(int id){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==id){
                return "user "+users[i];
            }
        }
        return "Нет такого пользователья";
    }
    public String updateUserProfile(int userId, Profile profile){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==userId){
                users[i].setProfile(profile);
                return "New profile of user "+users[i].getProfile();
            }
        }
        return "Нет такого пользователья";
    }
    public String deleteUser(int userId){
        User[]newUsers = new User[users.length-1];
        boolean index = false;
        for (int i = 0; i < users.length-1; i++) {
            if (!index && users[i].getId()!=userId){
                newUsers[i]=users[i];
            }else {
                index=true;
            }
            if(index){
                newUsers[i]=users[i+1];
            }
        }
        setUsers(newUsers);
        for (int j = 0; j < users.length; j++) {
            users[j].setId(j);
        }
        return "User is deleted"+Arrays.toString(newUsers);
    }
    public String saveProfile(int userId, Profile profile){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==userId){
                users[i].setProfile(profile);
                users[i].getProfile().setId(userId);
                return "New profile of user "+users[i].getProfile();
            }
        }
        return "Нет такого пользователья";
    }
    public String findProfileByUserId(int userId){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==userId){
                return "User "+users[i].getProfile();
            }
        }
        return "Нет такого пользователья";
    }
    public String deleteProfileByUserId(int userId){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==userId){
                users[i].setProfile(null);

                return "Profile deleted "+users[i].getId();
            }
        }
        return "Нет такого пользователья";
    }
    public String savePost(int userId, Post post) {
        for (int i = 0; i < users.length; i++) {
            Post[] OldPosts = users[i].getProfile().getPosts();
            Post[]newPosts = Arrays.copyOf(OldPosts,OldPosts.length+1);

            if (users[i].getId() == userId) {
                newPosts[OldPosts.length]=post;
                users[i].getProfile().setPosts(newPosts);

                for (int j = 0; j < newPosts.length; j++) {
                    newPosts[j].setId(j);
                }

                return "New post " + Arrays.toString(newPosts);
            }
        }
        return null;
    }
    public String getPostsByUserId(int userId){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId()==userId){
                return "User posts "+Arrays.toString(users[i].getProfile().getPosts());
            }
        }
        return null;
    }
    public String saveComment(int profileId, int postId, Comment comment){
        for (Profile p:profiles) {
            if(p.getId()==profileId){
                for (int i = 0; i < p.getPosts().length; i++) {
                    if (p.getPosts()[i].getId() == postId) {
                        Comment[] comments = Arrays.copyOf(p.getPosts()[i].getComments(), p.getPosts()[i].getComments().length + 1);
                        comments[comments.length - 1] = comment;
                        p.getPosts()[i].setComments(comments);

                        for (int j = 0; j < comments.length; j++) {
                            comments[j].setId(j);
                        }
                        return Arrays.toString(comments);
                    }
                }
            }
        }
        return null;
                    }
    @Override
    public String toString() {
        return "DataBase{" +
                "users=" + Arrays.toString(users) +
                ", profiles=" + Arrays.toString(profiles) +
                '}';
    }
}
