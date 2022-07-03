package com.LearnSpring.Dao;

import java.util.List;

import com.LearnSpring.Model.Customer;
import com.LearnSpring.Model.CustomerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 Test
 */
@Repository
@Transactional
public class CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Customer customer) {
		String sql = "INSERT INTO customer (name, address) VALUES (?, ?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getAddress());
	}

	public void delete(int id) {
		String sql = "DELETE FROM customer WHERE id = " + id;
		jdbcTemplate.update(sql);
	}

	public void update(Customer customer) {
		String sql = "UPDATE customer SET name = ?, address = ? WHERE id = ? ";
		jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getId());
	}

	public Customer findById(int id) {
		String sql = "SELECT * FROM customer WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
	}

	public List<Customer> findAll() {
		String sql = "SELECT * FROM customer";
		return jdbcTemplate.query(sql, new CustomerMapper());
	}
}
