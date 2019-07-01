find * -name "*.java" > sources.txt
javac -sourcepath @sources.txt
java avaj_launcher.simulation.Simulator scenario.txt