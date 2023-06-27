public class DomesticDivision extends Division {
    String divisionState;

    public DomesticDivision(String companyName, int companyAccNum, String divisionState) {
        super(companyName, companyAccNum);
        this.divisionState = divisionState;
    }

    public String display() {
        return "Company Name: " + companyName + "\nAccount Number: " + companyAccNum + "\nState: " + divisionState;
    }
}