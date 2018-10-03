import java.util.ArrayList;
import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		
		List<User> list=new ArrayList<>();
		
		list.add(new User("zhangsan ",18));
		
		System.out.println(list.toString());
	}
}
