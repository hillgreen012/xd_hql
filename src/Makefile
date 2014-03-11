PRJ_DIR := ..

TARGET := XDSHql.jar

ANTLR_JAR := antlr-3.4-complete.jar
CLASSPATH := "$(PRJ_DIR)/lib/$(ANTLR_JAR):${CLASSPATH}"
JAVA := ${JAVA_HOME}/bin/java
JAVAC := ${JAVA_HOME}/bin/javac
JAR := ${JAVA_HOME}/bin/jar

ALL_G := \
	HiveLexer.g \
	IdentifiersParser.g \
	FromClauseParser.g \
	SelectClauseParser.g \
	HiveParser.g 
ALL_JAVA := $(wildcard *.java)
ALL_JAR := $(wildcard antlr-*.jar)
ALL_SRC := $(ALL_G) $(ALL_JAVA) $(ALL_JAR) Manifest.mf

ALL_ANTLR := \
	HiveLexer.tokens \
	HiveLexer.java \
	IdentifiersParser.tokens \
	HiveParser_IdentifiersParser.java \
	FromClauseParser.tokens \
	HiveParser_FromClauseParser.java \
	SelectClauseParser.tokens \
	HiveParser_SelectClauseParser.java \
	HiveParser.tokens \
	HiveParser.java 

all: $(TARGET)

$(ALL_ANTLR): $(ALL_G)
	$(JAVA) -cp $(CLASSPATH) org.antlr.Tool HiveLexer.g HiveParser.g

$(TARGET): $(ALL_ANTLR) $(ALL_JAVA) $(ALL_JAR) Manifest.mf
	$(JAVAC) -cp $(CLASSPATH) *.java
	$(JAR) cfm $@ Manifest.mf *.class
	
install: $(TARGET)
	cp -f $(TARGET) $(PRJ_DIR)/bin

clean::
	rm -f *.class $(TARGET) $(ALL_ANTLR)

cleanup::
	rm -f *.class $(ALL_ANTLR)
