package br.edu.ifpb.foodstore.repository;

import br.edu.ifpb.foodstore.domain.Customer;
import br.edu.ifpb.foodstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
