package com.risk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.dao.FoodMenuDao;
import com.risk.model.FoodMenu;

@Service("foodMenuService")
@Transactional
public class FoodMenuServiceImpl implements FoodMenuService {

	@Autowired
	private FoodMenuDao foodMenuDao;
	
	@Override
	public List<FoodMenu> getFoodMenuList(){
		return foodMenuDao.getFoodMenuList();
	}

	@Override
	public void SaveFoodMenu(FoodMenu foodMenu) {
		foodMenuDao.SaveFoodMenu(foodMenu);
	}
}
