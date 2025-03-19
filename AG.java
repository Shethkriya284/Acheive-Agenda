//
import java.util.Scanner;

class Task {
    String taskName, taskDescription;
    boolean isCompleted ,isflagged,isrecur;

    Task(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isCompleted = false;
		this.isflagged =false;
		this.isrecur=false;
    }

    public void displayTask() {
		String flagstatus =isflagged?" |> " :" ";
		String recurstatus =isrecur?" () " :" ";
        if (isCompleted &&  isflagged) {
			System.out.println();
            System.out.println( recurstatus+""+flagstatus+" [X] " + taskName + " - " + taskDescription);
        } else if (isCompleted) {
			
            System.out.println(recurstatus+""+flagstatus+" [x] " + taskName + " - " + taskDescription);
        }
		else {
		    System.out.println(recurstatus+""+flagstatus+" [] " + taskName + " - " + taskDescription);

    }}

    public void markAsCompleted() {
        isCompleted = true;
		System.out.println();
        System.out.println("Task Marked as completed (O^.^O)");
    }
public void mflaggedtask(){
	isflagged=!isflagged;
	if(isflagged){
		System.out.println();
		System.out.println("Task marked as Flagged Task  <@.@>");
		System.out.println();
	}
	else
		System.out.println("Task marked as unFlagged Task  <*.*>");
}
public void mrecurtask(){
	isrecur=!isrecur;
	if(isrecur){
		System.out.println();
		System.out.println("Task marked as Recurring Task  (@-@)");
		System.out.println();
	}
	else
		System.out.println("Task is removed from Recurring Task  <*.*>");
}
    public void updateTask(String newTaskName, String newTaskDescription) {
        taskName = newTaskName;
        taskDescription = newTaskDescription;
        System.out.println("Task updated Successfully! :)");
    }
}

class TaskManager {
    static Task[] taskList = new Task[10]; // Array of tasks
    int taskCount = 0;

    String addTask(String taskName, String taskDescription) {
        if (taskCount < taskList.length) {
            taskList[taskCount++] = new Task(taskName, taskDescription);
            return "...Task added Successfully...";
        } else {
            System.out.println("STOP & DROP /n You can chill and Login after some time ");
            System.out.println("-----------:<< T H A N K   Y O U >>:-------------------");
			return "";
        }
    }

    public void viewTasks() {
        if (taskCount == 0) {
            System.out.println("Tasks are Far Away .......");
        } 
			else{
				
				System.out.println("Your Tasks:");
            for (int i = 0; i < taskCount; i++) {
				if(taskList[i].isrecur){
                System.out.print((i + 1) + ". ");
                taskList[i].displayTask();
				}
				else{
                System.out.print((i + 1) + ". ");
                taskList[i].displayTask();
				}
				}}
			
        
    }
public void flaggedtask(int index){
	
	if (index >= 1 && index <= taskCount) {
            taskList[index - 1].mflaggedtask();
        } else {
            System.out.println("Invalid task number.");
        }
}
public void recurtask(int index){
	
	if (index >= 1 && index <= taskCount) {
            taskList[index - 1].mrecurtask();
        } else {
            System.out.println("Invalid task number.");
        }
}
/*public void viewRecurringTasks() {
        if (taskCount == 0) {
            System.out.println("No recurring tasks available.");
        } else {
            for (int i = 0; i < taskCount; i++) {
				if(taskList[i].isrecur){
                System.out.print((i + 1) + ". ");
                taskList[i].displayTask();
            }}
        }
    }*/
    public void markAsCompleted(int index) {
        if (index >= 1 && index <= taskCount) {
            taskList[index - 1].markAsCompleted();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void updateTask(int index, String newTaskName, String newTaskDescription) {
        if (index >= 1 && index <= taskCount) {
            taskList[index - 1].updateTask(newTaskName, newTaskDescription);
        } else {
            System.out.println("Invalid task number.");
        }
    }

	
	}


class ScheduleTask {
    // Array of month names
    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    // Array of days in each month
    int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int year;

    ScheduleTask(int year) {
        this.year = year;
        // Adjust February for leap year
        if (isLeapYear(year)) {
            daysInMonths[1] = 29;
        }
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to calculate the first day of the year
    public static int getStartDay(int year) {
        int totalDays = 0;

        // Count the total days from year 2025 to the previous year
        for (int i = 2024; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }

        // Start day of 2024 was Monday (1), so adjust by adding 1
        return (totalDays + 1) % 7;
    }
int startDay;
    public void printCalendar() {
          startDay = getStartDay(year);
		  
        for (int month = 0; month < 12; month++) 
		{
            System.out.println("\n  " + monthNames[month] + " " + year);
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

            // Print leading spaces
            for (int i = 0; i < startDay; i++) {
                System.out.print("    ");
            }

            // Print the days of the month
           for (int day = 1; day <= daysInMonths[month]; day++) {
                if (day < 10) {
                    System.out.print("  " + day + " ");
          
		  } else {
                    System.out.print(" " + day + " ");
                }

                if ((startDay + day) % 7 == 0 || day == daysInMonths[month]) {
                    System.out.println();
                }
            }

            // Update start day for next month
            startDay = (startDay + daysInMonths[month]) % 7;
        }
    } 
}

 class Main {
    private static String name = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        // Welcome message
        System.out.println("_____________-``:***:''___________________");
        System.out.println();
        System.out.println("         W  E  L  C  O  M  E                  ");
        System.out.println("                 to                          ");
        System.out.println("         '' Achieve Agenda ''                ");
        System.out.println();
        System.out.println("_____________-``:***:''___________________");
        System.out.println("                             ~ Kriya Sheth");

        TaskManager taskManager = new TaskManager();
		TaskManager taskManager1 = new TaskManager();
		TaskManager taskManager2 = new TaskManager();
		TaskManager taskManager3 = new TaskManager();
        ScheduleTask scheduleTask ;
		//recurringtasks r=new recurringtasks();
boolean mainchoice=true;
       while(mainchoice){
            System.out.println("Are you ? \n 1.User \n 2. AG Pilot \n 3.EXIT ");
            int mchoice = sc.nextInt();

            switch (mchoice) {
                case 1: // User
                    System.out.println("1.New User");
                    System.out.println("2.Existing User");
                    int userChoice = sc.nextInt();

                    switch (userChoice) {
                        case 1: // New User
                            sc.nextLine(); // Consume newline
                            System.out.println("Enter your name:");
                            name = sc.nextLine().toUpperCase();
                            
                        case 2: // Existing User
                            if (name.isEmpty()) {
                                System.out.println("No user is registered. Please register first.");
                            } else {
                                System.out.println("HELLO " + name + " !!");
								
								 while (running) {
								System.out.println("====================");
								System.out.println("1.For Personal Use");
								System.out.println("2.For Work Use");
								System.out.println("3.For Study Use");
								System.out.println("====================");
								int uchoice=sc.nextInt();
								switch(uchoice){
								case 1://For personal use
                                boolean userMenu = true;
                                while (userMenu) {
									 System.out.println("\n");
									System.out.println(".............");
									System.out.println();
                                    System.out.println("1.Add Task");
                                    System.out.println("2.Schedule Task");
									System.out.println("3.Prioritize Task");
                                    System.out.println("4.View Tasks");
                                    System.out.println("5.Mark as Completed");
                                    System.out.println("6.Update Task");
                                    System.out.println("7.Exit");
							       System.out.println();
									System.out.println("............");
									System.out.println("Enter choice");
                                    int mchoice1 = sc.nextInt();
                                    switch (mchoice1) {
                                        case 1:
                                            sc.nextLine(); // Consume newline
                                            System.out.println("Enter Task title:");
                                            String title = sc.nextLine();
                                            System.out.println("Enter Task Description:");
                                            String description = sc.nextLine();
											taskManager.addTask(title, description);
                                            break;
                                           case 3: 
											
												System.out.println("1.Flagged/Unflag Task");
												System.out.println("2.Recurring Task");
												int pchoice=sc.nextInt();
												if(pchoice==1){
													System.out.println("Enter task number you want to flagged");
													int flagnum =sc.nextInt();
													System.out.println("***********");
													taskManager.flaggedtask(flagnum);
													System.out.println("***********");
												}
												else if(pchoice==2){
													System.out.println("Enter task number you want to do Recurring tasks");
													int recur =sc.nextInt();
													System.out.println("***********");
													taskManager.recurtask(recur);
													System.out.println("***********");
												}
												
											
											
											break;
                                        case 2:
                                            System.out.print("Enter year: ");
                                            int year = sc.nextInt();
										    System.out.print("Enter month to be schedule: ");
											int month = sc.nextInt();
                                            scheduleTask = new ScheduleTask(year);
                                            scheduleTask.printCalendar();
											System.out.print("Enter Date to be schedule: ");
                                            int date = sc.nextInt();
											sc.nextLine();
											 System.out.println("Enter Task title:");
                                            String stitle = sc.nextLine();
                                            System.out.println("Enter Task Description:");
                                            String sdescription = sc.nextLine();
											System.out.println();
                                            System.out.println (taskManager.addTask(stitle, sdescription) + " date is "+ date +"-"+month+"-"+year);
											
                                            break;
                                        case 4:
										System.out.println();
										System.out.println("<<--------------->>");
										    //taskManager.viewRecurringTasks();
                                            taskManager.viewTasks();
											System.out.println("<<--------------->>");
                                            break;
                                        case 5:
                                            System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager.markAsCompleted(taskNumber);
                                            break;
                                        case 6:
                                            System.out.println("Enter task number to update:");
                                            int updateNum = sc.nextInt();
                                            sc.nextLine(); // Consume newline
                                            System.out.println("Enter new task name:");
                                            String newTaskName = sc.nextLine();
                                            System.out.println("Enter new task description:");
                                            String newTaskDescription = sc.nextLine();
                                            taskManager.updateTask(updateNum, newTaskName, newTaskDescription);
                                            break;
                                        case 7:
                                            System.out.println("Exiting the Personal Tasks " + "  " + name+"^.^");
                                            userMenu = false;
											running =true;
											
                                            break;
                                        default:
                                            System.out.println("Invalid choice! Please try again.");
                                    }
									
                                }
								System.out.println("====================");
								System.out.println("1.For Personal Use");
								System.out.println("2.For Work Use");
								System.out.println("3.For Study Use");
								System.out.println("====================");
								uchoice=sc.nextInt();
								case 2: //For Work Use
								System.out.println("_______________________________");
								System.out.println("1.View Assign Tasks");
								System.out.println("2.View Scheduled Meetups");
								System.out.println("3.Login Out");
								System.out.println("_______________________________");
								int wchoice=sc.nextInt();
								if(wchoice==1){
									System.out.println();
										System.out.println("<<--------------->>");
                                            taskManager1.viewTasks();
											System.out.println("<<--------------->>");
                                           
								}
								else if(wchoice==2){
									System.out.println("<<--------------->>");
                                            taskManager2.viewTasks();
											System.out.println("<<--------------->>");
                                           
								}
								else{
									System.out.println("closing..");
									running =false;
									break;
									
								}
								
								System.out.println("====================");
								System.out.println("1.For Personal Use");
								System.out.println("2.For Work Use");
								System.out.println("3.For Study Use");
								System.out.println("====================");
								uchoice=sc.nextInt();
								case 3: //For Study Use
								System.out.println("For which exam are you preparing?");
System.out.println("1. UPSC Exam");
System.out.println("2. GATE Exam");
System.out.println("3. Internal Exam");
System.out.println("4. Exit");

int schoice = sc.nextInt();
sc.nextLine(); // Consume newline

switch (schoice) {
    case 1:
        System.out.println("How many hours do you want to study? (4/8)");
        int studyhrs = sc.nextInt();
        sc.nextLine(); // Consume newline
        if (studyhrs == 4) {
            System.out.println(":Study Schedule:");
            System.out.println("1. Politics: 1 hr.");
            System.out.println("2. Technology: 1 hr.");
            System.out.println("3. Social Issues: 1 hr.");
            System.out.println("4. Culture: 1 hr.");
            System.out.println("Do you want to schedule these tasks? (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                taskManager3.addTask("Politics", "1 hr.");
                taskManager3.addTask("Technology", "1 hr.");
                taskManager3.addTask("Social Issues", "1 hr.");
                taskManager3.addTask("Culture", "1 hr.");
				taskManager3.viewTasks();
				
				for(int i=0;i<4;i++){
				System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager3.markAsCompleted(taskNumber);
				}
				 running=false;
				break;
            }
        } else if (studyhrs == 8) {
            System.out.println(":Study Schedule:");
            System.out.println("1. Politics: 3 hr.");
            System.out.println("2. Technology: 2 hr.");
            System.out.println("3. Social Issues: 1 hr.");
            System.out.println("4. Culture: 2 hr.");
            System.out.println("Do you want to schedule these tasks? (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                taskManager3.addTask("Politics", "3 hr.");
                taskManager3.addTask("Technology", "2 hr.");
                taskManager3.addTask("Social Issues", "1 hr.");
                taskManager3.addTask("Culture", "2 hr.");
				taskManager3.viewTasks();
				for(int i=0;i<4;i++){
				System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager3.markAsCompleted(taskNumber);
				} break;
            } 
								}
								 running=false;
        break;
    case 2:
        System.out.println("GATE Exam Scheduling ");
		 System.out.println("How many hours do you want to study? (4/6)");
        int Gstudyhrs = sc.nextInt();
        sc.nextLine(); // Consume newline
        if (Gstudyhrs == 4) {
            System.out.println(":Study Schedule:");
            System.out.println("1. Programming: 1 hr.");
            System.out.println("2. Enginnering Maths: 1 hr.");
            System.out.println("3. Digital Logics: 1 hr.");
            System.out.println("4. Calculus: 1 hr.");
            System.out.println("Do you want to schedule these tasks? (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                taskManager3.addTask("Programming", "1 hr.");
                taskManager3.addTask("Enginnering Maths", "1 hr.");
                taskManager3.addTask("Digital Logicss", "1 hr.");
                taskManager3.addTask("Calculus", "1 hr.");
				taskManager3.viewTasks();
				
				for(int i=0;i<4;i++){
				System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager3.markAsCompleted(taskNumber);
				}
				break;
            }
        } else if (Gstudyhrs == 6) {
            System.out.println(":Study Schedule:");
            System.out.println("1. Programming: 2 hr.");
            System.out.println("2. Enginnering Maths: 2 hr.");
            System.out.println("3. Digital Logics: 1 hr.");
            System.out.println("4. Calculus: 1 hr.");
            System.out.println("Do you want to schedule these tasks? (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                taskManager3.addTask("Programming", "2 hr.");
                taskManager3.addTask(" Enginnering Maths", "2 hr.");
                taskManager3.addTask("Digital Logics", "1 hr.");
                taskManager3.addTask("Calculus", "1 hr.");
				taskManager3.viewTasks();
				for(int i=0;i<4;i++){
				System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager3.markAsCompleted(taskNumber);
				} break;
            } 
								}
        running=false;
        break;
    case 3:
        System.out.println("Internal Exam Scheduling :");
		 System.out.println("How many hours do you want to study? (3/4)");
        int Istudyhrs = sc.nextInt();
        sc.nextLine(); // Consume newline
        if (Istudyhrs == 4) {
            System.out.println(":Study Schedule:");
            System.out.println("1. JAVA: 1 hr.");
            System.out.println("2. Maths: 1 hr.");
            System.out.println("3.Physics: 1 hr.");
            System.out.println("4.Software Engineering: 1 hr.");
            System.out.println("Do you want to schedule these tasks? (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                taskManager3.addTask("Programming", "1 hr.");
                taskManager3.addTask("Enginnering Maths", "1 hr.");
                taskManager3.addTask("Digital Logicss", "1 hr.");
                taskManager3.addTask("Calculus", "1 hr.");
				taskManager3.viewTasks();
				
				for(int i=0;i<4;i++){
				System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager3.markAsCompleted(taskNumber);
				} running=false;
				break;
				
				
		}}
			if (Istudyhrs == 3) {
            System.out.println(":Study Schedule:");
            System.out.println("1. JAVA: 2 hr.");
            System.out.println("2. Maths: 1 hr.");
           
            System.out.println("Do you want to schedule these tasks? (Y/N)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                taskManager3.addTask("JAVA", "2 hr.");
                taskManager3.addTask(" Maths", "1 hr.");

				taskManager3.viewTasks();
				
				for(int i=0;i<2;i++){
				System.out.println("Enter task number to mark as completed:");
                                            int taskNumber = sc.nextInt();
                                            taskManager3.markAsCompleted(taskNumber);
				}
				break;
				
            }}
			 running=false;
        break;
    case 4:
        System.out.println("Exiting Study Session...");
        running = false;
        break;
    default:
        System.out.println("Invalid input! Please enter 1, 2, 3, or 4.");
							}}	running=false; 
							mainchoice=false;
					break;
					
					}}}	
                case 2: // AG Pilot
                   boolean b = true; // Declare boolean variable before loop
System.out.println("Login to AG Pilot");
    System.out.println("Enter password:");
    int p = sc.nextInt();
int password=1234;
    if (p == password) {
        System.out.println("1. Assign task to user");
        System.out.println("2. Schedule Meetups");
        int agchoice = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        if (agchoice == 1) {
            System.out.println("Enter Task title:");
            String title = sc.nextLine();
            System.out.println("Enter Task Description:");
            String description = sc.nextLine();
            taskManager1.addTask(title, description);
            System.out.println("You successfully assigned a task to the user.");
        } else  {
            System.out.println("Enter Meet Type:");
            String mtitle = sc.nextLine();
            System.out.println("Enter Meet Description:");
            String mdescription = sc.nextLine();
            System.out.println("Enter Date of meeting (DD/MM/YYYY):");
            String mdate = sc.nextLine();
            System.out.println(taskManager2.addTask(mtitle, mdescription) + "\n || " + mdate + " ||");
            System.out.println("You successfully scheduled a meeting.");
        }
        b = false;
		// Exit loop after successful login
    } else {
        System.out.println("Password not Matched");
        System.out.println("Exiting ACHIEVE AGENDA !!");
        running = false;
        break; // Ensure exit
    }
	case 3: 
	System.out.println("EXITING THE ACHIEVE AGENDA <*.*>");
	mainchoice=false;
	break;
			}
        
 }}}