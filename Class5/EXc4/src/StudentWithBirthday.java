import java.time.LocalDate;

class StudentWithBirthday {
    private String name;
    private int age;
    private String email;

    private LocalDate birthday;

    public StudentWithBirthday() {
    }

    public StudentWithBirthday(String name, int age, String email, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}