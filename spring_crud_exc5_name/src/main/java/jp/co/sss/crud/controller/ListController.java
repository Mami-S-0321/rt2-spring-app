package jp.co.sss.crud.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.service.SearchAllEmployeesService;
import jp.co.sss.crud.service.SearchForEmployeesByDepartmentService;
import jp.co.sss.crud.service.SearchForEmployeesByEmpIdService;
import jp.co.sss.crud.service.SearchForEmployeesByEmpNameService;

@Controller
public class ListController {

	@Autowired
	SearchAllEmployeesService searchAllEmployeesService;

	@Autowired
	SearchForEmployeesByEmpNameService searchForEmployeesByEmpNameService;

	@Autowired
	SearchForEmployeesByDepartmentService searchForEmployeesByDepartmentService;

	@Autowired
	SearchForEmployeesByEmpIdService searchForEmployeesByEmpIdService;

	/**
	 * 社員情報を全件検索した結果を出力
	 *
	 * @param model モデル
	 * @return 遷移先のビュー
	 * @throws ParseException 
	 */
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String findAll(Model model) {

		List<EmployeeBean> allEmployeeList = searchAllEmployeesService.execute();

		model.addAttribute("employees", allEmployeeList);
		return "list/list";
	}

	/**
	 * 社員情報を社員名検索した結果を出力
	 *
	 * @param empName 検索対象の社員名
	 * @param model モデル
	 * @return 遷移先のビュー
	 * @throws ParseException 
	 */
	@RequestMapping(path = "/list/empName", method = RequestMethod.GET)
	public String findByEmpName(String empName, Model model) {

		List<EmployeeBean> searchByEmpNameList = searchForEmployeesByEmpNameService.execute(empName);
		model.addAttribute("employees", searchByEmpNameList);
		model.addAttribute("empName", empName);//検索欄に入力した値を残す記述
		return "list/list";
	}

	/**
	 * 社員情報を部署ID検索した結果を出力
	 *
	 * @param deptId 検索対象の部署ID
	 * @param model モデル
	 * @return 選先のビュー
	 * @throws ParseException 
	 */
	@RequestMapping(path = "/list/deptId", method = RequestMethod.GET)
	public String findByDeptId(Integer deptId, Model model) {

		List<EmployeeBean> searchByDepartmentList = searchForEmployeesByDepartmentService.execute(deptId);
		model.addAttribute("employees", searchByDepartmentList);
		model.addAttribute("selectedDeptId", deptId);//検索欄で指定した値を残す記述
		return "list/list";
	}

	/**
	 * 社員情報を社員ID検索した結果を出力
	 *
	 * @param empId 検索対象の社員ID
	 * @param model モデル
	 * @return 選先のビュー
	 * @throws ParseException 
	 */

	@RequestMapping(path = "/list/empId", method = RequestMethod.GET)
	public String findByEmpId(String strEmpId, Model model) {
		Integer empId;
		if (strEmpId == null || strEmpId.isEmpty()) {
			empId = null;
		} else if (strEmpId.matches("\\d+")) {
			empId = Integer.valueOf(strEmpId);
		} else {
			empId = 0;
		}

		if (empId == null) {
			return "redirect:/list";
		} else {
			EmployeeBean emp = searchForEmployeesByEmpIdService.execute(empId);
			model.addAttribute("employees", emp);
			model.addAttribute("empId", empId);//検索欄に入力した値を残す記述
			return "list/list";
		}
	}
}
