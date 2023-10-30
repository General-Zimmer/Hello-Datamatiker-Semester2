package ordination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination {
    private final double antalEnheder;
    List<LocalDate> doser = new ArrayList<>();

    public PN(LocalDate startDato, LocalDate slutDato, Lægemiddel lægemiddel, double antalEnheder) {
        super(startDato, slutDato, lægemiddel);
        this.antalEnheder = antalEnheder;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    /**
     * Registrer datoen for en anvendt dosis.
     */
    public void anvendDosis(LocalDate dato) {
        if (dato.isBefore(getStartDato()) || dato.isAfter(getSlutDato())) {
            throw new IllegalArgumentException("Datoen er ikke indenfor ordinationens gyldighedsperiode");
        }
        doser.add(dato);
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int antalGangeAnvendt() {
        return doser.size();
    }

    @Override
    public double samletDosis() {
        return antalGangeAnvendt() * antalEnheder;
    }

    @Override
    public double doegnDosis() {

        if (doser.isEmpty()) return 0;

        LocalDate startDato = doser.get(0);
        LocalDate slutDato = doser.get(doser.size()-1);

        for (LocalDate time : doser) {
            if (time.isBefore(startDato)) startDato = time;
            if (time.isAfter(slutDato)) slutDato = time;
        }


        double AntalDageOrdinationBrugt = startDato.until(slutDato).getDays();
        return (antalGangeAnvendt() * antalEnheder) / (AntalDageOrdinationBrugt == 0 ? 1 : AntalDageOrdinationBrugt);
    }

    @Override
    public String getType() {
        return "PN";
    }

    public List<LocalDate> getDoser() {
        return doser;
    }
}
