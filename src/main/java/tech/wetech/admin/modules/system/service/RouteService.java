package tech.wetech.admin.modules.system.service;

import org.springframework.stereotype.Service;
import tech.wetech.admin.modules.system.po.Route;

import java.util.Date;

@Service
public interface RouteService {
    void insert(Route route);

    int selectByDate(Route route);

    void update(Route route);

    void deletebusroute(Long id);
}
