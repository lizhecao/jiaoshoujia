package cn.billy.common.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.billy.common.rbac.User;

/**
 * 用户DAO
 * 
 *
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	User findByName(String username);

    @Query(value = "select t from User t where t.name like %?1%", nativeQuery = false)
    Page<User> findAllByKeyword(String keyword, Pageable pageable);
}