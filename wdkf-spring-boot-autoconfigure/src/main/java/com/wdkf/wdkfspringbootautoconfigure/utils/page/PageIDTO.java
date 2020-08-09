package com.wdkf.wdkfspringbootautoconfigure.utils.page;

import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.MyException;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import com.wdkf.wdkfspringbootautoconfigure.utils.validator.InputParamValidator;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName: PageIDTO
 * @Author: nibohui
 * @Description:分页实体入参
 * @Date: 2020/02/10
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@Builder
public class PageIDTO<T> implements InputParamValidator {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页记录条数
     */
    private Integer pageSize;

    /**
     * 查询记录
     */
    private List<T> list;

    @Override
    public void validate() {
        if (pageNum == null || pageNum <= 0) {
            throw new MyException(ReturnMsg.ENTRY_PARAMETER_ISEMPTY);
        }
        if (pageSize == null || pageSize <= 0) {
            throw new MyException(ReturnMsg.ENTRY_PARAMETER_ISEMPTY);
        }
    }
}