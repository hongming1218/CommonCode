class Sort
{
	
	public void bubbleSort(int a[]  ){
		for(int i = 0; i < a.length ; i++){
			for(int j = 0; j < a.length-i ; j++){
				if (a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}


	public void selectSort(int a[]){
		for(int i = 0 ; i < a.length ; i++){
			int k = i ;
			for (int j = i+1 ; j < a.length ; j++ )
			{
				if (a[k] > a[j])
				{
					k = j;
				}
			}
			int temp = a[k];
			a[k] = a[i];
			a[i] = a[j];
		}
	}


	public void quickSort(int a[]){
	
	}



}