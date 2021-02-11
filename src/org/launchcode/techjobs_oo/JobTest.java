package org.launchcode.techjobs_oo;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {
    @Before
    public void createJobObjects(){
        Job jobObject1 = new Job();
        Job jobObject2 = new Job();
    }


    @Test
    public void testSettingJobId(){
        Job jobObject1 = new Job();
        Job jobObject2 = new Job();
        assertFalse(jobObject1.equals(jobObject2));
        assertTrue((jobObject2.getId()-1) == jobObject1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobObject instanceof Job);
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }


}