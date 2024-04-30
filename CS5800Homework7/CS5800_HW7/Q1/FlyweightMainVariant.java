package Q1;
public class FlyweightMainVariant {
    public static void main(String[] args) {
        FlyweightFactory characterFactory = new FlyweightFactory();
        Document editableDocument = new Document();

        // Using a consistent theme for properties but different parameters
        editableDocument.addCharacter('H', characterFactory.getFlyweight("Helvetica", "Red", 13));
        editableDocument.addCharacter('e', characterFactory.getFlyweight("Courier", "Blue", 15));
        editableDocument.addCharacter('l', characterFactory.getFlyweight("Monospace", "Black", 17));
        editableDocument.addCharacter('l', characterFactory.getFlyweight("Helvetica", "Red", 13));
        editableDocument.addCharacter('o', characterFactory.getFlyweight("Courier", "Blue", 15));
        editableDocument.addCharacter('W', characterFactory.getFlyweight("Monospace", "Black", 17));
        editableDocument.addCharacter('o', characterFactory.getFlyweight("Helvetica", "Red", 13));
        editableDocument.addCharacter('r', characterFactory.getFlyweight("Courier", "Blue", 15));
        editableDocument.addCharacter('l', characterFactory.getFlyweight("Monospace", "Black", 17));
        editableDocument.addCharacter('d', characterFactory.getFlyweight("Helvetica", "Red", 13));
        editableDocument.addCharacter('C', characterFactory.getFlyweight("Courier", "Blue", 15));
        editableDocument.addCharacter('S', characterFactory.getFlyweight("Monospace", "Black", 17));
        editableDocument.addCharacter('5', characterFactory.getFlyweight("Helvetica", "Red", 13));
        editableDocument.addCharacter('8', characterFactory.getFlyweight("Courier", "Blue", 15));
        editableDocument.addCharacter('0', characterFactory.getFlyweight("Monospace", "Black", 17));
        editableDocument.addCharacter('0', characterFactory.getFlyweight("Helvetica", "Red", 13));

        editableDocument.save("uniqueHelloWorld.txt");
    }
}
