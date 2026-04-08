package framework.xml;

/**
 * @author user
 **/
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConstructorArgConfig {

    @XmlAttribute
    private String ref;

    // getters & setters

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
