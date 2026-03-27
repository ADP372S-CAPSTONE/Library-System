/* MemberRepositoryImpl.java
   Member repository implementation
   Author: Nxasana Owenkosi 230240887
   Date: 13 March 2026
*/
package repository.impl;

import domain.Member;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

public class MemberRepositoryImpl implements MemberRepository {

    private static MemberRepositoryImpl repository = null;
    private final Map<String, Member> memberMap;

    // Private constructor (Singleton)
    private MemberRepositoryImpl() {
        memberMap = new HashMap<>();
    }

    // Global access point
    public static MemberRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new MemberRepositoryImpl();
        }
        return repository;
    }

    // CREATE
    @Override
    public Member create(Member member) {
        memberMap.put(member.getMemberID(), member);
        return member;
    }

    // READ (Optional = best practice)
    @Override
    public Optional<Member> read(String memberID) {
        return Optional.ofNullable(memberMap.get(memberID));
    }

    // UPDATE
    @Override
    public Member update(Member member) {
        if (memberMap.containsKey(member.getMemberID())) {
            memberMap.put(member.getMemberID(), member);
            return member;
        }
        throw new RuntimeException("Member not found");
    }

    // DELETE
    @Override
    public boolean delete(String memberID) {
        return memberMap.remove(memberID) != null;
    }

    // READ ALL
    @Override
    public List<Member> getAll() {
        return new ArrayList<>(memberMap.values());
    }

    public void clear() {
        memberMap.clear();
    }
}

