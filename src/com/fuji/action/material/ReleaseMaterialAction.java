package com.fuji.action.material;

import java.util.List;

import org.springframework.web.struts.ActionSupport;

import com.fuji.bean.Material;
import com.fuji.service.MaterialService;
import com.sun.corba.se.impl.ior.OldPOAObjectKeyTemplate;

/**
 * 接受前端4个条件init不需要条件，查询所有素材信息 获取后端数据，返回到jsp页面
 * 
 * @author 860618058
 *
 */
public class ReleaseMaterialAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	/** 素材ID */
	private Integer id;
	
    private String bankIdOrgin;
    private String materialTypeOrgin;
    private String materialVersionOrgin;
    private String remarkOrgin;
	/** service */
	private MaterialService materialService;

	public String releaseMaterial() throws Exception {
		// 依据ID查询到对应的素材数据 bank_id,type,status=2获取当前发布数量
		Material newMaterial = new Material();
		newMaterial = materialService.findMaterialById(id);
		newMaterial.setRelease_status(2);
		//删除最老的素材版本
		List<Material> oldMaterialsStatus3 = materialService.findOldMaterialsByTypeAndBankId3(newMaterial.getBank_id(),
				newMaterial.getMaterial_type());
		if(oldMaterialsStatus3!=null&&oldMaterialsStatus3.size()>0){
			if(oldMaterialsStatus3.get(0) != null){
				materialService.removeOldMaterial(oldMaterialsStatus3.get(0));
			}
		}
		
		// 查询旧的素材信息当前发布，过去发布
		List<Material> oldMaterials = materialService.findOldMaterialsByTypeAndBankId(newMaterial.getBank_id(),
				newMaterial.getMaterial_type());
		if(oldMaterials!=null&&oldMaterials.size()>0){
			if(oldMaterials.get(0)!=null){
				newMaterial.setDeploy_machine_num(oldMaterials.get(0).getDeploy_machine_num());
			}else{
				newMaterial.setDeploy_machine_num(123);
			}
		}else{
			newMaterial.setDeploy_machine_num(123);
		}
		// 更新新的素材信息
		materialService.updateNewMaterial(newMaterial);
		// 修改旧的素材状态，还有发布数量置为0
		if(oldMaterials!=null&&oldMaterials.size()>0){
			if(oldMaterials.get(0)!=null){
				oldMaterials.get(0).setDeploy_machine_num(0);
				oldMaterials.get(0).setRelease_status(oldMaterials.get(0).getRelease_status() + 1);
				Material oldMaterial = oldMaterials.get(0);
				materialService.updateNewMaterial(oldMaterial);
			}
		}
		// 修改新的素材状态，更新发布状态，发布数量置为最新
		return "toListMaterial";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getBankIdOrgin() {
		return bankIdOrgin;
	}

	public void setBankIdOrgin(String bankIdOrgin) {
		this.bankIdOrgin = bankIdOrgin;
	}

	public String getMaterialTypeOrgin() {
		return materialTypeOrgin;
	}

	public void setMaterialTypeOrgin(String materialTypeOrgin) {
		this.materialTypeOrgin = materialTypeOrgin;
	}

	public String getMaterialVersionOrgin() {
		return materialVersionOrgin;
	}

	public void setMaterialVersionOrgin(String materialVersionOrgin) {
		this.materialVersionOrgin = materialVersionOrgin;
	}

	public String getRemarkOrgin() {
		return remarkOrgin;
	}

	public void setRemarkOrgin(String remarkOrgin) {
		this.remarkOrgin = remarkOrgin;
	}

	public MaterialService getMaterialService() {
		return materialService;
	}

	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}

}
