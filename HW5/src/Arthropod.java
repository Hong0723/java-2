public class Arthropod {
    private String arthropodname;  // 곤충의 이름을 저장하는 필드 (Your Code)
    private int bodyRegions;      
    private int pairsOfAntennae;  
    private RespirationType respiration; 
    private MetamorphosisType metamorphosis; 
    private int pairsOfWing;       
    private int numberOfLegs;      
    private String distinction;   

    // ArthropodBuilder를 사용하여 Arthropod 객체를 생성하는 생성자
    public Arthropod(ArthropodBuilder builder){
        this.bodyRegions = builder.bodyRegions;
        this.pairsOfAntennae = builder.pairsOfAntennae;
        this.respiration = builder.respiration;
        this.metamorphosis = builder.metamorphosis;
        this.pairsOfWing = builder.pairsOfWing;
        this.numberOfLegs = builder.numberOfLegs;
        this.distinction = builder.disti
        nction;
        this.arthropodname = builder.arthropodname; // 곤충의 이름을 builder에서 가져옴 (Your Code)
    }

    // Getter 메소드들: 각각의 필드에 대한 값을 반환
    public int getBodyRegions(){
        return bodyRegions;
    }

    public int getPairsOfAntennae(){
        return pairsOfAntennae;
    }

    public RespirationType getRespiration(){
        return respiration;
    }

    public MetamorphosisType getMetamorphosis() {
        return metamorphosis;
    }

    public int getPairsOfWing(){
        return pairsOfWing;
    }

    public int getNumberOfLegs(){
        return numberOfLegs;
    }

    public String getDistinction(){
        return distinction;
    }

    public String getArthropodname(){  // 곤충의 이름을 반환하는 메소드 (Your Code)
        return arthropodname;
    }

    // Arthropod 객체의 필드들을 String 형태로 반환
    @Override
    public String toString() {
        return "{" +
            " Arthropod name='" + getArthropodname() + "'" +  // 곤충의 이름 출력 (Your Code)
            ", bodyRegions='" + getBodyRegions() + "'" +     
            ", pairsOfAntennae='" + getPairsOfAntennae() + "'" +  
            ", respiration='" + getRespiration() + "'" +         
            ", metamorphosis='" + getMetamorphosis() + "'" +    
            ", pairsOfWing='" + getPairsOfWing() + "'" +         
            ", numberOfLegs='" + getNumberOfLegs() + "'" +       
            ", distinction='" + getDistinction() + "'" +        
            "}";
    }

    // Builder 패턴을 사용하여 Arthropod 객체를 단계별로 생성할 수 있도록 하는 정적 내부 클래스
    public static class ArthropodBuilder {

        // 빌더 패턴에서 사용되는 필드들
        private int bodyRegions;
        private int pairsOfAntennae;
        private RespirationType respiration;
        private MetamorphosisType metamorphosis;
        private int pairsOfWing;
        private int numberOfLegs;
        private String distinction;
        private String arthropodname;  // 곤충 이름 (Your Code)

        // 곤충 이름을 설정하는 메소드
        public ArthropodBuilder setArthropodname(String arthropodname){ 
            this.arthropodname = arthropodname;
            return this; 
        }

        // 각 필드에 대한 설정 메소드들 
        public ArthropodBuilder setBodyRegions(int bodyRegions) {
            this.bodyRegions = bodyRegions;
            return this;  
        }

        public ArthropodBuilder setPairsOfAntennae(int pairsOfAntennae){
            this.pairsOfAntennae = pairsOfAntennae;
            return this;  
        }

        public ArthropodBuilder setRespiration(RespirationType respiration){
            this.respiration = respiration;
            return this;  
        }

        public ArthropodBuilder setMetamorphosis(MetamorphosisType metamorphosis){
            this.metamorphosis = metamorphosis;
            return this;  
        }

        public ArthropodBuilder setPairsOfWing(int pairsOfWing){
            this.pairsOfWing = pairsOfWing;
            return this; 
        }

        public ArthropodBuilder setNumberOfLegs(int numberOfLegs){
            this.numberOfLegs = numberOfLegs;
            return this;  
        }

        public ArthropodBuilder setDistinction(String distinction){
            this.distinction = distinction;
            return this;  
        }

        // Builder 패턴에서 실제로 Arthropod 객체를 생성하는 메소드
        public Arthropod build() {
            return new Arthropod(this);  // 빌더 객체를 사용하여 Arthropod 객체 생성
        }
    }
}
