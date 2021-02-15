package Tests;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.launchcode.techjobs_oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {
    Job jobObject1, jobObject2, jobObject;

    @Before
    public void createJobObjects(){
         jobObject1 = new Job();
         jobObject2 = new Job();
        jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

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
       jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       String jobObj = jobObject.toString();
       assertTrue(jobObj.startsWith("\n"));
       assertTrue(jobObj.endsWith("\n"));
   }
    @Test
    public void testToStringPrintLabels() {
         Job jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] str = jobObject.toString().trim().split("\n");

        assertTrue(str.length == 6);

        assertTrue(str[0].endsWith(Integer.toString(jobObject.getId())));
        assertTrue(str[1].endsWith(jobObject.getName()));
        assertTrue(str[2].endsWith(jobObject.getEmployer().toString()));
        assertTrue(str[3].endsWith(jobObject.getLocation().toString()));
        assertTrue(str[4].endsWith(jobObject.getPositionType().toString()));
        assertTrue(str[5].endsWith(jobObject.getCoreCompetency().toString()));
    }
    @Test
    public void testIf2ndIsSet(){
        jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String str = jobObject.toString();
        String[] jobArr = str.split("\n");
        assertEquals("ID: " + jobObject.getId(), jobArr[1]);
    }

    @Test
    public void testIfNoValuePassed() {
        jobObject = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        jobObject.getEmployer().setValue("");
        jobObject.getPositionType().setValue("");
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",jobObject.getId(), jobObject.getName(), jobObject.getLocation(), jobObject.getCoreCompetency());

        assertEquals(output, jobObject.toString());
    }
 }

