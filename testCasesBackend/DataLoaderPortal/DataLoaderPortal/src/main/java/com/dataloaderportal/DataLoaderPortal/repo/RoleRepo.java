package com.dataloaderportal.DataLoaderPortal.repo;

import com.dataloaderportal.DataLoaderPortal.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, String> {
}
