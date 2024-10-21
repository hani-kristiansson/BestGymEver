package BestGymEver;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberSearchTest {

    MemberSearch ms = new MemberSearch("Test/BestGymEver/MemberShipDataTest.txt");

    @Test
    void readTwoLinesTest() {

        String indataFile = "Test/BestGymEver/MemberShipDataTest.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(indataFile))) {
            String[] personUppgifter = ms.readTwoLines(bufferedReader);
            assertEquals(2, personUppgifter.length); // 2 means two lines
            assertEquals("7703021234, Alhambra Aromes", personUppgifter[0]);
            assertEquals("2024-07-01", personUppgifter[1]);

            assertNotEquals("7703021234, Alhambra Aro", personUppgifter[0]);
            assertNotEquals("2024-07-30", personUppgifter[1]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file is not existing");

        } catch (IOException e) {
            throw new RuntimeException("Could not read the file");
        }
    }

    @Test
    void findMember() {

        Member member1 = ms.findMember("Alhambra Aromes"); // existing member
        Member member2 = ms.findMember("7703021234");

        Member member3 = ms.findMember("Sven Svensson"); // not existing member
        Member member4 = ms.findMember("9102226789");

        assertNotNull(member1);
        assertEquals("Alhambra Aromes", member1.getName());
        assertEquals("7703021234", member2.getSocialSecurityNumber());

        assertEquals(member1, member2);

        assertEquals("2024-07-01", member1.getMembershipPaidDate().toString());
        assertEquals("2024-07-01", member2.getMembershipPaidDate().toString());

        //member2 is not in list, therefore returning null
        assertNull(member3);
        assertNull(member4);
    }
}
