package com.risk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.risk.model.FoodMenu;
import com.risk.model.OrderDetail;
import com.risk.service.FoodMenuService;
import com.risk.service.OrderDetailService;

@Controller
public class OrderController {

	@Autowired
	FoodMenuService foodMenuService;

	@Autowired
	OrderDetailService orderDetailService;

	@Qualifier(value = "orderDetailService")
	public void setPersonService(OrderDetailService ods) {
		this.orderDetailService = ods;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String listOrders(Model model) {
		model.addAttribute("order", new OrderDetail());

		List<FoodMenu> FoodMenuList = foodMenuService.getMenuList();
		model.addAttribute("FoodMenu", FoodMenuList);
		List<OrderDetail> orderDetailsList = orderDetailService.getOrderDetailList();
		model.addAttribute("orderList", orderDetailsList);
		return "order";
	}

	@RequestMapping("/success")
	public ModelAndView success(@Valid @ModelAttribute("order") OrderDetail orderDetail, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		// setters
		orderDetail.setCustomerId(001);
		// orderDetails.setId(4);
		orderDetail.setAmount(orderDetail.getFoodItemPrice() * orderDetail.getQuantity());
		if (orderDetail.getComment() == "") {
			orderDetail.setComment("____________");
		}
//			orderDetails.setFoodItemId();
		orderDetailService.SaveOrderDetail(orderDetail);

		mav.setViewName("redirect:/");
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		OrderDetail orderDetail = orderDetailService.findById(id);
		orderDetailService.deleteOrderDetail(orderDetail);
		return "redirect:/";
	}

	@RequestMapping("/bill")
	public String goToBillPage() {
		return "bill";
	}

}
