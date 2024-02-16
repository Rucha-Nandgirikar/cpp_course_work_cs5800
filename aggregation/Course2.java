package cpp.cs5800.adv_swe.assignment1.aggregation;

import java.util.ArrayList;
import java.util.List;

public class Course2 {

    String courseName;
    List<Instructor> instructorList;

    List<Textbook> textbookList;

    public Course2(String courseName) {
        instructorList = new ArrayList<>();
        textbookList = new ArrayList<>();
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Textbook> getTextbookList() {
        return textbookList;
    }

    public void setTextbookList(List<Textbook> textbookList) {
        this.textbookList = textbookList;
    }

    public void addInstructor(Instructor instructor) throws Exception {
        if (instructorList.size() == 2){
            throw new Exception("No more instructors allowed, max 2!");
        }
        if(instructor == null){
            throw new Exception("Null value is being passed");
        }
        instructorList.add(instructor);
    }

    public void addTextBook(Textbook textBook) throws Exception {
        if (textbookList.size() == 2){
            throw new Exception("No more textbooks allowed, max 2!");
        }
        if (textBook == null){
            throw new Exception("Null value is being passed");
        }
        textbookList.add(textBook);
    }

    public void print(){
        System.out.println("Course Name : " + this.courseName);

        instructorList.forEach(instructor -> System.out.println("Instructor : " + instructor.getFirstName() + ", " + instructor.getLastName()));
        textbookList.forEach(textBook -> {
            System.out.println("TextBook Title : " + textBook.getTitle());
            System.out.println("TextBook Author : " + textBook.getAuthor());
        });
    }
}
