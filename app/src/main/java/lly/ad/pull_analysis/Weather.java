package lly.ad.pull_analysis;

/**
 * Created by addy on 2016/11/5.
 */

public class Weather {
    String name;
    String temp;
    String pm;

    public Weather() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", temp='" + temp + '\'' +
                ", pm='" + pm + '\'' +
                '}';
    }
}
