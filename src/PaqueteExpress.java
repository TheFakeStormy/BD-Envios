public class PaqueteExpress implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return (Peso * 20)+30;
    }

    @Override
    public String TipoPaquete() {
        return "Express";
    }
}
