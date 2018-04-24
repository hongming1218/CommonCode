public class SingleInstance
{
	//这里可以添加volatile修饰，volatile属于原子操作，就是涉及到这个值都是取变量最后的值，也不是太清楚   但是这里确实可以用
	private static SingleInstance singleInstance = null ;

	private SingleInstace(){}

	public static SingleInstance getInstance(){
		if (singleInstance == null)
		{
			synchronized (SingleInstance.class)
			{
				if (singleInstance == null)
				{
					sinleInstance = new SingleInstance();
				}
			
			}
		}

		return sinleInstance;
	} 
}


public class Singleton
{
	
	private Singleton(){}

	//只有调用到这个内部类的时候才会初始化变量  所以这个是可以节省空间的
	private static class SingletonInstance
	{
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance(){
		return SingletonInstance.INSTANCE;
	}
}

//简单恶汉式，面试需要，一般不用   一般只用上边两个
public class Singleton
{
	pirvate Singleton(){}
	private static final Singleton singleton = new Singleton();
	public static Singleton getSingleton(){
		return singleton;
	}
}