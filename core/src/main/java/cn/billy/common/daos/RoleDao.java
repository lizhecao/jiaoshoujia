package cn.billy.common.daos;

import cn.billy.common.rbac.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *  角色 DAO
 * 
 *
 */
public interface RoleDao extends PagingAndSortingRepository<Role, Long> {

}