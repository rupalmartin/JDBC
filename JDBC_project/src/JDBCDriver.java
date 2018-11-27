
import java.sql.*;
public class JDBCDriver {


        public static void main(String[] args) throws SQLException {

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "***", "*****");

                System.out.println("Database connection successful!\n");

                // 2. Create a statement
                myStmt = myConn.createStatement();

                System.out.println("Inserting a new Employee!\n");

                //3. insert a new employee
                int rowsaffected = myStmt.executeUpdate("insert into employees " +
                        "(last_name,first_name,email,department,salary) " + "values " +
                        "('Wright', 'Eric','eric.wright@foo.com','HR',33000.00)");

                //4. Updating a new employee
                System.out.println("Updating the records of an Employee!\n");

                System.out.println("rows updated " + rowsaffected + "\n");

                int rows = myStmt.executeUpdate(
                        "update employees " +
                                "set email='new@gmail.com' " +
                                "where last_name='Doe' and first_name='John' ");

                //4. Deleting a new employee
                System.out.println("Deleting a records of an Employee!\n");

                int rowsdelete = myStmt.executeUpdate(
                        "delete from employees " +
                                "where last_name='Wright' and first_name='Eric' ");

                System.out.println("rows deleted " + rowsdelete + "\n");

                // 4. Execute SQL query
                myRs = myStmt.executeQuery("select * from employees");


                // 5. Process the result set
                while (myRs.next()) {
                    System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") +
                            ", " + myRs.getString("email"));
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            } finally {
                if (myRs != null) {
                    myRs.close();
                }

                if (myStmt != null) {
                    myStmt.close();
                }

                if (myConn != null) {
                    myConn.close();
                }
            }
        }
        }






