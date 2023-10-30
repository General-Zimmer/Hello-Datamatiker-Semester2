package controller;

import ordination.Lægemiddel;
import ordination.PN;
import ordination.Patient;
import storage.Storage;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void opretPNOrdination() {
        LocalDate startDate = LocalDate.of(2019, 1, 1);
        LocalDate endDate = LocalDate.of(2019, 12, 1);
        Patient patient = new Patient( "121256-0512","Jane Jensen", 63.4);
        Lægemiddel paracetamol = new Lægemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        PN pn = Controller.opretPNOrdination(startDate, endDate, patient, paracetamol, 123);;

        // TC1: FørsteDato
        patient.addOrdination(pn);
        assertTrue(patient.getOrdinationer().contains(pn));

        // TC2: AndenDato
        endDate = LocalDate.of(2019, 11, 2);
        pn = Controller.opretPNOrdination(startDate, endDate, patient, paracetamol, 123);;
        patient.addOrdination(Controller.opretPNOrdination(startDate, endDate, patient, paracetamol, 123));
        patient.addOrdination(pn);
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDøgn() {
        Patient basisPatient = new Patient("696969", "John Dillermand", 86);
        Patient lightPatient = new Patient("420420", "Bingo Dorte", 0.0999);
        Patient heavyPatient = new Patient("8675309", "Jenny Jenny", 9001);
        Lægemiddel lægemiddel = new Lægemiddel("Zyklon B", 0.1, 0.15, 0.16, "mg");

        // TC1: Basis
        assertEquals(12.9, Controller.anbefaletDosisPrDøgn(basisPatient, lægemiddel));

        // TC2: Let
        assertEquals(0.00999, Controller.anbefaletDosisPrDøgn(lightPatient, lægemiddel), 0.01);

        // TC3: Tung
        assertEquals(1440.16, Controller.anbefaletDosisPrDøgn(heavyPatient, lægemiddel), 0.01);
    }

    @org.junit.jupiter.api.Test
    void antalOrdinationerPrVægtPrLægemiddel() {
        Controller.setStorage(new Storage());
        Lægemiddel lægemiddel = new Lægemiddel("Cyanid", 4, 5, 9, "enhed");
        Patient a = Controller.opretPatient("4 8 15 16 23 42", "Hurley", 250);
        Patient b = Controller.opretPatient("007", "Bond, James Bond", 95);
        Patient c = Controller.opretPatient("24601", "Jean Valjean", 67);
        Patient d = Controller.opretPatient("404", "John Doe", 92);
        Patient e = Controller.opretPatient("221B", "Sherlock Holmes", 102);
        Patient f = Controller.opretPatient("42", "Douglas Adams", 83);
        Patient g = Controller.opretPatient("9001", "Vegeta", 51);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), a, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), b, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), c, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), d, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), e, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), f, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), f, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), f, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), g, lægemiddel, 5);
        Controller.opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"), g, lægemiddel, 5);

        // TC1: Patient B,D
        int actualResultA = Controller.antalOrdinationerPrVægtPrLægemiddel(90, 100, lægemiddel);
        assertEquals(2, actualResultA);

        // TC2: Patient C,F,G
        actualResultA = Controller.antalOrdinationerPrVægtPrLægemiddel(50, 84, lægemiddel);
        assertEquals(6, actualResultA);

        // TC3: Alle Patienter
        actualResultA = Controller.antalOrdinationerPrVægtPrLægemiddel(0, 300, lægemiddel);
        assertEquals(10, actualResultA);

        // TC4: Ingen Patienter
        actualResultA = Controller.antalOrdinationerPrVægtPrLægemiddel(300, 350, lægemiddel);
        assertEquals(0, actualResultA);

        // TC5: Patient D
        actualResultA = Controller.antalOrdinationerPrVægtPrLægemiddel(92, 92, lægemiddel);
        assertEquals(1, actualResultA);
    }

    @org.junit.jupiter.api.Test
    void anvendOrdinationPN() {
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 20);
        LocalDate usageDate = LocalDate.of(2023, 12, 5);
        LocalDate illegalUsageDate = LocalDate.of(2001, 11, 9);
        Lægemiddel lægemiddel = new Lægemiddel("Ivermectin", 2, 5, 10, "enhed");
        PN pnOrdination = new PN(startDate, endDate, lægemiddel, 3);

        Controller.anvendOrdinationPN(pnOrdination, usageDate);

        //test if usage has been registered
        assertTrue(pnOrdination.getDoser().contains(usageDate));

        //test illegal arguement exception
        Exception invalidDate = assertThrows(IllegalArgumentException.class, () -> {
            Controller.anvendOrdinationPN(pnOrdination, illegalUsageDate);
        });
    }

}