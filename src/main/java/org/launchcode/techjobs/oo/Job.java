package org.launchcode.techjobs.oo;

import java.util.Objects;
import static java.lang.System.lineSeparator;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String output = "";

        if (employer.getValue().isEmpty() & location.getValue().isEmpty() && coreCompetency.getValue().isEmpty() && positionType.getValue().isEmpty()) {
            output = "OOPS! This job does not seem to exist.";
        } else {
        if (name.isEmpty()){
            name = "Data not available";
        }
        if (employer.getValue().isEmpty()){
            employer.setValue("Data not available");
        }
        if (location.getValue().isEmpty()){
            location.setValue("Data not available");
        }
        if (coreCompetency.getValue().isEmpty()){
            coreCompetency.setValue("Data not available");
        }
        if (positionType.getValue().isEmpty()){
            positionType.setValue("Data not available");
        }
            output = String.format(
                    "\nID: %d" +
                            "\nName: %s" +
                            "\nEmployer: %s" +
                            "\nLocation: %s" +
                            "\nPosition Type: %s" +
                            "\nCore Competency: %s\n", id, name, employer, location, positionType, coreCompetency);
        }
        return output;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
