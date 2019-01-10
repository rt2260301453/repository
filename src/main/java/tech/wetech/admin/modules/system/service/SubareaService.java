package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.query.SubareaQuery;

import java.util.List;

public interface SubareaService {

    PageResultSet<SubareaDto> findByPage(SubareaQuery subareaQuery);

    List<SubareaDto> findByAddr(SubareaQuery subareaQuery);

    /**
     * &#x521b;&#x5efa;&#x7528;&#x6237;
     * @param subarea
     */
    void createUser(Subarea subarea) throws BizException;

    void updateUser(Subarea subarea);

    void deleteUser(String subareaId);

    List<Subarea> findAll();

}
