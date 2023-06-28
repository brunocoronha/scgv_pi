package modelos;

public class EnumTipoModelo {
    
    public EnumTipoModelo(){
    
    }

    public enum TipoModeloVeiculo {
        SEDAN,
        SUV,
        HATCHBACK,
        COUPE,
        CONVERSÍVEL,
        MINIVAN,
        PICAPE,
        CAMINHONETE,
        CROSSOVER,
        WAGON,
        ESPORTIVO,
        ELÉTRICO,
        HÍBRIDO,
        MICROCARRO,
        LIMUSINE,
        MONOVOLUME,
        OFF_ROAD,
        ROADSTER,
        FAMILIAR,
        COMPACTO,
        SUBCOMPACTO,
        MUSCLE_CAR,
        CARRO_DE_LUXO,
        CARRO_CONCEITO,
        CARRO_DE_CORRIDA,
        CARRO_CLÁSSICO,
        CARRO_DE_PATRULHA,
        CARRO_DE_POLÍCIA,
        CARRO_DE_BOMBEIRO,
        CARRO_FUNERÁRIO;

        public static TipoModeloVeiculo[] getValores() {
            return TipoModeloVeiculo.values();
        }
    }

}
