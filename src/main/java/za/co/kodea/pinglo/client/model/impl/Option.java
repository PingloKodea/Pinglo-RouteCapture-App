package za.co.kodea.pinglo.client.model.impl;

import java.io.Serializable;

/**
 * Created by Ghost Desktop on 2016/04/11.
 */
public class Option implements Serializable {

    private String name;

    public Option() {
    }

    public Option(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
