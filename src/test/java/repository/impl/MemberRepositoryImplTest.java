/*Member Repository implementation Test
Author: Nxasana Owenkosi 230240887
   Date: 23 March 2026
*/
package repository.impl;

import domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryImplTest {

    private MemberRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = MemberRepositoryImpl.getRepository();
        repository.clear(); // clean state for each test
    }

    // Happy path CRUD operations
    @Test
    void testCreateReadUpdateDelete() {
        // CREATE
        Member member = new Member.Builder("M001", "Owen")
                .setMemberEmail("owen@email.com")
                .setMemberPhone("0831111111")
                .build();
        repository.create(member);

        // READ
        Optional<Member> readMember = repository.read("M001");
        assertTrue(readMember.isPresent());
        assertEquals("Owen", readMember.get().getMemberName());

        // UPDATE
        Member updatedMember = new Member.Builder("M001", "Owen Updated")
                .setMemberEmail("owen@email.com")
                .setMemberPhone("0831111111")
                .build();
        repository.update(updatedMember);

        readMember = repository.read("M001");
        assertTrue(readMember.isPresent());
        assertEquals("Owen Updated", readMember.get().getMemberName());

        // DELETE
        assertTrue(repository.delete("M001"));
        assertFalse(repository.read("M001").isPresent());
    }


    //Reading non-existent member
    @Test
    void testReadNonExistentMember() {
        Optional<Member> member = repository.read("M999");
        assertFalse(member.isPresent());
    }


    // Updating non-existent member
    @Test
    void testUpdateNonExistentMember() {
        Member member = new Member.Builder("M002", "NonExistent").build();

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                repository.update(member)
        );
        assertEquals("Member not found", exception.getMessage());
    }

    // Deleting non-existent member
    @Test
    void testDeleteNonExistentMember() {
        assertFalse(repository.delete("M999"));
    }


    // Multiple members & getAll

    @Test
    void testMultipleMembersAndGetAll() {
        Member m1 = new Member.Builder("M001", "Owen").build();
        Member m2 = new Member.Builder("M002", "Alice").build();
        repository.create(m1);
        repository.create(m2);

        assertEquals(2, repository.getAll().size());
    }
}

