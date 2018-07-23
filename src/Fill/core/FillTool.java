package Fill.core;



import Fill.FillFactory;
import Fill.constent.FillConstent;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class FillTool extends FillToolImpl implements FillFactory {

    /**
     * tips HttpServletRequest-->MAP    保存空值
     *
     * @Author:hihuzi 2018/6/14 14:51
     */
    @Override
    public Map parameterFillMap(HttpServletRequest request) {

        return parameterFillMapDefault(request, FillConstent.NullWhetherSave, null);
    }

    /**
     * tips HttpServletRequest-->MAP   str 去掉没用的字段
     *
     * @param request
     * @param str
     * @Author:hihuzi 2018/6/14 14:51
     */
    @Override
    public Map parameterFillMap(HttpServletRequest request, String... str) {

        return parameterFillMapDefault(request, FillConstent.NullWhetherSave.setValue(0), str);
    }

    /**
     * tips HttpServletRequest-->MAP   是否舍弃空值  默认舍弃空字符
     *
     * @Author:hihuzi 2018/6/14 14:51
     */
    @Override
    public Map parameterFillMap(HttpServletRequest request, FillConstent fillConstent) {

        return parameterFillMapDefault(request, fillConstent.NullWhetherSave.setValue(1), null);
    }

    /**
     * tips HttpServletRequest-->MAP    是否舍弃空值 并且舍弃str特定字段
     *
     * @Author:hihuzi 2018/6/14 14:51
     */
    @Override
    public Map parameterFillMap(HttpServletRequest request, FillConstent fillConstent, String... str) {

        return parameterFillMapDefault(request, fillConstent, str);
    }

    /**
     * tips HttpServletRequest--> obj
     *
     * @Author:hihuzi 2018/6/14 14:50
     */
    @Override
    public <E> E parameterFillEntity(HttpServletRequest request, E e) throws Exception {

        return parameterFillEntity(request, e, FillConstent.Default);
    }

    /**
     * tips tips 对MAP数据装填--> 对象
     *
     * @Author:hihuzi 2018/6/14 14:50
     */
    @Override
    public <E> E mapFillEntity(Map map, E e) throws Exception {

        return mapFillEntity(map, e, FillConstent.Default);
    }

    /**
     * tips tips 对LIST数据装填--> 对象 针对数据库与实体类名有区别 key-value -->e
     *
     * @Author:hihuzi 2018/6/26 14:51
     */
    @Override
    public <E> List<E> listToEntity(List<Map> list, E e) throws Exception {

        return listToEntity(list, e, FillConstent.Default);
    }

    /**
     * tips tips 对LIST数据装填--> 对象 针对数据库与实体类名有区别 value -->t
     *
     * @param list
     * @param e
     * @Author:hihuzi 2018/6/26 14:51
     */
    @Override
    public <E> List<E> listFillEntity(List<String> list, E e) throws Exception {

        return listFillEntity(list, e, FillConstent.SEQUENCE);
    }

}
