package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
        //동시성 문제떄문에 실무에서는 HashMap을 써야 한다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findBtyId(Long memberId) {
        return store.get(memberId);
    }
}
