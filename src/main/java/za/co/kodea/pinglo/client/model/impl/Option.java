package za.co.kodea.pinglo.client.model.impl;

import java.io.Serializable;

/**
 * Created by Ghost Desktop on 2016/04/11.
 */
public class Option implements Serializable {

    private String name;
    private String value;

    public Option() {
    }

    public Option(String name, String value) {
        this.name = name;
        value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
