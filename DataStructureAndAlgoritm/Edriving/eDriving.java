import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
		Comparator<Employee> compareBySalary = (Employee o1, Employee o2) -> o1.emp_salary.compareTo(o2.emp_salary);
		Collections.sort(employeeList, compareBySalary);
		for (int i = employeeList.size() - 1; i > employeeList.size() - 10; i--) {
			System.out.println(employeeList.get(i).emp_name + " - " + employeeList.get(i).emp_salary);
		}
	}

	
	private static void getHowManyDepartments() {
		System.out.println("2-HOW MANY DEPARTMENTS");
		HashSet<String> departments = new HashSet<String>();
		for (Employee employee : employeeList) {
			departments.add(employee.department);
		}
		System.out.println("Department count=" + departments.size());
	}

	private static void getAvarageSalaryPerDepartment() {
		/*
		 * final Map<Double, List<Employee>> salaryPerDepartment = employeeList.stream()
		 * .collect(Collectors.groupingBy(Employee::getSalary));
		 * 
		 * for(Map.Entry<Double, List<Employee>> entry:salaryPerDepartment.entrySet()) {
		 * System.out.println("Department:"+entry.getValue()+"- Salary:"+entry.getKey())
		 * ; }
		 */

		System.out.println("3-AVARAGE SALARY PER DEPARTMENT");

		Double zero = 0.0;
		HashMap<String, Integer> departments = new HashMap<String, Integer>();
		HashMap<String, Double> averageBySalary = new HashMap<String, Double>();

		for (Employee employee : employeeList) {
			int count = departments.getOrDefault(employee.department, 0);
			departments.put(employee.department, ++count);
			Double salary = averageBySalary.getOrDefault(employee.department, zero);
			averageBySalary.put(employee.department, salary + employee.emp_salary);
		}

		for (Map.Entry<String, Double> entry : averageBySalary.entrySet()) {
			int count = departments.get(entry.getKey());
			averageBySalary.put(entry.getKey(), entry.getValue() / count);
			System.out.println("Department:" + entry.getKey() + "--" + "Avarage Slary:"
					+ String.format("%.2f", entry.getValue() / count));
		}
	}

	private static void unfairnessBetweenGendersByDepartments() {
		System.out.println("4-UNFAIRNESS");
		HashMap<String, Double> unfair = new HashMap<String, Double>();
		Double zero = 0.0;

		for (Employee employee : employeeList) {
			Double subs = unfair.getOrDefault(employee.department, zero);
			if (employee.gender.equals("Male")) {
				unfair.put(employee.department, subs + employee.emp_salary);
			} else {
				unfair.put(employee.department, subs - employee.emp_salary);
			}
		}

		for (Map.Entry<String, Double> entry : unfair.entrySet()) {
			unfair.put(entry.getKey(), Math.abs(entry.getValue()));
		}
		List<Double> mapValues = new ArrayList<Double>(unfair.values());
		Collections.sort(mapValues, Collections.reverseOrder());
		for (Map.Entry<String, Double> entry : unfair.entrySet()) {
			if (entry.getValue().equals(mapValues.get(0)) || entry.getValue().equals(mapValues.get(1))) {
				System.out.println(entry.getKey());
			}
		}
	}

	private static void jobTitleThatAttracts() {
		System.out.println("5-JOB TITLE THAT ATTRACTS MALES MOSTLY");
		Map<String, Integer> attractsMale = new HashMap<String, Integer>();
		for (Employee employee : employeeList) {
			int count = attractsMale.getOrDefault(employee.job_title, 0);
			if (employee.gender.equals("Male")) {
				attractsMale.put(employee.job_title, ++count);
			}
		}
		List<Integer> mapValues = new ArrayList<Integer>(attractsMale.values());
		Collections.sort(mapValues, Collections.reverseOrder());

		for (Map.Entry<String, Integer> entry : attractsMale.entrySet()) {
			if (entry.getValue().equals(mapValues.get(0))) {
				System.out.println(entry.getKey());
			}
		}
	}

}
