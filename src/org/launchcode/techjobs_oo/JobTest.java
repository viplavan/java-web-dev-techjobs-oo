package org.launchcode.techjobs_oo;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {
    Job jobObject1;
    Job jobObject2;
    @Before
    public void createJobObjects(){
         jobObject1 = new Job();
         jobObject2 = new Job();
    }


    @Test
    public void testSettingJobId(){
        jobObject1 = new Job();
        jobObject2 = new Job();
        assertFalse(jobObject1.equals(jobObject2));
        assertEquals(1,jobObject2.getId() - jobObject1.getId());
        assertTrue((jobObject2.getId()-1) == jobObject1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobObject instanceof Job);

        assertTrue(jobObject.getName() == "Product tester");

        assertTrue(jobObject.getEmployer() instanceof Employer);
        assertTrue(jobObject.getEmployer().getValue() == "ACME");

        assertTrue(jobObject.getLocation() instanceof Location);
        assertTrue(jobObject.getLocation().getValue() == "Desert");

        assertTrue(jobObject.getPositionType() instanceof PositionType);
        assertTrue(jobObject.getPositionType().getValue() == "Quality control");

        assertTrue(jobObject.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(jobObject.getCoreCompetency().getValue() == "Persistence");
    }
    @Test
    public void testJobsForEquality(){
        jobObject1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobObject2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobObject1.equals(jobObject2));
    }

   @Test
    public void testStringNewLines(){
       Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String jobObj = job.toString();
       assertTrue(jobObj.startsWith("\n"));
       assertTrue(jobObj.endsWith("\n"));
   }
    @Test
    public void testToStringPrintLabels() {
        Job jobObj = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] str = jobObj.toString().trim().split("\n");

        assertTrue(str.length == 6);

        assertTrue(str[0].startsWith("ID: "));
        assertTrue(str[1].startsWith("Name: "));
        assertTrue(str[2].startsWith("Employer: "));
        assertTrue(str[3].startsWith("Location: "));
        assertTrue(str[4].startsWith("Position Type: "));
        assertTrue(str[5].startsWith("Core Competency: "));

    }

    @Test
    public void testToStringDataUnavailable() {
    Job job = new Job();
    String[] str = job.toString().trim().split("\n");

    List<String> list = new ArrayList<String>(Arrays.asList(str));
        list.remove(0);
    str = list.toArray(new String[0]);

        for (String string : str) {
        assertTrue(string.endsWith("Data not available"));
    }
  }
}