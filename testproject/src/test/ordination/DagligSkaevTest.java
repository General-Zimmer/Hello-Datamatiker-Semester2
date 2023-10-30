package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {

    @Test
    void samletDosis() {
        Lægemiddel lægemiddel = new Lægemiddel("Paracetamol", 3, 6, 12, "enhed");
        DagligSkaev dsBasis = new DagligSkaev(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"), lægemiddel);
        DagligSkaev dsPlus = new DagligSkaev(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"), lægemiddel);
        DagligSkaev dsTid = new DagligSkaev(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"), lægemiddel);

        dsBasis.getDoser().add(new Dosis(LocalTime.parse("12:12"), 1));

        dsPlus.getDoser().add(new Dosis(LocalTime.parse("12:12"), 6));

        dsTid.getDoser().add(new Dosis(LocalTime.parse("12:12"), 6));
        dsTid.getDoser().add(new Dosis(LocalTime.parse("14:52"), 2));
        dsTid.getDoser().add(new Dosis(LocalTime.parse("23:45"), 4));

        assertEquals(5, dsBasis.samletDosis());
        assertEquals(30, dsPlus.samletDosis());
        assertEquals(60, dsTid.samletDosis());
    }

    @Test
    void doegnDosis() {
        Lægemiddel lægemiddel = new Lægemiddel("Paracetamol", 3, 6, 12, "enhed");
        DagligSkaev dsBasis = new DagligSkaev(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"), lægemiddel);
        DagligSkaev dsPlus = new DagligSkaev(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"), lægemiddel);
        DagligSkaev dsTid = new DagligSkaev(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"), lægemiddel);

        dsBasis.getDoser().add(new Dosis(LocalTime.parse("12:12"), 1));

        dsPlus.getDoser().add(new Dosis(LocalTime.parse("12:12"), 6));

        dsTid.getDoser().add(new Dosis(LocalTime.parse("12:12"), 6));
        dsTid.getDoser().add(new Dosis(LocalTime.parse("14:52"), 2));
        dsTid.getDoser().add(new Dosis(LocalTime.parse("23:45"), 4));

        assertEquals(1, dsBasis.doegnDosis(), 0.01);
        assertEquals(6, dsPlus.doegnDosis(), 0.01);
        assertEquals(12, dsTid.doegnDosis(), 0.01);
    }

    @Test
    void getType() {
    }

    @Test
    void getDoser() {
    }
}