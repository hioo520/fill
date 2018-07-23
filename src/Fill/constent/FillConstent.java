package Fill.constent;



import Fill.util.DateTool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum FillConstent {
    Default(0),// tips 默认
    NullWhetherSave(0) {Boolean whetherSave = true;},// tips 默认 0 表示保存 1 舍弃
    DeleteSpecificFields(0) {Boolean DeleteFields = true;Boolean whetherSave = true;},// tips 增加还是删除特定字段 true 删  false 不删
    SEQUENCE(0) {Integer[] sort;SimpleDateFormat simpleDateFormat;};//tips 排序

    private Integer value;

    private SimpleDateFormat format;

    private Integer[] sort = null;

    public Date getFormat(String date) throws ParseException {

        return DateTool.parse(date);
    }

    public FillConstent setFormat(SimpleDateFormat format) {

        this.format = format;
        return this;
    }


    FillConstent(Integer value) {

        this.value = value;
    }

    public Integer getValue() {

        return value;
    }

    public FillConstent setValue(Integer value) {

        this.value = value;
        return this;
    }

    public SimpleDateFormat getFormat() {

        return format;
    }

    public Integer[] getSort() {

        return sort;
    }

    public void setSort(Integer[] sort) {

        this.sort = sort;
    }
}
