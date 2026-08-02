public class PaqueteInternacional implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return (Peso * 25)+50.0;
    }

    @Override
    public String TipoPaquete() {
        return "Internacional";
    }
}
