package in.tritonlabs.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tritonlabs.jwt.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

	public Register findByEmail(String email);
	
}
