public enum ArthropodType {
    ARACHNIDA("Arachnida"),
    CHILOPODA("Chilopoda"),
    DIPLOPODA("Diplopoda"),
    CRUSTACEA("Crustacea"),
    ORTHOPTERA("Orthoptera"),
    ODONATA("Odonata"),
    DIPTERA("Diptera"),
    COLEOPTERA("Coleoptera"),
    LEPIDOPTERA("Lepidoptera"),
    HYMENOPTERA("Hymenoptera"),
    UNKNOWN("Unknown");

    private String name;

    ArthropodType(String name){
        this.name = name;
    }


    public String toString(){
        return name;
    }

}
