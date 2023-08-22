import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Comment comment1 = new Comment("Great post! Really enjoyed reading it.", LocalDate.of(2023, 8, 1));
        Comment comment2 = new Comment("I have a different perspective on this topic.", LocalDate.of(2023, 8, 2));
        Comment comment3 = new Comment("Thanks for sharing this valuable information.", LocalDate.of(2023, 8, 3));
        Comment comment4 = new Comment("This is a complex issue that needs more discussion.", LocalDate.of(2023, 8, 4));
        Comment comment5 = new Comment("I completely agree with your insights.", LocalDate.of(2023, 8, 5));
        Comment comment6 = new Comment("The data you presented is eye-opening.", LocalDate.of(2023, 8, 6));
        Comment comment7 = new Comment("I'm not sure I agree with your conclusions.", LocalDate.of(2023, 8, 7));
        Comment comment8 = new Comment("You missed an important aspect of this topic.", LocalDate.of(2023, 8, 8));
        Comment comment9 = new Comment("Your writing style is engaging and informative.", LocalDate.of(2023, 8, 9));
        Comment comment10 = new Comment("I've shared this article with my colleagues.", LocalDate.of(2023, 8, 10));
        Comment comment11 = new Comment("This information has changed my perspective.", LocalDate.of(2023, 8, 11));
        Comment comment12 = new Comment("I'm looking forward to more content from you.", LocalDate.of(2023, 8, 12));
        Comment comment13 = new Comment("Cool", LocalDate.of(2023, 8, 9));
        Comment[] comments1 = {comment1, comment2};
        Comment[] comments2 = {comment3, comment4};
        Comment[] comments3 = {comment5, comment6};
        Comment[] comments4 = {comment7, comment8};
        Comment[] comments5 = {comment9, comment10};
        Comment[] comments6 = {comment11, comment12};

        Post post1 = new Post("image Sunset", "Beautiful sunset", LocalDate.of(2023, 7, 30), comments1);
        Post post2 = new Post("image Meal", "Delicious meal", LocalDate.of(2023, 8, 1), comments2);
        Post post3 = new Post("image Memories", "Vacation memories", LocalDate.of(2023, 8, 4), comments3);
        Post post4 = new Post("image Coffee", "Morning coffee", LocalDate.of(2023, 8, 5), comments4);
        Post post5 = new Post("image Books", "Book recommendation", LocalDate.of(2023, 8, 2), comments5);
        Post post6 = new Post("image memories", "Throwback to last year", LocalDate.of(2023, 8, 9), comments6);

        Post[] posts1 = {post1, post2};
        Post[] posts2 = {post3, post4};
        Post[] posts3 = {post5, post6};

        Profile profile1 = new Profile("Alice Johnson", LocalDate.of(1990, 5, 10), "Female", "Nature enthusiast", posts1);
        Profile profile2 = new Profile("Bob Smith", LocalDate.of(1985, 9, 20), "Male", "Travel lover", posts2);
        Profile profile3 = new Profile("Eve Williams", LocalDate.of(2000, 2, 15), "Female", "Foodie", posts3);
        Profile profile4 = new Profile("Flower", LocalDate.of(2000, 9, 12), "Female", "flower lower", posts1);
        Profile[] profiles = {profile1, profile2, profile3, profile4};

        User user1 = new User("Alice", "alice@1", 121220, profile1);
        User user2 = new User("Bob", "bob@2", 202030, profile2);
        User user3 = new User("Eve", "eve@3", 141414, profile3);
        User[] users = {user1, user2, user3};

        DataBase dataBase = new DataBase(users, profiles);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*|Выберите действие|*");
            System.out.println("""
                    1. Создать аккаунт
                    2. Найти пользователя по его айди
                    3. Обновить профиль по айди
                    4. Удаление аккаунта по айди пользовтеля
                    5. Сохранить профиль по айди
                    6. Найти профиль по айди
                    7. Удаления профиля по айди
                    8. Сохранить пост в определенное айди
                    9. Просмотреть посты пользоватлеся по его айди
                    10. Поиск поста
                    11. Удаление поста по айди
                    12. Сохранить комментарий
                    13. Найти комментарий\s
                    14. Обновить комментарий
                    15. Удалить комментарий
                    """);
            System.out.print("Напишите номер действия: \n");
            int x = scanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println(dataBase.saveUser(user3));
                    break;
                case 2:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.findUserById(scanner.nextInt()));
                    break;
                case 3:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.updateUserProfile(scanner.nextInt(), profile2));
                    break;
                case 4:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.deleteUser(scanner.nextInt()));
                    break;
                case 5:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.saveProfile(scanner.nextInt(), profile4));
                    break;
                case 6:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.findProfileByUserId(scanner.nextInt()));
                    break;
                case 7:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.deleteProfileByUserId(scanner.nextInt()));
                    break;
                case 8:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.savePost(scanner.nextInt(), post6));
                    break;
                case 9:
                    System.out.println("введите айди пользователя");
                    System.out.println(dataBase.getPostsByUserId(scanner.nextInt()));
                    break;
                case 10:
                    System.out.println(user3.searchPost("Image Books"));
                    break;
                case 11:
                    System.out.println("введите айди поста");
                    System.out.println(user2.deletePostById(scanner.nextInt()));
                    break;
                case 12:
                    System.out.println("введите айди профиля");
                    System.out.println("введите айди поста");
                    System.out.println(dataBase.saveComment(scanner.nextInt(), scanner.nextInt(), comment13));
                    break;
                case 13:
                    System.out.println("введите айди поста");
                    System.out.println(profile1.findCommentByPostId(scanner.nextInt()));
                    break;
                case 14:
                    System.out.println("введите айди комментария");
                    System.out.println(post1.updateComment(scanner.nextInt(), "Woooooooooooooooww!!!!!"));
                    break;
                case 15:
                    System.out.println(post2.deleteComment(comment3));
                    break;
            }
        }
    }
}