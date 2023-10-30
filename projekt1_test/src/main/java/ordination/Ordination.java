package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
    private final LocalDate startDato;
    private final LocalDate slutDato;
    private Lægemiddel lægemiddel;

    public Ordination(LocalDate startDato, LocalDate slutDato, Lægemiddel lægemiddel) {
        this(startDato, slutDato);
        this.lægemiddel = lægemiddel;
    }

    public Ordination(LocalDate startDato, LocalDate slutDato) {
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    /**
     * Returner antal hele dage mellem startdato og slutdato
     * (begge dage inklusive).
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDato, slutDato) + 1;
    }

    @Override
    public String toString() {
        return startDato.toString();
    }

    public Lægemiddel getLaegemiddel() {
        return lægemiddel;
    }

    public void setLaegemiddel(Lægemiddel lægemiddel) {
        this.lægemiddel = lægemiddel;
    }

    /** Returner den totale dosis, der er givet i den periode, ordinationen er gyldig. */
    public abstract double samletDosis();

    /** Returner den gennemsnitlige dosis givet per dag. */
    public abstract double doegnDosis();

    /** Returner ordinationstypen som en String. */
    public abstract String getType();
}
