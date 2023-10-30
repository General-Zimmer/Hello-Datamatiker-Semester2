package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DagligFastTest {
    @Test
    void doegnDosis() {
        Lægemiddel lægemiddel = new Lægemiddel("Morfin", 3, 6, 12, "enhed");
        DagligFast dfAlleNull = new DagligFast(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"),
                                        lægemiddel, 0, 0, 0, 0);

        DagligFast dfAlleAktive = new DagligFast(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"),
                                        lægemiddel, 1, 1, 1, 1);
        DagligFast dfBasis = new DagligFast(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"),
                                        lægemiddel, 1, 2, 1, 3);

        assertEquals(0, dfAlleNull.doegnDosis(), 0.01);
        assertEquals(4, dfAlleAktive.doegnDosis(), 0.01);
        assertEquals(7, dfBasis.doegnDosis(), 0.01);
    }

    @Test
    void samletDosis() {
        Lægemiddel lægemiddel = new Lægemiddel("Morfin", 3, 6, 12, "enhed");
        DagligFast dfAlleNull = new DagligFast(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"),
                                        lægemiddel, 0, 0, 0, 0);

        DagligFast dfAlleAktive = new DagligFast(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"),
                                        lægemiddel, 1, 1, 1, 1);
        DagligFast dfBasis = new DagligFast(LocalDate.parse("2023-11-22"), LocalDate.parse("2023-11-26"),
                                        lægemiddel, 1, 2, 1, 3);

        assertEquals(0, dfAlleNull.samletDosis(), 0.01);
        assertEquals(20, dfAlleAktive.samletDosis(), 0.01);
        assertEquals(35, dfBasis.samletDosis(), 0.01);
    }

    @Test
    void getDoser() {
    }

    @Test
    void getType() {
    }
}
