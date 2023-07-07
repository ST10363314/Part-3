/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itse_prog;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Itse_Prog {
        public static String  username;                                         
        public static String password;
        public static String firstName;
        public static  String lastName;
        public static boolean loggedIn = false;
        public static String[] developers;
        public static String[] taskNames;
        public static String[] taskIDs;
        public static int[] taskDurations;
        public static String[] taskStatuses;

      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        registration();

       
        int totalHours = 0;
        String menuChoice = "";

        while (!menuChoice.equals("9")) {
    if (loggedIn) {
        menuChoice = JOptionPane.showInputDialog(
                "Menu:\n" +
                "- Input '1' to Add tasks\n" +
                "- Input '2' to Show tasks with status 'Done'\n" +
                "- Input '3' to Show developer with longest task duration\n" +
                "- Input '4' to Search for a task by Task Name\n" +
                "- Input '5' to Search for tasks assigned to a developer\n" +
                "- Input '6' to Delete a task\n" +
                "- Input '7' to Display the full task report\n" +
                "- Input '8' to Logout\n" +
                "- Input '9' to Quit"
        );
        
        switch (menuChoice) {
                case "1":
                    if (loggedIn) {
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks: "));
                            // Initialize the arrays with the specified number of elements
                            developers = new String[numTasks];
                            taskNames = new String[numTasks];
                            taskIDs = new String[numTasks];
                            taskDurations = new int[numTasks];
                            taskStatuses = new String[numTasks];
                            
                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task name: ");
                            String taskDescription = JOptionPane.showInputDialog("Enter task description: ");
                            String developerFirstName = JOptionPane.showInputDialog("Enter developer first name: ");                            
                            String developerLastName = JOptionPane.showInputDialog("Enter developer last name: ");

                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours: "));
                            String taskStatus = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing): ");

                            Task task = new Task(taskName, taskDescription, developerFirstName,developerLastName , taskDuration, taskStatus,i);
                            

                            // Store the task details in the arrays
                            developers[i] = developerFirstName + " " + developerLastName;
                            taskNames[i] = taskName;
                            taskIDs[i] = task.getTaskID();
                            taskDurations[i] = taskDuration;
                            taskStatuses[i] = taskStatus;
                            
                            totalHours += task.getTaskDuration();
                            JOptionPane.showMessageDialog(null, task.printTaskDetails());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please login to add tasks.");
                    }
                    break;

                case "2":
                    if (loggedIn) {
                        StringBuilder tasksDone = new StringBuilder();

                        for (int i = 0; i < taskStatuses.length; i++) {
                            if (taskStatuses[i].equalsIgnoreCase("Done")) {
                                tasksDone.append("Developer: ").append(developers[i])
                                        .append(", Task Name: ").append(taskNames[i])
                                        .append(", Task Duration: ").append(taskDurations[i])
                                        .append(" hours").append("\n");
                            }
                        }

                        if (tasksDone.length() > 0) {
                            JOptionPane.showMessageDialog(null, "Tasks with status 'Done':\n" + tasksDone.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No tasks with status 'Done' found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please login to view tasks.");
                    }
                    break;


                case "3":
                    if (loggedIn) {
                        int longestDuration = 0;
                        String developerWithLongestDuration = "";

                        for (int i = 0; i < taskDurations.length; i++) {
                            if (taskDurations[i] > longestDuration) {
                                longestDuration = taskDurations[i];
                                developerWithLongestDuration = developers[i];
                            }
                        }

                        if (longestDuration > 0) {
                            JOptionPane.showMessageDialog(null, "Developer with the longest duration:\n" +
                                    "Developer: " + developerWithLongestDuration +
                                    ", Duration: " + longestDuration + " hours");
                        } else {
                            JOptionPane.showMessageDialog(null, "No tasks found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please login to view tasks.");
                    }
//                    JOptionPane.showMessageDialog(null, "Total combined hours of all tasks: " + totalHours);
                    break;
                    case "4":
                        if (loggedIn) {
                            String searchTaskName = JOptionPane.showInputDialog("Enter the task name to search: ");

                            boolean taskFound = false;
                            StringBuilder taskDetails = new StringBuilder();

                            for (int i = 0; i < taskNames.length; i++) {
                                if (taskNames[i].equalsIgnoreCase(searchTaskName)) {
                                    taskDetails.append("Task Name: ").append(taskNames[i])
                                            .append(", Developer: ").append(developers[i])
                                            .append(", Task Status: ").append(taskStatuses[i])
                                            .append("\n");

                                    taskFound = true;
                                }
                            }

                            if (taskFound) {
                                JOptionPane.showMessageDialog(null, "Task found:\n" + taskDetails.toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "Task not found.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please login to search for tasks.");
                        }
                        break;
 case "5":
                    if (loggedIn) {
                        String searchDeveloper = JOptionPane.showInputDialog("Enter the developer's name to search: ");

                        boolean tasksAssigned = false;
                        StringBuilder assignedTasks = new StringBuilder();

                        for (int i = 0; i < developers.length; i++) {
                            if (developers[i].equalsIgnoreCase(searchDeveloper)) {
                                assignedTasks.append("Task Name: ").append(taskNames[i])
                                        .append(", Task Status: ").append(taskStatuses[i])
                                        .append("\n");

                                tasksAssigned = true;
                            }
                        }

                        if (tasksAssigned) {
                            JOptionPane.showMessageDialog(null, "Tasks assigned to " + searchDeveloper + ":\n" + assignedTasks.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No tasks assigned to " + searchDeveloper + " found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please login to search for tasks.");
                    }
                    break;
                        case "6":
                            if (loggedIn) {
                                String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete: ");

                                boolean taskDeleted = false;

                                for (int i = 0; i < taskNames.length; i++) {
                                    if (taskNames[i].equalsIgnoreCase(deleteTaskName)) {
                                        // Remove the task details from the arrays
                                        developers[i] = null;
                                        taskNames[i] = null;
                                        taskIDs[i] = null;
                                        taskDurations[i] = 0;
                                        taskStatuses[i] = null;

                                        taskDeleted = true;
                                    }
                                }

                                if (taskDeleted) {
                                    JOptionPane.showMessageDialog(null, "Task '" + deleteTaskName + "' deleted successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Task not found.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please login to delete tasks.");
                            }
                            break;
                            case "7":
                            // Display the full task report
                            if (loggedIn) {
                                displayReport();
                            } else {
                                JOptionPane.showMessageDialog(null, "Please login to view the report.");
                            }
                            break;

                        case "8":
                            // Logout
                            loggedIn = false;
                            JOptionPane.showMessageDialog(null, "You have been logged out.");
                            break;

                        case "9":
                            // Quit
                            JOptionPane.showMessageDialog(null, "Total combined hours of all tasks: " + totalHours);
                            JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban. Goodbye!");
                            System.exit(0);
                            break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                    break;
            }
                
            } else {
                menuChoice = JOptionPane.showInputDialog("Menu: \n- Input '1' to Login\n- Input '2' to Quit");
                
                switch (menuChoice) {
                
                case "1":
                    Login login = new Login(username, password, firstName, lastName);
                    String loginStatus = login.returnLoginStatus(username, password);
                    JOptionPane.showMessageDialog(null, loginStatus);
                    loggedIn = login.loginUser(username, password);
                    break;
                    
                    case "2":
                    JOptionPane.showMessageDialog(null, "Total combined hours of all tasks: " + totalHours);
                    break;
               
                                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                    break;
            }
            }

            
        }
    }
    public static void displayReport() {
    StringBuilder report = new StringBuilder();

    for (int i = 0; i < taskNames.length; i++) {
        if (taskNames[i] != null) {
            report.append("Task ID: ").append(taskIDs[i])
                    .append("\nTask Name: ").append(taskNames[i])
                    .append("\nDeveloper: ").append(developers[i])
                    .append("\nTask Duration: ").append(taskDurations[i])
                    .append(" hours\nTask Status: ").append(taskStatuses[i])
                    .append("\n\n");
        }
    }

    if (report.length() > 0) {
        JOptionPane.showMessageDialog(null, "Report:\n" + report.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No tasks found.");
    }
}

    public static void  registration(){
         username = JOptionPane.showInputDialog("REGISTRATION \n"
                                                      + "Enter your username: ");
         
         password = JOptionPane.showInputDialog("Enter your password: ");
         
         firstName = JOptionPane.showInputDialog("Enter your first name: ");
         lastName = JOptionPane.showInputDialog("Enter your last name: ");
         
         Login register = new Login(username, password, firstName, lastName);
                    String registrationStatus = register.registerUser();
                    JOptionPane.showMessageDialog(null, registrationStatus);
        if (registrationStatus != "User registered successfully!") {
            registration();
        }
    }
    
}
   
  
       
       
       
       
       
       
       
       
       
        

    
    

