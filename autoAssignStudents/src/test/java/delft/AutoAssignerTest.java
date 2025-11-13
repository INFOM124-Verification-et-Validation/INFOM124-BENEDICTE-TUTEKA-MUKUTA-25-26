package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.within;
import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

class AutoAssignerTest {
    List<Student> students;
    List<Workshop> workshops;
    AssignmentsLogger assignments;
    AutoAssigner autoAssigner;



    @BeforeEach
    void init() {
        students  = new ArrayList<>();
        workshops  = new ArrayList<>();
        assignments = new AssignmentsLogger();
        autoAssigner = new AutoAssigner();

    }


    private List<Student> generateStudents(){

        List<Student> students = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Student student = new Student(i, String.format("Student %d", i), String.format("Student%d@gmail.com", i));
            students.add(student);
        }
        return students;
    }


    private List<Workshop> generateWorkshops(){

        List<Workshop> workshops = new ArrayList<>();

        for(int i=1; i < 5; i++ ){
            Workshop workshop = generateWorkshop(i);
            workshops.add(workshop);
        }
        return workshops;
    }


    private Workshop generateWorkshop(int id){
        HashMap<ZonedDateTime, Integer> spotsPerDate = new HashMap<>();

        for(int i=1; i < 4; i++ ){
            Random rand = new Random();
            int spots = rand.nextInt(3);
            ZonedDateTime date = date(2025,rand.nextInt(12) + 1, rand.nextInt(29) + 1, 2,0);
            spotsPerDate.put(date, spots);
        }

        Workshop workshop = new Workshop(id,  String.format("Worshop %d",id),spotsPerDate );
        return workshop;
    }


    private Workshop generateFullWorkshop(){
        HashMap<ZonedDateTime, Integer> spotsPerDate = new HashMap<>();

        for(int i=1; i < 3; i++ ){
            Random rand = new Random();
            int spots = 0;
            ZonedDateTime date = date(2025,rand.nextInt(12) + 1, rand.nextInt(29) + 1, 2,0);
            spotsPerDate.put(date, spots);
        }

        Workshop workshop = new Workshop(1,  String.format("Worshop %d",1),spotsPerDate );
        return workshop;
    }


    private Workshop generateNextWorkshop(){
        HashMap<ZonedDateTime, Integer> spotsPerDate = new HashMap<>();

        for(int i=0; i < 3; i++ ){
            Random rand = new Random();
            int spots = i;
            ZonedDateTime date = date(2025,i+1, i+10, 2,0);
            spotsPerDate.put(date, spots);
        }

        Workshop workshop = new Workshop(1,  String.format("Worshop %d",1),spotsPerDate );
        return workshop;
    }

    @Test
    void testStudentInfo(){
        Student ben = new Student(1,"blessing", "ble@gmail.com");
        students.add(ben);
        assertTrue(students.contains(ben));
        Student getBen = students.get(students.indexOf(ben));
        assertEquals(getBen.getId(),1);
        assertEquals(getBen.getName(),"blessing");
        assertEquals(getBen.getEmail(),"ble@gmail.com");
    }

    @Test
    void testStudentWithSameInformation(){
        Student ben = new Student(1,"blessing", "ble@gmail.com");
        students.add(ben);
        assertTrue(students.contains(ben));
        Student getBen = students.get(students.indexOf(ben));
        assertTrue(ben.equals(getBen));

    }


    @Test
    void testWorkshopInfo(){
        Workshop ws  = generateWorkshop(1);
        workshops.add(ws);
        assertTrue(workshops.contains(ws));
        Workshop getWs = workshops.get(workshops.indexOf(ws));
        assertEquals(getWs.getId(),1);
        assertEquals(getWs.getName(),"Worshop 1");
    }

    @Test
    void testWorkshopWithSameInformation(){
        Workshop ws  = generateWorkshop(1);
        workshops.add(ws);
        assertTrue(workshops.contains(ws));
        Workshop getWs = workshops.get(workshops.indexOf(ws));
        assertTrue(ws.equals(getWs));

    }

    @Test
    void testAvailableWorkshop(){
        Workshop ws  = generateWorkshop(1);
        workshops.add(ws);
        assertTrue(ws.hasAvailableDate());
    }

    @Test
    void testNotAvailableWorkshop(){
        Workshop ws  = generateFullWorkshop();
        workshops.add(ws);
        assertFalse(ws.hasAvailableDate());
    }


    @Test
    void testAssign(){
        AutoAssigner autoAssigner = new AutoAssigner();

        AssignmentsLogger  assignmentsLogger = autoAssigner.assign(generateStudents(), generateWorkshops());

        System.out.println(assignmentsLogger.getAssignments());
        System.out.println(assignmentsLogger.getErrors());


    }

    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }




}
