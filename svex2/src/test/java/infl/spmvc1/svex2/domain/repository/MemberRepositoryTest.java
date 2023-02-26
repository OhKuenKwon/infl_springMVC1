package infl.spmvc1.svex2.domain.repository;

import infl.spmvc1.svex2.domain.member.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository mr = MemberRepository.getInstance();

    //각각의 단위테스트가 끝나면 항상 실행됨
    @AfterEach
    void afterEach() {
        mr.clearStore();
    }

    @Test
    @DisplayName("멤버 등록 테스트")
    void saveTest() {
        //given
        Member mb = new Member("hello", 20);

        //when
        Member sm = mr.save(mb);

        //then
        Member fm = mr.findById(sm.getId());
        assertThat(fm).isEqualTo(sm);
    }

    @Test
    @DisplayName("모든 멤버 검색 테스트")
    void findAllTest() {
        //given
        Member m1 = new Member("member1", 29);
        Member m2 = new Member("member2", 35);
        mr.save(m1);
        mr.save(m2);

        //when
        List<Member> result = mr.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(m1, m2);
    }
}