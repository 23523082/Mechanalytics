package project;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataMachine {

    public static String serializeMachineToXML(Machine machine) {
        XStream xStream = new XStream();
        xStream.alias("machine", Machine.class); // Alias for cleaner XML output
        return xStream.toXML(machine);
    }

    public static String xml2String(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream inputDoc = new FileInputStream(filePath)) {
            int content;
            while ((content = inputDoc.read()) != -1) {
                stringBuilder.append((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file: " + e.getMessage();
        }
        return stringBuilder.toString();
    }

    public static void writeXMLToFile(String xml, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(xml);
            System.out.println("XML written to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Machine loadMachineFromXML(String filename) {
        XStream xStream = new XStream();
        xStream.alias("machine", Machine.class);
        try (FileReader reader = new FileReader(filename)) {
            return (Machine) xStream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static List<Machine> loadMachineFromXMLforCombobox(String filename) {
        XStream xStream = new XStream();
        xStream.alias("machine", Machine.class);
        
        try (FileReader reader = new FileReader(filename)) {
            return (List<Machine>) xStream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static List<String> getAllMachineNames(String filename) {
        List<Machine> machines = loadMachineFromXMLforCombobox(filename);
        List<String> machineNames = new ArrayList<>();

        if (machines != null) {
            for (Machine machine : machines) {
                machineNames.add(machine.getMachineName());
            }
        }
        return machineNames;
    }

    // Method to simulate machine data update
    public static Machine getUpdatedMachineData() {
        // Simulate updated machine data
        return new Machine("Lathe", "Operational", "75°C", "5 years", null);
    }
    

    // Method to update XML with new machine data
    public static void updateMachineData() {
        Machine updatedMachine = getUpdatedMachineData();
        String xml = serializeMachineToXML(updatedMachine);
        writeXMLToFile(xml, "machine.xml");
    }
}
