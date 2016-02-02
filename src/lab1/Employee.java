package lab1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the other best practices as explained by 
 * your instructor.
 *
 * @author      Yasir Cheema
 * @version     1.01
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date currentDate;

    public Employee() {
        currentDate = new Date();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public boolean isMetWithHr() {
        return metWithHr;
    }
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }
    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }
    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

   
    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }
    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }
    public boolean isMovedIn() {
        return movedIn;
    }
    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }
    public String getCubeId() {
        return cubeId;
    }
    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }
    public Date getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    // Assume this must be performed first
    public void meetWithHrForBenefitAndSalryInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(getCurrentDate());
        System.out.println("Met with Hr on " + fmtDate);
        setMetWithHr(true);
    }

    // Assume this is must be performed second
    public void meetDepartmentStaff() {
        if(isMetWithHr()) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(getCurrentDate());
            System.out.println("Met with Dept. Staff on " + fmtDate);
            setMetDeptStaff(true);
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    public void reviewDeptPolicies() {
        if(isMetWithHr() && isMetDeptStaff()) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(getCurrentDate());
            System.out.println("Reviewed Dept. Policies on " + fmtDate);
            setReviewedDeptPolicies(true);
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    public void moveIntoCubicle(String cubeId) {
        if(isMetWithHr() && isMetDeptStaff() && isReviewedDeptPolicies()) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(getCurrentDate());
            System.out.println("Moved into cube on " + fmtDate);
            this.setCubeId(cubeId);
            this.setMovedIn(true);
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }

    public String getStatus() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(getCurrentDate());

        if(isMetWithHr() && isMetDeptStaff()
           && isReviewedDeptPolicies() && isMovedIn()) {
            return "Orientation is completed on: " + fmtDate;
        } else {
            return fmtDate + ": Orientation in progress...";
        }
    }
}
