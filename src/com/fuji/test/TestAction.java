/**
 * 
 */
package com.fuji.test;

import com.fuji.action.material.ReleaseMaterialAction;
import com.fuji.bean.Material;

/**
 * @author 860618058
 *
 */
public class TestAction {
	
	/**
	 * 测试后台数据
	 */
	public static void main(String[] args) {
		Material m = new Material();
		ReleaseMaterialAction mrAction = new ReleaseMaterialAction();
		
		try {
			mrAction.releaseMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
