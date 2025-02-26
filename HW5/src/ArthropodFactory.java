public class ArthropodFactory {

    public static Arthropod create(ArthropodType type){ // Arthropod 객체를 생성하는 정적 메소드. ArthropodType에 따라 적절한 Arthropod를 반환
        switch(type) { // ArthropodType에 따른 객체를 생성하여 반환하는 switch 문
            case ARACHNIDA :  
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Spiders") // your code
            .setBodyRegions(2)
            .setPairsOfAntennae(0)
            .setRespiration(RespirationType.BOOK_LUNGS)
            .setMetamorphosis(MetamorphosisType.NONE)
            .setPairsOfWing(0)
            .setNumberOfLegs(8)
            .setDistinction("")
            .build();

            case CHILOPODA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Centipedes") // your code
            .setBodyRegions(2)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.NONE)
            .setPairsOfWing(0)
            .setNumberOfLegs(30)
            .setDistinction("1 pairs per segment")
            .build();

            case DIPLOPODA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Milipedes") // your code
            .setBodyRegions(2)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.NONE)
            .setPairsOfWing(0)
            .setNumberOfLegs(100)
            .setDistinction("2 pair per segment")
            .build();
                     
            case CRUSTACEA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Crabs, Lobsters, etc.") // your code
            .setBodyRegions(2)
            .setPairsOfAntennae(2)
            .setRespiration(RespirationType.GILLS)
            .setMetamorphosis(MetamorphosisType.VARIABLE)
            .setPairsOfWing(0)
            .setNumberOfLegs(10)
            .setDistinction("")
            .build();

            case ODONATA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Dragonflies, Damselflies") // your code
            .setBodyRegions(3)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.INCOMPLETE)
            .setPairsOfWing(2)
            .setNumberOfLegs(6)
            .setDistinction("wings membranous")
            .build();
            
            case ORTHOPTERA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Grasshoppers, Crickets") // your code
            .setBodyRegions(3)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.INCOMPLETE)
            .setPairsOfWing(2)
            .setNumberOfLegs(6)
            .setDistinction("hind legs enlarged")
            .build();

            case  DIPTERA :
            return new Arthropod.ArthropodBuilder() 
            .setArthropodname("Flies") // your code
            .setBodyRegions(3)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.COMPLETE)
            .setPairsOfWing(1)
            .setNumberOfLegs(6)
            .setDistinction("")
            .build();

            case COLEOPTERA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Beetle") // your code
            .setBodyRegions(3)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.COMPLETE)
            .setPairsOfWing(2)
            .setNumberOfLegs(6)
            .setDistinction("hard exoskeleton and elytra(wing covers)")
            .build();

            case LEPIDOPTERA : 
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Butterflies, Moths") // your code
            .setBodyRegions(3)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.COMPLETE)
            .setPairsOfWing(2)
            .setNumberOfLegs(6)
            .setDistinction("wings scaly")
            .build();

            case HYMENOPTERA :
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("Bees, Wasps, Ants") // your code
            .setBodyRegions(3)
            .setPairsOfAntennae(1)
            .setRespiration(RespirationType.TRACHEAL)
            .setMetamorphosis(MetamorphosisType.COMPLETE)
            .setPairsOfWing(2)
            .setNumberOfLegs(6)
            .setDistinction("wings membranous")
            .build();
            
            default :  // UNKNOWN 타입에 대한 기본 처리
            return new Arthropod.ArthropodBuilder()
            .setArthropodname("UNKNOWN") // your code
            .setBodyRegions(0)
            .setPairsOfAntennae(0)
            .setRespiration(RespirationType.UNKNOWN)
            .setMetamorphosis(MetamorphosisType.UNKNOWN)
            .setPairsOfWing(0)
            .setNumberOfLegs(0)
            .setDistinction("UNKNOWN")
            .build();
        }
    }
}
