package project;

public class MachineHistory {
    private String date;
    private String userName;
    private String machineName;
    private String machineBrand;
    private String issueType;
    private String description;
    private String status;


    public MachineHistory(String date,String userName, String machineName,String machineBrand,String issueType,String description,String status){
        this.date = date;
        this.userName = userName;
        this.machineName = machineName;
        this.machineBrand = machineBrand;
        this.issueType = issueType;
        this.description = description;
        this.status = status;
    }
    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String MachineName) {
        this.machineName = MachineName;
    }

    public String getMachineBrand() {
        return machineBrand;
    }

    public void setMachineBrand(String MachineBrand) {
        this.machineBrand = MachineBrand;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    @Override
    public String toString() {
        return "MachineHistory{" +
                "date='" + date + '\'' +
                ", UserName='" + userName + '\'' +
                ", MachineName='" + machineName + '\'' +
                ", MachineBrand='" + machineBrand + '\'' +
                ", IssueType='" + issueType + '\'' +
                ", Description='" + description + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}
