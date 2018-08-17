package com.jdk;

/**
 * @author: wj
 * @version: v1
 * @date:2018年8月7日 下午3:45:34
 * @description:枚举类学习
 */
public class EnumTest {

	/**
	 * Enum定义枚举类型
	 */
	enum Days {
		Monday, Tuesday, Thursday, Wednesday, Friday, Saturday, Sunday;
	}
	
	/**
	 * Enum类可以添加方法和构造函数
	 */
	enum Day2{
		Monday("星期一"),Tuesday("星期二"), Thursday("星期三"), Wednesday("星期四"), 
		Friday("星期五"), Saturday("星期六"), Sunday("星期天");
		private String desc;
		private Day2(String desc){
			this.desc=desc;
		}
		public String getDesc(){
			return this.desc;
		}
	}
	
	/**
	 * Enum类中可以包含abstract方法，表示成员必须实现该方法
	 */
	enum Day3{
		Monday{
			@Override
			public String getInfo() {
				return "星期一";
			}
		},
		TuesDay{
			@Override
			public String getInfo(){
				return "星期二";
			}
		};
		
		public abstract String getInfo();
	}
	
	/**
	 * Enum类不能继承类，但是可以实现接口
	 */
	interface Weather{
		String getWeather();
	}
	enum Day4 implements Weather{
		Monday, Tuesday, Thursday, Wednesday, Friday, Saturday, Sunday;
		@Override
		public String getWeather() {
			// TODO Auto-generated method stub
			return null;
		} 
	}
	
	/**
	 * 对一组数据进行分类，比如进行食物菜单分类而且希望这些菜单都属于food类型，appetizer(开胃菜)、mainCourse(主菜)、
	 * dessert(点心)、Coffee等，每种分类下有多种具体的菜式或食品，此时可以利用接口来组织
	 */
	public interface Food {
		  enum Appetizer implements Food {
		    SALAD, SOUP, SPRING_ROLLS;
		  }
		  enum MainCourse implements Food {
		    LASAGNE, BURRITO, PAD_THAI,LENTILS, HUMMOUS, VINDALOO;
		  }
		  enum Dessert implements Food {
		    TIRAMISU, GELATO, BLACK_FOREST_CAKE,FRUIT, CREME_CARAMEL;
		  }
		  enum Coffee implements Food {
		    BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,LATTE, CAPPUCCINO, TEA, HERB_TEA;
		  }
	}
	
	public static void main(String[] args) {
		for(Day2 day :Day2.values()){
			System.out.println(day.name()+"------desc:"+day.getDesc());
		}
		
		Days[] days = { Days.Monday, Days.Tuesday, Days.Sunday };

		for (int i = 0; i < days.length; i++) {
			System.out.println("day[" + i + "].ordinal():" + days[i].ordinal());
		}
		
		System.out.println("-------------------------------------");
		
		// 通过compareTo方法比较,实际上其内部是通过ordinal()值比较的
		System.out.println("days[0].compareTo(days[1]):" + days[0].compareTo(days[1]));
		System.out.println("days[0].compareTo(days[2]):" + days[0].compareTo(days[2]));
		
		//获取该枚举对象的Class对象引用,当然也可以通过getClass方法
        Class<?> clazz = days[0].getDeclaringClass();
        System.out.println("clazz:"+clazz);

        System.out.println("-------------------------------------");

        //name()
        System.out.println("days[0].name():"+days[0].name());
        System.out.println("days[1].name():"+days[1].name());
        System.out.println("days[2].name():"+days[2].name());

        System.out.println("-------------------------------------");

        System.out.println("days[0].toString():"+days[0].toString());
        System.out.println("days[1].toString():"+days[1].toString());
        System.out.println("days[2].toString():"+days[2].toString());

        System.out.println("-------------------------------------");

        Days d=Enum.valueOf(Days.class,days[0].name());
        Days d2=Days.valueOf(Days.class,days[0].name());
        System.out.println("d:"+d);
        System.out.println("d2:"+d2);
	}
}
