package framework.xml;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class Beans {

    @XmlElement(name = "bean")
    private List<BeanConfig> beans;

    public List<BeanConfig> getBeans() {
        return beans;
    }

    public void setBeans(List<BeanConfig> beans) {
        this.beans = beans;
    }
}