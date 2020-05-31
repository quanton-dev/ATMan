package com.k0ft3.atman.infrastructure.repository;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.k0ft3.atman.domain.model.user.User;
import com.k0ft3.atman.domain.model.user.UserRepository;

import static org.junit.Assert.*;

public class HibernateUserRepositoryTests {

}