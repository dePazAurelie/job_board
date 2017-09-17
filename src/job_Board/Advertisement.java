package job_Board;

public class Advertisement {

    private int id;
    private String title;
    private String company;
    private String text;
    private String location;
    private String date;
    private String contract;
    private String experience;
    private String salary;
    private String contactName;
    private String contactEmail;

    public Advertisement(int id, String title, String company, String text, String location, String date,
                         String contract, String experience, String salary, String contactName,
                         String contactEmail) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.text = text;
        this.location = location;
        this.date = date;
        this.contract = contract;
        this.experience = experience;
        this.salary = salary;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public Advertisement(String title, String company, String text, String location,
                         String contract, String experience, String salary, String contactName,
                         String contactEmail) {
        this.title = title;
        this.company = company;
        this.text = text;
        this.location = location;
        this.contract = contract;
        this.experience = experience;
        this.salary = salary;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }

    String getDate() {
        return date;
    }

    String getContract() {
        return contract;
    }

    void setContract(String contract) {
        this.contract = contract;
    }

    String getExperience() {
        return experience;
    }

    void setExperience(String experience) {
        this.experience = experience;
    }

    String getSalary() {
        return salary;
    }

    void setSalary(String salary) {
        this.salary = salary;
    }

    String getContactName() {
        return contactName;
    }

    void setContactName(String contactName) {
        this.contactName = contactName;
    }

    String getContactEmail() {
        return contactEmail;
    }

    void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}