package com.mysoft;
//model (Данные)
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.IntStream;

public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "Aventador10");
    }
//    static List<Post> posts;
//    static {
//        posts = new ArrayList<Post>();
//        posts.add(new Post(1, "hello"));
//        posts.add(new Post(2, "world"));
//        posts.add(new Post(3, "people"));
//    }
    public static long rand(int a, int b) {

        Date date = new Date();
        long x = date.getTime();
        x = a + x%(b-a);

        return x;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(rand(-8, -6));
        System.out.println("hello");
        System.out.println(getPosts());
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }

    public static List<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try(Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT id, txt from posts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String txt = rs.getString(2);
                posts.add(new Post(id, txt));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return posts;
    }

   public static void deletePosts(int id){
       try(Connection c = getConnection()) {
           PreparedStatement ps = c.prepareStatement("DELETE FROM posts where id=?");
           ps.setInt(1, id);
           ps.executeUpdate();

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
   }
    public static void addPost(String txt) {
        try(Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT into posts (txt) values (?)");
            ps.setString(1, txt);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
   }
}
