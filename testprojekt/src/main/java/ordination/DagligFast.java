package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

    private final Dosis[] doser; // NOT NULLABLE AND NO NULL ELEMENTS

    public DagligFast(LocalDate startDato, LocalDate slutDato, Lægemiddel lægemiddel, double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        super(startDato, slutDato, lægemiddel);
        doser = new Dosis[4];
        doser[0] = new Dosis(LocalTime.of(8, 0), morgenAntal);
        doser[1] = new Dosis(LocalTime.of(14, 0), middagAntal);
        doser[2] = new Dosis(LocalTime.of(20, 0),  aftenAntal);
        doser[3] = new Dosis(LocalTime.of(2, 0), natAntal);
    }

    @Override
    public double samletDosis() {
        int antaldage = antalDage();
        double dosisPerDøgn = doegnDosis();
        return antaldage * dosisPerDøgn;
    }

    @Override
    public double doegnDosis() {

        double dagligdosering = 0;
        for (Dosis dosis : doser) {
            dagligdosering += dosis.getAntal();
        }

        return dagligdosering;
    }

    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
