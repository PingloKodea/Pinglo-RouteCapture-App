package za.co.kodea.pinglo.client.model.impl;

/**
 * Created by Ghost Desktop on 2016/04/18.
 */
public class TaxiRank {

    private String name;
    private String value;

    public TaxiRank(){}

    public TaxiRank(String name, String value) {
        this.name = name;
        this.value = value;
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
