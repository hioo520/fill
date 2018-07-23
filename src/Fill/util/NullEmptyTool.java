package Fill.util;


import java.util.Collection;

/**
 * TIPS 判断是否有空的 对象 实体 集合类
 *
 * @Author:hihuzi 2018/7/19 8:59
 */

public class NullEmptyTool {

    /**
     * tips 存在一个是  "" 或"  "或 null 返回 true  原名:isNullOrEmpty
     *
     * @Author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNoE(String... strs) {

        if (strs == null) return true;
        for (String str : strs) {
            if (str == null || str.equals("") || str.trim().length() <= 0)
                return true;
        }
        return false;
    }

    /**
     * tips 不存在  "" 或"  "或 null 返回 true  原名:isNotNullOrEmpty
     * tips 存在一个是  "" 或"  "或 null 返回 false
     *
     * @Author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNNoE(String... strs) {

        return !isNoE(strs);
    }

    /**
     * tips 全都是  "" 或"  "或 null 返回 true 原名:isNullButEmpty
     *
     * @Author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNbE(String... strs) {

        int i = 0;
        for (String str : strs) {
            if (str == null || "".equals(str) || str.trim().length() <= 0)
                i++;
        }
        if (strs.length == i) {
            return true;
        } else return false;
    }

    /**
     * tips 存在一个是  "" 或"  "或 null 返回 true 原名:isNotNullButEmpty
     *
     * @Author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNNbE(String... strs) {

        return !isNbE(strs);
    }

    /**
     * tips 存在一个是  null 或size 为0 返回 true 原名:isNullOrEmptyCollections
     *
     * @Author:hihuzi 2018/5/8 15:36
     */
    public static <E> Boolean isNoEC(Collection<E>... collections) {

        for (Collection<E> c : collections) {
            if (c == null || c.size() == 0)
                return true;
        }
        return false;
    }

    /**
     * tips 全部不是  null 或size=0 返回 true  原名:isNotNullOrEmptyCollections
     * tips 存在一个是  null 或size=0 返回 false
     *
     * @Author:hihuzi 2018/7/7 8:37
     */
    public static <E> Boolean isNNoEC(Collection<E>... collections) {

        return !isNoEC(collections);
    }

    /**
     * tips t 存在一个是  null  返回 true   原名:isNullOrEmptyEntrty
     *
     * @Author:hihuzi 2018/5/10 15:07
     */
    public static <E> Boolean isNoEE(E... e) {

        if (e == null)
            return true;
        for (E c : e) {
            if (c == null || e.length == 0)
                return true;
        }
        return false;
    }

    /**
     * tips e 存在一个是  null  返回 flase  原名:isNotNullOrEmptyEntrty
     * e 全都不是 null 返回 true
     *
     * @Author:hihuzi 2018/5/10 15:07
     */
    public static <E> Boolean isNNoEE(E... e) {

        return !isNoEE(e);
    }


}
