package Fill;



import Fill.constent.FillConstent;
import Fill.core.FillTool;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface FillFactory {

    FillTool fillTool = null;

    static FillTool batch() {

        if (fillTool == null)
            return new FillTool();
        return fillTool;
    }

    /**
     * tips HttpServletRequest-->MAP
     * 默认 方法一 保存空值
     *
     * @Author:hihuzi 2018/6/14 14:51
     */
    Map parameterFillMap(HttpServletRequest request);

    /**
     * tips HttpServletRequest-->MAP
     * 方法二 保存空值 并且舍弃str特定字段
     *
     * @Author:hihuzi 2018/7/23 15:05
     */
    Map parameterFillMap(HttpServletRequest request, String... str);

    /**
     * tips HttpServletRequest-->MAP
     * 方法三 是否舍弃空值 并且舍弃str特定字段(默认舍弃空值)
     *
     * @Author:hihuzi 2018/7/23 15:05
     */
    Map parameterFillMap(HttpServletRequest request, FillConstent fillConstent);

    /**
     * tips HttpServletRequest-->MAP
     * 方法四 是否舍弃空值 并且舍弃str特定字段(默认保存空值)
     *
     * @Author:hihuzi 2018/7/23 15:05
     */

    Map parameterFillMap(HttpServletRequest request, FillConstent fillConstent, String... str);

    /**
     * tips HttpServletRequest--> obj
     *
     * @Author:hihuzi 2018/6/14 14:50
     */
    <E> E parameterFillEntity(HttpServletRequest request, E e) throws Exception;

    /**
     * tips 对MAP数据装填--> 对象
     *
     * @Author:hihuzi 2018/6/14 14:50
     */
    <E> E mapFillEntity(Map map, E e) throws Exception;

    /**
     * tips List<Map> --> E --> List<E>
     *
     * @Author:hihuzi 2018/6/26 14:51
     */

    <E> List<E> listToEntity(List<Map> list, E e) throws Exception;

    /**
     * tips list<String> --> E --> list<E> 针对数据库与实体类名有区别
     *
     * @Author:hihuzi 2018/6/26 14:51
     */

    <E> List<E> listFillEntity(List<String> list, E e) throws Exception;

}
