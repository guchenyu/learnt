package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
