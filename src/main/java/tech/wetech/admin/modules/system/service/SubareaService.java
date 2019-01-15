package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.po.Addr;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.SubareaQuery;

import java.util.List;
import java.util.Map;

public interface SubareaService {

    PageResultSet<SubareaDto> findByPage(SubareaQuery subareaQuery);


    /**
     * &#x521b;&#x5efa;&#x7528;&#x6237;
     * @param subarea
     */
    void createUser(Subarea subarea) throws BizException;

    void updateUser(Subarea subarea);

    void deleteId(String subareaId);

    int selectOneno(Subarea subarea);

    List<Subarea> excel();

    List<Subarea> findAll();

    List<Addr> findPro();

    List<Addr> findEdit();

    List<Addr> findCity(SubareaQuery subareaQuery);

    List<Addr> findCounty(SubareaQuery subareaQuery);

    List<Addr> selectCity(Addr addr);

    List<Addr> selectCou(Addr addr);

}
