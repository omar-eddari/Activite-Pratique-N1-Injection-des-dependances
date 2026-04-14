package Partie2.framework.core;

public class Property {
    private String name;
    private String ref; // reference to another bean

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}