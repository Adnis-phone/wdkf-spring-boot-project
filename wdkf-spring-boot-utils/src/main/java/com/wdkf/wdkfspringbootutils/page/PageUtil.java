package com.wdkf.wdkfspringbootutils.page;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ProjectName: lf-activity-main
 * @Package: com.encdata.lf.activity.utils
 * @ClassName: PageUtil
 * @Description: 分页工具类
 * @Author: wangdehonga
 * @Date: 2020/7/1 21:22
 * @Version: 1.0
 */
@Component
@Slf4j
public class PageUtil {
    /**
     * @param pageIDTO
     * @Method: pageInfo
     * @Description: 通用简单分页函数
     * @Return: java.util.List<T>
     * @Author: wangdehonga
     * @Date 2020/7/1 21:31
     * @Version: 1.0
     */
    public <T> PageODTO pageInfo(PageIDTO pageIDTO) throws Exception {
        PageODTO pageODTO = new PageODTO();
        //1.检验入参
        if(pageIDTO.getPageNum() == null) {
            return pageODTO;
        }
        if(pageIDTO.getPageSize() == null) {
            pageODTO.setPageNum(pageIDTO.getPageNum());
            return pageODTO;
        }
        //2.初始化入参
        Integer pageSize = pageIDTO.getPageSize();
        Integer pageNum = pageIDTO.getPageNum();
        List<T> list = pageIDTO.getList();

        if (!CollectionUtils.isEmpty(list)) {
            //3. 计算分页参数
            int start = (pageNum - 1) * pageSize;
            int end = start + pageSize;
            if (end >= list.size()) {
                end = list.size();
            }
            //4. 组装返回数据
            List<T> res = list.subList(start, end);
            pageODTO = PageODTO
                    .<T>builder()
                    .recordTotal(list.size())
                    .pageNum(pageNum)
                    .pageTotal(list.size() / pageSize + 1)
                    .list(res)
                    .size(res.size())
                    .build();
        }
        return pageODTO;
    }
}
