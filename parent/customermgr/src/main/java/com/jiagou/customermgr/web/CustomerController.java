package com.jiagou.customermgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.jiagou.common.format.DateFormatHelper;
import com.jiagou.common.json.JsonHelper;
import com.jiagou.customermgr.service.ICustomerService;
import com.jiagou.customermgr.vo.CustomerModel;
import com.jiagou.customermgr.vo.CustomerQueryModel;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	private ICustomerService ics = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "customer/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm){
		cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		ics.create(cm);
		return "customer/success";
	}
	
	@RequestMapping(value="toUpdate/{customerUuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("customerUuid") int customerUuid){
		CustomerModel cm = ics.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("cm") CustomerModel cm){
		ics.update(cm);
		return "customer/success";
	}
	
	
	@RequestMapping(value="toDelete/{customerUuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("customerUuid") int customerUuid){
		CustomerModel cm = ics.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int customerUuid){
		ics.delete(customerUuid);
		return "customer/success";
	}
	
	
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CustomerWebModel wm,Model model){
		
		
		System.out.println(wm);
		CustomerQueryModel cqm = null;
		
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			cqm =  new CustomerQueryModel();
		}else{
			cqm = JsonHelper.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class);
		}
		
		cqm.setPageNum(wm.getNowPage());
		
		if(wm.getPageShow() > 0){
			cqm.setPageSize(wm.getPageShow());
		}
		
		PageInfo<CustomerModel> dbPage = ics.getByConditionPage(cqm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "customer/list";
	}
	
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "customer/query";
	}	
}
