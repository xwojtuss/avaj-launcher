# This will be deleted during the eval

all:
	@javac src/*/*.java

run: all
	@if [ -z "$(ARG)" ]; then \
		echo "Usage: make run ARG=resources/scenario.txt"; \
	else \
		java -cp src simulation.Simulation "$(ARG)"; \
	fi

re: clean all

clean:
	@rm src/Simulation/*/*.class src/Simulation/*.class