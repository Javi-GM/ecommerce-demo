package com.example.demo.infrastructure;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.domain.RateRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PostgreSQLRateRepository implements RateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Rate rate) {
        sessionFactory.getCurrentSession().save(rate);
    }

    @Override
    public Optional<Rate> search(Id id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Rate.class, id));
    }
}
