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
import java.util.HashMap;
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

    public List<User> getAllUsersForDate(LocalDate date) {
        DateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
        String sql = "SELECT fb_evn.usr,MIN(fb_evn.dt) as dt_min, MAX(fb_evn.dt) as dt_max FROM fb_evn " +
                "where fb_evn.evn in ('2','5')" +
                "group by fb_evn.usr";
        return jdbcTemplate.query(sql,ROW_MAPPER);
    }

    private User getUserFIO(User user){
        String sql = "select fb_usr.fio from fb_usr where fb_usr.id = ?";
        user.setFIO(jdbcTemplate.queryForObject(sql,new Object[]{user.getId()},ROW_MAPPER).getFIO());
        return user;
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

        return user;
    }

}
