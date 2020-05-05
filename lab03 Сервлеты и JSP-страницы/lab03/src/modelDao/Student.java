package modelDao;

import java.util.Date;

public class Student{
    private int id;
    private int grooupeId;
    private String grooupe;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private int age;

    public Student(){};

    public Student(int id, String grooupe, String lastName,String firstName, Date birthDate, int age){
        this.id= id;
        this.grooupe = grooupe;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.age = age;
    }

    public Student(String grooupe, String lastName,String firstName, Date birthDate, int age){
        this.grooupe = grooupe;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrooupeId() {
        return grooupeId;
    }

    public void setGrooupeId(int grooupeId) {
        this.grooupeId = grooupeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrooupe() {
        return grooupe;
    }

    public void setGrooupe(String grooupe) {
        this.grooupe = grooupe;
    }
}
