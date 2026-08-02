public class PaqueteFragil implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return (Peso * 15.0)+20.0;
    }

    @Override
    public String TipoPaquete() {
        return "Fragil";
    }
}
