/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itse_prog;

class Task {
    private String taskName;
    private String taskDescription;
    private String developerFirstName;    
    private String developerLastName;

    private int taskDuration;
    private String taskStatus;
    private String taskID;    
    private int TaskNum;


    public Task(String taskName, String taskDescription, String developerFirstName,String developerLastName, int taskDuration, String taskStatus,int TaskNum) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.TaskNum = TaskNum;
        this.developerFirstName = developerFirstName;        
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();        

    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    private String createTaskID() {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" +
                TaskNum + ":" +
                developerFirstName.substring(developerFirstName.length() - 3).toUpperCase();
        
        return taskID;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerFirstName + developerLastName+ "\n" +
                "Task Number: " + TaskNum + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Duration: " + taskDuration + " hours";
    }

    public int getTaskDuration() {
        return taskDuration;
    }
    public String getTaskID() {
        return taskID;
    }
}

/*
Login
 kyl_1
 Ch&&sec@ke99!

Task 1
 Add Login Feature
 Create Login to authenticate users
 Robyn Harrison 
 8
 To Do 

Task 2
Add Task Feature
Create Add Task feature to add task users”
Mike Smith
10
Doing
*/
