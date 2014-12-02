/**
 * Student
 *
 * @author Jayden Gardiner
 * @version 1.0 4/2/2014
 */

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private double grade;

    /**
     * Constructs a Student object with a first name and last name
     *
     * @param firstName The student's first name
     * @param lastName The student's last name
     */
    public Student(String firstName, String lastName) {

        if ((firstName == null)
            || (lastName == null)
            || (firstName.equals(""))
            || (lastName.equals(""))
            || (firstName.contains(" "))
            || (lastName.contains(" "))) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Sets the student's grade
     *
     * @param grade The student's grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Returns a string representation of the student's name and grade
     *
     * @return A string representation of the student's name and grade
     */
    public String toString() {
        return firstName + " " + lastName + ": " + grade;
    }

    /**
     * Checks to see if a Student is equal to another Student
     *
     * @return boolean true or false if Students are equal
     */
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        Student that = (Student) other;
        return this.firstName.equals(that.firstName)
            && this.lastName.equals(that.lastName);
    }

    /**
     * Compares a Student to another Student
     *
     * @return Integer Positve, negative, or zero comparison of students
     */
    public int compareTo(Student other) {
        int comparison = (int) (this.grade - other.grade);
        if (comparison == 0) {
            comparison = this.firstName.compareToIgnoreCase(other.firstName);
        }
        if (comparison == 0) {
            comparison = this.lastName.compareToIgnoreCase(other.lastName);
        }
        return comparison;
    }

    /**
     * Corresponding ashcode for the equals method
     *
     * @return A unique integer
     */
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode() + lastName.hashCode();
        return (int) this.grade;
    }

}