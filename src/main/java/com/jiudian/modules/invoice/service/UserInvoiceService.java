package com.jiudian.modules.invoice.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.invoice.entity.UserInvoiceEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-09-29 15:29:06
 */
public interface UserInvoiceService extends IService<UserInvoiceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

