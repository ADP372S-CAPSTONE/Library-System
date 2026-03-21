package factory;


//Member Factory Test.
//Author: 230240887 Nxasana Owenkosi
//Date:

import domain.Member;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberFactoryTest {

    @Test
    void shouldCreateMemberUsingBuilder() {

        Member member = new Member.Builder("M001", "Owe Nxasana")
                .setMemberEmail("owe@email.com")
                .setMemberPhone("0832234567")
                .setMembershipDate("2026-03-18")
                .build();

        assertNotNull(member);
        assertEquals("M001", member.getMemberId());
        assertEquals("Owe Nxasana", member.getMemberName());
        assertEquals("owe@email.com", member.getMemberEmail());
        assertEquals("0832234567", member.getMemberPhone());
        assertEquals("2026-03-18", member.getMembershipDate());
    }

    @Test
    void shouldThrowExceptionWhenIdIsMissing() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Member.Builder(null, "Owe")
                    .build();
        });
    }

    @Test
    void shouldThrowExceptionWhenIdIsInvalid() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Member.Builder("123", "Owe")
                    .build();
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsMissing() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Member.Builder("M002", "")
                    .build();
        });
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Member.Builder("M003", "Owe")
                    .setMemberEmail("invalid-email")
                    .build();
        });
    }
}
