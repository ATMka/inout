package ru.barsim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barsim.dto.TimeAndEVN;
import ru.barsim.dto.User;
import ru.barsim.repository.TimeAndEVNRepository;

import java.util.List;

@Service
public class TImeAndEVNService {
    @Autowired
    private TimeAndEVNRepository timeAndEVNRepository;

    public List<TimeAndEVN> getTimeAndEVNinMonthforUser(User user, int month, int year){
        return timeAndEVNRepository.getTimeAndEVNinMonthforUser(user,month,year);
    }
}
