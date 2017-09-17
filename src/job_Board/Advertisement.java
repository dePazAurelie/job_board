package job_Board;

import javafx.beans.property.SimpleStringProperty;

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

    public void setId(int id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}