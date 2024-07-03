package project;

public class Machine {
    String machineName;
    String healthStatus;
    String temperature;
    String age;
    

    public Machine(String machineName, String healthStatus, String temperature, String age) {
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "machineName='" + machineName + '\'' +
                ", status='" + healthStatus + '\'' +
                ", temperature='" + temperature + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    
       
}