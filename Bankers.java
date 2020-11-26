import java.util.*;
import java.lang.*;

class BankersAlgorithm{
	public int maxResources,allocatedResources;
	public void display(int arr[][],int numP,int numR){
		for (int i=0;i<numP;i++)
		{
			for (int j=0;j<numR;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	// void isSafe() 
    // { 
	// 	int count=0; 
		
	// 	//visited array to find the already allocated process 
	// 	boolean visited[] = new boolean[n];  
	// 	for (int i = 0;i < n; i++) 
	// 	{ 
	// 		visited[i] = false; 
	// 	} 
			
	// 	//work array to store the copy of available resources 
	// 	int work[] = new int[m];     
	// 	for (int i = 0;i < m; i++) 
	// 	{ 
	// 		work[i] = avail[i]; 
	// 	} 
	
	// 	while (count<n) 
	// 	{ 
	// 		boolean flag = false; 
	// 		for (int i = 0;i < n; i++) 
	// 		{ 
	// 			if (visited[i] == false) 
	// 			{ 
	// 			int j; 
	// 			for (j = 0;j < m; j++) 
	// 			{         
	// 				if (need[i][j] > work[j]) 
	// 				break; 
	// 			} 
	// 			if (j == m) 
	// 			{ 
	// 			safeSequence[count++]=i; 
	// 			visited[i]=true; 
	// 			flag=true; 
							
	// 				for (j = 0;j < m; j++) 
	// 				{ 
	// 				work[j] = work[j]+alloc[i][j]; 
	// 				} 
	// 			} 
	// 			} 
	// 		} 
	// 		if (flag == false) 
	// 		{ 
	// 			break; 
	// 		} 
	// 	} 
	// 	if (count < n) 
	// 	{ 
	// 		System.out.println("The System is UnSafe!"); 
	// 	} 
	// 	else
	// 	{ 
	// 		//System.out.println("The given System is Safe"); 
	// 		System.out.println("Following is the SAFE Sequence"); 
	// 				for (int i = 0;i < n; i++) 
	// 		{ 
	// 			System.out.print("P" + safeSequence[i]); 
	// 			if (i != n-1) 
	// 			System.out.print(" -> "); 
	// 		} 
	// 	} 
    // } 
}
public class Bankers {
	
	public static void main(String[] args) {
		int numProcess,numResources,cnt=0;
		int[][] maxArray,allocationArray,needArray,availableArray;

		int[] safeSequence;
		System.out.println("Enter number of processes in memory");
		Scanner sc=new Scanner(System.in);
		numProcess=sc.nextInt();
		System.out.println("Enter number of resources");
		numResources=sc.nextInt();
		maxArray=new int[numProcess][numResources];
		allocationArray=new int[numProcess][numResources];
		needArray=new int[numProcess][numResources];
		availableArray=new int[1][numResources];
		safeSequence=new int[numProcess];
		// System.out.println("Enter maximum resources required for each process for "+numResources+" resources.");
		for (int i=0;i<numProcess;i++)
		{
			System.out.println("Enter maximum resources required for process p"+(i+1));
			for (int j=0;j<numResources;j++)
			{

				maxArray[i][j]=sc.nextInt();
			}
		}
		for (int i=0;i<numProcess;i++)
		{
			System.out.println("Enter allocated resources required for process p"+(i+1));
			for (int j=0;j<numResources;j++)
			{
				allocationArray[i][j]=sc.nextInt();
			}
		}
		for (int i=0;i<numProcess;i++)
		{
			//System.out.println("Enter allocated resources required for process p"+(i+1));
			for (int j=0;j<numResources;j++)
			{
				needArray[i][j]=maxArray[i][j]-allocationArray[i][j];
			}
		}
		System.out.println("Enter available matrix :");
		for (int i=0;i<numResources;i++) 
		{
			availableArray[0][i]=sc.nextInt();
		}

		BankersAlgorithm b=new BankersAlgorithm();

		int count=0; 
		
		//visited array to find the already allocated process 
		boolean visited[] = new boolean[numProcess];  
		for (int i = 0;i < numProcess; i++) 
		{ 
			visited[i] = false; 
		} 
			
		//work array to store the copy of available resources 
		int work[] = new int[numResources];     
		for (int i = 0;i < numResources; i++) 
		{ 
			work[i] = availableArray[0][i]; 
		} 
	
		while (count<numProcess) 
		{ 
			boolean flag = false; 
			for (int i = 0;i < numProcess; i++) 
			{ 
				if (visited[i] == false) 
				{ 
					int j; 
					for (j = 0;j < numResources; j++) 
					{         
						if (needArray[i][j] > work[j]) 
						break; 
					} 
					if (j == numResources) 
					{ 
						safeSequence[count++]=i; 
						visited[i]=true; 
						flag=true; 
								
						for (j = 0;j < numResources; j++) 
						{ 
							work[j] = work[j]+allocationArray[i][j]; 
						} 
					} 
				} 
			} 
			if (flag == false) 
			{ 
				break; 
			} 
		} 
		if (count < numProcess) 
		{ 
			System.out.println("The System is UnSafe!"); 
		} 
		else
		{ 
			//System.out.println("The given System is Safe"); 
			System.out.println("Following is the SAFE Sequence"); 
					for (int i = 0;i < numProcess; i++) 
			{ 
				System.out.print("P" + safeSequence[i]); 
				if (i != numProcess-1) 
				System.out.print(" -> "); 
			} 
		} 

	}	
}