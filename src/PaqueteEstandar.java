public class PaqueteEstandar implements TipoPaquete{
    @Override
    public double CalcularCosto(double Peso) {
        return Peso * 12.0;
    }

    @Override
    public String TipoPaquete() {
        return "Estandar";
    }
}
