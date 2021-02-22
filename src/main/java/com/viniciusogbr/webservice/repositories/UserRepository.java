package com.viniciusogbr.webservice.repositories;

import com.viniciusogbr.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Tipo da entidade / Tipo da chave dessa entidade
public interface UserRepository extends JpaRepository<User, Long> {
}
