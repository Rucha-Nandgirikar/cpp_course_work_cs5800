package Q1;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Document {
    private List<Character> document = new ArrayList<>();

    public void addCharacter(char character, CharacterProperties properties) {
        document.add(new Character(character, properties));
    }

    public String getDocumentString() {
        StringBuilder documentString = new StringBuilder();
        for (Character character : document) {
            documentString.append(character.getCharacter());
        }
        return documentString.toString();
    }

    public void save(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Character character : document) {
                CharacterProperties properties = character.getProperties();
                writer.write(character.getCharacter() + ", " + properties.getFont() + ", " +
                        properties.getColor() + ", " + properties.getSize() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error occurred in saveFile(): " + e.getMessage());
        }
    }

    public void load(String filePath, FlyweightFactory factory) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            document.clear();
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(", ");
                if (splitter.length == 4) {
                    char characterValue = splitter[0].charAt(0);
                    String font = splitter[1].trim();
                    String color = splitter[2].trim();
                    int size = Integer.parseInt(splitter[3].trim());
                    addCharacter(characterValue, factory.getFlyweight(font, color, size));
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred in loadFile(): " + e.getMessage());
        }
    }
}
