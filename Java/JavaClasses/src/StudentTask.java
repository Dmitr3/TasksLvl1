import java.util.*;

/*Создать классы, спецификации которых приведены ниже.
Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов.
Задать критерий выбора данных и вывести эти данные на консоль.
В каждом классе, обладающем информацией, должно быть объявлено несколько
конструкторов.
1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон,
Факультет, Курс, Группа.
Создать массив объектов. Вывести:
a) список студентов заданного факультета;
b) списки студентов для каждого факультета и курса;
c) список студентов, родившихся после заданного года;
d) список учебной группы.*/

public class StudentTask {
    public static void main(String[] args) {
        University university = new University();
        university.setStudentData();

        System.out.println("Students by faculties:");
        university.getFaculties();

        System.out.println("Students by faculties and course:");
        university.getFacultiesAndCourse();

        System.out.println("Students by birth");
        university.getYear();

        System.out.println("Students by groups:");
        university.getStudGroup();
    }
}

class University {
    private ArrayList<Student> StudentList = new ArrayList<>();

    void addStudent(Student student) {
        StudentList.add(student);
    }

    public void setStudentData() {
        this.addStudent(new Student("Курочкин", "Иван", "Петрович", "22 03 2000", "г.Минск", "80291111111", "ФАК1", 1, 111));
        this.addStudent(new Student("Снегурочкин", "Пётр", "Иванович", "15 02 1999", "г.Минск", "80291111112", "ФАК1", 1, 111));

        this.addStudent(new Student("Хоботов", "Илья", "Михайлович", "17 08 1997", "г.Минск", "80291111113", "ФАК2", 2, 222));
        this.addStudent(new Student("Нехоботов", "Михаил", "Ильич", "10 09 1997", "г.Минск", "80291111114", "ФАК2", 2, 333));

        this.addStudent(new Student("Зверобоев", "Руслан", "Олегович", "27 12 1995", "г.Минск", "80291111115", "ФАК3", 3, 666));
        this.addStudent(new Student("Зверолюбов", "Олег", "Русланович", "13 05 1995", "г.Минск", "80291111116", "ФАК3", 3, 777));

        this.addStudent(new Student("Лучезарный", "Антон", "Антонович", "01 01 1993", "г.Минск", "80291111117", "ФАК4", 4, 999));

    }

    public void getFaculties() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose students faculties: ФАК1, ФАК2, ФАК3 or ФАК4:");
        String fac = in.nextLine();

        for (Student Student111 : StudentList) {
            if (Student111.getFaculty().equals(fac)) {
                System.out.println(Student111.toString());
            }
        }
    }

    public void getFacultiesAndCourse() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose students faculties: ФАК1, ФАК2, ФАК3 or ФАК4 and course: 1, 2, 3 or 4 :");
        String faculty = in.nextLine();
        int course = in.nextInt();

        for (Student Student222 : StudentList) {
            if (Student222.getFaculty().equals(faculty) && Student222.getCourse() == course) {
                System.out.println(Student222.toString());
            }
        }
    }

    public void getYear() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose students year:");
        int year = in.nextInt();

        for (Student Student333 : StudentList) {
            if (parseYear(Student333.getDayOfBirth().substring(6)) >= year) {
                System.out.println(Student333.toString());
            }
        }
    }

    public int parseYear(String years) {
        return Integer.parseInt(years);
    }

    public void getStudGroup() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose students groups: 111, 222, 333, 666, 777 or 999:");
        int group = in.nextInt();

        for (Student Student444 : StudentList) {
            if (Student444.getGroup() == group) {
                System.out.println(Student444.toString());
            }
        }
    }
}

class Student {
    private static int totalCustomers = 0;
    private final int id = totalCustomers++;

    private String surname;
    private String name;
    private String patronymic;
    private String dayOfBirth;
    private String address;
    private String telNumber;
    private String faculty;
    private Integer course;
    private Integer group;

    Student(String surname, String name, String patronymic, String dayOfBirth, String address, String telNumber, String faculty,
            Integer course, Integer group) {

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.telNumber = telNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getCourse() {
        return course;
    }

    public Integer getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dayOfBirth=" + dayOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", telNumber=" + telNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course + '\'' +
                ", group=" + group +
                '}';
    }
}
