package streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;


public class Test {
	public static void main(String[] args) {
		
		List<String> A = Stream.of("a","c","b").collect(Collectors.toList());
 		for (int i = 0; i < A.size(); i++) {
			System.out.println(A.get(i));
		}
		//A.stream().forEach(a -> System.out.print(a));
		
		System.out.println("------------------");
		List<String> B = Stream.of("f","D","G").collect(Collectors.toList());
		
		//A 和  B 合并
		List<String> C =Stream.of(A,B).flatMap(n -> n.stream()).collect(Collectors.toList());
		
		//C.stream().forEach(c -> System.out.println(c));
		// 去除空集合
		List<String> D = Arrays.asList("aaa"," ","","sd"," asd");
		List<String> result =D.stream().filter(a -> StringUtils.isNotBlank(a)).collect(Collectors.toList());
		result.stream().forEach(System.out::println);
		
		System.out.println("------------------");
		//空字符串的数量
		int num = (int) D.stream().filter(string -> StringUtils.isBlank(string)).count();
		//System.out.println(num);
		
		 List<Integer> list = Arrays.asList(1,3,2,6,8,3,9);
		Optional<Integer> max = list.stream().max(Integer::compareTo);
		Optional<Integer> max1 = list.stream().max(Integer::compare);
		 System.out.println(max.get());
		 System.out.println(max1.get());

	}
}
