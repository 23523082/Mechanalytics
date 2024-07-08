package project;

import java.util.List;

import javafx.scene.control.TableColumn;

public class Machine {
    String machineName;
    String healthStatus;
    String temperature;
    String age;
    private TableColumn<MachineHistory, List<MachineHistory>> tableColumn;
    

    public Machine(String machineName, String healthStatus, String temperature, String age, TableColumn<MachineHistory, List<MachineHistory>> tableColumn) {
        this.machineName = machineName;
        this.healthStatus = healthStatus;
        this.temperature = temperature;
        this.age = age;
        this.tableColumn = tableColumn;
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

    public void setmachinenamestable (TableColumn<MachineHistory, List<MachineHistory>> tableColumn){
        this.tableColumn = tableColumn;
    }
    public TableColumn<MachineHistory, List<MachineHistory>> getMachinesnamestable () {
        return tableColumn;
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