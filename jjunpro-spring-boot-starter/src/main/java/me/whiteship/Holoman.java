package me.whiteship;

public class Holoman {
    private String  name;
    private Integer howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHowLong() {
        return howLong;
    }

    public void setHowLong(Integer howLong) {
        this.howLong = howLong;
    }

    @Override
    public String toString() {
        return "Holoman{" + "name='" + name + '\'' + ", howLong=" + howLong + '}';
    }
}
