package com.risk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.risk.model.FoodMenu;

@Repository("foodMenuDao")
public class FoodMenuDaoImpl extends AbstractDao<Integer, FoodMenu> implements FoodMenuDao {

	@SuppressWarnings("unchecked")
	public List<FoodMenu> getFoodMenuList() {
		Criteria criteria = createEntityCriteria();
		return (List<FoodMenu>) criteria.list();
	}

	@Override
	public void SaveFoodMenu(FoodMenu foodMenu) {
		persist(foodMenu);
	}

}
