
all:
	find . -name "*.java" > sources.txt
	javac -sourcepath . @sources.txt
	java src.Main Simulation.txt

clean :
	rm -f src/*.class
	rm -f src/*/*.class
	rm -f sources.txt