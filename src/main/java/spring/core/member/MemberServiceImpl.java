package spring.core.member;

public class MemberServiceImpl implements MemberService{

    //다형성에 의해 MemoryMemberRepository 에 있는 오버라이드 메서드가 호출됨
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findMember(memberId);
    }
}
