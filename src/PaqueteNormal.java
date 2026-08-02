public class PaqueteNormal implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return Peso * 10.0;
    }

    @Override
    public String TipoPaquete() {
        return "Normal";
    }
}
