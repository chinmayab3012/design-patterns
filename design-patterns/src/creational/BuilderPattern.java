package creational;

import java.io.Serializable;
import java.util.List;

/**
 * Builder Pattern is a creational design pattern that allows you to
 * create complex objects step by step.
 * <p>
 * In Builder Pattern, we create an object using a builder class.
 * The builder class provides methods to set different parts of the object.
 * <p>
 * Builder Pattern is useful when we want to create objects in a generic way,
 * without specifying the exact class of the object to be created.
 *
 *
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Product laptop = Product.newBuilder()
                .setName("Laptop")
                .setPrice(1000.0)
                .setFeatures(List.of("8GB RAM", "256GB SSD", "Intel Core i7"))
                .build();

        Product mobile = Product.newBuilder()
                .setName("Mobile")
                .setPrice(500.0)
                .setFeatures(List.of("8GB RAM", "128GB SSD", "Snapdragon 8"))
                .setDescription("Samsung m36 ")
                .build();

        System.out.println("Product Name: " + laptop.getName());
        System.out.println("Product Price: " + laptop.getPrice());
        System.out.println("Product Features: " + laptop.getFeatures());

        System.out.println("Product Name: " + mobile.getName());
        System.out.println("Product Price: " + mobile.getPrice());
        System.out.println("Product Features: " + mobile.getFeatures());
        System.out.println("Product Description: " + mobile.getDescription());
    }
}

class Product implements Serializable {
    private String name;
    private double price;
    private List<String> features;
    private String description;

    //private constructor for builder
    private Product(String name, double price, List<String> features,String description) {
        this.name = name;
        this.price = price;
        this.features = features;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getFeatures() {
        return features;
    }

    public String getDescription() {
        return description;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    //builder class
    public static class Builder {
        private String name;
        private double price;
        private List<String> features;
        private String description;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setFeatures(List<String> features) {
            this.features = features;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(name, price, features,description);
        }
    }
}
