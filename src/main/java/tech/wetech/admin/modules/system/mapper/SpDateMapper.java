package tech.wetech.admin.modules.system.mapper;

<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Select;
>>>>>>> 6d33d21b07cf5a9ab55662480a172d6b37992622
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.SpDate;

public interface SpDateMapper extends MyMapper<SpDate> {
<<<<<<< HEAD
=======

    @Select(value = "select count(1) from spdate where datename=#{datename}")
    int selectByName(SpDate datename);
>>>>>>> 6d33d21b07cf5a9ab55662480a172d6b37992622
}