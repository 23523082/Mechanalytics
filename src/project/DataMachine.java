package project;

import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataMachine {

    public static String serializeMachineToXML(Machine machine) {
        XStream xStream = new XStream();
        xStream.alias("machine", Machine.class); // Alias for cleaner XML output
        return xStream.toXML(machine);
    }

    public static void main(String[] args) {
        // Example machine data
        Machine machine = new Machine("Lathe", "Operational", "75°C", "5 years");

        // Serialize to XML
        String xml = serializeMachineToXML(machine);
        System.out.println("Serialized XML:\n" + xml);

        // Optional: Write XML to file
        writeXMLToFile(xml, "machine.xml");

        // Optional: Load XML from file and deserialize
        Machine loadedMachine = loadMachineFromXML("machine.xml");
        if (loadedMachine != null) {
            System.out.println("Deserialized Machine: " + loadedMachine.getMachineName());
        }
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
}
