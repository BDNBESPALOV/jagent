.DEFAULT_GOAL := run
run:build
	java -jar target/jagent-1.0-SNAPSHOT-jar-with-dependencies.jar
build:
	mvn clean package
clean:
	rm target/jagent-1.0-SNAPSHOT-jar-with-dependencies.jar
install:
	mvn install

