/**
 * Represents student information for discount eligibility.
 * Holds the university name and student ID.
 *
 * Used to verify if a customer qualifies for a student discount
 * based on valid, non-empty university and student ID inputs.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class StudentInfo
{
    /** The name of the student's university */
    private String university;

    /** The student's ID number */
    private String studentId;

    /**
     * Constructs a StudentInfo object with university name and student ID.
     *
     * @param university the name of the university
     * @param studentId the student's ID number
     */
    public StudentInfo(String university, String studentId)
    {
        //Setting the university and student ID fields
        this.university = university;
        this.studentId = studentId;
    }

    /**
     * Checks if both university and student ID are non-null and not empty.
     *
     * @return true if both fields are valid, false otherwise
     */
    public boolean isValid()
    {
        //Return only true if both university and studentId are filled out
        return university != null && !university.isEmpty()
                && studentId != null && !studentId.isEmpty();
    }

    /**
     * Returns the name of the university.
     *
     * @return the university name
     */
    public String getUniversity()
    {
        //Return the university name
        return university;
    }

    /**
     * Returns a string representation of the student information.
     *
     * @return a formatted string with university and student ID
     */
    @Override
    public String toString()
    {
        //Format the university and student ID for a nice display
        return university + " (ID: " + studentId + ")";
    }
}
