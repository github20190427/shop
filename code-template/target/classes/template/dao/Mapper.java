package ${package_mapper};
import ${package_pojo}.${Table};
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;

/****
 * @Author:shenkunlin
 * @Description:${Table}的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface ${Table}Mapper extends Mapper<${Table}> {
}
