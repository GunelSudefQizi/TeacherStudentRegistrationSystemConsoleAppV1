package bean;

public class Teacher {

    private Integer id;
    private String name;
    private String surname;
    private Double salary;
    private Student[] studentsofTeacher = new Student[100];
    public int indexOfStudents = 0;

    public Teacher(Integer id, String name, String surname, Double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Student[] getStudentsofTeacher() {
        return studentsofTeacher;
    }

    public void setStudentsofTeacher(Student[] studentsofTeacher) {
        this.studentsofTeacher = studentsofTeacher;
    }

    public String print() {
        return "" + id +
                ", '" + name + '\'' +
                ", '" + surname + '\'' +
                ", " + salary;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary;
    }
}
