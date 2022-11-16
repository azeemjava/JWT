package in.tritonlabs.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tritonlabs.jwt.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {


}
