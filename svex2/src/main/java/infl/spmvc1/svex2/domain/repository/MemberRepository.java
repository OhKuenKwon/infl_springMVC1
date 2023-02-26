package infl.spmvc1.svex2.domain.repository;

import infl.spmvc1.svex2.domain.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long seq = 0L;

    //싱글톤 객체 생성
    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance(){
        return instance;
    }

    //기본 생성자 막기
    private  MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++seq);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
