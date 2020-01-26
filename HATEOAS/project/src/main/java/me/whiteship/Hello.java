package me.whiteship;

public class Hello {
    private String Prefix;
    private String name;

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" + "Prefix='" + Prefix + '\'' + ", name='" + name + '\'' + '}';
    }
}
