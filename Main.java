package codes;

import java.util.Scanner;

public class Main {
	
	public static Scanner input = new Scanner(System.in);
	public static LinkedList LL = new LinkedList();

	public static int numInput() {//Allows the input of a number and error traps
		int num1=0;
		boolean success=true;
		do{
			success=true;
			try{
				num1=input.nextInt();
			}
			
			catch(Exception e){
				input.nextLine();
				success=false;
			}
			
		}while(success==false);
		
		return num1;

	}
	
	public static void main(String[] args) {
		
		int menuChoice = -1;
		LL.push(1);
		LL.push(2);
		LL.push(3);
		LL.push(4);
		LL.push(5);
		LL.push(6);
		
		while(menuChoice!=0){
			
			System.out.println("0. Exit.");
			System.out.println("1. Push a number.");
			System.out.println("2. Pop a number.");
			System.out.println("3. Display the List forwards.");
			System.out.println("4. Display the List backwards.");
			System.out.println("5. Display the address of the first Node with a specified value.");
			System.out.println("6. Swap two nodes with specified values.");
			
			menuChoice = numInput();
			
			if(menuChoice==1){
				System.out.println("Please enter a number.");
				LL.push(numInput());
			}
			if(menuChoice==2)
				LL.pop();
			if(menuChoice==3){
				if(LL.getLength()<=0)
					System.out.println("The list is empty!");
				LL.display();
			}
			if(menuChoice==4){
				if(LL.getLength()<=0)
					System.out.println("The list is empty!");
				LL.displayBack();
			}
			
			if(menuChoice==5)
				System.out.println(LL.find(numInput()));
			
			if(menuChoice==6){
				LL.swap(numInput(), numInput());
			}
			
			System.out.println();
		}

	}

}
