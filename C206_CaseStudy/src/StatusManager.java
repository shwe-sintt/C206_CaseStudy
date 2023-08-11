
/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22017139
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Wednesday 09-08-2023 20:59
 */

/**
 * @author 22017139
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatusManager {
    private List<ApprovalStatus> approvalStatuses;

    public StatusManager() {
        this.approvalStatuses = new ArrayList<>();
    }

    public void addApprovalStatus(String name, String description) {
        ApprovalStatus newStatus = new ApprovalStatus(name, description);
        approvalStatuses.add(newStatus);
    }

    public List<ApprovalStatus> getApprovalStatuses() {
        return approvalStatuses;
    }

    public boolean isApprovalStatusNameUnique(String name) {
        for (ApprovalStatus status : approvalStatuses) {
            if (status.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public void deleteApprovalStatus(String name) {
        Iterator<ApprovalStatus> iterator = approvalStatuses.iterator();
        while (iterator.hasNext()) {
            ApprovalStatus status = iterator.next();
            if (status.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }
}
