package com.example.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBTest {
	// @Value("${spring.datasource.platform}")
	// private String platform;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	List<Map<String, Object>> query() {
		String sql = "SELECT * FROM inventory";
		return jdbcTemplate.queryForList(sql);
	}
	
	public void create(String id,String Quantity)
	{	
		String sql = "INSERT INTO inventory(ItemID, Quantity) VALUES ('" + id + "','"+Quantity+"')";
		jdbcTemplate.execute(sql);
	}

	Post find(String id) {
		String sql = "SELECT * FROM inventory where ItemID='" + id + "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		Post post = new Post();
		for (Map<String, Object> row : list) {
			post.ItemID = (String) row.get("ItemID");
			post.Quantity = (String) row.get("Quantity");
		}
		return post;
	}

	public void update(Post post) {
		String sql = "UPDATE inventory SET Quantity='" + post.Quantity + "' WHERE ItemID='" + post.ItemID + "'";
		jdbcTemplate.execute(sql);
		
	}
	
	public void delete(String id)
	{
		String sql = "DELETE from inventory WHERE ItemID='" + id + "'";
		jdbcTemplate.execute(sql);
	}
}
