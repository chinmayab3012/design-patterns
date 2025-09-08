package creational;

import java.util.Scanner;

/**
*The factory design pattern is used when we have a superclass with multiple subclasses and based on input, we need to return one of the subclasses. This pattern takes out the responsibility of the instantiation of a Class from the client program to the factory class. 
 * Factory Pattern is a creational design pattern that provides a way to create objects
 * without specifying the exact class of the object to be created. based on a given
 *  * input or configuration.
 * <p>
 * In Factory Pattern, we create objects without exposing the instantiation logic to the client.
 * The client only needs to know the type of object to be created.
 * <p>
 * Factory Pattern is useful when we want to create objects in a generic way,
 * without specifying the exact class of the object to be created.
 */

public class FactoryPattern {

}

// Product interface
interface Document {
    void open();

    void save();

    void close();
}

// Concrete product classes
class WordDocument implements creational.Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }
}

// Concrete product classes
class ExcelDocument implements creational.Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }


    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }
}

//concrete product classes
class PDFDocument implements creational.Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }

}


// Creator class or factory class
abstract class DocumentFactory {
    public abstract creational.Document createDocument();

    public void newDocument() {
        creational.Document document = createDocument();
        document.open();
        document.save();
        document.close();
    }


    public static DocumentFactory getFactory(String type) {
        return switch (type) {
            case "word" -> new WordDocumentFactory();
            case "excel" -> new ExcelDocumentFactory();
            case "pdf" -> new PDFDocumentFactory();
            default -> null;
        };
    }
}

// Concrete creator classes
class WordDocumentFactory extends DocumentFactory {
    @Override
    public creational.Document createDocument() {
        return new creational.WordDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public creational.Document createDocument() {
        return new creational.ExcelDocument();
    }
}

class PDFDocumentFactory extends DocumentFactory {
    @Override
    public creational.Document createDocument() {
        return new creational.PDFDocument();
    }
}

class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of document to create (word/excel/pdf):");
        String documentType = scanner.nextLine();
        documentType = documentType.trim().toLowerCase();

        DocumentFactory documentFactory = DocumentFactory.getFactory(documentType);


        if (documentFactory != null) {
            documentFactory.newDocument();
        } else {
            System.out.println("Invalid document type.");
        }
        scanner.close();
    }
}
