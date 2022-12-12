package com.dataloaderportal.DataLoaderPortal.repo;

import com.dataloaderportal.DataLoaderPortal.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
}
