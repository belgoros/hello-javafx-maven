hello-javafx-maven
==================

Simple javaFX project tested with jemmmyFX and cucumber-jvm.

*System requirements:*

- jdk1.7
- fix JRE path as described at https://github.com/zonski/javafx-maven-plugin/wiki
- run *sudo mvn com.zenjava:javafx-maven-plugin:1.5:fix-classpath*  for Linux/Unix based OSs. For Windows - desactivate user control option in the Control panel.

*Running*:

- just mvn clean install.

*To be fixed:*

On OS X, the first run always fails, because the RobotExecutor is started and it takes some time for launching. As a result, when I simulate typing 'toto' in a textfield, it 'looses' the first letter and types in 'oto'. The RobotExecutor stays running and the second test run is OK. Another 'strange' behaviour is that it (jemmyFX) does not recognise AZERTY keyboard and sees typed in lettres as if I used the QWERTY one.

