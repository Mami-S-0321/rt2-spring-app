package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.repository.EmployeeRepository;

/**
 * 全従業員検索サービスクラス。
 * データベースから全ての従業員情報を取得し、EmployeeBeanリストとして返却します。
 * 従業員情報は従業員IDの昇順でソートされます。
 * 
 * @author SystemShared Co., Ltd.
 * @version 1.0
 * @since 1.0
 */
@Service
public class SearchAllEmployeesService {

	/**
	 * 従業員データアクセス用リポジトリ。
	 * Spring DIによって自動注入されます。
	 */
	//TODO ここに記述
	@Autowired
	EmployeeRepository employeerepository;
	/**
	 * 全従業員情報を取得します。
	 * 
	 * データベースから全ての従業員エンティティを従業員ID昇順で取得し、
	 * BeanManagerを使用してEmployeeBeanリストに変換して返却します。
	 * 
	 * @return 全従業員のEmployeeBeanリスト（従業員ID昇順）。データが存在しない場合は空のリストを返却
	 */
	//TODO ここに記述

}