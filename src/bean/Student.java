package bean;

public class Student {
    private Integer id;
    private String name;
    private String surname;
    private Double scholarship;

    public Student(Integer id, String name, String surname, Double scholarship) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.scholarship = scholarship;
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

    public Double getScholarship() {
        return scholarship;
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "" + id +
                ", '" + name + '\'' +
                ", '" + surname + '\'' +
                ", " + scholarship;
    }
}
