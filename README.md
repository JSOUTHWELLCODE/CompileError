# CompileError
AlgorihtimVisualizer

Algorithim visualizer in Java and JavaFX.
The App include ajustable: speeds, data , code. The app also includes time completion and big o notation for each algorithim.

In order to run the app you need to download JavaFX libraries for the appropriate operating system 

Libs located at https://gluonhq.com/products/javafx/

Intellij is the IDE used to run the application.


Here are instructions for setting up the application.


Step 1: Install JavaFX
First, you need to download JavaFX. Follow these steps:
Download JavaFX SDK:
Go to the official JavaFX download page: https://openjfx.io/
Download the appropriate version for your operating system.
Extract the SDK:
Extract the downloaded .zip file to a location of your choice on your system.
Step 2: Set Up a New JavaFX Project in IntelliJ IDEA
Create a New Project:
Open IntelliJ IDEA and select New Project.
Choose Java from the project options.
 
Make sure that you have a valid JDK installed (Java 11 or higher is recommended).
Configure the Project SDK:
Select the JDK you want to use for the project (if not already selected, you can install a JDK from IntelliJ IDEA by clicking "Download JDK").
Add JavaFX Libraries to the Project:
In the IntelliJ IDEA project, go to File > Project Structure.
Under Libraries, click + and select Java.
Navigate to the folder where you extracted the JavaFX SDK and select the lib folder (where all the .jar files are located).
Add these .jar files to the project.
Step 3: Configure the JavaFX Library in IntelliJ IDEA
Add JavaFX to Module Dependencies:
Go to File > Project Structure > Modules.
Select your module and go to the Dependencies tab.
Click the + button and choose Library > Java.
Select the JavaFX SDK's lib folder again and add all the .jar files.
Ensure vmOptions are Set (For JavaFX to work properly):
JavaFX requires additional VM options to be set, so when running your program, make sure you pass the JavaFX libraries to the Java Virtual Machine.
The JavaFX SDK comes with several .jar files, so we need to make sure these are available during runtime.
Step 4: Configure the Run Configuration
Go to the Run Configurations:
In IntelliJ IDEA, click on the Run menu and choose Edit Configurations.
Add a New Configuration:
Click the + sign to add a new configuration.
Select Application.
JAR application, and select AlgorithimVisualizer.JAR
 
Replace /path/to/javafx-sdk/lib with the actual path where your JavaFX SDK's lib folder is located. Make sure to specify both javafx.controls and javafx.fxml (if you're using FXML). If you're only using basic JavaFX, just javafx.controls should be enough.
Save the Configuration:
After entering the necessary fields, click OK to save the configuration.
bashCopy--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml in the VM options












