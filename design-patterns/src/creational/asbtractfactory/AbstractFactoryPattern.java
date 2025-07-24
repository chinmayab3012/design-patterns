package creational.asbtractfactory;

import java.util.Scanner;

/**
 * Abstract Factory Pattern is a creational design pattern that provides
 * an interface/abstract class for creating
 * families of related or dependent objects without specifying their concrete classes.
 * <p>
 * It's a "factory of factories". Each concrete factory creates a suite of products.
 * <p>
 * This pattern is useful when:
 * 1. A system needs to be independent of how its products are created,
 * composed, and represented.
 * 2. A system needs to be configured with one of multiple families of products.
 * 3. A family of related product objects is designed to be used together,
 * and you need to enforce this constraint.
 */


// Product interface (Document remains the same)
interface Document {
    void open();

    void save();

    void close();
}

// Concrete product classes (WordDocument, ExcelDocument, PDFDocument remain the same)
class WordDocument implements Document {
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

class ExcelDocument implements Document {
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

class PDFDocument implements Document {
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

// Abstract Factory: Defines methods for creating abstract products
interface DocumentAbstractFactory {
     Document createWordDocument();

     Document createExcelDocument();

     Document createPDFDocument();
}

// Concrete Factory 1: Creates a family of Microsoft Office related documents
class MicrosoftOfficeFactory implements DocumentAbstractFactory {
    @Override
    public Document createWordDocument() {
        return new WordDocument();
    }

    @Override
    public Document createExcelDocument() {
        return new ExcelDocument();
    }

    @Override
    public Document createPDFDocument() {
        // Microsoft Office factory might not create PDFs natively,
        // but for demonstration, we can include it or return null/throw exception
        System.out.println("Microsoft Office Factory does not natively create PDF. ");
         throw new UnsupportedOperationException("Microsoft Office Factory does not natively create PDF.");
    }
}

// Concrete Factory 2: Creates a family of generic/open-source related documents (example)
class OpenSourceDocumentFactory implements DocumentAbstractFactory {
    @Override
    public Document createWordDocument() {
        System.out.println("Creating Open Source Word-like document...");
        return new WordDocument(); // Could be a different concrete product if available
    }

    @Override
    public Document createExcelDocument() {
        System.out.println("Creating Open Source Excel-like document...");
        return new ExcelDocument(); // Could be a different concrete product if available
    }

    @Override
    public Document createPDFDocument() {
        return new PDFDocument();
    }
}

// Factory for getting the Abstract Factory
class DocumentFactoryProducer {
    public static DocumentAbstractFactory getFactory(String type) {
        return switch (type.toLowerCase()) {
            case "microsoft" -> new MicrosoftOfficeFactory();
            case "opensource" -> new OpenSourceDocumentFactory();
            default -> throw new IllegalArgumentException("Invalid factory type: " + type);
        };
    }
}

class DocumentTypeFactory {
    private final DocumentAbstractFactory factory;
    private final Scanner scanner; // Inject scanner for consistency

    public DocumentTypeFactory(DocumentAbstractFactory factory, Scanner scanner) {
        this.factory = factory;
        this.scanner = scanner;
    }


    public void processDocumentCreation() {
        System.out.println("Enter the specific document type to create (word/excel/pdf):");
        String documentType = scanner.nextLine().trim().toLowerCase();

        System.out.println("\n--- Creating a " + documentType + " document ---");

        // Use the injected abstractFactory to create the specific document
        Document document = switch (documentType) {
            case "word" -> factory.createWordDocument();
            case "excel" -> factory.createExcelDocument();
            case "pdf" -> factory.createPDFDocument();
            default -> throw new IllegalArgumentException("Invalid document type: " + documentType);
        };

        if (document != null) {
            document.open();
            document.save();
            document.close();
        } else {
            System.out.println("Document creation failed for type: " + documentType);
        }
    }

}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of document suite to create (microsoft/opensource):");
        String factoryType = scanner.nextLine();
        factoryType = factoryType.trim().toLowerCase();

        DocumentAbstractFactory abstractFactory = DocumentFactoryProducer.getFactory(factoryType);


        if (abstractFactory == null) {
            System.out.println("Invalid document suite type. Please enter 'microsoft' or 'opensource'.");
            scanner.close();
            return; // Exit if the factory type is invalid
        }

        // 2. Get the specific document type (e.g., word, excel, pdf)
        DocumentTypeFactory documentTypeFactory = new DocumentTypeFactory(abstractFactory, scanner);
        documentTypeFactory.processDocumentCreation();

        scanner.close();
    }
}