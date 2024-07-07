package project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataModule {

    // Method to serialize a Module object to XML
    public static String serializeModuleToXML(Module module) {
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY); // Allow all types (use with caution)
        xStream.alias("module", Module.class);
        return xStream.toXML(module);
    }

    // Method to convert XML file content to a String
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

    // Method to write XML content to a file
    public static void writeXMLToFile(String xml, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(xml);
            System.out.println("XML written to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load a Module object from XML file
    public static Module loadModuleFromXML(String filename) {
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY); // Allow all types (use with caution)
        xStream.alias("module", Module.class);
        try (FileReader reader = new FileReader(filename)) {
            return (Module) xStream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to check if the XML file exists and create it with initial data if it doesn't
    public static void initializeXML(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            // Create initial Module data
            Module initialModule = new Module("SK2345-GH","Operational","7");
            String xml = serializeModuleToXML(initialModule);
            writeXMLToFile(xml, filename);
            System.out.println("Initial XML created with data: " + xml);
        } else {
            System.out.println("XML file already exists.");
        }
    }

    
}