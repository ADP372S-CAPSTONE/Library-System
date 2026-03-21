/* MemberRepositoryImpl.java
   Member repository implementation
   Author: Nomhle Njengele (216227488)
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

public class MemberRepositoryImpl implements MemberRepository {

    private final Map<String, Member> storage = new HashMap<>();

    private String keyFor(Member member) {
        return String.valueOf(member.hashCode());
    }

    @Override
    public Member create(Member entity) {
        storage.put(keyFor(entity), entity);
        return entity;
    }

    @Override
    public Optional<Member> read(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Member update(Member entity) {
        storage.put(keyFor(entity), entity);
        return entity;
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(storage.values());
    }

}

