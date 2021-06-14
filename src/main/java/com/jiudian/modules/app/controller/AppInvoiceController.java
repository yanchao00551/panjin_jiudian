package com.jiudian.modules.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.R;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.form.InvoiceForm;
import com.jiudian.modules.invoice.entity.UserInvoiceEntity;
import com.jiudian.modules.invoice.service.UserInvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/app")
@Api("发票管理接口")
public class AppInvoiceController {
	
	@Autowired
	private UserInvoiceService userInvoiceService; 

	@Login
    @PostMapping("addInvoice")
    @ApiOperation("增加发票配置")
    public R addInvoice(@RequestAttribute("userId") Integer userId, @RequestBody InvoiceForm invoiceForm) {
		int invoiceId = invoiceForm.getInvoiceId();
		UserInvoiceEntity userInvoiceEntity = null;
		if(invoiceId == 0) {
			userInvoiceEntity = new UserInvoiceEntity();
		}else {
			userInvoiceEntity = userInvoiceService.selectOne
					(new EntityWrapper<UserInvoiceEntity>().eq("invoice_id", invoiceId));
		}
		userInvoiceEntity.setIsCompany(invoiceForm.getIsCpmpany());
		userInvoiceEntity.setCompanyName(invoiceForm.getCompanyName());
		if(invoiceForm.getIsCpmpany() == 0) {//公司发票
			userInvoiceEntity.setInvoiceType(invoiceForm.getInvoiceType());
			userInvoiceEntity.setTaxpayerCode(invoiceForm.getTaxpayerCode());
			userInvoiceEntity.setSocialCreditCode(invoiceForm.getSocialCreditCode());
			userInvoiceEntity.setCompanyAddress(invoiceForm.getCompanyAddress());
			userInvoiceEntity.setTelNum(invoiceForm.getTelNum());
			userInvoiceEntity.setBank(invoiceForm.getBank());
			userInvoiceEntity.setBankAccount(invoiceForm.getBankAccount());
		}
		userInvoiceEntity.setUid(userId);
		boolean res = userInvoiceService.insertOrUpdate(userInvoiceEntity);
		return res ? R.ok() : R.error("数据添加/修改失败");
	}
	
	@Login
    @GetMapping("getInvoiceList")
    @ApiOperation("获取发票列表")
    public R getInvoiceList(@RequestAttribute("userId") Integer userId) {
		return R.ok().put("data", userInvoiceService.selectList(
				new EntityWrapper<UserInvoiceEntity>().eq("uid", userId)));
	}
	
	@Login
    @GetMapping("getInvoiceDetail")
    @ApiOperation("获取发票详细信息")
    public R getInvoiceDetail(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		return R.ok().put("data", userInvoiceService.selectOne(
				new EntityWrapper<UserInvoiceEntity>().eq("uid", userId).eq("invoice_id", params.get("invoiceId"))));
	}
	
	@Login
    @PostMapping("dropInvoice")
    @ApiOperation("删除发票配置")
    public R dropInvoice(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		return userInvoiceService.delete(new EntityWrapper<UserInvoiceEntity>()
				.eq("uid", userId).eq("invoice_id", params.get("invoiceId"))) ? R.ok() : R.error("数据删除失败");
	}
}
