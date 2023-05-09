package compensation;

import java.io.Serial;
import java.io.Serializable;

public class Claim implements Serializable {

    // ids
    private String claimId;
    private String customerId;
    private String employeeId;
    // info
    private String date;
    private String type;
    private String description;
    private String location;
    // review
    private String report;
    private int compensation;
    private String reviewer;
    private boolean isPaid;
    private String review = "Reporting";

    public Claim(String[] values) {
        this.claimId = values[0];
        this.customerId = values[1];
        this.employeeId = values[2];
        this.date = values[3];
        this.type = values[4];
        this.description = values[5];
        this.location = values[6];
        this.report = values[7];
        this.compensation = Integer.parseInt(values[8]);
        this.reviewer = values[9];
        this.isPaid = values[10].equals("P");
        this.review = values[11];
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getCompensation() {
        return compensation;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}