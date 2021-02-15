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

        assertTrue(str[0].endsWith(Integer.toString(jobObj.getId())));
        assertTrue(str[1].endsWith(jobObj.getName()));
        assertTrue(str[2].endsWith(jobObj.getEmployer().toString()));
        assertTrue(str[3].endsWith(jobObj.getLocation().toString()));
        assertTrue(str[4].endsWith(jobObj.getPositionType().toString()));
        assertTrue(str[5].endsWith(jobObj.getCoreCompetency().toString()));
    }
    @Test
    public void testIf2ndIsSet(){
        Job jobObj = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String str = jobObj.toString();
        String[] jobArr = str.split("\n");
        assertEquals("ID: " + jobObj.getId(), jobArr[1]);
    }

    @Test
    public void testIfNoValuePassed() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String[] str = job.toString().trim().split("\n");
        Employer expected = job.getEmployer();
        assertEquals("", expected);
    }
 }
