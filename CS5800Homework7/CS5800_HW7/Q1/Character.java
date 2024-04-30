package Q1;
public class Character {
    char character;
    CharacterProperties properties;

    public Character(char character, CharacterProperties properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperties getProperties() {
        return properties;
    }
}
