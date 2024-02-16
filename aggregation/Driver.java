package cpp.cs5800.adv_swe.assignment1.aggregation;

public class Driver {

    public static void main(String[] args) {

        Instructor instructor = new Instructor("Nima","Davarpanah ","3-2636");
        Textbook textbook = new Textbook("Clean Code ","Robert C Martin","Prentice Hall");
        Course course = new Course("CS5800-Advanced Software Engineering",instructor,textbook);

//        System.out.println(course);

        course.print();
        System.out.println("-----------------------------------------------------------------------------------");
        /// Modified course object
        Instructor instructor1 = new Instructor("David", "Johansen", "3-2637");
        Instructor instructor2 = new Instructor("John", "Korah", "2-2636");

        Textbook textBook1 = new Textbook("Kyle Rodriguez", "Intro to Algorithms", "Boston");
        Textbook textBook2 = new Textbook("Garcia Ortega", "Algorthim Expert", "Peterson");

        Course2 course2 = new Course2("Algorithm Analysis");

        try{
            course2.addInstructor(instructor1);
            course2.addInstructor(instructor2);

            course2.addTextBook(textBook1);
            course2.addTextBook(textBook2);

            course2.print();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
