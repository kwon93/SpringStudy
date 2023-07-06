package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) { // 멤버 객체가 변수로 들어오면
        store.put(member.getId(),member); // 메모리 저장 형식인 store Map에 키, 밸류 형태로 저장이 된다.
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
