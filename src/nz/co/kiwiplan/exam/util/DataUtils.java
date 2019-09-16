package nz.co.kiwiplan.exam.util;

import java.util.Arrays;
import java.util.List;

import nz.co.kiwiplan.exam.entity.Employee;

/**
 * @author <a href="mailto:cp.michael@icloud.com">Michael Panganiban</a>
 *
 */
public class DataUtils {

	public static List<Employee> generateFirstExample(){
		return  Arrays.asList(
				new Employee(10, "Tom", 0)
				, new Employee(2, "Mickey", 10)
				, new Employee(3, "Jerry", 10)
				, new Employee(7, "John", 2)
				, new Employee(5, "Sarah", 10)
		);
	}

	public static List<Employee> generateSecondExample(){
		return  Arrays.asList(
				new Employee(1, "Jerry", 0)
				, new Employee(2, "Philip", 1)
				, new Employee(4, "David", 2)
				, new Employee(5, "Alice", 4)
				, new Employee(6, "John", 5)
				, new Employee(7, "Mike", 4)
				, new Employee(8, "Ken", 2)
				, new Employee(9, "Peter", 8)
				, new Employee(10, "Tom", 2)
				, new Employee(3, "Stacie", 1)
		);
	}

	public static List<Employee> generateThirdExample(){
		return  Arrays.asList(
				new Employee(1, "Michael", 0)
				, new Employee(2, "Mary Rose", 0)
		);
	}

	/**
	 * Validates the employee data.
	 * @param employees
	 */
	public static void validateEmployeeList(List<Employee> employees) {

		if (employees == null || employees.isEmpty()) {
			throw new RuntimeException("Employees should not be null");
		}

		long rootManagerCount = employees.stream()
				.filter(employee -> employee.getManagerId() == 0)
				.count();

		if (rootManagerCount > 1) {
			throw new RuntimeException("Root manager should only be 1.");
		}

	}
}
