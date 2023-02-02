import java.util.Scanner;

public class Duke {

	public static void startDuke() {

		Greetings dukeGreeting = new Greetings();
		dukeGreeting.printGreetings();
		dukeGreeting.printOpeningLine();
		Scanner sc = new Scanner(System.in);

		Task[] tasks = new Task[100];
		int taskCount = 0;

		String userMessage;

		boolean shouldExit = false;

		while (!shouldExit) {
			userMessage = sc.nextLine();
			if (userMessage.startsWith("todo")) {
				userMessage.substring(6);
				tasks[taskCount] = new Todo(userMessage);
				dukeGreeting.printDivider();
				System.out.println("Got it. I've added this task: ");
				tasks[taskCount].printTask();
				taskCount += 1;
				System.out.println("Now you have " + taskCount + " tasks in the list.");
				dukeGreeting.printDivider();
			} else if (userMessage.startsWith("deadline")) {
				userMessage.substring(10);
				String[] message = userMessage.split(" /by ");
				tasks[taskCount] = new Deadline(message[0], message[1]);
				dukeGreeting.printDivider();
				System.out.println("Got it. I've added this task: ");
				tasks[taskCount].printTask();
				taskCount += 1;
				System.out.println("Now you have " + taskCount + " tasks in the list.");
				dukeGreeting.printDivider();
			} else if (userMessage.startsWith("event")) {
				userMessage.substring(7);
				String[] messages = userMessage.split(" /from ");
				String description = messages[0];
				String[] dates = messages[1].split(" /to");
				String from = dates[0];
				String to = dates[1];
				tasks[taskCount] = new Event(description, from, to);
				dukeGreeting.printDivider();
				System.out.println("Got it. I've added this task: ");
				tasks[taskCount].printTask();
				taskCount += 1;
				System.out.println("Now you have " + taskCount + " tasks in the list.");
				dukeGreeting.printDivider();
			} else if (userMessage.startsWith("mark")) {
				dukeGreeting.printDivider();
				String[] messages = userMessage.split(" ");
				int taskNumber = Integer.parseInt(messages[1]);
				tasks[taskNumber - 1].markAsDone();
				System.out.println("Niceee! I've marked this task as done: ");
				tasks[taskCount - 1].printTask();
				dukeGreeting.printDivider();
			} else if (userMessage.startsWith("unmark")) {
				dukeGreeting.printDivider();
				String[] messages = userMessage.split(" ");
				int taskNumber = Integer.parseInt(messages[1]);
				tasks[taskNumber - 1].markAsUndone();
				System.out.println("Fine...I've marked this task as undone: ");
				tasks[taskCount - 1].printTask();
				dukeGreeting.printDivider();
			} else if (userMessage.equalsIgnoreCase("Hello")) {
				dukeGreeting.printDivider();
				System.out.println(userMessage);
				dukeGreeting.printDivider();
			} else if (userMessage.equalsIgnoreCase("list")) {
				dukeGreeting.printDivider();
				if (taskCount > 0) {
					for (int i = 0; i < taskCount; i += 1) {
						System.out.println("Here are the tasks in your list: ");
						System.out.print(i + 1);
						System.out.print(".");
						tasks[i].printTask();
					}
				} else {
					System.out.println("You have no task right now!!");
				}
				dukeGreeting.printDivider();
			} else if (userMessage.equalsIgnoreCase("help")) {
				dukeGreeting.printHelp();
			} else if (userMessage.equalsIgnoreCase("exit")) {
				shouldExit = true;
				dukeGreeting.printExitLine();
			} else {
				dukeGreeting.printErrorMessage();
			}
		}
	}

	public static void main(String[] args) {
		startDuke();
	}
}
