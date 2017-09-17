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
    private String post;
    private String experience;
    private String salary;
    private String contactName;
    private String contactEmail;

    public Advertisement(String title, String company, String text, String location, String date,
                         String contract, String post, String experience, String salary, String contactName,
                         String contactEmail) {
        this.title = title;
        this.company = company;
        this.text = text;
        this.location = location;
        this.date = date;
        this.contract = contract;
        this.post = post;
        this.experience = experience;
        this.salary = salary;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
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

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}