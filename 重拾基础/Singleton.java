public class SingleInstance
{
	//����������volatile���Σ�volatile����ԭ�Ӳ����������漰�����ֵ����ȡ��������ֵ��Ҳ����̫���   ��������ȷʵ������
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

	//ֻ�е��õ�����ڲ����ʱ��Ż��ʼ������  ��������ǿ��Խ�ʡ�ռ��
	private static class SingletonInstance
	{
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance(){
		return SingletonInstance.INSTANCE;
	}
}

//�򵥶�ʽ��������Ҫ��һ�㲻��   һ��ֻ���ϱ�����
public class Singleton
{
	pirvate Singleton(){}
	private static final Singleton singleton = new Singleton();
	public static Singleton getSingleton(){
		return singleton;
	}
}