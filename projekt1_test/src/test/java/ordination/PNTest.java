package ordination;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PNTest {

    PN pn = null;
    @BeforeEach
    void testSetup() {
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 28), null, 3);
        pn.anvendDosis(LocalDate.of(2022, 1, 23));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 28));
    }


    @org.junit.jupiter.api.Test
    void samletDosis() {
        // Test from first medicne registration date to end
        assertEquals(9, pn.samletDosis());

        // Test from not first registration date to end
        pn = new PN(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 10), null, 5);
        pn.anvendDosis(LocalDate.of(2021, 1, 5));
        pn.anvendDosis(LocalDate.of(2021, 1, 5));
        pn.anvendDosis(LocalDate.of(2021, 1, 6));
        assertEquals(15, pn.samletDosis());
    }

    @org.junit.jupiter.api.Test
    void doegnDosis() {

        // TC1:Basis
        assertEquals(1.8, pn.doegnDosis());
        // TC2:EnDagFleredosis
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 28), null, 3);
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        assertEquals(9, pn.doegnDosis());
        // TC3:EnDosis
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 28), null, 3);
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        assertEquals(3, pn.doegnDosis());
        // TC4:ForskudtStartAnvendelse
        pn = new PN(LocalDate.of(2022, 1, 21), LocalDate.of(2022, 1, 28), null, 3);
        pn.anvendDosis(LocalDate.of(2022, 1, 23));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 28));
        assertEquals(1.8, pn.doegnDosis());
        // TC5:ForskudtSlutAnvendelse
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 30), null, 3);
        pn.anvendDosis(LocalDate.of(2022, 1, 23));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 28));
        assertEquals(1.8, pn.doegnDosis());
        // TC6:ForskudtAnvendelser
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 28), null, 3);
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 23));
        pn.anvendDosis(LocalDate.of(2022, 1, 28));
        assertEquals(1.8, pn.doegnDosis());
        // TC7:MangeEnheder
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 28), null, 20);
        pn.anvendDosis(LocalDate.of(2022, 1, 23));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 28));
        assertEquals(12, pn.doegnDosis());
        // TC8:enEnhed
        pn = new PN(LocalDate.of(2022, 1, 23), LocalDate.of(2022, 1, 28), null, 1);
        pn.anvendDosis(LocalDate.of(2022, 1, 23));
        pn.anvendDosis(LocalDate.of(2022, 1, 25));
        pn.anvendDosis(LocalDate.of(2022, 1, 28));
        assertEquals(0.6, pn.doegnDosis());


    }

}