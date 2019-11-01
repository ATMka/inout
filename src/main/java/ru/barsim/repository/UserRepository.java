package ru.barsim.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import ru.barsim.dto.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<User> ROW_MAPPER = ((resultSet, rowNumber) -> new User(
            resultSet.getLong("ID"),
            resultSet.getString("FIO")
    ));
    private RowMapper<User> ROW_MAPPER_FOR_DAY = ((resultSet, rowNumber) -> new User(
            resultSet.getLong("dt_min"),
            resultSet.getString("dt_max")
    ));

    private User getUser(Long id){
        String sql = "select fb_usr.id, fb_usr.fio from fb_usr where fb_usr.id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},ROW_MAPPER);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT fb_usr.id, fb_usr.fio FROM fb_usr";
        return jdbcTemplate.query(sql,ROW_MAPPER);
    }


    public User getUserInDay(User user, LocalDate date) {
        DateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        String sql = "SELECT MIN(fb_evn.dt) as dt_min,MAX(fb_evn.dt) as dt_max FROM fb_usr" +
                "join fb_evn on fb_usr.id = fb_evn.usr" +
                "where fb_usr.ID = :usr and fb_evn.evn in ('2','5')" +
                "and fb_evn.dt between ':localdate 00:00:00' and ':localdate 23:59:59" +
                "group by fb_usr.id,  fb_usr.FIO";

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("usr", user.getId());
        namedParameters.addValue("localdate", dt.format(date));
        User tmpUser = namedParameterJdbcTemplate.query(sql,ROW_MAPPER_FOR_DAY).get(0);
        user.setDtMin(tmpUser.getDtMin());
        user.setDtMax(tmpUser.getDtMax());
        return user;
    }

}
