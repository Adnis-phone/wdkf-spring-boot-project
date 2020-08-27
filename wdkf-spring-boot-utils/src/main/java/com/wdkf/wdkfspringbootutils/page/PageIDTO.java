package com.wdkf.wdkfspringbootutils.page;

import com.wdkf.wdkfspringbootutils.validator.InputParamValidator;
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
public class PageIDTO<T>{

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
}