import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class eDriving {

	final static String path = "C:/Users/omer/Desktop/UCSC/CMPR.X416.(19) Python for Programmers/Edriving/bbb.csv";
	static List<List<String>> records = new ArrayList<>();

	static List<Employee> employeeList = new ArrayList<eDriving.Employee>();

	public static class Employee {
		public int emp_id;
		public String emp_name;
		public String gender;
		public String department;
		public String job_title;

		public String getJob_title() {
			return job_title;
		}

		public void setJob_title(String job_title) {
			this.job_title = job_title;
		}

		public Double emp_salary;

		public Employee(int emp_id, String emp_name, String gender, String department, String job_title,
				Double emp_salary) {
			this.emp_id = emp_id;
			this.emp_name = emp_name;
			this.gender = gender;
			this.department = department;
			this.job_title = job_title;
			this.emp_salary = emp_salary;
		}

		public Double getSalary() {
			return emp_salary;
		}

		public String getDepartment() {
			return department;
		}

		public String getGender() {
			return gender;
		}

		@Override
		public String toString() {
			return emp_name + " - " + emp_salary + " - " + gender;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readCSV();
		getTop10Employess();
		getHowManyDepartments();
		getAvarageSalaryPerDepartment();
		unfairnessBetweenGendersByDepartments();
		jobTitleThatAttracts();
	}

	private static void readCSV() {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if (count != 0) {
					Employee employee = new Employee(Integer.parseInt(values[0]), values[1], values[2], values[3],
							values[4], Double.parseDouble(values[5]));
					employeeList.add(employee);
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getTop10Employess() {
		System.out.println("1-TOP 10 EMPLOYEES");
		employeeList.stream().sorted((Employee o1, Employee o2) -> o2.emp_salary.compareTo(o1.emp_salary))
				.collect(Collectors.toList()).subList(0, 10).stream().forEach(System.out::println);
	}

	private static void getHowManyDepartments() {
		System.out.println(
				"2-Department count=" + employeeList.stream().map(p1 -> p1.getDepartment()).distinct().count());
	}

	private static void getAvarageSalaryPerDepartment() {
		System.out.println("3-AVARAGE SALARY PER DEPARTMENT");
		employeeList.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream().forEach(System.out::println);
	}

	private static void unfairnessBetweenGendersByDepartments() {
		System.out.println("4-UNFAIRNESS");
		Map<String, Double> map = new HashMap<String, Double>();
		Map<String, Map<String, Double>> list = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))));
		for (Map.Entry<String, Map<String, Double>> entry : list.entrySet()) {
			map.put(entry.getKey(), Math.abs(entry.getValue().get("Male") - entry.getValue().get("Female")));
		}
		System.out.println(map.entrySet().stream().max(Map.Entry.<String, Double>comparingByValue()).get().getKey());
	}

	private static void jobTitleThatAttracts() {
		System.out.println("5-JOB TITLE THAT ATTRACTS MALES MOSTLY");
		System.out.println(employeeList.stream().filter(p -> p.gender.equals("Male"))
				.collect(Collectors.groupingBy(Employee::getJob_title, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream().max(Map.Entry.<String, Double>comparingByValue()).get().getKey());

	}

}
