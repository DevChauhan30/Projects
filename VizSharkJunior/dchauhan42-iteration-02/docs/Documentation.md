# Running VizShark on your system.

##Prerequisite 
* Link to [GraphStream](https://graphstream-project.org/download/) for download.
   - gs-core-2.0.jar
   - gs-algo-2.0.jar
   - gs-ui-javafx-2.0.jar
* Link to [javafx SDK](https://gluonhq.com/products/javafx/) for download.
   - javafx-sdk-11.0.2/lib/javafx-swt.jar
   - javafx-sdk-11.0.2/lib/javafx.base.jar 
   - javafx-sdk-11.0.2/lib/javafx.controls.jar
   - javafx-sdk-11.0.2/lib/javafx.fxml.jar
   - javafx-sdk-11.0.2/lib/javafx.graphics.jar
   - javafx-sdk-11.0.2/lib/javafx.media.jar
   - javafx-sdk-11.0.2/lib/javafx.swing.jar 
   - javafx-sdk-11.0.2/lib/javafx.web.jar
* Download Wireshark with tshark extension to run live data.

###Running TShark on Command Prompt:

   - Before running the TShark on command prompt you have to follow this step in order get tshark on your local path, so you can run tshark without changing the directory.
   - Step 1: Open File Explore on Windows and for Mac or Linux open Finder.
   - Step 2: Go to program files on Windows and for Mac or Linux open files.
   - Step 3: Under program files go to Wireshark folder and copy the path. Then go start bar and search for edit environment variable and new path to variable. 

####Step 1:

- Locate the directory in which downloaded or cloned program folder.

####Step 2:

- Open command prompt on and first thing you want to do is set classpath.
    - For Windows:
      - set CLASSPATH=%LIB%\gs-core-2.0.jar;%LIB%\gs-algo-2.0.jar;%LIB%\gs-ui-javafx-2.0.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx-swt.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.base.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.controls.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.fxml.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.graphics.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.media.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.swing.jar;%LIB%\javafx-sdk-11.0.2\lib\javafx.web.jar
    - For Mac or Linux:
      - export CLASSPATH=$LIB/gs-core-2.0.jar:$LIB/gs-algo-2.0.jar:$LIB/gs-ui-javafx-2.0.jar:$LIB/javafx-sdk-11.0.2/lib/javafx-swt.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.base.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.controls.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.fxml.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.graphics.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.media.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.swing.jar:$LIB/javafx-sdk-11.0.2/lib/javafx.web.jar
####Step 3:

- After setting %CLASSPATH% open command line and change directory to where VizShark program is located.
   - you can use following command: cd "directory name". to change directory in command prompt. 
 
####Step 4:

- The program is executed using the following command-line arguments:
- After reaching directory compile and execute program.

    - Compilation: javac -d out\standalone\*.java 

    - Running: java -cp %CLASSPATH% standalone.VizSharkJunior {--csv filename | --live interface}
        For example,
        java -cp %CLASSPATH% standalone.VizSharkJunior --live 5
        where the network interface is 5, and
        java -cp %CLASSPATH% standalone.VizSharkJunior --csv data/data2.csv
    
### You are all done!!!!