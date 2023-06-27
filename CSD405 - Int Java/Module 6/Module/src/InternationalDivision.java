public class InternationalDivision extends Division {
    String divisionCountry;
    String divisionLanguage;

    public InternationalDivision(String companyName, int companyAccNum, String divisionCountry, String divisionLanguage) {
        super(companyName, companyAccNum);
        this.divisionCountry = divisionCountry;
        this.divisionLanguage = divisionLanguage;
    }

    public String display() {
        return "Company Name: " + companyName + "\nAccount Number: " + companyAccNum + "\nCountry: " + divisionCountry + "\nLanguage: " + divisionLanguage;
    }
}