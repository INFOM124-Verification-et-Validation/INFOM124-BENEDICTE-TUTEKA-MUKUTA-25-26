package delft;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;
import static delft.Field.*;
import static delft.Property.*;
import static delft.SportsHallPlanner.planHalls;

class SportsHallPlannerTests {

    private Set<Property> properties;
    private Map<Field,Integer> fields;
    private  List<Request> requests;
    private  List<SportsHall> sportsHalls;



    @BeforeEach
    void init() {
        properties  = new HashSet<>();
        fields  = new HashMap();
        requests =  new ArrayList<>();
        sportsHalls =  new ArrayList<>();

    }

    @Test
    void testNoPropertiesRequest() {

        Request request = new Request(properties, BASKETBALL, 3);



    }
}
