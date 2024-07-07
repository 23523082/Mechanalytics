package project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataMachineHistory {

    public static String serializeMachineHistoryListToXML(List<MachineHistory> historyList) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("machineHistory", MachineHistory.class);
        xStream.alias("history", List.class);
        return xStream.toXML(historyList);
    }

    @SuppressWarnings("unchecked")
    public static List<MachineHistory> loadMachineHistoryFromXML(String filename) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("machineHistory", MachineHistory.class);
        xStream.alias("history", List.class);

        try (FileReader reader = new FileReader(filename)) {
            return (List<MachineHistory>) xStream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeXMLToFile(String xml, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(xml);
            System.out.println("XML written to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createInitialXMLIfNotExists(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            List<MachineHistory> initialHistory = new ArrayList<>();
            // Add initial data if needed
            initialHistory.add(new MachineHistory("2024-01-01", "JohnDoe", "Lathe", "BrandX", "Maintenance", "Regular maintenance performed", "Completed"));
            String xml = serializeMachineHistoryListToXML(initialHistory);
            writeXMLToFile(xml, filename);
        }
    }

}