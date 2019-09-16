package nz.co.kiwiplan.exam;

import java.util.ArrayList;
import java.util.List;

import nz.co.kiwiplan.exam.entity.Employee;
import nz.co.kiwiplan.exam.util.DataUtils;

/**
 * @author <a href="mailto:cp.michael@icloud.com">Michael Panganiban</a>
 *
 */
public class Application {

	/**
	 * Displays and prints the management tree.
	 * @param employees
	 */
	public static void displayManagementTree(List<Employee> employees) {
		getManagementTree(employees)
		.forEach(System.out::println);
	}

	/**
	 * Process the given list of employees by adding an arrow before the name to show the level of
	 * hierarchy base from the manager id.
	 * @param employees
	 * @return The list of management tree.
	 */
	public static List<String> getManagementTree(List<Employee> employees) {
		DataUtils.validateEmployeeList(employees);

		List<String> output = new ArrayList<>();

		employees.forEach(
				employee -> output.add(employee.drawArrow(employees) + employee.getName())
		);

		return output;
	}

}
