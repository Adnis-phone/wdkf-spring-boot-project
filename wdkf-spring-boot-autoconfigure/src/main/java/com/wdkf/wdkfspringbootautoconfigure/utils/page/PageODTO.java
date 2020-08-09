package com.wdkf.wdkfspringbootautoconfigure.utils.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ProjectName: lf-activity-main
 * @Package: com.wdkf.wdkfspringbootautoconfigure.dto.out
 * @ClassName: PageODTO
 * @Description: 分页信息出参列表
 * @Author: wangdehonga
 * @Date: 2020/7/2 9:07
 * @Version: 1.0
 */
@AllArgsConstructor //生成全参构造函数
@NoArgsConstructor //生成无参构造函数
@Data
@Builder
public class PageODTO<T> {

    /**
     * 记录总数
     */
    private Integer recordTotal;

    /**
     * 总页数
     */
    private Integer pageTotal;

    /**
     * 当前记录数
     */
    private Integer size;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 结果集
     */
    private List<T> list;
}
