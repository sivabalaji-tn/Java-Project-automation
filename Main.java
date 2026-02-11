import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STAFF LOGIN =====");
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        try {
            Connection c = DBConnection.getConnection();

            String q = "SELECT * FROM staff WHERE username=? AND password=?";
            PreparedStatement ps = c.prepareStatement(q);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful ✅");

                int choice = 0;

                while (choice != 2) {
                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Add Student");
                    System.out.println("2. Exit");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine(); 

                    if (choice == 1) {

                        System.out.print("Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        String insert = "INSERT INTO students(name, dept, email) VALUES (?, ?, ?)";
                        PreparedStatement ps2 = c.prepareStatement(insert);
                        ps2.setString(1, name);
                        ps2.setString(2, dept);
                        ps2.setString(3, email);

                        ps2.executeUpdate();

                        System.out.println("Student Added Successfully 🎓");
                    }
                }

                System.out.println("Exited Successfully.");

            } else {
                System.out.println("Invalid Login ❌");
            }

            c.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}
