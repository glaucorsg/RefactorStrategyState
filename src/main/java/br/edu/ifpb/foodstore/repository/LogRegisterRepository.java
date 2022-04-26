package br.edu.ifpb.foodstore.repository;

import br.edu.ifpb.foodstore.domain.LogRegister;
import br.edu.ifpb.foodstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRegisterRepository extends JpaRepository<LogRegister, Long> {
}
