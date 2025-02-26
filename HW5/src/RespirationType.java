public enum RespirationType {
    TRACHEAL("Tracheal"),
    BOOK_LUNGS("Book Lungs"),
    GILLS("Gills"),
    UNKNOWN("Unknown");

    private String name;

    RespirationType(String name){
        this.name = name;
    }

    @Override
    public String toString() {
    return name;
        }
}
