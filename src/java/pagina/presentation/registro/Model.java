package pagina.presentation.registro;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import pagina.logica.Estudiante;

/**
 * Proyecto 1 Estudiantes: Crystian Chininin Barrantes 115920081 Eva Durán
 * Escobar 117130031 Miguel Montero Arce 402440709
 *
 */
public class Model {

    Estudiante current;
    String clave;
    Random random;

    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Estudiante());
        random = new Random();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String generaClave() {
        return String.format("%04d", random.nextInt(10000));
    }

    public Estudiante getCurrent() {
        return current;
    }

    public void setCurrent(Estudiante current) {
        this.current = current;
    }

}
