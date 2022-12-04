public class Man {
    private String Name;
    protected  String SurName;
    int age;
    public boolean Adm;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdm() {
        return Adm;
    }

    public void setAdm(boolean adm) {
        Adm = adm;
    }
}
