package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

import static java.lang.System.lineSeparator;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String firstChar = String.valueOf(job.toString().charAt(0));
        String lastChar = String.valueOf(job.toString().charAt(job.toString().length()-1));
        assertEquals(lineSeparator(), firstChar);
        assertEquals(lineSeparator(), lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = String.format(lineSeparator() +
                "ID: %d" + lineSeparator() +
                "Name: %s" + lineSeparator() +
                "Employer: %s" + lineSeparator() +
                "Location: %s" + lineSeparator() +
                "Position Type: %s" + lineSeparator() +
                "Core Competency: %s" + lineSeparator(), job.getId(), job.getName(), job.getEmployer().getValue(), job.getLocation().getValue(), job.getPositionType().getValue(), job.getCoreCompetency().getValue());
        assertEquals(expected, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = String.format(lineSeparator() +
                "ID: %d" + lineSeparator() +
                        "Name: Data not available" + lineSeparator() +
                        "Employer: %s" + lineSeparator() +
                        "Location: %s" + lineSeparator() +
                        "Position Type: %s" + lineSeparator() +
                        "Core Competency: %s" + lineSeparator(), job.getId(), job.getEmployer().getValue(), job.getLocation().getValue(), job.getPositionType().getValue(), job.getCoreCompetency().getValue());
        assertEquals(expected, job.toString());
    }

    @Test
    public void testToStringHandlesAllEmptyFields() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", job.toString());
    }
}
