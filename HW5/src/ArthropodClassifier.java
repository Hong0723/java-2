public class ArthropodClassifier {
    private ArthropodType arthropodType;
    private Arthropod arthropod;

    public ArthropodClassifier(ArthropodType arthropodType, Arthropod arthropod) {
        this.arthropodType = arthropodType;
        this.arthropod = arthropod;
    }

    // 첫 번째 matches 메서드: Arthropod 객체를 매개변수로 받음
    public boolean matches(Arthropod arthropod) {
        return this.arthropod.equals(arthropod);
    }

    // 두 번째 matches 메서드: 다양한 타입의 매개변수를 받음
    public boolean matches(String arthropodname, int bodyRegions, int pairsOfAntennae, RespirationType respiration, 
                           MetamorphosisType metamorphosis, int pairsOfWing, int numberOfLegs, String distinction) {
        return  this.arthropod.getArthropodname() == arthropodname && // your code
                this.arthropod.getBodyRegions() == bodyRegions &&
                this.arthropod.getPairsOfAntennae() == pairsOfAntennae &&
                this.arthropod.getRespiration() == respiration &&
                this.arthropod.getMetamorphosis() == metamorphosis &&
                this.arthropod.getPairsOfWing() == pairsOfWing &&
                this.arthropod.getNumberOfLegs() == numberOfLegs &&
                this.arthropod.getDistinction().equals(distinction);
    }

    public ArthropodType getArthropodType() {
        return arthropodType;
    }

    public Arthropod getArthropod() {
        return arthropod;
    }

    @Override
    public String toString() {
        return arthropodType.name();
    }
}
