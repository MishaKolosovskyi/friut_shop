package model;

public enum Type {
    s("s"),
    b("b"),
    r("r");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
