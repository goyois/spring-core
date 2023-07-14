package spring.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //해쉬맵은 동시성 이슈가 있을 수 있으므로 테스트시에만 사용하고 실무에선 주의해야함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findMember(Long memberId) {
        return store.get(memberId);
    }
}
