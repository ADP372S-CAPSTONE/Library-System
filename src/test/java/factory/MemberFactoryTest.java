package factory;


//Member Factory Test.
//Author: 230240887 Nxasana Owenkosi
//Date:

import domain.Member;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberFactoryTest {

    @Test
    void shouldCreateMemberUsingFactory() {

        Member member = MemberFactory.createMember(
                "M001",
                "Owen Nxasana",
                "owen@email.com",
                "0832234567"
        );

        assertNotNull(member);
        assertEquals("M001", member.getMemberID());
        assertEquals("Owen Nxasana", member.getMemberName());
        assertEquals("owen@email.com", member.getMemberEmail());
        assertEquals("0832234567", member.getMemberPhone());
    }

    @Test
    void shouldThrowExceptionWhenIdIsMissing() {

        assertThrows(IllegalArgumentException.class, () ->
                MemberFactory.createMember(null, "Owen")
        );
    }

    @Test
    void shouldThrowExceptionWhenIdIsInvalid() {

        assertThrows(IllegalArgumentException.class, () ->
                MemberFactory.createMember("123", "Owen")
        );
    }

    @Test
    void shouldThrowExceptionWhenNameIsMissing() {

        assertThrows(IllegalArgumentException.class, () ->
                MemberFactory.createMember("M002", "")
        );
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {

        assertThrows(IllegalArgumentException.class, () ->
                MemberFactory.createMember("M003", "Owen", "invalid-email", "083")
        );
    }

    @Test
    void shouldGenerateValidMemberId() {
        String id = MemberFactory.generateMemberId(1);
        assertEquals("M001", id);
    }

    @Test
    void shouldThrowExceptionForInvalidGeneratedId() {

        assertThrows(IllegalArgumentException.class, () ->
                MemberFactory.generateMemberId(0)
        );
    }
}
