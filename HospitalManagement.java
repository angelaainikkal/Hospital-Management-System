package HospitalManagement;
import java.util.*;
import java.util.Calendar;
import java.util.ArrayList;
//Use of Abstraction
abstract class hospital{
	abstract void new_ent();
	abstract void get_info();
}
//Using Inheritance.
class staff extends hospital
{
String staffid, staffname, designation, gender;
int salary;
void new_ent()
{
Scanner input = new Scanner(System.in);
System.out.print("Enter ID : ");
staffid = input.nextLine();
System.out.print("Enter Name : ");
staffname = input.nextLine();
System.out.print("Enter Designation : ");
designation = input.nextLine();
System.out.print("Enter Gender : ");
gender = input.nextLine();
System.out.print("Enter Salary : ");
salary = input.nextInt();
}
void get_info()
{ 
	System.out.printf("%-5s %-10s %-10s %-7s\n", staffid, staffname, gender, salary);
}
}
class doctor extends hospital
{
String doctorid, doctorname, specialisation, worktime, qualifications;
int roomno;
void new_ent()
{
	//Accepting details from user
Scanner input = new Scanner(System.in);
System.out.print("Enter ID : ");
doctorid = input.nextLine();
System.out.print("Enter Name : ");
doctorname = input.nextLine();
System.out.print("Enter Specialization : ");
specialisation = input.nextLine();
System.out.print("Enter work time : ");
worktime = input.nextLine();
System.out.print("Enter Qualification : ");
qualifications = input.nextLine();
System.out.print("Enter Room No. : ");
roomno = input.nextInt();
}
void get_info()
{
System.out.printf("%-5s %-15s %-15s %-15s %-15s %-5s\n", doctorid, doctorname, specialisation, worktime, qualifications, roomno);
}
}
class patient extends hospital
{
String patientid, patientname, illness, gender, hospitalization;
int patientage;
void new_ent()
{
Scanner input = new Scanner(System.in);
System.out.print("Enter ID : ");
patientid = input.nextLine();
System.out.print("Enter Name : ");
patientname = input.nextLine();
System.out.print("Enter Name of illness : ");
illness = input.nextLine();
System.out.print("Enter Gender : ");
gender = input.nextLine();
System.out.print("Admit Status (Y/N) : ");
hospitalization = input.nextLine();
System.out.print("Enter Age : ");
patientage = input.nextInt();
}
void get_info()
{
	
	System.out.printf("%-5s %-15s %-15s %-10s %-15s %-5s\n", patientid, patientname, illness, gender,        hospitalization, patientage);
}
}
class medical extends hospital
{
String drugname, drugcompany, expiry;
int drugcost, count;
void new_ent() {
Scanner input = new Scanner(System.in);
System.out.print("Enter Name of Medicine : ");
drugname = input.nextLine();
System.out.print("Enter Company name of Medicine : ");
drugcompany = input.nextLine();
System.out.print("Enter Expiry Date : ");
expiry = input.nextLine();
// Loop until a non-zero cost is entered
while (true) {
   System.out.print("Enter Cost per unit : ");
   drugcost = input.nextInt();
   if (drugcost != 0) {
       break; // Exit the loop if cost is non-zero
   } else {
       System.out.println("Cost cannot be zero. Please enter a valid cost.");
       // Consume the newline character left in the input buffer
       input.nextLine();
   }
}
System.out.print("Enter No. of Units : ");
count = input.nextInt();
}
void get_info()
{
	System.out.printf("%-10s %-15s %-15s %-10s\n", drugname, drugcompany, expiry, drugcost);
}
}
class lab extends hospital
{
String labservice;
int service_cost;
void new_ent() {
Scanner input = new Scanner(System.in);
System.out.print("Enter Name of Test : ");
labservice = input.nextLine();
// Loop until a non-zero cost is entered
while (true) {
   System.out.print("Enter Cost of Test : ");
   service_cost = input.nextInt();
   if (service_cost != 0) {
       break; // Exit the loop if cost is non-zero
   } else {
       System.out.println("Cost cannot be zero. Please enter a valid cost.");
       // Consume the newline character left in the input buffer
       input.nextLine();
   }
}
}
void get_info()
{
	System.out.printf("%-15s %-5s\n", labservice, service_cost);
}
}
class facility extends hospital
{
String hospital_fac;
void new_ent()
{
Scanner input = new Scanner(System.in);
System.out.print("Enter Facility Name : ");
hospital_fac = input.nextLine();
}
void get_info()
{
System.out.println(hospital_fac);
}
}
public class HospitalManagement
{     //Creating ArrayList for things to be displayed in bill
	 static ArrayList<Integer> bill=new ArrayList<Integer>();
	 static ArrayList<Integer> medcost=new ArrayList<Integer>();
	 static ArrayList<String> med=new ArrayList<String>();
	 static  ArrayList<String> lab1=new ArrayList<String>();
	 static  ArrayList<Integer> medquant=new ArrayList<Integer>();
	 static ArrayList<Integer> testnos=new  ArrayList<Integer>();
	
public static void main(String args[])
{
	  Scanner input=new Scanner(System.in);
String months[] = {
  "Jan",
  "Feb",
  "Mar",
  "Apr",
  "May",
  "Jun",
  "Jul",
  "Aug",
  "Sep",
  "Oct",
  "Nov",
  "Dec"
};
Calendar calendar = Calendar.getInstance();
int count1 = 4, count2 = 4, count3 = 4, count4 = 4, count5 = 4, count6 = 4;
System.out.println("----------------------------------------------------------------------------------------------------------");
System.out.println("                           ***HOSPITAL  ADMINISTRATION  SOFTWARE***                              ");
System.out.println("----------------------------------------------------------------------------------------------------------");
//Printing date and time
System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
doctor[] d = new doctor[25];
patient[] p = new patient[100];
lab[] l = new lab[20];
facility[] f = new facility[20];
medical[] m = new medical[100];
staff[] s = new staff[100];
int i;
//initializing the arrays
for (i = 0; i < 25; i++)
  d[i] = new doctor();
for (i = 0; i < 100; i++)
  p[i] = new patient();
for (i = 0; i < 20; i++)
  l[i] = new lab();
for (i = 0; i < 20; i++)
  f[i] = new facility();
for (i = 0; i < 100; i++)
  m[i] = new medical();
for (i = 0; i < 100; i++)
  s[i] = new staff();
d[0].doctorid = "1";
d[0].doctorname = "Dr.Ghanendra";
d[0].specialisation = "ENT";
d[0].worktime = "5-9PM";
d[0].qualifications = "MBBS,MD";
d[0].roomno = 17;
d[1].doctorid = "2";
d[1].doctorname = "Dr.Vikram";
d[1].specialisation = "Derma";
d[1].worktime = "2-5PM";
d[1].qualifications = "MBBS,MD";
d[1].roomno = 45;
d[2].doctorid = "3";
d[2].doctorname = "Dr.Rekha";
d[2].specialisation = "Eye";
d[2].worktime = "8-2AM";
d[2].qualifications = "MBBS,MS";
d[2].roomno = 8;
d[3].doctorid = "4";
d[3].doctorname = "Dr.Pramod";
d[3].specialisation = "Ortho";
d[3].worktime = "1-4PM";
d[3].qualifications = "MBBS,MS";
d[3].roomno = 40;
p[0].patientid = "12";
p[0].patientname = "Pankaj";
p[0].illness = "Typhoid";
p[0].gender = "Male";
p[0].hospitalization = "Yes";
p[0].patientage = 30;
p[1].patientid = "13";
p[1].patientname = "Sumit ";
p[1].illness = "Jaundice";
p[1].gender = "Male";
p[1].hospitalization = "Yes";
p[1].patientage = 23;
p[2].patientid = "14";
p[2].patientname = "Alok";
p[2].illness = "Maleria";
p[2].gender = "Male";
p[2].hospitalization = "Yes";
p[2].patientage = 45;
p[3].patientid = "15";
p[3].patientname = "Ravi";
p[3].illness = "Diabetes";
p[3].gender = "Male";
p[3].hospitalization = "No";
p[3].patientage = 25;
m[0].drugname = "Corex";
m[0].drugcompany = "Cino pvt";
m[0].expiry = "9-5-24";
m[0].drugcost = 35;
m[0].count = 8;
m[1].drugname = "Nytra";
m[1].drugcompany = "Ace pvt";
m[1].expiry = "4-4-26";
m[1].drugcost = 500;
m[1].count = 5;
m[2].drugname = "Brufa";
m[2].drugcompany = "Reckitt";
m[2].expiry = "12-7-24";
m[2].drugcost = 50;
m[2].count = 56;
m[3].drugname = "Telma";
m[3].drugcompany = "DDF pvt";
m[3].expiry = "12-4-26";
m[3].drugcost = 200;
m[3].count = 100;
l[0].labservice = "X-ray";
l[0].service_cost = 1500;
l[1].labservice = "CT Scan";
l[1].service_cost = 6000;
l[2].labservice = "MRI Scan";
l[2].service_cost = 7500;
l[3].labservice = "CBC Test";
l[3].service_cost = 500;
f[0].hospital_fac = "Ambulance";
f[1].hospital_fac = "Admit Facility ";
f[2].hospital_fac = "Canteen";
f[3].hospital_fac = "Emergency";
s[0].staffid = "22";
s[0].staffname = "Prakash";
s[0].designation = "Worker";
s[0].gender = "Male";
s[0].salary = 5000;
s[1].staffid = "23";
s[1].staffname = "Komal";
s[1].designation = "Nurse";
s[1].gender = "Female";
s[1].salary = 2000;
s[2].staffid = "24";
s[2].staffname = "Raju";
s[2].designation = "Worker";
s[2].gender = "Male";
s[2].salary = 5000;
s[3].staffid = "25";
s[3].staffname = "Rani";
s[3].designation = "Nurse";
s[3].gender = "Female";
s[3].salary = 20000;
s[4].staffid="12";
s[4].staffname = "Ronak";
s[4].designation = "Security";
s[4].gender = "male";
s[4].salary = 2000;
s[4].staffid="13";
s[4].staffname = "Ashok";
s[4].designation = "Security";
s[4].gender = "Male";
s[4].salary = 2000;
int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1,s7=1,s8=1,s9;
while (status == 1)
{
  System.out.println("\n                                ****DASHBOARD****");
  System.out.println("----------------------------------------------------------------------------------------------------------");
  System.out.println("1.Appointment Scheduling   2.Medicine Purchase and Test Booking                 3.Billing and Payment");
  System.out.println("4.Patient Records          5. Doctor Details                                    6.Pharmacy           "     );
  System.out.println("7.Lab Services             8.Staff Management                                   9.Service Overview");
  System.out.println("10. Exit");
   System.out.println("----------------------------------------------------------------------------------------------------------");
  choice = input.nextInt();
  switch (choice)
  {
      case 5:
          {
              System.out.println("--------------------------------------------------------------------------------");
              System.out.println("                      ** DOCTOR DETAILS **");
              System.out.println("--------------------------------------------------------------------------------");
              s1 = 1;
              while (s1 == 1)
              {
                  System.out.println("1.Add New Entry\n2.Display Existing Doctor Details");
                  c1 = input.nextInt();
                  switch (c1)
                  {
                      case 1:
                          {
                              d[count1].new_ent();
                              count1+=1;
                              break;
                          }
                      case 2:
                          {
                              System.out.println("-----------------------------------------------------------------------------------------");
                              System.out.println("ID      Name          Specialization   Timing        Qualification    Room No.");
                              System.out.println("-----------------------------------------------------------------------------------------");
                              for (j = 0; j < count1; j++)
                              {
                                  d[j].get_info();
                              }
                              break;
                          }
                  }
                  System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
                  s1 = input.nextInt();
              }
              break;
          }
      case 4:
          {
              System.out.println("--------------------------------------------------------------------------------");
              System.out.println("                     **PATIENT RECORDS**");
              System.out.println("--------------------------------------------------------------------------------");
              s2 = 1;
              while (s2 == 1)
              {
                  System.out.println("1.Add New Entry\n2.Display Existing Patient Records");
                  c1 = input.nextInt();
                  switch (c1)
                  {
                      case 1:
                      	
                          {
                              p[count2].new_ent();
                              count2+=1;
                              break;
                          }
                      case 2:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("ID   Name              Illness      Gender      Admit Status     Age");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count2; j++) {
                                  p[j].get_info();
                              }
                              break;
                          }
                  }
                  System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
                  s2 = input.nextInt();
              }
              break;
          }
      case 6:
          {
              s3 = 1;
              System.out.println("--------------------------------------------------------------------------------");
              System.out.println("                     **PHARMACY**");
              System.out.println("--------------------------------------------------------------------------------");
              while (s3 == 1)
              {
                  System.out.println("1.Add New Entry\n2. Display Existing Medicines List");
                  c1 = input.nextInt();
                  switch (c1)
                  {
                      case 1:
                          {
                              m[count3].new_ent();
                              count3+=1;
                              break;
                          }
                      case 2:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("Name \t Company \t Expiry Date \t Cost");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count3; j++) {
                                  m[j].get_info();
                              }
                              break;
                          }
                  }
                  System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
                  s3 = input.nextInt();
              }
              break;
          }
      case 7:
          {
              s4 = 1;
              System.out.println("--------------------------------------------------------------------------------");
              System.out.println("                    **LAB SERVICES**");
              System.out.println("--------------------------------------------------------------------------------");
              while (s4 == 1)
              {
                  System.out.println("1.Add New Entry \n2.Existing Laboratories List");
                  c1 = input.nextInt();
                  switch (c1)
                  {
                      case 1:
                          {
                              l[count4].new_ent();
                              count4+=1;
                              break;
                          }
                      case 2:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("Facilities      Cost");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count4; j++) {
                                  l[j].get_info();
                              }
                              break;
                          }
                  }
                  System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
                  s4 = input.nextInt();
              }
              break;
          }
      case 9:
          {
              s5 = 1;
              System.out.println("--------------------------------------------------------------------------------");
              System.out.println("          **HOSPITAL SERVICES OVERVIEW**");
              System.out.println("--------------------------------------------------------------------------------");
              while (s5 == 1)
              {
                  System.out.println("1.Add New Facility\n2.Display Existing Fecilities List");
                  c1 = input.nextInt();
                  switch (c1)
                  {
                      case 1:
                          {
                              f[count5].new_ent();count5++;
                              break;
                          }
                      case 2:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("Hospital  Facility are:");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count5; j++) {
                                  f[j].get_info();
                              }
                              break;
                          }
                  }
                  System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
                  s5 = input.nextInt();
              }
              break;
          }
      case 8:
          {
              s6 = 1;
              System.out.println("--------------------------------------------------------------------------------");
              System.out.println("                       **STAFF MANAGEMENT**");
              System.out.println("--------------------------------------------------------------------------------");
              while (s6 == 1)
              {
                  String a = "Nurse", b = "Worker", c = "Security";
                  System.out.println("1.Add New Entry \n2.Existing Nurses List\n3.Existing Workers List \n4.Existing Security Guards List");
                  c1 = input.nextInt();
                  switch (c1)
                  {
                      case 1:
                          {
                              s[count6].new_ent();count6++;
                              break;
                          }
                      case 2:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("ID \tName \t  Gender     Salary");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count6; j++)
                              {
                                  if (a.equalsIgnoreCase(s[j].designation))
                                      s[j].get_info();
                              }
                              break;
                          }
                      case 3:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("id \t Name \t Gender      Salary");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count6; j++)
                              {
                                  if (b.equalsIgnoreCase(s[j].designation))
                                      s[j].get_info();
                              }
                              break;
                          }
                      case 4:
                          {
                              System.out.println("--------------------------------------------------------------------------------");
                              System.out.println("ID \t Name \t Gender    Salary");
                              System.out.println("--------------------------------------------------------------------------------");
                              for (j = 0; j < count6; j++)
                              {
                                  if (c.equalsIgnoreCase(s[j].designation))
                                      s[j].get_info();
                              }
                              break;
                          }
                  }
                  System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
                  s6 = input.nextInt();
              }
              break;
          }
      case 1:
     {
     while(s7==1) {
      int nm;
      System.out.println("1. Add new patient\t\t2.Book Appointment");
      nm=input.nextInt();
      switch(nm){
      case 1:
      {
          p[count2].new_ent();
          count2+=1;
      }
          break;
       case 2:
     {
  		
  		  System.out.println("----------------------------------------------------------------------------");
  		  System.out.println("                      ****APPOINTMENT SCHEDULING****");
  		  System.out.println("----------------------------------------------------------------------------");
  	   String pa;
  	   System.out.println("Enter patient name:");
  	   input.nextLine();// Consume the newline character
  	   pa=input.nextLine();
  	  for(int c=0;c<count2;c++)
       {
           if(pa.equalsIgnoreCase(p[c].patientname))
           {
  	
  	   System.out.println("--------------------------------------------------------------------------------");
         System.out.println("                      **DOCTOR PROFILE**");
         System.out.println("--------------------------------------------------------------------------------");
         for (j = 0; j < count1; j++)
          {
              d[j].get_info();
          }
      	
      	System.out.println("Enter doctor name :");
      	String doc=input.nextLine().trim();//trim is used to trim leading and trailing  spaces
      	
      	boolean docFound=false;
      	 for (j = 0; j < count1; j++)
      	{
      		if(doc.equalsIgnoreCase(d[j].doctorname))
      		{
      			docFound=true;
      			System.out.println("Enter Date of Appointment (DD/MM/YY):");
      			String dd=input.nextLine();
      			System.out.println("Enter Time of Appointment:");
           	  // input.nextLine();
      			String  time=input.nextLine();
      			System.out.println("Appointment Booked!");
      			System.out.println("*********************************Appointment Details*********************************");
      			System.out.println("Patient name:"+pa);
      			System.out.println("Doctor name:"+d[j].doctorname+"\t\tTime of Appointment:"+time+"\t\tDate:"+dd);
      			System.out.println("Appointment charges : Rs. 600/-");
      			break;//exit loop once doctor is found;
      		}
      		                	}
      	 if(!docFound) {System.out.println("Doctor not found! ");}
   
           }
       }
     }
     break;
      }
  	 System.out.println("\nPress 1 to go back or press 0 for the Main Menu.");
      s7= input.nextInt();
      }
    	break;
     }
     case 2:
      {
     	 s8=1;
     	 while (s8 == 1)
          {
     	
     	 String name;
   	   System.out.println("Enter patient name:");
   	   input.nextLine();// Consume the newline character
   	   name=input.nextLine();
               for(int c=0;c<count2;c++)
               {
                   if(name.equalsIgnoreCase(p[c].patientname))
                   {
                 	  int g=1;
                       while(g==1) {
                System.out.println("1.Laboratary Service\t\t2. Buy Medicine\t\t3.Proceed");
     	 int ch =input.nextInt();
     	 switch(ch) {
     	case 1: {
     	    while (true) {
     	        try {
     	            System.out.println("--------------------------------------------------------------------------------");
     	            System.out.println("Facilities\t\t Cost");
     	            System.out.println("--------------------------------------------------------------------------------");
     	            for (j = 0; j < count4; j++) {
     	                l[j].get_info();
     	            }
     	            int t1;
     	        
     	                System.out.println("Enter the number of tests to be done:");
     	                t1 = input.nextInt();
     	                input.nextLine();
     	                if (t1 <= 0) {
     	                    System.out.println("Number of tests must be greater than 0. Please try again.");
     	                }
     	        
     	            for (int t = 1; t <= t1; t++)
     	            {
     	                System.out.println("Enter name of laboratory procedure or test " + t);
     	            
     	                String test_name = input.nextLine();
     	            
     	                for (j = 0; j < count4; j++)
     	                {
     	                    if (test_name.equalsIgnoreCase(l[j].labservice))
     	                    {
     	                        bill.add(l[j].service_cost);
     	                        lab1.add(l[j].labservice);
     	                        testnos.add(l[j].service_cost);
     	                        System.out.println("Test Added .");
     	                    }
     	                }
     	            }
     	            break; // Exit the loop if input is valid and tests are done
     	        } catch (IllegalArgumentException e) {
     	            System.out.println("Error: " + e.getMessage());
     	            // You can add additional handling here if needed
     	        }
     	    }
     	    break;
     	}
     	
     	case 2: {
     	    System.out.println("--------------------------------------------------------------------------------");
     	    System.out.println("Name \t Company \t Expiry Date \t Cost");
     	    System.out.println("--------------------------------------------------------------------------------");
     	    for (j = 0; j < count3; j++) {
     	        m[j].get_info();
     	    }
     	    int number;
     	    do {
     	        System.out.println("Enter number of medicines to buy (at least 1):");
     	        number = input.nextInt();
     	        if (number <= 0) {
     	            System.out.println("Please enter a valid number of medicines (at least 1).");
     	        }
     	    } while (number <= 0);
     	    for (int u = 1; u <= number; u++) {
     	        System.out.println("Enter name of medicine " + u);
     	        input.nextLine();
     	        String medi = input.nextLine();
     	        int pi;
     	        do {
     	            System.out.println("Enter count for medicine " + u + " (at least 1):");
     	            pi = input.nextInt();
     	            if (pi <= 0) {
     	                System.out.println("Please enter a valid count for medicine " + u + " (at least 1).");
     	            }
     	        } while (pi <= 0);
     	        for (j = 0; j < count3; j++) {
     	            if (medi.equalsIgnoreCase(m[j].drugname)) {
     	                bill.add((m[j].drugcost) * pi);
     	                med.add(m[j].drugname);
     	                medcost.add(m[j].drugcost);
     	                medquant.add(pi);
     	                System.out.println("Medicine added: " + medi);
     	            }
     	        }
     	    }
     	    break;
     	}
     	 case 3:
     		 g=0;
     	 }
          }
             }  }
     	 System.out.println(" Press 1 to return back or for Main Menu Press 0");
          s8 = input.nextInt();
     	
     	 }break;
      }
    	 case 3:
    	 {
    		
    		String ame;
    	   System.out.println("Enter patient name:");
    	   input.nextLine();// Consume the newline character
         ame=input.nextLine();
    		System.out.println("----------------------------------------------------------------------------");
     		System.out.println("                      ****Total Bill****");
     		System.out.println("----------------------------------------------------------------------------");
     		 System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
     	     System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
     		s9=1;
     		while(s9==1)
              {
             for(j=0;j<count2;j++)
             {
                 if(ame.equalsIgnoreCase(p[j].patientname)){
          
             System.out.println("Patient Name:"+p[j].patientname);
     		System.out.println("Medicines purchased :");
     		System.out.println("  Name                     Cost      Quantity ");
      		for (int k = 0; k < med.size(); k++)
      		{
                System.out.printf("%2d. %-20s %5s %8s\n", (k + 1), med.get(k), medcost.get(k), medquant.get(k));
            }
     		System.out.println();
     		System.out.println("Name of Tests done:");
     		System.out.println("  Name                    Cost               "     );
     		 for (int k = 0; k < lab1.size(); k++)
     		 {
                System.out.printf("%2d. %-20s %5s\n", (k + 1), lab1.get(k), testnos.get(k));
            }
     		System.out.println();
     		System.out.println("Appointment charges: Rs 600/-\n");
     		int sum=0;
     		for(int no: bill)
     		{
     			sum+=no;
     		}
     		sum+=600;
     		System.out.println("Total bill without TAX(18 percent):"+sum+"\n");
     		double nis=(sum+(18*sum/100));
     		System.out.println("Amount to be paid with tax: RS.  "+nis);
     		System.out.println("----------------------------------------------------------------------------");
      		System.out.println("----------------------------------------------------------------------------");
              break;
     	
          }
      }
          System.out.println(" Press 1 to return back or for Main Menu Press 0");
          s9 = input.nextInt();
           }
     		break;
      }
    	 case 10:
    	 {
    		System.out.println("----------------------------------------------------------------------------");
     		System.out.println("                      ****Thanks for visiting !! ****");
     		System.out.println("----------------------------------------------------------------------------");
     	status=0;
    	 }
    	 break;
    	
   default:
      	
          {
              System.out.println(" You Have Enter Wrong Choice!!!");
          }
}
}
}
}


