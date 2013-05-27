hello-javafx-maven
==================

Simple javaFX project tested with jemmyFX and cucumber-jvm.

**System requirements:**

- Java, jdk1.7
- fix JRE path as described at https://github.com/zonski/javafx-maven-plugin/wiki
- Apache Maven >= 3.0.3
- run **sudo mvn com.zenjava:javafx-maven-plugin:1.5:fix-classpath**  for Linux/Unix based OSs. For Windows - deactivate user control option in the Control panel for Windows 7.

**Running:**

- To run the javaFX application: **mvn jfx:run**
- To run tests: **mvn clean install**

**To be fixed:**

On OS X, the first test run always fails because the **RobotExecutor** is started and it takes some time for launching. As a result, when I simulate typing '**toto**' in a textfield, it 'looses' the first letter and types in '**oto**'. The RobotExecutor stays running and the second test run is OK.


On a WindowsPC no RobotExecutor launched and everything passes from the very first time.

Another 'strange' behaviour is that it (jemmyFX) does not recognise AZERTY keyboard and sees typed in lettres as if I used the QWERTY one.

