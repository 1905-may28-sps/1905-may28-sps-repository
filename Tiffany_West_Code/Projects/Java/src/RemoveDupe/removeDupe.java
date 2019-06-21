package RemoveDupe;

public class removeDupe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "BBBeeyoooonnnnceee";
		System.out.println(input.replaceAll("(.)\\1{1,}", "$1"));

	}

}
