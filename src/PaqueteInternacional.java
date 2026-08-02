public class PaqueteInternacional implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return 0;
    }

    @Override
    public String TipoPaquete() {
        return "Internacional";
    }
}
