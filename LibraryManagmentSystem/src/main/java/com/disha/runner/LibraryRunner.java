package com.disha.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.disha.model.LibraryData;
import com.disha.service.LibraryService;

@Component
public class LibraryRunner implements CommandLineRunner{
	private LibraryService serv;

    @Autowired
	public LibraryRunner(LibraryService serv) {
		
		this.serv = serv;
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		do {
			System.out.println("LIBRARAY MANAGEMENT ");
			System.out.println("-------------------");
			System.out.println("Please Selct An Operation :");
			System.out.println("1.Create Book Record ");
			System.out.println("2.View All Book Records ");
			System.out.println("3.Find Book Record ");
			System.out.println("4.Update Book Record ");
			System.out.println("5.Delete Book Record ");
			System.out.println("6.Exit");
			
			
			int choice  = sc.nextInt();
			sc.nextLine();  
			switch (choice){
			case 1: 
				System.out.println("Enter Book Name :");
				String bookName = sc.nextLine();
				
				System.out.println("Enter Author Name :");
//				sc.next();
				String authorName  = sc.nextLine();
				
				System.out.println("Enter Genre :");
//				sc.next();
				String genre  = sc.nextLine();
				
				System.out.println("Enter ISBN Number :");
				int isbnNo = sc.nextInt();
				sc.nextLine();
				LibraryData l = new LibraryData(bookName, genre ,authorName, isbnNo);
				serv.save(l);
				System.out.println("Record Created Successfully !");
				break;
				
			case 2:
				List<LibraryData>list = serv.findbyALl();
				if(list.isEmpty()) {
					System.out.println("No Records Found !");
				}else {
					System.out.println("List Of Records : ");
					for(LibraryData reco:list) {
						System.out.println(reco);
					}
				}
				break;
		   
		   case 3:
			   System.out.println("Enter Book Name : ");
			   String findName = sc.next();
			   LibraryData searchedReco = serv.findbyName(findName);
			   if(searchedReco != null) {
				   System.out.println(searchedReco);
			   }
			   else {
				   System.out.println("No Records Found With Book Name "+ findName);
			   }
			   
				
			   break;
			   
		   case 4:
			   System.out.println("Enter Book Name : ");
			   String updToName = sc.next();
			   sc.nextLine(); //Consume the newline left after next()
			   LibraryData lb  = serv.findbyName(updToName); //take input from user only if the record exist
			   if(lb != null) {
				   System.out.println("Enter Book Name :");
					String upName = sc.nextLine();
					
					System.out.println("Enter Author Name :");
//					sc.next();
					String upauthorName  = sc.nextLine();
					
					System.out.println("Enter Genre :");
//					sc.next();
					String upgenre  = sc.nextLine();
					
					System.out.println("Enter ISBN Number :");
					int upisbnNo = sc.nextInt();
					 sc.nextLine();  // Consume the newline left after nextInt()
					
					lb.setBookName(upName);
					lb.setAuthorName(upauthorName);
					lb.setGenre(upgenre);
					lb.setIsbnNo(upisbnNo);
					serv.update(lb,updToName);
					System.out.println("Record Updated !");
			   }
			   else {
				   System.out.println("Record Not Found ! ");
			   }
				
			   break;
			   
		   case 5:
			  
			   System.out.println("Enter the Book Name : ");
			   String delName = sc.next();
			   int count = serv.delete(delName);
			   if(count == 0) {
				   System.out.println("Record Not Found ! ");
			   }
			   else {
				   System.out.println("Record Deleted !");
			   }
			   break;
				
				
		   case 6:
			   
			   System.out.println("Thank You...");
			   return;
			   
			default:
				System.out.println("Invalid Choice Try Again !");
			}
		}while(true);  
		
	}
		

}
