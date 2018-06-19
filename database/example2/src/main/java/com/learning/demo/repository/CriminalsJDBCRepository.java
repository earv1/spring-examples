package com.learning.demo.repository;

import com.learning.demo.model.Criminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//TODO
// Note how we don't need to worry about opening and closing connections.
// But also note how we have to manually create our objects.
// Also, note how we have to do a lot of ugly sql.

// You will also note that our sql isn't type safe. What I mean by that
// is that you can change it to what you want but the compiler wont complain
// It is only once you run it that you get an error. And a bad one at that.

// Think about how this might be made better. Do you think we can get a
// system that does this for us?
// Spend at least 10 minutes going over this and making sure that you understand how this works.
// Ask questions if you want to better understand anything.
@Repository
public class CriminalsJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Criminal> findCriminalByNameContains(@NotBlank String name){
        //Wilcard searching, note how these aren't escaped
        name = '%' + name + '%';
        List<Criminal> criminals =  jdbcTemplate.query(
                "SELECT id, name, city, updated_at, created_at FROM criminals WHERE name like ?",
                new Object[] { name },
                new RowMapper<Criminal>() {
                    @Override
                    public Criminal mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new Criminal(
                                resultSet.getString("name"),
                                resultSet.getString("city"),
                                resultSet.getDate("updated_at"),
                                resultSet.getDate("created_at")
                        );
                    }
                });
        return criminals;
    }
}
