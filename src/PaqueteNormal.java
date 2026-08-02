public class PaqueteNormal implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return 0;
    }

    @Override
    public String TipoPaquete() {
        return "Normal";
    }
}
