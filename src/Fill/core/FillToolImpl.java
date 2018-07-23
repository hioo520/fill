package Fill.core;



import Fill.common.Invoke;
import Fill.constent.FillConstent;
import Fill.util.NullEmptyTool;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.*;

public class FillToolImpl {

    public Map parameterFillMapDefault(HttpServletRequest request, FillConstent fillConstent, String... str) {

        Map map = new HashMap();
        List<String> exclude = null;
        if (NullEmptyTool.isNNoE(str))
            exclude = Arrays.asList(str);
        Enumeration pars = request.getParameterNames();
        while (pars.hasMoreElements()) {
            String name = pars.nextElement().toString().trim();
            String value = request.getParameter(name);
            if (NullEmptyTool.isNNoEC(exclude)) {
                if (!exclude.contains(name)) {
                    if (NullEmptyTool.isNNoE(value)) {
                        map.put(name, value);
                    } else {
                        if (fillConstent.getValue() == 0)
                            map.put(name, value);
                    }
                }
            } else {// str=null
                if (NullEmptyTool.isNNoE(value)) {
                    map.put(name, value);
                } else {
                    if (fillConstent.getValue() == 0)
                        map.put(name, value);
                }

            }
        }
        return map;
    }


    public <E> E parameterFillEntity(HttpServletRequest request, E e, FillConstent fillConstent) throws Exception {

        Enumeration pars = request.getParameterNames();
        Class<E> clazz = (Class<E>) e.getClass();
        while (pars.hasMoreElements()) {
            String name = pars.nextElement().toString().trim();
            String value = request.getParameter(name);
            if (NullEmptyTool.isNNoE(value)) {
                Invoke.injectionParameters(e, name, value, fillConstent);
            } else {
                if (fillConstent.getValue() == 0)
                    Invoke.injectionParameters(e, name, value, fillConstent);
            }
        }
        return e;
    }

    public <E> E mapFillEntity(Map map, E e, FillConstent fillConstent) throws Exception {

        Iterator iterator = map.entrySet().iterator();
        Class<E> clazz = (Class<E>) e.getClass();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String names = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            if (NullEmptyTool.isNNoE(value, names)) {
                Invoke.injectionParameters(e, names, value, fillConstent);
            } else {
                if (fillConstent != null && fillConstent.getValue() == 0)
                    Invoke.injectionParameters(e, names, value, fillConstent);
            }
        }
        return e;
    }

    public <E> List<E> listToEntity(List<Map> list, E t, FillConstent fillConstent) throws Exception {

        List<E> result = new ArrayList<>();
        List<String> fieldsMap = new ArrayList<>();
        List<Map> entityMaps = new ArrayList<>();
        Class<E> clazz = (Class<E>) t.getClass();
        //todo 遍历所有父类子类属性
        for (; clazz != Object.class; clazz = (Class<E>) clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fieldsMap.add(fields[i].getName());
            }
        }
        for (Map map : list) {
            Iterator iterator = map.entrySet().iterator();
            Map transition = new HashMap();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String names = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                if (NullEmptyTool.isNNoE(value)) {
                    //tips name 处理大小写
                    for (String fields : fieldsMap) {
                        if (fields.toLowerCase().equalsIgnoreCase(names.replaceAll("_", "").toLowerCase())) {
                            transition.put(fields, value);
                        }
                    }
                }
            }
            entityMaps.add(transition);
        }
        for (Map map : entityMaps) {
            Object obj = t.getClass().newInstance();/*新建对象*/
            obj = mapFillEntity(map, obj, fillConstent);
            result.add((E) obj);
        }
        return result;
    }

    public <E> List<E> listFillEntity(List<String> list, E e, FillConstent fillConstent) throws Exception {

        List<E> result = new ArrayList<>();
        List<String> field = new ArrayList<>();
        List<String> fieldsMap = new ArrayList<>();
        List<Map> entityMaps = new ArrayList<>();
        Class<E> clazz = (Class<E>) e.getClass();
        //todo 遍历所有父类子类属性
        for (; clazz != Object.class; clazz = (Class<E>) clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                field.add(fields[i].getName());
            }
        }
        int i = 0;
        if (NullEmptyTool.isNNoEE(fillConstent) && NullEmptyTool.isNNoEE(fillConstent.getSort())) {
            Integer[] sort = fillConstent.getSort();
            for (Integer integer : sort) {//tips 最外层
                if (integer < field.size() && i <= field.size()) {//tips 实体 属性
                    fieldsMap.add(field.get(integer));//tips key
                } else {
                    fieldsMap.add("");
                }
                i++;
            }
        } else {//tips FillConstent 传值为空时
            fieldsMap = field;
        }

        Map transition = new HashMap();
        i = 0;
        for (String fields : fieldsMap) {//key
            if (i < list.size() && !fields.equals("")) {
                transition.put(fields, list.get(i));
                i++;
            }
        }
        entityMaps.add(transition);
        for (Map map : entityMaps) {
            Object obj = e.getClass().newInstance();/*新建对象*/
            obj = mapFillEntity(map, obj, FillConstent.SEQUENCE);
            result.add((E) obj);
        }
        return result;
    }

}
