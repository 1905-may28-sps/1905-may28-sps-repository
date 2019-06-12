package collections;

public class SetImplementationTest {

	public static void main(String[] args) {

		Integer[] nums = {5, 1, 2, 4, 4, 4};
		SetImplementation<Integer> a = new SetImplementation<Integer>(nums);
		
		a.insert(5);
		a.insert(7);
		a.insert(5);
		a.insert(10);
		a.print();
		System.out.println("-----");
		a.remove(7);
		a.print();

	}

}
