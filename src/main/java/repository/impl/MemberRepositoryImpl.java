/* MemberRepositoryImpl.java
   Member repository implementation
   Author: Nomhle Njengele (216227488)
   Date: 13 March 2026
*/
package repository.impl;

import domain.Member;
import repository.MemberRepository;

import java.util.Collection;
import java.util.HashMap;

public class MemberRepositoryImpl implements MemberRepository {
    private final HashMap<String, Member> memberStore = new HashMap<>();
    private static MemberRepositoryImpl instance = null;

    private MemberRepositoryImpl() {}

    public static MemberRepositoryImpl getInstance() {
        if (instance == null) instance = new MemberRepositoryImpl();
        return instance;
    }

    @Override
    public Member create(Member member) {
        if (member == null || memberStore.containsKey(member.getMemberId())) return null;
        memberStore.put(member.getMemberId(), member);
        return member;
    }

    @Override
    public Member read(String id) {
        return memberStore.getOrDefault(id, null);
    }

    @Override
    public Member update(Member member) {
        if (member == null || !memberStore.containsKey(member.getMemberId())) return null;
        memberStore.put(member.getMemberId(), member);
        return member;
    }

    @Override
    public boolean delete(String id) {
        if (!memberStore.containsKey(id)) return false;
        memberStore.remove(id);
        return true;
    }

    @Override
    public Collection<Member> getAll() {
        return memberStore.values();
    }
}

