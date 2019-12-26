# Software_ScooterSystem_Java
 This is a software of campus scooter sharing system.
 
1. The jdk version used in the development of this project is 1.8.0_144.

2. Put the ScooterSystem folder in a certain path (such as the root directory of the D drive)

3. Place the txt files specified below in the root directory of the D drive:(These files can be found in the "ScooterSystem" folder)

      161195012.txt
      161195012Time.txt
      161195399.txt
      161195399Time.txt
      161195447.txt
      161195447Time.txt
      161196031.txt
      161196031Time.txt
      161196606.txt
      161196606Time.txt
      161197061.txt
      161197061Time.txt
      A.txt
      B.txt
      C.txt
      Gflash.gif
      Users.txt

4. Configure system variables: create a new variable name "CLASSPATH", variable value: .; %JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar

5. Open the cmd command line interface and enter the file path location where ScooterSystem is located.
If placed on the D drive, the interface should display: D:\ScooterSystem>

6. In the cmd command line interface, enter: javac -sourcepath src @src\source.txt -d bin

7. Then, type in the cmd command line interface: cd bin

8. Then, type in the cmd command line interface: java GUI.MainArea
