package common.employee;


import java.io.File;
import java.io.Serializable;

public class Investigator extends Employee implements Serializable {

    public Investigator(String[] values) {
        super(values);
    }


    public boolean decideCompensation(String claimId, int compensation) {
        return false;
    }

    public boolean requestReview(String claimId) {
        return false;
    }

    public boolean uploadReport(String claimId, File report) {
        return false;
    }

}