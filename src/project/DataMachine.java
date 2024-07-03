package project;

import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataMachine {

    public static void main(String[] args) {
        XStream xStream = new XStream();

        // Setup aliases to make XML more readable
        xStream.alias("machine", Machine.class);

        // Example machine
        Machine machine = new Machine("Lathe", "Operational", "75°C", "5 years");

        // Serialize to XML
        String xml = xStream.toXML(machine);
        System.out.println("Serialized XML:\n" + xml);

        
        try (FileWriter writer = new FileWriter("machine.xml")) {
            writer.write(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load XML from file
        try (FileReader reader = new FileReader("machine.xml")) {
            Machine loadedMachine = (Machine) xStream.fromXML(reader);
            System.out.println("Deserialized Machine: " + loadedMachine.getMachineName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}