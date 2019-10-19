package ru.barsim.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.barsim.dto.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> ROW_MAPPER = ((resultSet, rowNumber) -> new User(
            resultSet.getLong("ID"),
            resultSet.getString("FIO")));

    public User getUser(Long id) {
        String sql = "select * from fb_usr where fb_usr.ID = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},ROW_MAPPER);
    }
    public List<User> getAllUsers(){
        String sql = "SELECT * FROM fb_usr";
        return jdbcTemplate.query(sql,ROW_MAPPER);
    }
}
