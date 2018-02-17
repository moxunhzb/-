package com.jqueryajax.dao.impl;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jqueryajax.dao.BaseDao;
import com.jqueryajax.entity.City;
import com.jqueryajax.entity.Province;

public class ProvinceDaoImpl  extends BaseDao{
	 public List<Province> getAllProvince() {
	        List<Province> list = new ArrayList<Province>();
	        String sql="select * from province";
	        rs = this.execQuery(sql, null);
	        try {
	            while(rs.next()){
	                Province province = new Province();
	                province.setProvinceId(rs.getInt("provinceId"));
	                province.setProvinceName(rs.getString("provinceName"));
	                list.add(province);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            this.closeAll();
	        }
	        return list;
	    }

	    public List<City> getCitiesByProvinceId(int provinceId) {
	        List<City> list = new ArrayList<City>(); 
	        String sql="select * from city where provinceId="+provinceId;
	        rs = this.execQuery(sql, null);
	        try {
	            while(rs.next()){
	                City city = new City();
	                city.setCityId(rs.getInt("cityId"));
	                city.setCityName(rs.getString("cityName"));
	                city.setPersonSize(rs.getInt("personSize"));
	                city.setCityArea(rs.getInt("cityArea"));
	                city.setPlace(rs.getString("place"));
	                city.setProvinceId(rs.getInt("provinceId"));
	                list.add(city);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            this.closeAll();
	        }
	        return list;
	    }

}
