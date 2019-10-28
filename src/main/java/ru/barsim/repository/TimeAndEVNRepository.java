package ru.barsim.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.barsim.dto.TimeAndEVN;
import ru.barsim.dto.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class TimeAndEVNRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<TimeAndEVN> ROW_MAPPER = ((resultSet, rowNumber) -> new TimeAndEVN(
            resultSet.getObject("USR", User.class),
            resultSet.getString("DT"),
            resultSet.getInt("EVN")
    ));

    public List<TimeAndEVN> getTimeAndEVNinMonthforUser(User user, int month, int year){
        String sql = "select USR,DT,EVN from fb_evn where fb_evn.ID = " + user.getId() +
        " and fb_evn.EVN in ('2','5')" +
        " and fb_evn.DT >= '1." + month + "." + year + " 00:00:00'" +
        " and fb_evn.DT <= '" + Month.of(month).maxLength() + "." + month + "." + year + " 23:59:59'";
        return jdbcTemplate.query(sql,ROW_MAPPER);
    }
}
