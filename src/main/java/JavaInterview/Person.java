package main.java.JavaInterview;

/**
 * Created by tjanusz929 on 6/24/16.
 */
public class Person {

    private String fullName;
    private int age;
    private String department;

    public Person(String fullName, int age, String department) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
