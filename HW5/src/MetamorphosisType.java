public enum MetamorphosisType {
    COMPLETE("Complete"),
    INCOMPLETE("Incomplete"),
    NONE("None"),
    VARIABLE("Variable"),
    UNKNOWN("Unknown");

    private String name;

    MetamorphosisType(String name){
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
