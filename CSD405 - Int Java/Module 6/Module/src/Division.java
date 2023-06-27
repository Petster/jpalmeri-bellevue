public abstract class Division {
    String companyName;
    int companyAccNum;
    
    public abstract String display();

    public Division(String companyName, int companyAccNum) {
        this.companyName = companyName;
        this.companyAccNum = companyAccNum;
    }
}