package u8pp;

import java.util.Comparator;

public class Student {
    private int year;
    private String firstName;
    private String lastName;

    public Student(int year, String firstName, String lastName) {
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return year == other.year
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName);
    }

    public static Student generateRandomStudent() {
        int year = (int) (Math.random() * 4) + 9;
        String first = Character.toString((char) ('A' + (int) (Math.random() * 26)));
        String last = Character.toString((char) ('A' + (int) (Math.random() * 26)));
        return new Student(year, first, last);
    }
}

class StudentSorter implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getYear() != o2.getYear()) {
            return o2.getYear() - o1.getYear();
        }
        if (!o1.getLastName().equals(o2.getLastName())) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}