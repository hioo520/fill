package Fill;


import Fill.bean.FillBean;
import Fill.constent.FillConstent;
import Fill.core.FillTool;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.*;

/**
 * tips
 *
 * @Author:hihuzi 2018/7/23 9:21
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:test.xml"})
public class FillFactoryTest {

    private MockHttpServletRequest request;

    private FillFactory fillTool;

    @Before
    public void setUp() {

        request = new MockHttpServletRequest();
        request.setCharacterEncoding("utf-8");
        fillTool = (FillFactory) new FillTool();
    }

    /**
     * tips HttpServletRequest-->MAP
     * 默认 方法一 保存空值
     *
     * @Author:hihuzi 2018/6/14 14:51
     */
    @Test
    public void parameterFillMap() {

        FillBean bean = new FillBean();
        request.setParameter("iinteger", "123456");
        request.setParameter("sstring", "你好师姐!!!");
        request.setParameter("llong", "12.3");
        request.setParameter("iint", "   ");
        request.setParameter("ddouble", "");
        Map map = FillFactory.batch().parameterFillMap(request);
        System.out.println(Arrays.asList(map).toString());


    }

    /**
     * tips HttpServletRequest-->MAP
     * 方法二 保存空值 并且舍弃str特定字段
     *
     * @Author:hihuzi 2018/7/23 15:05
     */
    @Test
    public void parameterFillMap1() {

        request.setParameter("iinteger", "123456");
        request.setParameter("sstring", "你好师姐!!!");
        request.setParameter("llong", "1.238");
        request.setParameter("ddouble", "");
        Map map = FillFactory.batch().parameterFillMap(request, "llong");
        System.out.println(Arrays.asList(map).toString());
    }

    /**
     * tips HttpServletRequest-->MAP
     * 方法三 是否舍弃空值 并且舍弃str特定字段(默认舍弃空值)
     * 方法四 是否舍弃空值 并且舍弃str特定字段(默认保存空值)
     *
     * @Author:hihuzi 2018/7/23 15:05
     */
    @Test
    public void parameterFillMap2() {

        request.setParameter("iinteger", "123456");
        request.setParameter("sstring", "你好师姐!!!");
        request.setParameter("llong", "1.238");
        request.setParameter("iint", "  ");
        Map map1 = FillFactory.batch().parameterFillMap(request, FillConstent.NullWhetherSave);
        Map map = FillFactory.batch().parameterFillMap(request, FillConstent.NullWhetherSave.setValue(1), "sstring");
        Map map0 = FillFactory.batch().parameterFillMap(request, "llong");
        System.out.println(Arrays.asList(map1).toString());
        System.out.println(Arrays.asList(map).toString());
        System.out.println(Arrays.asList(map0).toString());
    }

    /**
     * tips HttpServletRequest--> obj
     *
     * @Author:hihuzi 2018/6/14 14:50
     */
    @Test
    public void parameterFillEntity() throws Exception {

        request.setParameter("iinteger", "123456");
        request.setParameter("sstring", "你好师姐!!!");
        request.setParameter("iint", "  ");
        request.setParameter("ddouble", "3.55");
        request.setParameter("ddate", "2012-12-12");
        request.setParameter("bbigDecimal", "9825485.61551");
        request.setParameter("llong", "132542435");
        request.setParameter("ffloat", "12.99");
        request.setParameter("sshort", "129");
        request.setParameter("bboolean", "true");
        request.setParameter("bbyte", "1");
        request.setParameter("bbyte", "2");
        request.setParameter("ssshort", "5");
        request.setParameter("iint", "55");
        request.setParameter("lllong", "555");
        request.setParameter("fffloat", "0.9");
        request.setParameter("dddouble", "1.94");
        request.setParameter("bbboolean", "true");
        request.setParameter("cchar", "a");
        FillBean map1 = FillFactory.batch().parameterFillEntity(request, new FillBean());
        System.out.println(Arrays.asList(map1).toString());
    }

    @Test
    public void mapFillEntity() throws Exception {

        Map map = new HashMap();
        map.put("iinteger", "123456");
        map.put("sstring", "你好师姐!!!");
        map.put("iint", "  ");
        map.put("ddouble", "3.55");
        map.put("ddate", "2012-12-12");
        map.put("bbigDecimal", "9825485.61551");
        map.put("llong", "132542435");
        map.put("ffloat", "12.99");
        map.put("sshort", "129");
        map.put("bboolean", "true");
        map.put("bbyte", "1");
        map.put("bbyte", "2");
        map.put("ssshort", "5");
        map.put("iint", "55");
        map.put("lllong", "555");
        map.put("fffloat", "0.9");
        map.put("dddouble", "1.94");
        map.put("bbboolean", "true");
        map.put("cchar", "a");
        FillBean bean = FillFactory.batch().mapFillEntity(map, new FillBean());
        System.out.println(bean.toString());
    }

    /**
     * tips List<Map> --> E --> List<E>
     *
     * @Author:hihuzi 2018/6/26 14:51
     */
    @Test
    public void listToEntity() throws Exception {

        List list = new ArrayList();
        Map map = new HashMap();
        map.put("iinteger", "123456");
        map.put("sstring", "你好师姐!!!");
        map.put("iint", "  ");
        map.put("ddouble", "3.55");
        map.put("ddate", "2012-12-12");
        map.put("bbigDecimal", "9825485.61551");
        map.put("llong", "132542435");
        map.put("ffloat", "12.99");
        map.put("sshort", "129");
        map.put("bboolean", "true");
        map.put("bbyte", "1");
        map.put("bbyte", "2");
        map.put("ssshort", "5");
        map.put("iint", "55");
        map.put("lllong", "555");
        map.put("fffloat", "0.9");
        map.put("dddouble", "1.94");
        map.put("bbboolean", "true");
        map.put("cchar", "a");
        list.add(map);
        Map map0 = new HashMap();
        map.put("iinteger", "123456");
        map.put("sstring", "你好师姐!!!");
        map.put("iint", "  ");
        map.put("ddouble", "3.55");
        map.put("ddate", "2012-12-12");
        map.put("bbigDecimal", "9825485.61551");
        map.put("llong", "132542435");
        map.put("ffloat", "12.99");
        map.put("sshort", "129");
        map.put("bboolean", "true");
        map.put("bbyte", "1");
        map.put("bbyte", "2");
        map.put("ssshort", "5");
        map.put("iint", "55");
        map.put("lllong", "555");
        map.put("fffloat", "0.9");
        map.put("dddouble", "1.94");
        map.put("bbboolean", "true");
        map.put("cchar", "a");
        list.add(map0);
        List<FillBean> bean = FillFactory.batch().listToEntity(list, new FillBean());
        System.out.println(bean.get(0).toString());
    }

    /**
     * tips list<String> --> E --> list<E> 针对数据库与实体类名有区别
     *
     * @Author:hihuzi 2018/6/26 14:51
     */

    @Test
    public void listFillEntity() throws Exception {

        List list = new ArrayList();
        list.add("123456");
        list.add("你好师姐!!!");
        list.add("3.1415926");
        list.add("2012-12-12");
        list.add("3.557897");
        list.add("951");
        list.add("15");
        list.add("12");
        list.add("true");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("55");
        list.add("555");
        list.add("0.9");
        list.add("true");
        list.add("B");
        List<FillBean> bean = FillFactory.batch().listFillEntity(list, new FillBean());
        System.out.println(bean.get(0).toString());
    }

}