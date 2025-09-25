package jp.co.sss.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	/**
	 * 社員IDとパスワードに一致した社員を検索する
	 * 
	 * @param empId
	 * @param empPass
	 * @return
	 */
	Employee findByEmpIdAndEmpPass(Integer empId, String empPass);

	/**
	 * 社員一覧(社員IDで並び替え)
	 * 
	 * @return 全社員リスト
	 */
	List<Employee> findAllByOrderByEmpId();

	/**
	 * 社員名検索(社員IDで並び替え)
	 * 
	 * @param empName
	 * @return 社員名検索後のリスト
	 */
	List<Employee> findByEmpNameContainingOrderByEmpId(String empName);

	/**
	 * 部署ID検索(社員IDで並び替え)
	 * 
	 * @param deptId
	 * @return 検索後のリスト
	 */
	List<Employee> findByDepartmentOrderByEmpId(Department department);
	
	/**
	 * 社員ID検索(社員IDで完全一致)
	 * 
	 * @param empId
	 * @return 検索後のリスト
	 */
	Employee findByEmpId(Integer empId);


}
