package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    Member activeMember = new Member
            ("7703021234", "Alhambra Aromes", LocalDate.parse("2024-07-01")); //membership paid date
    Member inactvieMember = new Member
            ("8204021234", "Bear Belle", LocalDate.parse("2019-12-02"));

    @Test
    void isMembershipActiveTest() {
        assertTrue(activeMember.isMembershipActive(LocalDate.parse("2024-10-20"))); //true
        assertTrue(activeMember.isMembershipActive(LocalDate.parse("2025-06-30"))); //true
        assertFalse(activeMember.isMembershipActive(LocalDate.parse("2025-07-15"))); //false

        assertFalse(inactvieMember.isMembershipActive(LocalDate.parse("2024-10-20"))); //false
    }

    @Test
    void membershipVaildUntilDateTest() {
        LocalDate validUntilDate = activeMember.membershipValidUntilDate();
        assertEquals(LocalDate.parse("2025-07-01"), validUntilDate);
        assertNotEquals(LocalDate.parse("2025-07-02"), validUntilDate);

        LocalDate validUntilDate2 = inactvieMember.membershipValidUntilDate();
        assertEquals(LocalDate.parse("2020-12-02"), validUntilDate2);
        assertNotEquals(LocalDate.parse("2024-12-02"), validUntilDate2);
    }
}

