package nz.co.kiwiplan.exam.entity;

import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:cp.michael@icloud.com">Michael Panganiban</a>
 *
 */
public class Employee {

	private int id;
	private String name;
	private int managerId;

	public int getId() { return id; }
	public Employee setId(final int id) {
		this.id = id;
		return this;
	}

	public String getName() { return name; }
	public Employee setName(final String name) {
		this.name = name;
		return this;
	}

	public int getManagerId() { return managerId; }
	public Employee setManagerId(final int managerId) {
		this.managerId = managerId;
		return this;
	}

	public Employee(final int id, final String name, final int managerId) {
		this.id = id;
		this.name = name;
		this.managerId = managerId;
	}

	public Employee() {
	}

	/**
	 * A recursive function that will add an arrow that will match the id with the manager id.
	 * By default, root manager is always have a manager id of zero.
	 * @param employees
	 * @return A string arrow.
	 */
	public String drawArrow(List<Employee> employees) {
		int rootManager = 0;
		String arrow = "->";

		if (this.managerId == rootManager) {
			return arrow;
		} else {

			return arrow + employees.stream()
					.filter(Objects::nonNull)
					.filter(employee -> employee.getId() == this.managerId)
					.findFirst()
					.orElseThrow()
					.drawArrow(employees);
		}

	}

}
