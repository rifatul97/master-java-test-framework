package Sql;


public class DeleteDataFromDBDemo {

    public static void main(String[] args) {

        System.out.println("Printing Student Record from DB Before we delete a data");
        StudentDAO.findAll().forEach(System.out::println);

        final int studentIdToDelete = 5;
        System.out.printf("\nDeleting a student record of id: %d\n", studentIdToDelete);
        StudentDAO.deleteById(studentIdToDelete);

        System.out.println("\nPrinting Student Record from DB After we deleted the data");
        StudentDAO.findAll().forEach(System.out::println);

    }
}
