package ordination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DagligSkaev extends Ordination {

    List<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDato, LocalDate slutDato, Lægemiddel lægemiddel) {
        super(startDato, slutDato, lægemiddel);
    }

    @Override
    public double samletDosis() {
            return doegnDosis() * antalDage();
    }

    @Override
    public double doegnDosis() {
        double doegnDosis = 0;
        for (Dosis d : doser) {
            doegnDosis += d.getAntal();
        }
        return doegnDosis;
    }

    @Override
    public String getType() {
        return "DagligSkaev";
    }

    public List<Dosis> getDoser() {
        return doser;
    }
}
