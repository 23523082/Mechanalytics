package project;

public class Machine {
    private String machineName;
    private String healthStatus;
    private int temperature;
    private String age;
    

    public Machine(String machineName, String healthStatus, int temperature, String age) {
        this.machineName = machineName;
        this.healthStatus = healthStatus;
        this.temperature = temperature;
        this.age = age;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public void setMachine( Machine machine) {
        
    }
}