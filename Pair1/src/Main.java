
public class Main {

	public static void main(String[] args) {
		
		Employee employee = new Employee(1, "doruk", "abc", "istanbul");
		Employee employee2 = new Employee(1, "doruk", "abc", "ankara");
		Employee employee3 = new Employee(1, "doruk", "abc", "izmir"
				+ "");
		MyList<Object> list = new MyList<Object>();
		
		list.add(employee.getCity());
		list.add(employee2.getCity());
		list.add(employee3.getCity());
		list.list();
		
		System.out.println(list.contains("istanbul"));
		list.remove(employee.getCity());
		list.remove(0);
		list.list();

	}

}
