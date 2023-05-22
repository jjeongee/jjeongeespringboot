package likelion.springbootjjeongee.repository;

import likelion.springbootjjeongee.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public class MemberRepository {
    public interface MemberRepository extends JpaRepository<Member,Long>{}
}
