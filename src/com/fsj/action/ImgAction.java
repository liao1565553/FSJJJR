package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Img;
import com.fsj.entity.Pager;
import com.fsj.service.ImgDAO;
import com.fsj.service.impl.ImgDAOImpl;

//图片Action动作类
public class ImgAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Img> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Img> pager = new Pager<Img>();
		ImgDAO imgdao = new ImgDAOImpl();
		pager.setRowCount(imgdao.queryAll(hql, map));// 总记录数
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getRowCount() > 0) {
			// 在session中保存
			int t1 = pager.getRowCount() % pager.getPageSize();
			int t2 = pager.getRowCount() / pager.getPageSize();
			pager.setPageCount(t1 == 0 ? t2 : t2 + 1);
		} else {
			pager.setPageCount(0);
		}
		return pager;
	}

	// 获取当前页数
	public int getPageNumber() {
		String number = request.getParameter("pageNumber");
		if (number == null) {
			return 1;
		} else {
			int pageNumber = Integer.parseInt(number); // 获得传过来的pageNumber值
			return pageNumber;
		}
	}

	// 实现查询所有图片的操作（可选查询条件：文件名称）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(iid) from Img as img where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("filename") != null
				&& request.getParameter("filename").length() > 0) {
			map.put("filename", "%" + request.getParameter("filename") + "%");
			hql.append("and img.filename like :filename ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<Img> pager = getPageCount(hql.toString(), map);
		ImgDAO imgdao = new ImgDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(imgdao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加图片操作
	public String add() throws Exception {
		Img img = new Img();
		ImgDAO imgdao = new ImgDAOImpl();
		imgdao.addImg(setAll(img));
		return "operationsuccess";
	}

	// 更新图片操作
	public String save() throws Exception {
		Img img = new Img();
		ImgDAO imgdao = new ImgDAOImpl();
		imgdao.updateImg(setAll(img));
		return "operationsuccess";
	}

	// 删除图片操作
	public String delete() {
		// 定义图片业务逻辑类的对象
		ImgDAO imgdao = new ImgDAOImpl();
		int iid = Integer.parseInt(request.getParameter("iid")); // 获得传过来的要删除图片的id值
		imgdao.deleteImg(iid);
		return "operationsuccess";
	}

	// 持久化类
	public Img setAll(Img img) throws Exception {
		return img;
	}

}
