package Partie2.framework.xml;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyConfig {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String ref;

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
}